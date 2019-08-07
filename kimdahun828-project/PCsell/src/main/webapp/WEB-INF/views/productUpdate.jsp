<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Electro - HTML Ecommerce Template</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="/PCsell/resources/css/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet"
	href="/PCsell/resources/css/slick.css" />
<link type="text/css" rel="stylesheet"
	href="/PCsell/resources/css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet"
	href="/PCsell/resources/css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="/PCsell/resources/css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="/PCsell/resources/css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
<jsp:include page="include/header.jsp" />

	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<ul class="breadcrumb-tree">
						<li><a href="#">Home</a></li>
						<li><a href="#">All Categories</a></li>
					</ul>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /BREADCRUMB -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<form action="${ path }/productUpdate" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="pcCode" value="${ product.pcCode }">
					<!-- Product details -->
					<div class="col-md-5">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">제품 정보</h3>
							</div>
							<div class="form-group">
								<select class="select-option" name="category">
									<option value="CPU">CPU</option>
									<option value="MainBoard">MainBoard</option>
									<option value="RAM">RAM</option>
									<option value="VGA">VGA</option>
									<option value="SSD">SSD</option>
									<option value="HDD">HDD</option>
									<option value="Power">Power</option>
									<option value="Case">Case</option>
								</select>
							</div>

							<div class="form-group">
								<input class="input" type="text" name="name" 
									placeholder="품명" value="${ product.name }" required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="companyName"
									placeholder="제조사" value="${ product.companyName }" required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="division"
									placeholder="제품분류" value="${ product.division }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="generation"
									placeholder="세대" value="${ product.generation }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="core" 
									placeholder="코어" value="${ product.core }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="thread"
									placeholder="쓰레드" value="${ product.thread }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="capacity"
									placeholder="용량" value="${ product.capacity }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="clock" 
									placeholder="클럭" value="${ product.clock }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="chipSet" 
									placeholder="칩셋" value="${ product.chipSet }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="socket" 
									placeholder="소켓" value="${ product.socket }">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="interfaceType"
									placeholder="인터페이스" value="${ product.interfaceType }">
							</div>
							<div class="form-group">
								<input class="input" type="tel" name="buffer"
									placeholder="HDD 버퍼 용량" value="${ product.buffer }">
							</div>
							<div class="form-group">
								<input class="input" type="tel" name="type"
									placeholder="SDD 메모리 타입" value="${ product.type }">
							</div>
							<div class="form-group">
								<input class="input" type="tel" name="outPut"
									placeholder="파워 출력" value="${ product.outPut }">
							</div>
							<div class="form-group">
								<input class="input" type="tel" name="price" 
									placeholder="*가격" value="${ product.price }" required>
							</div>
							<div class="form-group">
								<input class="input" type="tel" name="count" 
									placeholder="수량" value="${ product.count }">
							</div>
							<div class="form-group">
								<c:forEach var="file" items="${ product.files }">
								${ file.savedFileName }
								[<a href="${ path }/deleteImage?pcCode=${ product.pcCode }">삭제</a>]<br>
								</c:forEach>
								<br>	
								<input type="file" name="productImage">
							</div>
							<div class="form-group">
								<div class="input-checkbox">* 은 필수 작성내용입니다.</div>
							</div>
						</div>
						<input type="submit" class="add-to-cart-btn" value="수정">
						<a href="${ path }/detail/${ product.pcCode }"><input type="button" class="add-to-cart-btn" value="취소"></a>
					</div>
				</form>
				<!-- /Product details -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- Section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row"></div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /Section -->

	<!-- NEWSLETTER -->
	<div id="newsletter" class="section">
		<!-- container -->
		<div class="container"></div>
		<!-- /container -->
	</div>
	<!-- /NEWSLETTER -->

	<jsp:include page="include/footer.jsp" />

	<!-- jQuery Plugins -->
	<script src="/PCsell/resources/js/jquery.min.js"></script>
	<script src="/PCsell/resources/js/bootstrap.min.js"></script>
	<script src="/PCsell/resources/js/slick.min.js"></script>
	<script src="/PCsell/resources/js/nouislider.min.js"></script>
	<script src="/PCsell/resources/js/jquery.zoom.min.js"></script>
	<script src="/PCsell/resources/js/main.js"></script>

</body>
</html>
