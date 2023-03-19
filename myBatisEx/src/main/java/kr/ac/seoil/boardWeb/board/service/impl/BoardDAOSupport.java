package kr.ac.seoil.boardWeb.board.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import kr.ac.seoil.boardWeb.board.vo.BoardRowMapper;
import kr.ac.seoil.boardWeb.board.vo.BoardVO;
import kr.ac.seoil.boardWeb.common.JDBCUtil;

//@Repository("boardDAO")
public class BoardDAOSupport extends JdbcDaoSupport {
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	// SQL ��ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer_name, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_COUNT = "select count(*) from board";

	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		int ret = getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriterName(), vo.getContent());
		System.out.println("===> JdbcDaoSupport�� insertBoard() ��� ó�� : " + ret + "�� ����");
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		int ret = getJdbcTemplate().update(BOARD_UPDATE, args);
		System.out.println("===> JdbcDaoSupport�� updateBoard() ��� ó�� : " + ret + "�� ����");
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		Object[] args = {vo.getSeq()};
		int ret = getJdbcTemplate().update(BOARD_DELETE, args);
		System.out.println("===> JDBC�� deleteBoard() ��� ó�� : " + ret + "�� ����");
	}

	// �� �� ��ȸ
	public BoardVO selectBoard(BoardVO vo) {
		System.out.println("===> JDBC�� selectBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return getJdbcTemplate().queryForObject(BOARD_GET, new BoardRowMapper(), args);
	}

	// �� ��� ��ȸ
	public List<BoardVO> selectBoardList(BoardVO vo) {
		System.out.println("===> JDBC�� selectBoardList() ��� ó��");
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
	
}
