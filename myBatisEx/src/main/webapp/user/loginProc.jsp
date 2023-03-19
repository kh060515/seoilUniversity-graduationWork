<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@page import="kr.ac.seoil.boardWeb.user.service.impl.UserDAO"
%><%@page import="kr.ac.seoil.boardWeb.user.service.impl.UserServiceImpl"
%><%@page import="kr.ac.seoil.boardWeb.user.vo.UserVO"
%><%
	// 1. 사용자 입력정보 추출
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setUserId(userId);
	vo.setPassword(password);
	
//	UserServiceImpl userService = new UserServiceImpl();
//	UserVO user = userService.getUser(vo);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.selectUser(vo);

	// 3. 화면 내비게이션
	if (user != null) {
		request.getSession().setAttribute("user", user);
		response.sendRedirect("../board/getList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>
