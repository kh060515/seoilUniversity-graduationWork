<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.function.Function"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">    
    function maxLengthCheck(object) {
		if (object.value.length>object.maxLength) {
			object.value=object.value.slice(0,object.maxLength);
		}
	}
        function check_pw(){
            var pw = document.getElementById('pw').value;
            var SC = ["!","@","#","$","%","^","&","*","(",")",",","."];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pw').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            
            if(check_SC == 0){
                window.alert('특수문자가 들어가 있지 않습니다.')
                document.getElementById('pw').value='';
            }
            if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
                if(document.getElementById('pw').value==document.getElementById('pw2').value){
                    document.getElementById('check').innerHTML='V';
                    document.getElementById('check').style.color='green';
                    $("#pwcheckok").val("Y"); 
                }
                else{
                    document.getElementById('check').innerHTML='X';
                    document.getElementById('check').style.color='red';
                    $("#pwcheckok").val("N"); 
                }               
            }          
        }      
        
        function idcheck(){
    		var id = $("#id").val();

    		$.ajax({
    			url:"idcheck.ck",
    			type:"post",
    			data : {
    				"id" : id					
    			},
    			datatype:"json",
    	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
    			success:function(data){
    				if(data.cnt == 0){
    					alert("사용가능한 아이디 입니다.");
    					$("#id").attr("readonly", "readonly");
    					var temp=$("#pw").val();
						$("#idcheckok").val("Y"); 						
    				} else {
    					document.getElementById('id').value='';
    					$("#id").focus();
    					alert("이미 사용중인 아이디입니다.");
    				}
    			},
    			error:function(data){
    				alert("중복확인 오류");
    			}
    		});
    	}

        function mailcheck() {
        	var mail1=$("#mail1").val()+"@"+$("#mail2").val();
        	
        	$.ajax({
    			url:"mailcheck.ck3",
    			type:"post",
    			data : {
    				"mail1" : mail1		  				
    			},
    			datatype:"json",
    	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
    			success:function(data){
    				if(data.cnt == 0){
    					alert("사용가능한 메일 입니다.");
    					$("#mail1").attr("readonly", "readonly");    					 					
						var temp=$("#mail1").val();
						$("#mailcheckok").val("Y"); 
						
    				} else {
    					alert("이미 사용중인 메일입니다.");   	
    					document.getElementById('mail1').value='';
    					$("#mail1").focus();
    				}
    			},
    			error:function(data){
    				alert("중복확인 오류");
    			}
    		});   		        
		}
        
        function jumincheck() {
        	var jumin=$("#jumin1").val()+"-"+$("#jumin2").val();
        	
        	$.ajax({
    			url:"jumincheck.ck4",
    			type:"post",
    			data : {
    				"jumin" : jumin		  				
    			},
    			datatype:"json",
    	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
    			success:function(data){
    				if(data.cnt == 0){
    					alert("사용가능한 주민번호 입니다.");
    					$("#jumin1").attr("readonly", "readonly");    	
    					$("#jumin2").attr("readonly", "readonly"); 
						var temp=$("#jumin").val();
						$("#jumincheckok").val("Y"); 
						
    				} else {
    					alert("이미 등록된 주민번호 입니다.");   	
    					document.getElementById('jumin1').value='';
    					document.getElementById('jumin2').value='';
    					$("#jumin1").focus();
    				}
    			},
    			error:function(data){
    				alert("중복확인 오류");
    			}
    		});   		        
		}
        
        function phonecheck() {
        	var phone=$("#phone").val();
        	if (!phone) {
				alert("전화번호를 입력 후 중복확인을 진행해주세요.");
				$("#phone").focus();
			}else{
				$.ajax({
	    			url:"phonecheck.ck2",
	    			type:"post",
	    			data : {
	    				"phone" : phone				
	    			},
	    			datatype:"json",
	    	        contentType: "application/x-www-form-urlencoded; charset=utf-8",			
	    			success:function(data){
	    				if(data.cnt == 0){   		
	    					alert("사용가능한 전화번호 입니다.");
	    					$("#phone").attr("readonly", "readonly");
	    					var temp=$("#phone").val();
	    					$("#phonecheckok").val("Y"); 
													
	    				} else {
	    					alert("이미 사용중인 번호입니다.");
	    					document.getElementById('phone').value='';
	    					$("#phone").focus();
	    					return false;
	    				}
	    			},
	    			error:function(data){
	    				alert("중복확인 오류");
	    			}
	    		});    		      
			}     	
		}
        
        
        function check_jumin1(){
        	var jumin1=document.getElementById('jumin1').value;        	        	
        	if(jumin1.length!=6)
        		{
        			window.alert('주민번호 앞자리는 6글자로 해주세요.');
        			document.getElementById('jumin1').value='';
        		}        	        	
        }
        
        function check_jumin2(){
        	var jumin2=document.getElementById('jumin2').value;  
        	if(jumin2.length!=7)
    		{
    			window.alert('주민번호 뒷자리는 7글자로 해주세요.');
    			document.getElementById('jumin2').value='';
    		}               	
        }
        
        function formsubmit(){
        	var jumin1= $("#jumin1").val();
        	if(!jumin1){
        		alert("주민번호를 입력해주세요");
        		$("#jumin1").focus();
        		return false;
        	}
        	
        	var jumin2= $("#jumin2").val();
        	if(!jumin2){
        		alert("주민번호 뒷자리를 입력해주세요");
        		$("#jumin2").focus();
        		return false;
        	}
        	
        	var id= $("#id").val();
        	if(!id){
        		alert("아이디를 입력해주세요");
        		$("#id").focus();
        		return false;
        	}
        	
        	var pw= $("#pw").val();
        	if(!pw){
        		alert("비밀번호를 입력해주세요");
        		$("#pw").focus();
        		return false;
        	}
        	
        	var pw2= $("#pw2").val();
        	if(!pw2){
        		alert("비밀번호 확인를 입력해주세요");
        		$("#pw2").focus();
        		return false;
        	}
        	
        	var name= $("#name").val();
        	if(!name){
        		alert("이름을 입력해주세요");
        		$("#name").focus();
        		return false;
        	}
        	
        	var mail1= $("#mail1").val();
        	if(!mail1){
        		alert("메일을 입력해주세요");
        		$("#mail1").focus();
        		return false;
        	}
        	
        	var phone= $("#phone").val();
        	if(!phone){
        		alert("휴대폰번호를 입력해주세요");
        		$("#phone").focus();
        		return false;
        	}
        	
        	var idck = $("#idcheckok").val();
    		if(idck != 'Y'){
    			alert("ID 중복확인이 필요합니다.");
    			$("#id").focus();
    			return false;
    		}  
    		var mailck = $("#mailcheckok").val();
    		if(mailck != 'Y'){
    			alert("mail 중복확인이 필요합니다.");
    			$("#mail1").focus();
    			return false;
    		}    	
    		var phoneck = $("#phonecheckok").val();
    		if(phoneck != 'Y'){
    			alert("휴대폰번호 중복확인이 필요합니다.");
    			$("#phone").focus();
    			return false;
    		}      		
    		var pwck = $("#pwcheckok").val();
    		if(pwck != 'Y'){
    			alert("비밀번호를 확인 해주세요.");
    			$("#pw").focus();
    			return false;
    		}  
    		var juminck = $("#jumincheckok").val();
    		if(juminck != 'Y'){
    			alert("주민번호 확인을 진행해주세요.");
    			$("#jumin1").focus();
    			return false;
    		}    
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
	}
	input[class=Lin2] {
		border: none;
		background-color: rgb(234,236,239);
		box-shadow: inset 0 1px 3px #ddd;
	}
	button {
		width: 70px;
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
<title>회원가입</title>
</head>
<body>
<form onsubmit="return formsubmit();" method="post" action="JoinMembership.do" name="userInfo" id="joinForm">
		<input type="hidden" id="idcheckok" value="N"> 
		<input type="hidden" id="phonecheckok" value="N"> 
		<input type="hidden" id="mailcheckok" value="N"> 
		<input type="hidden" id="pwcheckok" value="N"> 
		<input type="hidden" id="jumincheckok" value="N">
			
	<img alt="" src="img/상단메뉴및로고.png">
	<div id="Ldi">		
			<label id="Ldivtitle" style="margin-left: 5%;"><b>안내 및 유의사항</b></label>
			<hr width="1000px;">
			<label id="Lla">서일은행에 등록된 계좌는 졸업작품을 위한 계좌인 것이므로 아무나 사용할 수 있음을 공지하며 안내 및 유의사항에 텍스트를</label>	<br id="Lbr">
			<label id="Lla">채워야하는데 정작 채울건 없고 이거 언제 다채우나 싶기도 하고 그냥 여백으로 남겨두긴 좀 그래서 아무 말이나 쓰고 있긴 </label><br id="Lbr">
			<label id="Lla">한데 최소 5줄은 넘게 써야지 안내 및 유의사항이 좀 괜찮아 보일것 같기도 하니 앞으로 2줄은 더 써야하는데 어떻게 채우 </label><br id="Lbr">
			<label id="Lla">지 하면서 쓰다보니 이미 4번째 줄이네여 앞으로 1줄 남았다</label><br id="Lbr">			
	</div>
	<h3 style="margin-left: 23%; margin-top: 30px;">개인정보 입력</h3>
	
	<table id="Lta" border="1">
		<tr>
			<td id="Lta"><label id="Lltd">아이디</label></td>
			<td id="Ltd"><input name="id" class="Lin" id="id" style="width: 250px;height: 30px;"><button type="button" onclick="javascript:idcheck();">중복확인</button></td>
		</tr>		
		<tr>
			<td id="Lta"><label id="Lltd">비밀번호</label></td>
			<td id="Ltd"><input name="pw" class="Lin" id="pw" style="width: 250px;height: 30px;"onchange="check_pw()" type="password"></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">비밀번호 확인</label></td>
			<td id="Ltd"><input type="password" class="Lin" name="pw2" id="pw2" onchange="check_pw()" style="width: 250px;height: 30px;"><span
				id="check"></span></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">이름</label></td>
			<td id="Ltd"><input id="name" name="name" class="Lin" style="width: 250px;height: 30px;"></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">주민번호</label></td>
			<td id="Ltd"><input id="jumin1" class="Lin" onchange="check_jumin1()" name="jumin1" style="width: 250px;height: 30px;"> - <input id="jumin2" class="Lin2" name="jumin2" onchange="check_jumin2()" style="width: 250px;height: 30px;"><button onclick="javascript:jumincheck();" type="button">중복확인</button></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">이메일</label></td>
			<td id="Ltd"><input id="mail1" class="Lin" name="mail1" style="width: 250px;height: 30px;">@<input id="mail2" class="Lin2" name="mail2" style="width: 250px;height: 30px;"><button type="button" onclick="javascript:mailcheck();">중복확인</button></td>
		</tr>
		<tr>
			<td id="Lta"><label id="Lltd">휴대전화</label></td>
			<td id="Ltd"><input name="phone" id="phone" class="Lin" style="width: 280px;height: 30px;"><button type="button" onclick="javascript:phonecheck();">중복확인</button></td>
		</tr>
	</table>
	<div style="margin-left: 40%; margin-top: 30px;">
		<input type="image" src="img/회원가입아이콘.png" style="margin-left: 30px;"> <a href="mainpage.jsp" onclick="goLoginForm()"><img style="margin-top: 10px; margin-left: 30px;" src="img/취소아이콘.png"></a>	
	</div>	
	</form>	
</body>
</html>