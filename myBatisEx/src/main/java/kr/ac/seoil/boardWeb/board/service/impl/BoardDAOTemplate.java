package kr.ac.seoil.boardWeb.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.seoil.boardWeb.board.vo.BoardRowMapper;
import kr.ac.seoil.boardWeb.board.vo.BoardVO;

//@Repository("boardDAO")	//이름 설정 안하면 class명인 BoardDAOTemplate로 설정된다.
public class BoardDAOTemplate {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// SQL ��ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer_name, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_COUNT = "select count(*) from board";
	private final String BOARD_LIST_TITLE="select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_CONTENT="select * from board where content like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_WRITER="select * from board where writer_name like '%'||?||'%' order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		int ret = jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriterName(), vo.getContent());
		System.out.println("===> JdbcDaoSupport로 insertBoard() 기능 처리 : " + ret + "건 적용");
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		int ret = jdbcTemplate.update(BOARD_UPDATE, args);
		System.out.println("===> JdbcDaoSupport로 updateBoard() 기능 처리 : " + ret + "건 적용");
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		Object[] args = {vo.getSeq()};
		int ret = jdbcTemplate.update(BOARD_DELETE, args);
		System.out.println("===> JDBC로 deleteBoard() 기능 처리 : " + ret + "건 적용");
	}

	// 글 상세 조회
	public BoardVO selectBoard(BoardVO vo) {
		System.out.println("===> JDBC로 selectBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
	}

	// 글 목록 조회
	public List<BoardVO> selectBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 selectBoardList() 기능 처리");
		Object[] args = {vo.getSearchKeyword()};
		if (vo.getSearchCondition()==null) {
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}else if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_TITLE, new BoardRowMapper(),args);
		}else if(vo.getSearchCondition().equals("WRITER")) {
			return jdbcTemplate.query(BOARD_LIST_WRITER, new BoardRowMapper(),args);		
		}else {
			return jdbcTemplate.query(BOARD_LIST_CONTENT,new BoardRowMapper(),args);
		}
	}
}
