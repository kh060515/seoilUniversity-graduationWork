<%@page import="java.util.ArrayList"%>
<%@page import="com.domain.SendPaperDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>송금 내역서</title>
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
		margin-left: 23%;		
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
		width: 880px;
		height: 50px;
				
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
	label[id=Lltd]{
		margin-left: 30px;
	}
</style>
</head>
<body>
<%--<%List<SendPaperDTO> list=new ArrayList<SendPaperDTO>(); --%>
	<img alt="" src="img/송금내역서로고.png">
	<table id="Lta" border="1">
		<tr>
			<td id="Lta"><label id="Lltd">보낸계좌번호</label></td>
			<td id="Ltd"><label><%--<%=list.get(0).getSendAccount()--%></label></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">받은계좌번호</label></td>
			<td id="Ltd"><input type="text" id="mail" name="mail" class="Lin"></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">은행명</label></td>
			<td id="Ltd"><input type="text" id="mail" name="mail" class="Lin"></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">송금금액</label></td>
			<td id="Ltd"><input type="text" id="mail" name="mail" class="Lin"></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">남은잔액</label></td>
			<td id="Ltd"><input type="text" id="mail" name="mail" class="Lin"></td>
		</tr>
	</table>	
</body>
</html>