<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/include/header.jsp" />

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
							<c:forEach var="product" items="${ products }" begin="0" end="2">
							<div class="product-widget">
								<div class="product-img">
									<c:if test="${ not empty product.files }">
										<img src="/PCsell/resources/img/${ product.files[0].savedFileName }" alt="">
									</c:if>
								</div>
								<div class="product-body">
									<p class="product-category">${ product.category }</p>
									<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
									<h4 class="product-price">${ product.price }원</h4>
								</div>
							</div>
							</c:forEach>

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
							<c:choose>
				            	<c:when test='${ id eq "testadmin" }'>
									<ul class="store-grid">
										<li><a href="${ path }/productWrite">상품등록</a></li>
									</ul>
								</c:when>
								<c:otherwise>
				         	 		<ul class="store-grid"></ul>
				            	</c:otherwise>
							</c:choose>
						</div>
						<!-- /store top filter -->

						<!-- store products -->
						<div class="row" id="product-list">
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
								<form action="/PCsell/cart/cartadd" method="POST">
									<input type="hidden" name="pcCode" value="${ product.pcCode }">
									<div class="product-body">
										<p class="product-category">${ product.category }</p>
										<h3 class="product-name"><a href="detail/${ product.pcCode }">${ product.name }</a></h3>
										<h4 class="product-price">${ product.price }원</h4>
										<div class="product-btns">
											<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
											<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
											<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
										</div>
									</div>
									<div class="add-to-cart">
										<button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
									</div>
								</form>
								</div>
							</div>
							</c:forEach>
							<!-- /product -->
						</div>
						<!-- /store products -->

						<!-- store bottom filter -->
						<div class="store-filter clearfix">	
							<span class="store-qty">Showing 20-100 products</span>
								<ul class="store-pagination"  id="pager">
								<c:set var="pagerSize" value="3" />
									<li><a id="first" data-pageno="-1" href="javascript:">처음</a></li>
									<li><a id="prev" data-pageno="-1" href="javascript:"><i class="fa fa-angle-left"></i></a></li>
									<c:forEach var="idx" begin="1" end="${ pagerSize }">
										<li><a class="pageno" data-pageno="${ idx }" href="javascript:">${ idx }</a></li>
										<c:if test="${ idx < pagerSize }">
										&nbsp;
										</c:if>
									</c:forEach>
									<li><a id="next" data-pageno="-1"  href="javascript:"><i class="fa fa-angle-right"></i></a></li>
									<li><a id="last" data-pageno="-1" href="javascript:">끝</a></li>
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

<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<jsp:include page="/WEB-INF/views/include/jsimport.jsp" />

	</body>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script type="text/javascript">
	$(function() {
		var currentPage = 1;
    	var pagerSize = 3;
    	var pageSize = 9;
    	var lastPage = ( Math.floor(${ productsCount } / pageSize ) + 1 );
		
    	function loadProducts() {
   			$("#product-list").load('/PCsell/product-list', 
									{ "pageNo": currentPage }, 
									function() {});
    	}
    	
    	$('#pager #first').on('click', function(event) {
    		if (currentPage == 1) {
    			return;
    		}
    		
    		currentPage = 1;
    		$('#pager .pageno').each(function(idx, item) {
    			$(this).attr('data-pageno', idx + 1);
    			$(this).text( (idx + 1));
    		});
    		
    		loadProducts();
    	});
    	
    	$('#pager #prev').on('click', function(event) {
    		if (currentPage == 1) {
    			return;
    		}
    		
    		var pageNo = $('#pager .pageno:first').attr("data-pageno");
    		if (currentPage == pageNo) {
    			if (pageNo <= pagerSize) {
    				var i = 1;
    				$('#pager .pageno').each(function(idx, item) {    					
    					$(this).attr('data-pageno', i);
		    			$(this).text( i );
		    			i++;
    				});
    			} else {
	    			$('#pager .pageno').each(function(idx, item) {
		    			$(this).attr('data-pageno', currentPage - (pagerSize - idx));
		    			$(this).text( (currentPage - (pagerSize - idx) ));
		    		});
	    		}
    		} 
    		
    		currentPage--;	
    		
    		loadProducts();
    	});
    	
    	$('#pager .pageno').on('click', function(event) {
    		var pageNo = $(this).attr('data-pageno');
    		if (pageNo == currentPage) {
    			return;
    		}
    		
    		$(this).text(pageNo);
    		var tmp = $("#pager a[data-pageno=" + currentPage + "]");
    		tmp.text(tmp.attr('data-pageno'));
    		currentPage = parseInt(pageNo);
    		
    		loadProducts();
    	});
    	
    	$('#pager #last').on('click', function(event) {
    		if (currentPage == lastPage) {
    			return;
    		}
    		
    		currentPage = lastPage;
    		$('#pager .pageno').each(function(idx, item) {
    			$(this).attr('data-pageno', lastPage - (pagerSize - idx) + 1);
    			$(this).text( (lastPage - (pagerSize - idx) + 1 ));
    		});
    		
    		loadProducts();
    	});
    	
    	$('#pager #next').on('click', function(event) {
    		if (currentPage == lastPage) {
    			return;
    		}
    		var pageNo = $('#pager .pageno:last').attr("data-pageno");
    		if (currentPage == pageNo) {
    			if (lastPage - pageNo < 3) {
    				 var i = lastPage - 2;
    				$('#pager .pageno').each(function(idx, item) {    					
    					$(this).attr('data-pageno', i);
		    			$(this).text( i );
						i++
    				});
    			} else {
   				 	 $('#pager .pageno').each(function(idx, item) {
   	    			  	$(this).attr('data-pageno', (currentPage + idx + 1));
   	    			  	$(this).text((currentPage + idx + 1));
	    		  	  });
    			  }
    		}
   		currentPage++;
   		
   		loadProducts();
    	});
    	
	});
	
	$(document).ready(function(){
		$('input[type="checkbox"]').change(function(){
	        if($("input[name=CPU]").is(":checked")){
	        	location.href = "productCategoryList?category=CPU";
	        } else if ($("input[name=MainBoard]").is(":checked")){
	        	location.href = "productCategoryList?category=MainBoard";
	        } else if ($("input[name=RAM]").is(":checked")){
	        	location.href = "productCategoryList?category=RAM";
	        } else if ($("input[name=VGA]").is(":checked")){
	        	location.href = "productCategoryList?category=VGA";
	        } else if ($("input[name=SSD]").is(":checked")){
	        	location.href = "productCategoryList?category=SSD";
	        } else if ($("input[name=HDD]").is(":checked")){
	        	location.href = "productCategoryList?category=HDD";
	        } else if ($("input[name=Power]").is(":checked")){
	        	location.href = "productCategoryList?category=Power";
	        }
	    });
	});
	</script>
</html>
