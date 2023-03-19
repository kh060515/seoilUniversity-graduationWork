package kr.ac.seoil.boardWeb.board.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.seoil.boardWeb.board.vo.BoardVO;
import kr.ac.seoil.boardWeb.common.JDBCUtil;

// DAO(Data Access Object)
//@Repository("boardDAO")
public class BoardDAO {
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// SQL ��ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer_name, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?,content=?,writer_name=?,cnt=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC�� insertBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriterName());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC�� updateBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getWriterName());
			stmt.setInt(4, vo.getCnt());
			stmt.setInt(5, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC�� deleteBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// �� �� ��ȸ
	public BoardVO selectBoard(BoardVO vo) {
		System.out.println("===> JDBC�� selectBoard() ��� ó��");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriterName(rs.getString("WRITER_NAME"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REG_DATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}

	// �� ��� ��ȸ
	public List<BoardVO> selectBoardList(BoardVO vo) {
		System.out.println("===> JDBC�� selectBoardList() ��� ó��");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriterName(rs.getString("WRITER_NAME"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REG_DATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}