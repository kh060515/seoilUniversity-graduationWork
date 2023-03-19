<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글상세</title>
	</head>
	<body>
		<center>
			<h1>글상세</h1>
			<a href="/user/logout.do">로그아웃</a>
			<hr />
			<form action="modify.do" method="post">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="orange" width="70">제목</td>
						<td align="left">
							<input type="hidden" name="seq" value="${board.seq}" />
							<input type="text" name="title" value="${board.title}" />
						</td>
					</tr>
					<tr>
						<td bgcolor="orange">작성자</td>
						<td align="left">${board.writerName}</td>
					</tr>
					<tr>
						<td bgcolor="orange">등록일</td>
						<td align="left">${board.regDate}</td>
					</tr>
					<tr>
						<td bgcolor="orange">조회수</td>
						<td align="left">${board.cnt}</td>
					</tr>
					<tr>
						<td bgcolor="orange">내용</td>
						<td align="left">
							<textarea name="content" cols="40" rows="10">
								${board.content}
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
			<a href="reg.do">글등록</a>&nbsp;&nbsp;&nbsp;
			<a href="remove.do?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
			<a href="getList.do">글목록</a>
		</center>
	</body>
</html>










