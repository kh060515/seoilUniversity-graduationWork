<%@page import="com.domain.MembershipDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서일은행</title>
<link rel="stylesheet" href="css/mainpage.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var $banner = $(".banner").find("ul");

				var $bannerWidth = $banner.children().outerWidth();//이미지의 폭
				var $bannerHeight = $banner.children().outerHeight(); // 높이
				var $length = $banner.children().length;//이미지의 갯수
				var rollingId;

				//정해진 초마다 함수 실행
				rollingId = setInterval(function() {
					rollingStart();
				}, 3000);//다음 이미지로 롤링 애니메이션 할 시간차

				function rollingStart() {
					$banner.css("width", $bannerWidth * $length + "px");
					$banner.css("height", $bannerHeight + "px");
					//alert(bannerHeight);
					//배너의 좌측 위치를 옮겨 준다.
					$banner.animate({
						left : -$bannerWidth + "px"
					}, 1500, function() { //숫자는 롤링 진행되는 시간이다.
						//첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
						$(this).append(
								"<li>" + $(this).find("li:first").html()
										+ "</li>");
						//뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
						$(this).find("li:first").remove();
						//다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
						$(this).css("left", 0);
						//이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
					});
				}
			});
	$(document).ready(function() {
		$('selector').css('width', $(window).width());
		$('selector').css('height', $(window).height());
		$(window).resize(function() {
			$('selector').css('width', $(window).width());
			$('selector').css('height', $(window).height());
		});
	});
	function AccountCountck() {
		$.ajax({
			url : "accountCountCk.countCk",
			type : "post",
			data : {

			},
			datatype : "json",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(data) {

				if (data.cnt >= 3) {
					alert("계좌는 3개를 초과해서 생성할 수 없습니다.");
					location.href = "mainpage.jsp";
				} else {
					let url = "createAccountNum.jsp";
					location.replace(url);
				}
			},
			error : function(data) {
				alert("AccountCountck(main.jsp) ajax오류");
			}
		});
	}
	function openPopUp() {
		var options = 'width=800, height=600, top=30, left=30, resizable=no, scrollbars=no, location=no';
		window.open("inquiry.jsp","고객문의", options);
	}
	function alertPopUp() {
		alert("로그인 후 이용해주세요.");
	}
</script>
</head>
<body>	
	<div class="contents" style="position: relative;">
	<img src="img/newseoil.png" style="position: absolute; z-index: 1000; left: 450px; top: 15px; height:50px; width:150px ">
	<c:if test="${empty login.id}">
		<a href="loginform.jsp"><img src="img/loginlogo.png" style="position: absolute; z-index: 1000; left: 610px; top: 24px; height:30px; width:75px "></a>	
	</c:if>
	<c:if test="${not empty login.id}">
		<a href="logout.do"><img src="img/logoutlogo.png" style="position: absolute; z-index: 1000; left: 610px; top: 24px; height:30px; width:75px "></a>
	</c:if>
	<h3 style="position: absolute; z-index:1000; left: 780px; top:6px; text-shadow: 3px;">개인</h3>	
	<h3 style="position: absolute; z-index:1000; left: 840px; top:6px; text-shadow: 3px;">기업</h3>
	<c:if test="${empty login.id}">
		<h3 style="position: absolute; z-index:1000; left: 910px; top:6px; text-shadow: 3px;"><a href="JoinMemberShip.jsp">회원가입</a></h3>
	</c:if>
	<c:if test="${not empty login.id}">
		<h3 style="position: absolute; z-index:1000; left: 910px; top:6px; text-shadow: 3px;"><a href="createAccountNum.jsp" onclick="AccountCountck()">계좌개설</a></h3>
	</c:if>
	<h3 style="position: absolute; z-index:1000; left: 1020px; top:6px; text-shadow: 3px;">금융상품</h3>
	<h3 style="position: absolute; z-index:1000; left: 1130px; top:6px; text-shadow: 3px;">카드</h3>
	<c:if test="${not empty login.id}">		
		<h3 style="position: absolute; z-index:1000; left: 1250px; top:6px; text-shadow: 3px;"><a onclick="openPopUp()">고객문의</a></h3>	
	</c:if>
	
	<a href="" style="z-index: 1002">
		<img src="img/menu2_1.png" style="position: absolute; z-index: 1000; left: 560px; top: 463px; height:76px; width:160px ">
	</a>
	<a href="selectAccount.jsp">
		<img src="img/menu2_2.png" style="position: absolute; z-index: 1000; left: 720px; top: 464px; height:75px; width:144px ">
	</a>
	<a href="sendmoney.jsp">
		<img src="img/menu2_3.png" style="position: absolute; z-index: 1000; left: 863px; top: 464px; height:75px; width:144px ">
	</a>
	
		<img src="img/menu2_4.png" style="position: absolute; z-index: 1000; left: 1007px; top: 464px; height:75px; width:144px ">
	
	
		<img src="img/menu2_5.png" style="position: absolute; z-index: 1000; left: 1150px; top: 464px; height:75px; width:160px ">
	
	<div class="add_menu_list" style="position: absolute; z-index: 1000; left: 705px; top: 585px;"> 
		<ul class="submenu">
			<li><a href=''>금융 소비자 보호</a></li>
			<li><a href="">보안뉴스</a></li>
			<li><a href="">상품/약관 공시</a></li>
		</ul>
	</div>
	<div>
		<h2 class="font-22" style="left: 450px; top: 615px; position: absolute;">금융상품</h2>
		<a><img src="img2/금융상품1.png" style="position: absolute; left:460px; top: 690px;"></a>
		<a><img src="img2/금융상품2.png" style="position: absolute; left:550px; top: 690px;"></a>
		<a><img src="img2/금융상품3.png" style="position: absolute; left:635px; top: 690px;"></a>
		<a><img src="img2/금융상품4.png" style="position: absolute; left:715px; top: 690px;"></a>
		<a><img src="img2/금융상품5.png" style="position: absolute; left:810px; top: 690px;"></a>
		<a><img src="img2/금융상품6.png" style="position: absolute; left:900px; top: 690px;"></a>
		<a><img src="img2/금융상품7.png" style="position: absolute; left:980px; top: 690px;"></a>
		<a><img src="img2/금융상품8.png" style="position: absolute; left:1070px; top: 690px;"></a>
		<a><img src="img2/라인.png" style="position: absolute; left:1140px; top: 670px; height: 90px;"></a>
		<a><img src="img2/금융상품9.png" style="position: absolute; left:1180px; top: 695px;"></a>
		<a><img src="img2/금융상품10.png" style="position: absolute; left:1250px; top: 690px;"></a>
		<a><img src="img2/금융상품11.png" style="position: absolute; left:1330px; top: 690px;"></a>
		<h2 class="font-22" style="left: 1160px; top: 615px; position: absolute;">카드</h2>
		<h4 style="position: absolute; left: 470px; top: 720px;">예금</h4>
		<h4 style="position: absolute; left: 555px; top: 720px;">대출</h4>
		<h4 style="position: absolute; left: 635px; top: 720px;">펀드</h4>
		<h4 style="position: absolute; left: 720px; top: 720px;">외환</h4>
		<h4 style="position: absolute; left: 810px; top: 720px;">신탁</h4>
		<h4 style="position: absolute; left: 890px; top: 720px;">퇴직연금</h4>
		<h4 style="position: absolute; left: 990px; top: 720px;">보험</h4>
		<h4 style="position: absolute; left: 1080px; top: 720px;">ISA</h4>
		<h4 style="position: absolute; left: 1175px; top: 720px;">카드신청</h4>
		<h4 style="position: absolute; left: 1250px; top: 720px;">나의카드</h4>
		<h4 style="position: absolute; left: 1330px; top: 720px;">이벤트</h4>
	</div>
	<h2 class="font-22" style="left: 450px; top: 820px; position: absolute;">서비스</h2>
	<a><img src="img3/서비스배너.png" style="position: absolute; top: 890px;left: 450px;"></a>
	<a><img src="img3/서비스배너2.png" style="position: absolute; top: 890px;left: 780px;"></a>
	<c:if test="${not empty login.id}">
		<a href="" onclick="openPopUp()"><img src="img3/서비스배너3.png" style="position: absolute; top: 890px;left: 1110px;"></a>
	</c:if>
	<c:if test="${empty login.id}">
		<a href="" onclick="alertPopUp()"><img src="img3/서비스배너3.png" style="position: absolute; top: 890px;left: 1110px;"></a>
	</c:if>
	<img src="img3/footer.png" style="position: absolute; top: 1230px; width:1920px; height: 180px;">
	<h3 style="left: 450px; top: 1235px; position: absolute;">공지사항</h3>
	<img src="img3/푸터2디자인.png" style="position: absolute; top:1500px; width:1920px; heigh:300px;">
		<div class="banner">
			<ul>
				<li><img src="img/이벤트배너1.png" width="1920px" height="500px"></li>	
				<li><img src="img/이벤트배너2.png" width="1920px" height="500px"></li>
				<li><img src="img/이벤트배너3.png" width="1920px" height="500px"></li>						
			</ul>
		</div>
	</div>
</body>
</html>