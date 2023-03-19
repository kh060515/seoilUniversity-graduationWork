<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.function.Function"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link href="/css/normal.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
     </script>
<style type="text/css">
h2{
	margin-left: 10%;
}
legend{
	margin-left: 10%;
}
legend {
	display: block;
	width: 100%;
	padding: .3em 0;
	margin-bottom: .3em;
	color: #333;
	border-bottom: 1px solid #e5e5e5;
}

label{
	margin-left: 10%;
	padding-right: 20px;
}

label[id=Lid]{
	margin-left: 13%;
	
}
label[id=Lpw]{
	margin-left: 13%;
}
label[id=Lpwck]{
	margin-left: 13%;
}
label[id=Lname]{
	margin-left: 13%;
}
label[id=Ljumin]{
	margin-left: 13%;
}
label[id=Lmail]{
	margin-left: 13%;
}
label[id=Lphone]{
	margin-left: 13%;
}

button {
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

body {
	text-align: left;
}

input {
	margin-left: 13%;
	padding: .5em .6em;
	width: 300px;
	height: 30px;
	color: inherit;
	font: inherit;
	margin: 5 display: inline-block;
	margin-bottom:20px;
	border: 1px solid #ccc;
	box-shadow: inset 0 1px 3px #ddd;
	border-radius: 4px;
	vertical-align: middle;
	box-sizing: border-box;
	
}

input[type=submit] {
	height: 40px;
	-webkit-appearance: button;
	cursor: pointer;
	background-color: rgb(0, 120, 231);
	text-align: center;
	color: white;
	margin-left: 10%;
}
input[id=jumi2]{
	margin-right: 30px;
}
input[name=cancle] {
	height: 40px;
	-webkit-appearance: button;
	cursor: pointer;
	text-align: center;
	color: black;
}
</style>
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
    					$("#jumin").attr("readonly", "readonly");    					 					
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
</head>
<body>

	<form onsubmit="return formsubmit();" method="post"
		action="JoinMembership.do" name="userInfo" id="joinForm">

		<input type="hidden" id="idcheckok" value="N"> <input
			type="hidden" id="phonecheckok" value="N"> <input
			type="hidden" id="mailcheckok" value="N"> <input
			type="hidden" id="pwcheckok" value="N"> <input type="hidden"
			id="jumincheckok" value="N">
		
			<legend>
				<h2>서일은행 회원가입</h2>
			</legend>
			<label id="Lid">아이디</label><br> <input type="text" name="id" id="id">
			<button type="button" onclick="javascript:idcheck();">중복확인</button>
			<br> <label id="Lpw">비밀번호</label><br> <input type="password" name="pw"
				id="pw" onchange="check_pw()"><br> <label id="Lpwck">비밀번호
				확인</label><br> <input type="password" name="pw2" id="pw2" onchange="check_pw()"><span
				id="check"></span><br> <label id="Lname">이름</label><br> <input type="text"
				name="name" id="name" maxlength="50"><br> <label id="Ljumin">주민번호</label><br>
			<input type="text" name="jumin1" id="jumin1"
				onchange="check_jumin1()">-<input type="password"
				name="jumin2" id="jumin2" onchange="check_jumin2()">
			<button type="button" onclick="javascript:jumincheck();">중복확인</button>
			<br> <label id="Lmail">이메일</label><br> <input type="text" name="mail1"
				maxlength="50" id="mail1">@ <select name="mail2" id="mail2">
				<option>naver.com</option>
				<option>daum.net</option>
				<option>gmail.com</option>
				<option>nate.com</option>
			</select>
			<button type="button" onclick="javascript:mailcheck();">중복확인</button>
			<br> <label id="Lphone">휴대전화</label><br> <input type="text" name="phone"
				id="phone" />
			<button type="button" onclick="javascript:phonecheck();">중복확인</button>
			<br> <input type="submit" value="가입"> 
			<input
				type="button" value="취소" onclick="goLoginForm()" name="cancle">
		
	</form>

</body>
</html>