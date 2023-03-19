package kr.ac.seoil.boardWeb.board.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriterName(rs.getString("WRITER_NAME"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REG_DATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
}
