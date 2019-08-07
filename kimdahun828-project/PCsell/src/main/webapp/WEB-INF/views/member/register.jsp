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
					<h3 class="widget-header user">회원 가입</h3>
					<form id="registerForm" action="register" method="post">
					
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
						
						<!-- 비밀번호 확인 -->
						<div class="form-group">
							<label for="confirm-passwd">비밀번호 확인</label>
							<input type="password" class="form-control" name="confirm" id="confirm-passwd">
						</div>
						
						<!-- 이메일 -->
						<div class="form-group">
							<label for="email">이메일</label>
							<input type="email" class="form-control" name="email" id="email">
						</div>
						
						<!-- hp -->
						<div class="form-group">
							<label for="hp">hp</label>
							<input type="hp" class="form-control" name="hp" id="hp">
						</div>
						
						<div class="wrap-input100">
							<input type="radio" name="userType" value="member">일반
							<input type="radio" name="userType" value="host">관리자
						</div>
						
						<button id="registerButton" type="submit" class="btn btn-transparent">회원 가입</button>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<%-- <jsp:include page="/WEB-INF/views/include/jsimport.jsp" /> --%>



</body>

</html>