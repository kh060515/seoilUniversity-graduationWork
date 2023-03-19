<%@page import="com.domain.MembershipDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서일은행</title>
<link rel="stylesheet" href="css/company.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
				}, 6000);//다음 이미지로 롤링 애니메이션 할 시간차

				function rollingStart() {
					$banner.css("width", $bannerWidth * $length + "px");
					$banner.css("height", $bannerHeight + "px");
					//alert(bannerHeight);
					//배너의 좌측 위치를 옮겨 준다.
					$banner.animate({
						left : -$bannerWidth + "px"
					}, 1500, function() { //숫자는 롤링 진행되는 시간이다.
						//첫번째 이미지를 마지막 끝에 복사(이동이 아k니라 복사)해서 추가한다.
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
</script>

</head>
<body>
	<%
	MembershipDTO login = (MembershipDTO) request.getSession().getAttribute("login");
	String money = "";
	%>
	<div id="page">
		<header>
			<div class="banner" style="width: 100%">
				<ul>
					<li><img src="img/banker202102042.png" name="image"></li>
					<li><img src="img/2.jpg" ></li>
					<li><img src="img/3.jpg"></li>
				</ul>
			</div>
			<div id="logo">
				<img alt="logo" src="img/newseoil.png">
			</div>

			<div id="top_menu">
				<c:if test="${empty login.id}">
					<a href="loginform.jsp"><b> 로그인</b></a>
				</c:if>

				<c:if test="${not empty login.id}">
					<a href="logout.do"><b> 로그아웃</b></a>
					<a href="createAccountNum.jsp" onclick="AccountCountck()">계좌 개설</a>
					<a href="">계좌 정보</a>
					<a href="" onclick="openPopUp()">고객 문의</a>
				</c:if>
			</div>

			<nav>
				<ul>
					<li><a href="">이체</a></li>
					<li><a href="">계좌개설</a></li>
					<li><a href="">문의</a></li>
					<li><a href="">조회</a></li>
				</ul>
			</nav>
			<article>
				<section>
					<a id="section" name="section" href="">공지사항</a>
				</section>
			</article>
		</header>
	</div>

</body>
</html>