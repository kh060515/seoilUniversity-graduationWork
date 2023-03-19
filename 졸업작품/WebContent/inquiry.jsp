<%@page import="com.domain.MembershipDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div#submit2 {
	position: relative;
	left: 300px;
}
</style>
<link href="/css/jquery-ui.css" rel="stylesheet" />
<link href="/css/font.css" rel="stylesheet" />
<link href="/css/print.css" rel="stylesheet" />
<link href="/css/help_reset.css" rel="stylesheet" />
<link href="/css/help_common.css" rel="stylesheet" />
<link href="/css/game_help.css" rel="stylesheet" />
<link href="/css/all.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function closePopup() {
		alert("전송되었습니다.");
		window.close();
	}		
</script>
<meta charset="UTF-8">
<title>고객 문의</title>
</head>
<body style="margin: 30px; margin-top: 30px">
	<%
	MembershipDTO login = (MembershipDTO) request.getSession().getAttribute("login");
	%>
	<form class="pure-form pure-form-stacked" action="inquiry.do">
		<fieldset>
			<div class="help_question_tit">
				<legend style="margin-top: 20px; margin-left: 50px">
					<h3>문의입력</h3>
				</legend>
			</div>
			<div class="help_tbl_common help_tbl_style01">
				<table>
					<caption
						style="margin-bottom: 10px; margin-top: 30px; margin-left: 20px"></caption>
					<colgroup>
						<col style="width: 13%">
						<col style="width: 37%">
						<col style="width: 12%">
						<col style="width: 38%">
					</colgroup>
					<tbody style="margin-top: 30px">
						<tr>
							<th scope="row"><label>제목</label></th>
							<td colspan="3"><input type="text" style="width: 631px"
								class="input_st" id="inquiry_ctitle" name="title"></td>
						</tr>
						<tr>
							<th scope="row"><label>메일</label></th>
							<td colspan="3"><input type="text" style="width: 631px"
								class="input_st" id="inquiry_ctitle" readonly="readonly" name="mail"
								value="<%=login.getMail()%>"></td>
						</tr>
						<tr id="inquirytrText">
							<th><label>내용</label></th>
							<td colspan="3"><textarea class="input_st"
									id="inquiry_receptionform" style="width: 631px; height: 150px" name="content"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<button type="submit" name="submit2" id="submit2" onclick="javascript:closePopup();"
					class="pure-button pure-button-primary"
					style="margin-top: 10px; margin-left: 630px" value="문의신청">문의신청</button>
				<button class="pure-button pure-button-primary"
					style="margin-top: 10px; margin-left: 630px" value="취소">취소</button>
			</div>
		</fieldset>
	</form>
</body>
</html>