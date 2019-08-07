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
							<input type="password" class="form-control" name="confirmPasswd" id="confirm-passwd">
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
						
						<button id="registerButton" type="submit" class="btn btn-transparent">회원 가입</button>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<jsp:include page="/WEB-INF/views/include/jsimport.jsp" />

<script type="text/javascript">

$("#registerButton").on("click", function(e){
	//e.preventDefault();
	//doRegister();
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
	
	if (passwd.length === 0) {
		alert("비밀번호를 입력해 주세요.");
		$("#passwd").focus();
		return;
	}
	
	if (passwd !== confirmPasswd) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#confirm-passwd").val('');
		$("#confirm-passwd").focus();
		return;
	}
	
	if (email.length === 0) {
		alert("이메일을 입력해 주세요.");
		$("#email").focus();
		return;
	}
	
	if (hp.length === 0) {
		alert("휴대전화번호를 입력해 주세요.");
		$("#hp").focus();
		return;
	}
	
	$.ajax({
		type: "post",
		url: contextPath + "/member/register",
		dataType: "text",
		data: $("#registerForm").serialize(),
		success: function(resp) {
			if (resp === 'success') {
				alert("회원가입이 정상적으로 처리되었습니다.");
				location.href = contextPath + "/member/login";
			} else if (resp === 'wrong_id'){
				alert("이미 존재하는 아이디이거나 사용이 불가한 아이디입니다.");
				return;	
			} else if (resp === 'wrong_passwd') {
				alert("사용 불가능한 비밀번호이거나, 비밀번호가 일치하지 않습니다.");
				return;	
			} else if (resp === 'wrong_email'){
				alert("이미 존재하는 이메일이거나 사용이 불가한 이메일입니다.");
				return;
			} else if (resp === 'wrong_hp') {
				alert("휴대전화를 다시 한번 확인 바랍니다.");
				return;
			}
		},
		error: function(err) {
			// do nothing...
		}
	});
	
}

</script>

</body>

</html>