<%@page import="com.domain.AccountInfoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.MembershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title>송금</title>

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
		margin-top: 30px;
	}
	table[id=Rta]{
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
	td[id=Lta]{
		background-color: rgb(243,244,246);
		width: 200px;
		height: 50px;	
	}
	td[id=Lata]{		
		width: 300px;
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
	td[id=Rtd]{
		width: 100px;
		height:20px;
		margin-left: 20px;
		
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
<%
	MembershipDAO dao=new MembershipDAO();
	ArrayList<AccountInfoDTO> list=(ArrayList<AccountInfoDTO>)session.getAttribute("list");
%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
//계좌의 갯수에 따라서 송금화면에 보여줄 계좌구분을 위한 함수, submit시 전송할 계좌를 구분하기위한 함수 시작
	function discriminant1() {
		document.getElementById('balance').value =<%=list.get(0).getCredit()%>;
		document.getElementById('sendForAccountNumber').value=<%=list.get(0).getsAccountNumber()%>;
	}
	function discriminant2() {
		document.getElementById('balance').value =<%=list.get(1).getCredit()%>;
		document.getElementById('sendForAccountNumber').value=<%=list.get(1).getsAccountNumber()%>;
	}
	function discriminant3() {
		document.getElementById('balance').value =<%=list.get(2).getCredit()%>;
		document.getElementById('sendForAccountNumber').value=<%=list.get(2).getsAccountNumber()%>;
	}
//계좌의 갯수에 따라서 송금화면에 보여줄 계좌구분을 위한 함수 끝

	function maxmoneydistinguish(){
		//송금할 금액을 입력할 때 가지고 있는 잔액의 최대치를 넘게 입력 못하게 하는 함수
		var maxmoney=0;
		maxmoney=parseInt(document.getElementById("balance").value);
		var sendmoney2=0;
		sendmoney2=parseInt(document.getElementById("sendmoney").value);
		
		if (sendmoney2>maxmoney) {
			window.alert('소유한 금액을 초과할 수 없습니다.');
			document.getElementById('sendmoney').value=maxmoney;
		}
	}
	
	function formsubmit(){
		//송금 버튼 클릭 시 비어있는 칸이 존재할 경우 송금하는걸 막기 위한 함수
		if(!jQuery('input[name="choiceAc"]:checked').val()){
			alert("계좌를 선택해주세요.");
			return false;
		}
		if(!jQuery('input[name="selectbk"]:checked').val()){
			alert("은행를 선택해주세요.");
			return false;
		}
		var sendmoney=$("#sendmoney").val();
		if(!sendmoney){
			alert("금액을 입력해주세요.");
			$("#sendmoney").focus();
			return false;
		}
		if((sendmoney%10)!=0){
			alert("10원 단위로 입력해주세요.");
			$("#sendmoney").focus();
			return false;
		}
	}
	
	function accountnumberCheck() {
		//보낼려는 계좌가 올바른 계좌인지 확인하는 과정
		if (!jQuery('input[name="selectbk"]:checked').val() ) {
  		  alert('은행을 선택해주세요.');
  		  jQuery('input[name="selectbk"]').focus();
          return false;
		}
		var account=$("#account").val();
		var selectbk=$("input:radio[name='selectbk']:checked").val();
		$.ajax({
			url:"accountnumberck.money2",
			type:"post",
			data : {
				"account" : account,
				"selectbk" : selectbk		
			},
			datatype:"json",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
			success:function(data){
				if(data.cnt == 1){
					alert("계좌 확인 완료");
					$("#account").attr("readonly", "readonly");    	
					$("#selectbk").attr("readonly", "readonly"); 
					$("#accountNumberCheck").val("Y"); 		
				} else {
					alert("유효하지 않은 계좌번호 입니다.");   	
					document.getElementById('account').value='';
					$("#account").focus();
				}
			},
			error:function(data){
				alert("중복확인 오류");
			}
		});   
	}
</script>
</head>
<body>
	<form action="sendmoney.do" method="get" onsubmit="return formsubmit();">
	<input type="hidden" value="N" id="accountNumberCheck">
	<input type="hidden" value="temp1" id="sendForAccountNumber" name="sendForAccountNumber">	<%--선택된 계좌를 submit으로 넘겨주기 위한 input --%>
	<img alt="" src="img/계좌송금로고.png">
		<h3 style="margin-left: 23%; margin-top: 30px;">계좌정보 입력</h3>
		<h4 style="margin-left: 23%;">사용할 계좌 선택</h4>
		<table id="Rta" border="1">
			<tr>			
			<%--생성된 계좌 갯수에 따라서 출력되는 계좌가 다르기 때문에 if문 사용. --%>
			<c:if test="${fn:length(list)==3}">
				<td id="Lata"><input name="choiceAc" id="choiceAc" type="radio" class="radio-value1" value="nullcheck" onclick="javascript:discriminant1()"> 계좌:<%=list.get(0).getsAccountNumber()%>  잔액:<%=list.get(0).getCredit() %></td>
				<td id="Lata"><input name="choiceAc" id="choiceAc" type="radio" class="radio-value2" value="nullcheck" onclick="javascript:discriminant2()"> 계좌:<%=list.get(1).getsAccountNumber() %>  잔액:<%=list.get(1).getCredit() %></td>
				<td id="Lata"><input name="choiceAc" id="choiceAc" type="radio" class="radio-value3" value="nullcheck" onclick="javascript:discriminant3()"> 계좌:<%=list.get(2).getsAccountNumber() %>  잔액:<%=list.get(2).getCredit() %></td>
			</c:if>	
			<c:if test="${fn:length(list)==2}">
				<td id="Lata"><input name="choiceAc" id="choiceAc" type="radio" class="radio-value1" value="nullcheck" onclick="javascript:discriminant1()"> 계좌:<%=list.get(0).getsAccountNumber() %>  잔액:<%=list.get(0).getCredit() %></td>
				<td id="Lata"><input name="choiceAc" id="choiceAc" type="radio" class="radio-value2" value="nullcheck" onclick="javascript:discriminant2()"> 계좌:<%=list.get(1).getsAccountNumber() %>  잔액:<%=list.get(1).getCredit() %></td>
			</c:if>	
			<c:if test="${fn:length(list)==1}">
				<td id="Lata"><input name="choiceAc" id="choiceAc" type="radio" class="radio-value1" value="nullcheck" onclick="javascript:discriminant1()"> 계좌:<%=list.get(0).getsAccountNumber() %>  잔액:<%=list.get(0).getCredit() %></td>				
			</c:if>						
			</tr>		
		</table>

		<h4 style="margin-left: 23%;">은행선택</h4>
		<table id="Rta" border="1">
			<tr>
				<td id="Rtd"><input type="radio" name="selectbk" id="selectbk" value="서일은행">서일은행</td>
				<td id="Rtd"><input type="radio" name="selectbk" id="selectbk" value="국미은행">국미은행</td>
				<td id="Rtd"><input type="radio" name="selectbk" id="selectbk" value="신하은행">신하은행</td>
				<td id="Rtd"><input type="radio" name="selectbk" id="selectbk" value="한나은행">한나은행</td>
			</tr>
		</table>
		
		<table id="Lta" border="1">			
			<tr>
				<td id="Lta"><label id="Lltd">계좌</label></td>
				<td id="Ltd"><input id="account" name="account" class="Lin"><button type="button" onclick="accountnumberCheck()">계좌 확인</button></td>
			</tr>
			<tr>
				<td id="Lta"><label id="Lltd">금액</label></td>
				<td id="Ltd"><input id="sendmoney" name="sendmoney" class="Lin" onchange="maxmoneydistinguish()">잔액: <input type="text" name="balance" id="balance" value="0" readonly="readonly"></td>
			</tr>
		</table>
	<input type="image" src="img/확인아이콘.png" style="margin-left:44%; margin-top: 1%;"name="submit2" id="submit2"><a href="mainpage.jsp"><img id="cancle" name="cancle" style="margin-top: 10px; margin-left: 30px;" src="img/취소아이콘.png"></a>
	</form>
</body>
</html>