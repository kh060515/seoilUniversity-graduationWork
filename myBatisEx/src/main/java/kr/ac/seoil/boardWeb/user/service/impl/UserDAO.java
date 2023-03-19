package kr.ac.seoil.boardWeb.user.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.seoil.boardWeb.common.JDBCUtil;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

public class UserDAO {
	//JDBC ���ú���
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL ��ɾ�
	private final String USER_SELECT = "SELECT * FROM USERS WHERE USER_ID=? AND PASSWORD=?";
	
	// CRUD ����� �޼ҵ� ����
	// �α���
	public UserVO selectUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC selectUser() ���ó��");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_SELECT);
			stmt.setString(1, vo.getUserId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setUserId(rs.getString("USER_ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}











