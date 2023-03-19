package kr.ac.seoil.boardWeb.user.vo;

import java.io.Serializable;

public class UserVO implements Serializable {
	private static final long serialVersionUID = -6329722468871619433L;
	private String userId;
	private String password;
	private String userName;
	private String role;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", password=" + password + ", userName=" + userName + ", role=" + role
				+ "]";
	}
}
