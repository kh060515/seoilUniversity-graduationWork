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
	
	// 1.검색할 게시글 번호 추출
	String seq = request.getParameter("seq");
	
	// 2.DB 연동처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.selectBoard(vo);
%><!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글상세</title>
	</head>
	<body>
		<center>
			<h1>글상세</h1>
			<a href="/user/logout.jsp">로그아웃</a>
			<hr />
			<form action="modify.jsp" method="post">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="orange" width="70">제목</td>
						<td align="left">
							<input type="hidden" name="seq" value="<%=board.getSeq() %>" />
							<input type="text" name="title" value="<%=board.getTitle() %>" />
						</td>
					</tr>
					<tr>
						<td bgcolor="orange">작성자</td>
						<td align="left"><%=board.getWriterName() %></td>
					</tr>
					<tr>
						<td bgcolor="orange">등록일</td>
						<td align="left"><%=board.getRegDate() %></td>
					</tr>
					<tr>
						<td bgcolor="orange">조회수</td>
						<td align="left"><%=board.getCnt() %></td>
					</tr>
					<tr>
						<td bgcolor="orange">내용</td>
						<td align="left">
							<textarea name="content" cols="40" rows="10">
								<%=board.getContent() %>
							</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="글 수정" />
						</td>
					</tr>
				</table>
			</form>
			<hr />
			<a href="reg.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
			<a href="remove.jsp?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
			<a href="getList.jsp">글목록</a>
		</center>
	</body>
</html>










