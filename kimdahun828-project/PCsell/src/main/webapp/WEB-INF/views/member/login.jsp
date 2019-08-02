<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro - HTML Ecommerce Template</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="/PCsell/resources/css/bootstrap.min.css"/>

		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="/PCsell/resources/css/slick.css"/>
		<link type="text/css" rel="stylesheet" href="/PCsell/resources/css/slick-theme.css"/>

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="/PCsell/resources/css/nouislider.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="/PCsell/resources/css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="/PCsell/resources/css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>


<body class="body-wrapper">

<jsp:include page="/WEB-INF/views/include/header.jsp" />

<section class="popular-deals section bg-gray" style="min-height: 800px">
	<div class="container">
		<div class="row">
			<div class="col col-md-12">
				<!-- 로그인 -->
				<div class="widget personal-info">
					<h3 class="widget-header user">로그인</h3>
					
					<c:if test="${param.logout ne null}">
						<div style="text-align: center">
							<span style="color: blue; font-size: 16px;">로그아웃되었습니다.</span>
						</div>
					</c:if>
					
					<c:if test="${param.expired ne null}">
						<div style="text-align: center">
							<span style="color: red; font-size: 16px;">세션이 만료되었습니다.</span>
						</div>
					</c:if>
					
					<form id="loginForm">
					
						<!-- 아이디 -->
						<div class="form-group">
							<label for="id">아이디</label>
							<input type="text" class="form-control" name="id" id="id">
						</div>
					
						<!-- 비밀번호 -->
						<div class="form-group">
							<label for="passwd">비밀번호</label>
							<input type="password" class="form-control" name="passwd" id="passwd">
						</div>
						
						<div class="form-group" style="float: left">
							<input type="checkbox" name="remember-me" id="remember-me" />
							<label for="remember-me">로그인 기억하기</label>
						</div>
						
						<div style="float: right">
							<a href="#">비밀번호를 잊으셨나요?</a>
						</div>
						
						<div style="clear: both">
							<button id="loginButton" class="btn btn-transparent">로그인</button>
							
							<a href="/member/register" class="btn btn-transparent">회원가입</a>
							
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<jsp:include page="/WEB-INF/views/include/jsimport.jsp" />

<script type="text/javascript">

/* ========================================= 로그인 =============================================== */

$("#loginButton").on("click", function(e){
	e.preventDefault();
	doLogin();
});

function doRegister() {
	
	if (!confirm("회원가입을 진행하시겠습니까?")){
		return;
	}
	
	var contextPath = $("#contextPath").val();
	
	var id = $("#id").val();
	var passwd = $("#passwd").val();
	var confirmPasswd = $("#confirm-passwd").val();
	var email = $("#email").val();
	var hp = $("#hp").val();
	
	if (id.length === 0) {
		alert("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}
	
	$.ajax({
		method: "post",
		url: contentPath + "/member/doLogin",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		dataType: "text",
		data: $("#loginForm").serialize(),
		success: function(resp) {
			if (resp === 'success'){
				alert("로그인되었습니다.");
				location.href = "${path}/";
				return;
			} else {
				alert("아이디가 존재하지 않거나, 비밀번호가 일치하지 않습니다.");
				return;
			}
		},
		error: function(err) {
			console.log(err);
		}
	});
	
}

</script>

</body>

</html>