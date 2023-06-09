<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
</style>
<%
	String err = (String)request.getAttribute("err");
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var err = "<%=err%>";
		if(err == 'not'){
			alert("아이디나 비번이 다릅니다. 다시 로그인 해주세요");
		}
	})
</script>
</head>
<body style="margin:30px;">
<form action="loginaction.do" method="post" class="pure-form pure-form-stacked">
	<fieldset>
        <legend>로그인</legend>

        <label for="id">ID</label>
        <input type="text" name="id" id="id" placeholder="ID">

        <label for="password">Password</label>
        <input id="pw" name="pw" type="password" placeholder="Password">
		
        <input type="submit" class="pure-button pure-button-primary" style="margin-top:10px;" value="로그인">
    </fieldset>
</form>
<a href="mainpage.jsp" class="pure-button">메인페이지로 돌아가기</a>
<a href="idfind.jsp" class="pure-button">아이디 찾기</a>
<a href="pwfind.jsp" class="pure-button">비밀번호 찾기</a>
</body>
</html>