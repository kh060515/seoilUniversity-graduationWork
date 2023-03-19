<%@page import="com.domain.MembershipDTO"%>
<%@page import="com.function.MailExam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script type="text/javascript">
	window.onload=function(){
	$("#cknumTe10").hide();
	$("#num3").hide();
	$("#label2").hide();
	$("#submit2").hide();
	$("#itr").hide();
	$("#cancle").hide();
	}
	
	function idcknum() {
		var mail = $("#mail").val();
		var name = $("#name").val();
		var nameck=$("#nameck").val();

		if(name.length!=4){					
			alert("비밀번호를 4글자로 입력해주세요");
			document.getElementById('name').value='';
			$("#name").focus();
			return false;
		}
		if (!name) {
			alert("비밀번호를 입력해주세요");
			$("#name").focus();

			return false;
		}else if (!mail) {
			alert("메일을 입력해주세요");
			$("#mail").focus();

			return false;
			
		}else if(!nameck){
			alert("비밀번호 확인을 입력해주세요");
			$("#nameck").focus();
			return false;
		}else if(name!=nameck){
			alert("비밀번호와 비밀번호확인을 동일하게 입력 해주세요");
			$("#nameck").focus();
			return false;
		}else{
			$.ajax({
				url : "mailcheck2.ck10",
				type : "post",
				data : {
					"mail" : mail
				},
				datatype : "json",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success : function(data) {
					if (data.cnt == 1) {
						alert("발송되었습니다.");
						$("#mail").attr("readonly", "readonly");
						var temp = $("#mail").val();
						$("#cknumTe10").show();
						$("#num3").show();
						$("#label2").show();
						$("#submit2").show();
						$("#itr").show();
						$("#cancle").show();
						$.ajax({
			    			url:"creaAcNum.do",
			    			type:"get",
			    			data : {		    				
			    				"mail" : mail
			    			},
			    			datatype:"json",
			    	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
			    			success:function(data){
			    				$("#aTagOk").val("Y"); 			    				
			    			},
			    			error:function(data){
			    				
			    			}
			    		});  
												
					} else {
						alert("잘못된 메일 입니다.");

						document.getElementById('mail').value = '';
						$("#mail").focus();						
					}
				},
				error : function(data) {
					
				}
			});
		}		
	}
		
	function  formsubmit(){
		var cknumok=$("#cknumok").val();
		if(cknumok!='Y'){
			alert("인증번호 확인을 진행해주세요.");
			return false;
		}
	}
	
	
	function cknumcheck(){	
		var num3=$("#num3").val();
		
		$.ajax({
			url:"cknumcheck.numck3",
			type:"post",
			data : {				
				"num3" : num3
			},
			datatype:"json",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
			success:function(data){
				if(data.cnt == 1){
					alert("인증번호 확인 완료");
					$("#num3").attr("readonly", "readonly");					
					$("#cknumok").val("Y"); 						
				} else {				
					alert("인증번호가 불일치 합니다.");
				}
			},
			error:function(data){
				
			}
		});
	}
</script>
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
	<form onsubmit="return formsubmit();" action="createbk.do">
		<img alt="" src="img/계좌개설로고.png">
		<h3 style="margin-left: 23%; margin-top: 30px;">계좌정보 입력</h3>
		<input type="hidden" id="cknumok" value="N" name="cknumok">		
		<table id="Lta" border="1">
			<tr>
				<td id="Lta"><label id="Lltd">비밀번호</label></td>
				<td id="Ltd"><input type="number" name="name" id="name" maxlength="4" class="Lin"></td>
			</tr>
			<tr>
				<td id="Lta"><label id="Lltd">비밀번호 확인</label></td>
				<td id="Ltd"><input type="password" name="nameck" id="nameck" maxlength="4" class="Lin" onchange="check_pw()"></td>
			</tr>
			<tr>
				<td id="Lta"><label id="Lltd">메일</label></td>
				<td id="Ltd"><input type="text" name="mail" id="mail" class="Lin"> <button type="button" onclick="javascript:idcknum()">인증번호 전송</button></td>
			</tr>
			<tr id="itr">
				<td id="Lta"><label id="Lltd">인증번호</label></td>
				<td id="Ltd"><input type='text' name='num3' id='num3' class="Lin"><button type="button" onclick="javascript:cknumcheck()" name="cknumTe10" id="cknumTe10">인증번호 확인</button></td>
			</tr>
		</table>
			<input type="image" src="img/확인아이콘.png" style="margin-left:44%; margin-top: 1%;" name="submit2" id="submit2"><a href="mainpage.jsp"><img id="cancle" name="cancle" style="margin-top: 10px; margin-left: 30px;" src="img/취소아이콘.png"></a>				
	</form>
</body>
</html>