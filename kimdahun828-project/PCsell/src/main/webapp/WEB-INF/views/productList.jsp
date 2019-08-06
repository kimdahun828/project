<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<jsp:include page="include/header.jsp" />

		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<ul class="breadcrumb-tree">
							<li><a href="${ path }/">Home</a></li>
							<li class="active">All Categories</li>
							<li class="category" id="category"><a href="#"></a></li>
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
					<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Categories</h3>
							<div class="checkbox-filter">

								<div class="input-checkbox">
									<input type="checkbox" id="category-1" name="CPU">
									<label for="category-1">
										<span></span>
										CPU
										<small></small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-2" name="MainBoard">
									<label for="category-2">
										<span></span>
										Mainboard
										<small></small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-3" name="RAM">
									<label for="category-3">
										<span></span>
										RAM
										<small></small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-4" name="VGA">
									<label for="category-4">
										<span></span>
										VGA
										<small></small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-5" name="SSD">
									<label for="category-5">
										<span></span>
										SSD
										<small></small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-6" name="HDD">
									<label for="category-6">
										<span></span>
										HDD
										<small></small>
									</label>
								</div>
								
								<div class="input-checkbox">
									<input type="checkbox" id="category-7" name="Power">
									<label for="category-7">
										<span></span>
										Power
										<small></small>
									</label>
								</div>
								
								<div class="input-checkbox">
									<input type="checkbox" id="category-8" name="Case">
									<label for="category-8">
										<span></span>
										Case
										<small></small>
									</label>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Price</h3>
							<div class="price-filter">
								<div id="price-slider"></div>
								<div class="input-number price-min">
									<input id="price-min" type="number">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
								<span>-</span>
								<div class="input-number price-max">
									<input id="price-max" type="number">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Brand</h3>
							<div class="checkbox-filter">
								<div class="input-checkbox">
									<input type="checkbox" id="brand-1">
									<label for="brand-1">
										<span></span>
										SAMSUNG
										<small>(578)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-2">
									<label for="brand-2">
										<span></span>
										LG
										<small>(125)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-3">
									<label for="brand-3">
										<span></span>
										SONY
										<small>(755)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-4">
									<label for="brand-4">
										<span></span>
										SAMSUNG
										<small>(578)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-5">
									<label for="brand-5">
										<span></span>
										LG
										<small>(125)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-6">
									<label for="brand-6">
										<span></span>
										SONY
										<small>(755)</small>
									</label>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Top selling</h3>
							<div class="product-widget">
								<div class="product-img">
									<img src="/PCsell/resources/img/product01.png" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name"><a href="#">product name goes here</a></h3>
									<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								</div>
							</div>

							<div class="product-widget">
								<div class="product-img">
									<img src="/PCsell/resources/img/product02.png" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name"><a href="#">product name goes here</a></h3>
									<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								</div>
							</div>

							<div class="product-widget">
								<div class="product-img">
									<img src="/PCsell/resources/img/product03.png" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name"><a href="#">product name goes here</a></h3>
									<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->
					</div>
					<!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
						<!-- store top filter -->
						<div class="store-filter clearfix">
							<div class="store-sort">
								<label>
									Sort By:
									<select class="input-select">
										<option value="0">Popular</option>
										<option value="1">Position</option>
									</select>
								</label>

								<label>
									Show:
									<select class="input-select">
										<option value="0">20</option>
										<option value="1">50</option>
									</select>
								</label>
							</div>
							<ul class="store-grid">
								<li><a href="${ path }/productWrite">상품등록</a></li>
							</ul>
						</div>
						<!-- /store top filter -->

						<!-- store products -->
						<div class="row">
							<!-- product -->
							<c:forEach var="product" items="${ products }">
							<div class="col-md-4 col-xs-6">
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
										<div class="product-btns">
											<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
											<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
											<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
										</div>
									</div>
									<div class="add-to-cart">
										<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
									</div>
								</div>
							</div>
							</c:forEach>
							<!-- /product -->
						</div>
						<!-- /store products -->

						<!-- store bottom filter -->
						<div class="store-filter clearfix">
							<span class="store-qty">Showing 20-100 products</span>
							<ul class="store-pagination">
								<li class="active">1</li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
							</ul>
						</div>
						<!-- /store bottom filter -->
					</div>
					<!-- /STORE -->
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

		<jsp:include page="include/footer.jsp" />
		<jsp:include page="include/jsimport.jsp" />

	</body>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	    $("input[name=CPU]").change(function(){
	        if($("input[name=CPU]").is(":checked")){
	        	location.href = "productCategoryList?category=CPU";
	        	$("#category").text("CPU");
	        	$("#category").attr("productCategoryList?category=CPU");
	        }
	    });
	    $("input[name=MainBoard]").change(function(){
	        if($("input[name=MainBoard]").is(":checked")){
	        	location.href = "productCategoryList?category=MainBoard";
	        }
	    });
	    $("input[name=RAM]").change(function(){
	        if($("input[name=RAM]").is(":checked")){
	        	location.href = "productCategoryList?category=RAM";
	        }
	    });
	    $("input[name=VGA]").change(function(){
	        if($("input[name=VGA]").is(":checked")){
	        	location.href = "productCategoryList?category=VGA";
	        }
	    });
	    $("input[name=SSD]").change(function(){
	        if($("input[name=SSD]").is(":checked")){
	        	location.href = "productCategoryList?category=SSD";
	        }
	    });
	    $("input[name=HDD]").change(function(){
	        if($("input[name=HDD]").is(":checked")){
	        	location.href = "productCategoryList?category=HDD";
	        }
	    });
	    $("input[name=Power]").change(function(){
	        if($("input[name=Power]").is(":checked")){
	        	location.href = "productCategoryList?category=Power";
	        }
	    });
	    $("input[name=Case]").change(function(){
	        if($("input[name=Case]").is(":checked")){
	        	location.href = "productCategoryList?category=Case";
	        }
	    });
	});
	</script>
</html>
