<%@page import="java.util.ArrayList"%>
<%@page import="com.domain.AccountInfoDTO"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dao.MembershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
	label[id=Lla]{
		margin-left: 7%;
		font-size: 15px;
		font-family: "나눔고딕";
	}
	div[id=Ldi]{
		border: 1px solid;
		width: 1081px;
		height:140px;
		margin-left: 23%;
		margin-top:1%;
		background-color: rgb(249,250,255);
		
	}
	br[id=Lbr]{
		line-height: 5em;
	}
	label[id=Ldivtitle]{
		margin-top:5px;
		font-family: "나눔고딕";
	}
	table[id=Lta]{
		margin-left: 27%;	
		margin-top:50px;	
		border-color: rgb(210,223,235);	
		border-bottom-color:rgb(210,223,235);
		border-left: none;
		border-collapse: collapse;
		border-spacing: 0;	
		border-right: none;	
		border-top-color: rgb(0,120,231);
		border-top:1; 
	}
	td[id=Lta]{
		background-color: rgb(243,244,246);
		width: 200px;
		height: 50px;	
	}
	td[id=Ltd]{		
		width: 450px;
		height: 50px;
				
	}
	td[id=Ltitle]{
		background-color:rgb(220,233,246);
		width: 200px;
		height: 20px;
		margin-left: 30%;
	}
	td[id=dtitle]{
		background-color:rgb(220,233,246);
		width: 450px;
		height: 20px;
		margin-left: 30%;
	}
	input[class=Lin]{
		margin-left: 30px;
		border: none;
		background-color: rgb(234,236,239);
		box-shadow: inset 0 1px 3px #ddd;
		width: 250px;
		height: 30px;
	}
	input[class=Lin2] {
		border: none;
		background-color: rgb(234,236,239);
		box-shadow: inset 0 1px 3px #ddd;
	}
	button {
		width: 120px;
		height: 30px;	
		border: none;
		margin-left: 20px;
		display: inline-block;
		zoom: 1;
		white-space: nowrap;
		vertical-align: middle;
		text-align: center;
		cursor: pointer;
		-webkit-user-drag: none;
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
		box-shadow: inset 0 1px 3px #ddd;
		border: 1px solid #ccc;
	}
	label[class=Lltd]{
		margin-left: 30px;
	}
</style>
<%	
	ArrayList<AccountInfoDTO> list=(ArrayList<AccountInfoDTO>)session.getAttribute("list");
%>


</head>
<body>
	<img alt="" src="img/계좌조회로고.png">
	<form action="sendmoney.jsp">
	<table id="Lta" border="1">		
		<tr>
			<td id="dtitle">계좌번호</td>
			<td id="Ltitle">잔액</td>
		</tr>		
		<c:forEach var="AccountInfoDTO" items="${list}" varStatus="status">
		<%--forEach문이 돌아갈때마다 count를 하기 위하여 varstatus정의 count하는 이유는 송금버튼을 눌렀을 시 해당 송금버튼이 있는 행의 정보들만 sendmoney.jsp로 넘겨주기 위함--%>			
		<tr>		
			<td id="Ltd"><label id="accountNumber${status.count}" name="accountNumber${status.count}" class="Lltd">${AccountInfoDTO.sAccountNumber}</label></td>
			<td id="Lta"><label id="credit${status.count}" name="credit${status.count}" class="Lltd">${AccountInfoDTO.credit}</label></td>	
		</tr>		
		</c:forEach>		
	</table>
	<button type="submit">송금</button><button type="button" onclick="location.href='mainpage.jsp'">메인페이지</button>
	</form>	
</body>
</html>