<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- <%@ page import ="com.pcsell.vo.BOARD" %> --%>
<c:set var="nav" value="board" scope="request"/>
<c:set var="title" value="상세보기" scope="request" />
 
<!-- board -->

<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/default.css?ver=1011">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/style.css?v2">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/board.common.css?ver=1011">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/js/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/mobile.css?ver=1011">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/contents.css?ver=1011">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/featherlight/featherlight.min.css?ver=1011">

<jsp:include page="/WEB-INF/views/include/header.jsp" /> 

<link rel="stylesheet" type="text/css" href="/PCsell/resources/styles/blog.css">
<link rel="stylesheet" type="text/css" href="/PCsell/resources/styles/blog_responsive.css">



<!-- 콘텐츠 시작  -->
<div id="ctWrap">
	<div id="container">
		<!-- 게시물 읽기 시작 { -->
		<article id="detail_v" style="width: 100%">
			<script>
				// 글자수 제한
				var char_min = parseInt(0); // 최소
				var char_max = parseInt(0); // 최대
			</script>

			<section id="bo_v_atc">

				<h2 id="bo_v_atc_title">자유게시판</h2>
				<!-- 게시물 상단 버튼 시작 { -->
			<div id="bo_v_top">
				<ul class="bo_v_left">
					<li>
						<c:if test="${ loginuser.id eq board.id }">
						<a class="btn_b01 btn" id="update">
						<i class="fa fa-pencil-square-o" aria-hidden="true" id="update"></i>수정</a>
						<a class="btn_b01 btn" id="delete">
						<i class="fa fa-trash-o" aria-hidden="true"></i>삭제</a>
						</c:if>
						<a href="/PCsell/boardlist" class="btn_b01 btn" id="boardlist">
						<i class="fa fa-list" aria-hidden="true"></i>목록</a>
					</li>
				</ul>
			</div>
			<!-- } 게시물 상단 버튼 끝 -->
				<h4>
					<div class="contents">
						<div class="pageSection">
							<form name="viewForm" id="viewForm" method="get">
								<input type="hidden" name="currentPageNo" value="1" /> 
								<input type="hidden" name="searchCondition" value="title" /> 
									<input type="hidden" name="searchKeyword" value="" /> 
									<input type="hidden" name="procMode" id="procMode" value="INSERT" /> 
									<input type="hidden" name="idx" id="idx" value="544" /> 
									<input type="hidden" name="fileIdx" id="fileIdx" value="" />
								<div class="tblWrap">
									
									<table border='1' style="height: 200px; width: 1000px; text-align: center">
										<tr>
											<td style="height: 45px"><h2>번호</h2></td>
											<td colspan='2' style="text-align: center">${ Board.boardNo }</td>
										</tr>
										<tr>
											<td style="height: 45px"><h2>제목</h2></td>
											<td colspan='2' style="text-align: center">${ Board.title }</td>
										</tr>
										<tr>
											<td style="height: 45px"><h2>작성자</h2></td>
											<td colspan='2' style="text-align: center">${ Board.ID }</td>
										</tr>
										<tr>
											<td style="height: 45px"><h2>작성일자</h2></td>
											<td colspan='2' style="text-align: center">${ d.substring(0,10) }</td>
										</tr>
										<tr>
											<c:forEach var="file" items="${ Board.files }">
												<td style="height: 370px">이미지</td>
												<td colspan="4" style="text-align: center">
												<img src="/PCsell/resources/files/board-files/${ file.savedFileName } "width="550" height="300"></td>
											</c:forEach>
										</tr>
										<tr>
											<td style="height: 100px">내용</td>
											<td colspan="3" style="text-align: center">${ Board.content }</td>
										</tr>
									</table>
									
								</div>
							</form>
							</div>
						</div>
					</h4>
				</section>
			<div id="bo_v_share"></div>
		</article>
		<!-- 후기 -->
				<%-- <c:if test="${ board.reviewCheck }"> --%>
	            <form id="reviewform" class="form-inline row">
	               <h4 class="text-black col-md-12 py-3"><b>후기</b></h4>
	               <input type="hidden" name="boardNo" id="boardNo" value="${ Board.boardNo }"> 
	               <input type="hidden" name="writer" value="${ loginuser.id }">
					<div class="col-md-12">
						<!-- <div class='starrr' id='star'></div>
						<br /> 
						<input type="hidden" name='rating' id='star_input' /> -->
						<textarea class="form-control mr-1" id="review_content" name="content" cols="65" rows="3"></textarea>
						<a class="btn btn-primary py-3 px-4" id="writereview" href="javascript:">댓글<br>등록
						</a>
					</div>
				</form>
	            <%-- </c:if> --%>
	            
	            <hr style="border-color: #4a2773;">
				<!-- review list -->
				<c:if test="${ not empty board.reviews and board.reviews[0].reviewNo != 0 }">
					<table id="review-list" class="w-100 m-auto border-top">
						<c:forEach var="review" items="${ Board.reviews }">
						<fmt:formatDate value="${ review.regDate }" var="regDate" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
							<tr id="tr${ review.reviewNo }">
								<td class="border-bottom text-left" style="padding-left:${ review.depth*20 + 10 }px">
									<div id='reviewview${ review.reviewNo }' class="container">
										<div class="col-sm-12 row justify-content-between py-1">
											${ review.writer } &nbsp;&nbsp; [${ regDate }] 
											<div class="row"style='display:${ loginuser.id eq review.writer ? "block" : "none" }'>
												<a class="editreview" data-reviewno='${ review.reviewNo }' href="javascript:" style="width: 30px; height: 30px"> 편집
												</a> &nbsp; 
												<a class="deletereview" href="javascript:" data-reviewno="${ review.reviewNo }" style="width: 30px; height: 30px"> 삭제
												</a>
											</div>
										</div>
										<span>${ review.content }</span>
										
										<div style="width: 30px;height: 30px">
											<a class="comment-link"
												data-toggle="collapse" href="#comment-collapse${ review.reviewNo }"
												aria-controls="comment-collapse${ review.reviewNo }">
													<img src="/PCsell/resources/images/comment.svg" class="svg">
											</a>
										</div>

									</div>
									<div>
									<div class="row">
										<div class="col">
											<div class="collapse multi-collapse" id="comment-collapse${ review.reviewNo }">
												<div class="card-body">
												<form id="comment-form" class="form-inline row">
													<input type="hidden" name="reviewNo" value="${ review.reviewNo }">
									               <input type="hidden" name="boardNo" id="boardNo" value="${ Board.boardNo }"> 
									               <input type="hidden" name="writer" value="${ loginuser.id }">
									               <div class="col-md-12">
									                  <textarea class="form-control mr-1" name="content" cols="${ 60 - review.depth*5 }" rows="3"></textarea>
									                  <a class="btn btn-primary py-3 px-4" id="write-comment" 
									                  	data-reviewno='${ review.reviewNo }' href="javascript:">댓글<br>등록</a>
									               </div>
									            </form>
									            </div>
											</div>
										</div>
									</div>
									</div>
									<div id='reviewedit${ review.reviewNo }' style="display: none" class="container">
										<div class="col-sm-12 row justify-content-between py-1">
											${ review.writer } &nbsp;&nbsp; [${ regDate }]
										</div>
										<form id="updateform${ review.reviewNo }">
											<input type="hidden" name="reviewNo" value="${ review.reviewNo }" />
											<textarea class="form-control"name="content" style="width: 550px" rows="3"
												maxlength="200">${ review.content }</textarea>
										</form>
										<div>
											<a class="updatereview" href="javascript:" data-reviewno="${ review.reviewNo }">수정</a> &nbsp; 
											<a class="cancel" data-reviewno="${ review.reviewNo }" href="javascript:">취소</a>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${ empty board.reviews or board.reviews[0].reviewNo eq 0 }">
					<table id="review-list" class="w-100 m-auto border-top">
						<tr>
							<td>등록된 후기가 없습니다.</td>
						</tr>
					</table>
				</c:if>
			</div>
		</div>
	</div><!-- // #container 닫음 -->


<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/jquery-1.11.0.min.js"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/jquery.menu.min.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/js/common.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/WEBsiting.js?ver=221712222"></script>
<script src="http://sample.paged.kr/purewhite/js/wrest.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/js/placeholders.min.js"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/shuffleLetters/jquery.shuffleLetters.min.js"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/featherlight/featherlight.min.js"></script>

<!-- 하단 시작 { -->
<jsp:include page="/WEB-INF/views/include/footer.jsp" />

<!-- 현재위치 및 서브메뉴 활성화 설정// -->
<script type="text/javascript">
window.addEventListener('load', function(event) {
	var btnUpdate = document.querySelector('#update');
	btnUpdate.addEventListener('click', function(event) {
		location.href="/PCsell/boardupdate/${Board.boardNo}";
	});
	
	var btnUpdate = document.querySelector('#delete');
	btnUpdate.addEventListener('click', function(event) {
		var ok = confirm("${Board.boardNo}번 자료를 삭제할까요?");
		if (ok) {
			location.href = "/PCsell/boarddelete/${Board.boardNo}";		        			
		}
	});
	
	var btnUpdate = document.querySelector('#boardlist');
	btnUpdate.addEventListener('click', function(event) {
		location.href="/PCsell/boardlist";
	});
});
$(function(){$('.snb.bo_tablebasic, .snb .snb2d_bo_tablebasic').addClass('active');});
$(document).ready(function(){ 
	if ( $("#snb > li").is(".snb.active") ) {
		$('.loc1D').text( $('#snb .bo_tablebasic h2 a b').text());
		$('.loc2D').html( $('.snb2d_bo_tablebasic a b').html());
		$('.faArr').html('<i class="fa fa-angle-right"></i>');
		var index = $("#snb > li").index("#snb > li.active");
		$( "#page_title" ).addClass("subTopBg_0"+($("#snb > li.bo_tablebasic").index() + 1) ); 
	} else { 
		$('.loc1D').text('기본게시판'); 
		$('.noInfoPageTit').html('<h2><a><b>기본게시판</b><sub></sub></a></h2>'); 
		$('.noInfoPageTit').addClass('active');
		$('#page_title').addClass('subTopBg_00'); 
	} 
	
	//////////////////////////////////////////////////////////////////
	$(function() {
		$('#register-board-button').on('click', function(event) {
			event.preventDefault();
			event.stopPropagation();
			boardAddConfirm()
		});
	});
	
});  
</script>
<!-- //현재위치 및 서브메뉴 활성화 설정 -->

</body>
</html>