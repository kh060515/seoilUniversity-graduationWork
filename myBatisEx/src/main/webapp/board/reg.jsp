<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ page import="kr.ac.seoil.boardWeb.user.vo.UserVO"
%><%
	UserVO user = (UserVO) request.getSession().getAttribute("user");
	if (user == null) {
		response.sendRedirect("/user/login.jsp");
		return;
	}
%><!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글 등록</title>
	</head>
	<body>
		<center>
			<h1>글 등록</h1>
			<a href="/user/logout.jsp">로그아웃</a>
			<hr />
			<form action="create.jsp" method="post">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="orange" width="70">제목</td>
						<td align="left">
							<input type="text" name="title" value="" />
						</td>
					</tr>
					<tr>
						<td bgcolor="orange">작성자</td>
						<td align="left">
							<input type="text" name="writerName" value="<%=user.getUserName() %>" />
						</td>
					</tr>
					<tr>
						<td bgcolor="orange">내용</td>
						<td align="left">
							<textarea name="content" cols="40" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="글 등록" />
						</td>
					</tr>
				</table>
			</form>
			<hr />
			<a href="getList.jsp">글목록</a>
		</center>
	</body>
</html>