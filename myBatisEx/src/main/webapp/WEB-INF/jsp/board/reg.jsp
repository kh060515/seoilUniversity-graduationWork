<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib
	uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		<a href="/user/logout.do">로그아웃</a>
		<hr />
		<form action="create.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title" value="" />
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="text" name="writerName"
						value="${user.userName}" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">첨부파일</td>
					<td align="left">
						<input type="file" name="attach" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 등록" /></td>
				</tr>
			</table>
		</form>
		<hr />
		<a href="getList.do">글목록</a>
	</center>
</body>
</html>