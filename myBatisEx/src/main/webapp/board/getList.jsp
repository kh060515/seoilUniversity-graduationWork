<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.seoil.boardWeb.board.service.impl.BoardDAO"%>
<%@page import="kr.ac.seoil.boardWeb.board.vo.BoardVO"%>
<%@page import="kr.ac.seoil.boardWeb.user.vo.UserVO"%>
<%
	UserVO user = (UserVO) request.getSession().getAttribute("user");

	if (user == null) {
		response.sendRedirect("/user/login.jsp");
		return;
	}

	// TODO 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.selectBoardList(vo);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글 목록</title>
	</head>
	<body>
		<center>
			<h1> 글목록</h1>
			<h3><%=user.getUserName() %>님 환영합니다...<a href="/user/logout.jsp">Log-out</a></h3>

			<!-- 검색시작 -->
			<form action="getList.jsp" method="post">
				<table border="1" cellpadding="0" cellspacing="0" width="700">
					<tr>
						<td align="right">
							<select name="searchCondition">
								<option value="TITLE">제목</option>
								<option value="CONTENT">내용</option>
							</select>
							<input type="text" name="searchKeyword" />
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
<% for(BoardVO board : boardList) { %>
				<tr>
					<td><%=board.getSeq() %></td>
					<td align="left">
						<a href="getInfo.jsp?seq=<%=board.getSeq() %>">
							<%=board.getTitle() %>
						</a>
					</td>
					<td><%=board.getWriterName()%></td>
					<td><%=board.getRegDate() %></td>
					<td><%=board.getCnt() %>
				</tr>
<%} %>
			</table>
			<br />
			<a href="regBoard.jsp">새글등록</a>
		</center>
	</body>
</html>









