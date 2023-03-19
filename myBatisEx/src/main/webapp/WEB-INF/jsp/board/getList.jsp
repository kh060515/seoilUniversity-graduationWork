<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글 목록</title>
	</head>
	<body>
		<center>
			<h1> 글목록</h1>
			<h3>${user.userName}님 환영합니다...<a href="/user/logout.do">Log-out</a></h3>

			<!-- 검색시작 -->
			<form action="getList.do" method="post">
				<table border="1" cellpadding="0" cellspacing="0" width="700">
					<tr>
						<td align="right">
							<select name="searchCondition">
							<c:forEach items="${conditionMap}" var="option">
							<c:set var="sel" value=""/>							
								<c:if test="${param.searchCondition == option.value}">
									<c:set var="sel" value="selected"/>
								</c:if>
								<option value="${option.value}" ${sel}>${option.key}</option>
							</c:forEach>
							</select>
							<input type="text" name="searchKeyword" value="${param.searchKeyword}"/><!-- param: 넘어갔던걸 특정값을 가져온다 -->
							<input type="submit" value="검색" />
						</td>
					</tr>
				</table>
			</form>
			
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<th bgcolor="orange" width="100">번호</th>
					<th bgcolor="orange" width="200">제목</th>
					<th bgcolor="orange" width="150">작성자</th>
					<th bgcolor="orange" width="150">등록일</th>
					<th bgcolor="orange" width="100">조회수</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left">
						<a href="getInfo.do?seq=${board.seq}">${board.title}</a>
					</td>
					<td>${board.writerName}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
				</c:forEach>
			</table>
			<br />
			<a href="reg.do">새글등록</a>
		</center>
	</body>
</html>









