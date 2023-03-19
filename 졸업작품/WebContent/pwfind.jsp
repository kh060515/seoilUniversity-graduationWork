<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		width: 100px;
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
<script type="text/javascript">
	window.onload=function(){
	$("#cknumTe11").hide();
	$("#cknum").hide();
	$("#label2").hide();
	$("#submit2").hide();
	$("#itr").hide();
	$("#cancle").hide();
	}
	
	function pwcknum(){
		var id=$("#id").val();
		var mail=$("#mail").val();
		
		if(!id){
			alert("id를 입력해주세요");
			$("id").focus();
			return false;
		}else if(!mail){
			alert("메일을 입력해주세요");
			$("#mail").focus();
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
						$("#cknumTe11").show();
						$("#cknum").show();
						$("#label2").show();
						$("#submit2").show();
						$("#itr").show();
						$("#cancle").show();
						
						$.ajax({
			    			url:"findpw.do",
			    			type:"get",
			    			data : {
			    				"id" : id,
			    				"mail" : mail
			    			},
			    			datatype:"json",
			    	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
			    			success:function(data){
			    				$("#aTagOk").val("Y"); 			    				
			    			},
			    			error:function(data){
			    				alert("중복확인 오류");
			    			}
			    		});  
												
					} else {
						alert("잘못된 메일 입니다.");

						document.getElementById('mail').value = '';
						$("#mail").focus();						
					}
				},
				error : function(data) {
					alert("중복확인 오류");
				}
			});
		}		
	}
	function cknumcheck(){	
		var cknum=$("#cknum").val();
		
		$.ajax({
			url:"cknumcheck.numck2",
			type:"post",
			data : {				
				"cknum" : cknum
			},
			datatype:"json",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
			success:function(data){
				if(data.cnt == 1){
					alert("인증번호 확인 완료");
					$("#cknum").attr("readonly", "readonly");					
					$("#cknumok").val("Y"); 						
				} else {				
					alert("인증번호가 불일치 합니다.");
				}
			},
			error:function(data){
				alert("중복확인 오류");
			}
		});
	}
	function  formsubmit(){
		var cknumok=$("#cknumok").val();
		if(cknumok!='Y'){
			alert("인증번호 확인을 진행해주세요.");
			return false;
		}		
	}
</script>
<title>비밀번호 찾기</title>
</head>
<body>
<form onsubmit="return formsubmit();" action="pwnumcksubmit.do">
	<img alt="" src="img/상단메뉴및로고2.png">
	<h3 style="margin-left: 23%; margin-top: 30px;">회원정보 입력</h3>
	<input type="hidden" id="cknumok" value="N" name="cknumok">
	<table id="Lta" border="1">
		<tr>
			<td id="Lta"><label id="Lltd">아이디</label></td>
			<td id="Ltd"><input type="text" name="id" id="id" class="Lin"></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">메일</label></td>
			<td id="Ltd"><input class="Lin" type="text" name="mail" id="mail"><button type="button" onclick="javascript:pwcknum()">인증번호 전송</button></td>
		</tr>
		<tr id="itr">
			<td id="Lta"><label id="Lltd">인증번호</label></td>
			<td id="Ltd"><input type="text" class="Lin" name="cknum" id="cknum"><button type="button" onclick="javascript:cknumcheck()" name="cknumTe11" id="cknumTe11">인증번호 확인</button></td>
		</tr>		
	</table>
	<input type="image" src="img/확인아이콘.png" style="margin-left:30%; margin-top: 3%;" action='pwnumcksubmit.do' name="submit2" id="submit2"><a href="mainpage.jsp"><img id="cancle" name="cancle" style="margin-top: 10px; margin-left: 30px;" src="img/취소아이콘.png"></a>
</form>
</body>
</html>