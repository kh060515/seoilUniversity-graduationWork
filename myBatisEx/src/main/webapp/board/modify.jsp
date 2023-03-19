<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ page import="kr.ac.seoil.boardWeb.board.vo.BoardVO"
%><%@ page import="kr.ac.seoil.boardWeb.board.service.impl.BoardDAO"
%><%@ page import="kr.ac.seoil.boardWeb.user.vo.UserVO"
%><%
	UserVO user = (UserVO) request.getSession().getAttribute("user");
	if (user == null) {
		response.sendRedirect("/user/login.jsp");
		return;
	}
	
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	String title = request.getParameter("title");
	String writerName = request.getParameter("writerName");
	String content = request.getParameter("content");
	
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	vo.setTitle(title);
	vo.setWriterName(writerName);
	vo.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	
	response.sendRedirect("getList.jsp");
%>






