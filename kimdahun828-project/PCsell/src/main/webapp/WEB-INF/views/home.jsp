<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/include/header.jsp" />

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="/PCsell/resources/img/7f9b402c-bac0-4b49-b736-426deecbab30.jpg" alt="">
							</div>
							<div class="shop-body">
								<h3>GPU<br>Collection</h3>
								<a href="productCategoryList?category=VGA" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="/PCsell/resources/img/a96e6975-5127-4521-8aff-62d9583bff4e.jpg" alt="">
							</div>
							<div class="shop-body">
								<h3>SSD<br>Collection</h3>
								<a href="productCategoryList?category=SSD" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="/PCsell/resources/img/daec51eb-5299-4189-87e2-2e573abc3b9d.jpg" alt="">
							</div>
							<div class="shop-body">
								<h3>Memory<br>Collection</h3>
								<a href="productCategoryList?category=RAM" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">New Products</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab1">Laptops</a></li>
									<li><a data-toggle="tab" href="#tab1">Accessories</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab1" class="tab-pane active">
									<div class="products-slick" data-nav="#slick-nav-1">
										<!-- product -->
										<c:forEach var="product" items="${ products }" begin="1" end="3">
										<div class="product">
											<div class="product-img">
												<c:if test="${ not empty product.files }">
													<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
												</c:if>
												<div class="product-label">
													<span class="sale">-30%</span>
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${ product.category }</p>
												<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
												<h4 class="product-price">${ product.price }원 <del class="product-old-price">${ product.price }원</del></h4>
											</div>
											<div class="add-to-cart">
												<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
											</div>
										</div>
										</c:forEach>
										<!-- /product -->

									</div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- HOT DEAL SECTION -->
		<div id="hot-deal" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="hot-deal">
							<ul class="hot-deal-countdown">
								<li>
									<div>
										<h3>02</h3>
										<span>Days</span>
									</div>
								</li>
								<li>
									<div>
										<h3>10</h3>
										<span>Hours</span>
									</div>
								</li>
								<li>
									<div>
										<h3>34</h3>
										<span>Mins</span>
									</div>
								</li>
								<li>
									<div>
										<h3>60</h3>
										<span>Secs</span>
									</div>
								</li>
							</ul>
							<h2 class="text-uppercase">hot deal this week</h2>
							<p>New Collection Up to 50% OFF</p>
							<a class="primary-btn cta-btn" href="#">Shop now</a>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /HOT DEAL SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Top selling</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab2">Laptops</a></li>
									<li><a data-toggle="tab" href="#tab2">Accessories</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab2" class="tab-pane fade in active">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<c:forEach var="product" items="${ products }" begin="1" end="4">
										<div class="product">
											<div class="product-img">
												<c:if test="${ not empty product.files }">
													<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
												</c:if>
												<div class="product-label">
													<span class="sale">-30%</span>
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${ product.category }</p>
												<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
												<h4 class="product-price">${ product.price }원 <del class="product-old-price">${ product.price }원</del></h4>
											</div>
											<div class="add-to-cart">
												<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
											</div>
										</div>
										</c:forEach>
										<!-- /product -->
									</div>
									<div id="slick-nav-2" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">CPU</h4>
							<div class="section-nav">
								<div id="slick-nav-3" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-3">
							<div>
								<!-- product widget -->
								<c:forEach var="product" items="${ cpu }" begin="0" end="3">
								<div class="product-widget">
									<div class="product-img">
										<c:if test="${ not empty product.files }">
											<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
										</c:if>
									</div>
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원<del class="product-old-price">${ product.price }원</del></h4>
									</div>
								</div>
								</c:forEach>
								<!-- /product widget -->
							</div>
							<div>
								<!-- product widget -->
								<c:forEach var="product" items="${ cpu }" begin="4" end="7">
								<div class="product-widget">
									<div class="product-img">
										<c:if test="${ not empty product.files }">
											<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
										</c:if>
									</div>
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원<del class="product-old-price">${ product.price }원</del></h4>
									</div>
								</div>
								</c:forEach>
								<!-- /product widget -->
							</div>
						</div>
					</div>

					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">MainBoard</h4>
							<div class="section-nav">
								<div id="slick-nav-4" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-4">
							<div>
								<!-- product widget -->
								<c:forEach var="product" items="${ mainBoard }" begin="0" end="3">
								<div class="product-widget">
									<div class="product-img">
										<c:if test="${ not empty product.files }">
											<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
										</c:if>
									</div>
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원<del class="product-old-price">${ product.price }원</del></h4>
									</div>
								</div>
								</c:forEach>
								<!-- /product widget -->
							</div>
							<div>
								<!-- product widget -->
								<c:forEach var="product" items="${ mainBoard }" begin="4" end="7">
								<div class="product-widget">
									<div class="product-img">
										<c:if test="${ not empty product.files }">
											<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
										</c:if>
									</div>
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원<del class="product-old-price">${ product.price }원</del></h4>
									</div>
								</div>
								</c:forEach>
								<!-- /product widget -->
							</div>
						</div>
					</div>

					<div class="clearfix visible-sm visible-xs"></div>

					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">VGA</h4>
							<div class="section-nav">
								<div id="slick-nav-5" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-5">
							<div>
								<!-- product widget -->
								<c:forEach var="product" items="${ vga }" begin="0" end="3">
								<div class="product-widget">
									<div class="product-img">
										<c:if test="${ not empty product.files }">
											<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
										</c:if>
									</div>
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원<del class="product-old-price">${ product.price }원</del></h4>
									</div>
								</div>
								</c:forEach>
								<!-- /product widget -->
							</div>
							<div>
								<!-- product widget -->
								<c:forEach var="product" items="${ vga }" begin="4" end="7">
								<div class="product-widget">
									<div class="product-img">
										<c:if test="${ not empty product.files }">
											<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
										</c:if>
									</div>
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원<del class="product-old-price">${ product.price }원</del></h4>
									</div>
								</div>
								</c:forEach>
								<!-- /product widget -->
							</div>
						</div>
					</div>

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- NEWSLETTER -->
		<div id="newsletter" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="newsletter">
							<p>Sign Up for the <strong>NEWSLETTER</strong></p>
							<form>
								<input class="input" type="email" placeholder="Enter Your Email">
								<button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
							</form>
							<ul class="newsletter-follow">
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-instagram"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-pinterest"></i></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /NEWSLETTER -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	
	<jsp:include page="/WEB-INF/views/include/jsimport.jsp" />

	</body>
</html>
