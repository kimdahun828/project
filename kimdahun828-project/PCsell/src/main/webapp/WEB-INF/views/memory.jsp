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
							<li><a href="${path}">Home</a></li>
							<li><a href="#">All Categories</a></li>
							<li><a href="dram">Accessories</a></li>
							<li class="active">Headphones (227,490 Results)</li>
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
									<input type="checkbox" id="category-1">
									<label for="category-1">
										<span></span>
										Laptops
										<small>(120)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-4">
									<label for="category-4">
										<span></span>
										Accessories
										<small>(578)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-5">
									<label for="category-5">
										<span></span>
										Laptops
										<small>(120)</small>
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
									<input type="checkbox" id="brand-4">
									<label for="brand-4">
										<span></span>
										Hynix
										<small>(578)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-5">
									<label for="brand-5">
										<span></span>
										Micron
										<small>(125)</small>
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
									<img src="/PCsell/resources/img/32GB DDR4.jpg" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name"><a href="dram">SAMSUNG 32GB DDR4 DRAM(laptop)</a></h3>
									<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								</div>
							</div>

							<div class="product-widget">
								<div class="product-img">
									<img src="/PCsell/resources/img/16GB DDR4.jpg" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name"><a href="dram">SAMSUNG 16GB DDR4 DRAM</a></h3>
									<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								</div>
							</div>

							<div class="product-widget">
								<div class="product-img">
									<img src="/PCsell/resources/img/8GB DDR4.jpg" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name"><a href="#">SAMSUNG 8GB DDR4 DRAM(laptop)</a></h3>
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
										<option value="0">2</option>
										<option value="1">5</option>
									</select>
								</label>
							</div>							
					 <c:choose>
			            <c:when test='${ id eq "manager" }'><!-- 매니저 일 경우에만 상품 등록 가능함. -->
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
						<div class="row">
							<!-- product -->
							<c:forEach var="product" items="${ product }">
							<div class="col-md-4 col-xs-6">								
								<div class="product">
									<c:if test="${ not empty product.files }">
										<div class="product-img">
	
											<c:choose>
									            <c:when test='${ product.pcCode eq "8F1F89C375DC2D78E050C5D3F6121E25" }'>
													<img src="/PCsell/resources/img/${product.files[0].savedFileName }" alt="">
													<div class="product-label"><span class="new">NEW</span></div>
									            </c:when>
									            <c:when test='${ product.pcCode eq "8F1F89C375DB2D78E050C5D3F6121E25" }'>
													<img src="/PCsell/resources/img/${product.files[0].savedFileName }" alt="">
													<div class="product-label"><span class="new">NEW</span></div>
									            </c:when>
									            <c:otherwise>
									         	 	 <img src="/PCsell/resources/img/${product.files[0].savedFileName }" alt="">
									            </c:otherwise>
								       		 </c:choose>
										</div>									
									</c:if>
								<form action="/PCsell/cart/cartadd" method="POST">
									<input type="hidden" name="pcCode" value="${product.pcCode }">
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="dram/${product.pcCode}">${product.name }</a></h3>
										<h4 class="product-price">${product.price } 원</h4>
										<div class="product-rating">
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>

										</div>
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

							<!-- product -->
						
							<!-- /product -->
						</div>
						<!-- /store products -->
						
						<!-- store bottom filter -->
						<div class="store-filter clearfix">
							<ul class="store-pagination">
									<c:if test="${pagination.prev}">
										<li><a class="active" href="#"
											onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${ param.type }')">이전</a></li>
									</c:if>
									<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
										<li <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
											<a  href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${ param.type }')">${idx}</a>
										</li>
									</c:forEach>
									
									<c:if test="${pagination.next}">
										<li>
											<a href="#" onClick="fn_next('${pagination.range}','${pagination.range}', '${pagination.rangeSize}', '${ param.type }')">다음</a>
										</li>
									</c:if>	
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

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<script type="text/javascript">              
      $(function(){
                  
         $('#type_form').on('change', function(event){
            
            this.form.submit();
            
         });
      });
 
   
		//이전 버튼 이벤트
		function fn_prev(page, range, rangeSize , type) {

			var page = ((range - 2) * rangeSize) + 1;
			var range = range - 1;
			var url = "${pageContext.request.contextPath}/memorylist";

			url = url + "?page=" + page;
			url = url + "&range=" + range; 
			url = url + "&type=" + type ;

			location.href = url;

		}

		//페이지 번호 클릭
		function fn_pagination(page, range, rangeSize, type) {

			var url = "${pageContext.request.contextPath}/memorylist";

			url = url + "?page=" + page;
			url = url + "&range=" + range;
			url = url + "&type=" + type ;

			location.href = url;

		}

		//다음 버튼 이벤트
		function fn_next(page, range, rangeSize, type) {

			var page = parseInt((range * rangeSize)) + 1;

			var range = parseInt(range) + 1;

			var url = "${pageContext.request.contextPath}/memorylist";

			url = url + "?page=" + page;
			url = url + "&range=" + range;
			url = url + "&type=" + type ;

			location.href = url;
		}
	</script>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<jsp:include page="/WEB-INF/views/include/jsimport.jsp" />

	</body>
</html>
