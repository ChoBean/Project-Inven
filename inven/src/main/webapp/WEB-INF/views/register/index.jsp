<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="top.jsp"/>
		<div class="right">
		<!-- Swiper -->
		<div class="swiper-container"> 
			<div class="swiper-wrapper">
				<div class="swiper-slide" style="width: 100%"><a href="http://kart.nexon.com/events/2019/0808/event.aspx" target="_blank"><img src="<c:url value="/webresources/images/slide1.jpg"/>"></a></div>
				<div class="swiper-slide" style="width: 100%"><a href="http://kart.nexon.com/kart/news/patch/view.aspx?n4ArticleSN=75068" target="_blank"><img src="<c:url value="/webresources/images/slide2.jpg"/>"></a></div>
				<div class="swiper-slide" style="width: 100%"><a href="http://kart.nexon.com/events/2019/0822/event.aspx" target="_blank"><img src="<c:url value="/webresources/images/slide3.jpg"/>"></a></div>
				<div class="swiper-slide" style="width: 100%"><a href="http://kart.nexon.com/events/2019/0829/event.aspx" target="_blank"><img src="<c:url value="/webresources/images/slide4.jpg"/>"></a></div>
			</div>
			<!-- Add Pagination -->
			<div class="swiper-pagination"></div>
			<!-- Initialize Swiper -->
			<script>
				var swiper = new Swiper('.swiper-container', {
					spaceBetween: 50,
					pagination: {
					el: '.swiper-pagination',
					clickable: true,
					},
				});
		</script>
		</div>
			<!-- 메인 간이 게시판  -->
			<div style="width:100%; margin-bottom:5%; height:500px; ">
				<div style="width:48%; float:left; margin-left:1%; height:498px; border:1px solid #000; ">
					<a href="<c:url value="/list/ucc/1"/>"><b style=" font-family:'본고딕'; font-size:30px">UCC 게시판</b></a>
						<table class="table table-hover" style="width:100%; font-size:15px; margin-top:3%">
							<tr style="text-align: center; background-color: #f5f5f5">	
								<th>BestImage 게시글</th>
								<th>BestVideo 게시글</th>
							</tr>
							<tr style="text-align: center;">
								<c:if test="${not empty	bestImage}">
								<td><a href="<c:url value="/read/${bestImage.num0}" />">${bestImage.title }</a></td>
								</c:if>
								<c:if test="${not empty bestVideo }">							
								<td><a href="<c:url value="/read/${bestVideo.num0}" />">${bestVideo.title }</a></td>
								</c:if>
							</tr>
						</table>
						
						<table class="table table-hover" style="font-size: 15px; text-align:left; width:100%" >
							<c:forEach var="uccList" items="${uccList}" varStatus="status" begin="0" end="6">
								<tr>	
									<td><a href="<c:url value="/read/${uccList.num0}" />">
									        ${uccList.title}</a></td>
									<td>${uccList.writer}</td>
									<td>${uccList.readcount}</td>
								</tr>
							</c:forEach>
						</table>
							
						
				</div>
				<div style="width:48%; float:right; margin-right:1%; height:498px; border:1px solid #000;">	
					<a href="<c:url value="/list/playtip/1"/>"><b style=" font-family:'본고딕'; font-size:30px">공략 게시판</b></a>
						<table class="table table-hover" style="width:100%; font-size:15px; margin-top:3%">
							<tr style="text-align: center; background-color: #f5f5f5">	
								<th colspan="2" style="text-align: left">Best 공략 게시글</th>
							</tr>
							
							<c:if test="${ tipList.size()>=1 }">
							<tr style="text-align: center;">
								<td><a href="<c:url value="/read/${bestPlaytip1.num0}" />">${bestPlaytip1.title }</a></td>							
								<td><a href="<c:url value="/read/${bestPlaytip2.num0}" />">${bestPlaytip2.title }</a></td>
							</tr>
							</c:if>
						</table>
						
						<table class="table table-hover" style="font-size: 15px; text-align:left; width:100%" >
							
							<c:forEach var="tipList" items="${tipList}" varStatus="status" begin="0" end="6">
								<tr>	
									<td><a href="<c:url value="/read/${tipList.num0}" />">
									        ${tipList.title}</a></td>
									<td>${tipList.writer}</td>
									<td>${tipList.readcount}</td>
								</tr>
							</c:forEach>
							
						</table>
				</div>
			</div>
			<!--  -->
			
			<div style="width:98%; margin-bottom:5%; margin-left:1%; border:1px solid #000; ">
				<div style="width:100%">	
					<img src="/webresources/images/mainBanner1.jpg" style="width: inherit;">
				</div>
			</div>
			
			<div style="width:100%; margin-bottom:5%; height:500px; ">
				<div style="width:48%; float:left; margin-left:1%; height:498px; border:1px solid #000;">
					<a href="<c:url value="/list/free/1"/>"><b style=" font-family:'본고딕'; font-size:30px">자유 게시판</b></a>
					<table class="table table-hover" style="width:100%; font-size:15px; margin-top:5%">
						<tr style="text-align: center; background-color: #f5f5f5; width:100%">	
							<th colspan="3" style="width:100%; text-align: left">최신 게시글</th>
						</tr>
						<c:forEach var="freeList" items="${freeList}" varStatus="status" begin="0" end="7">
							<tr>	
								<td><a href="<c:url value="/read/${freeList.num0}" />">
								        ${freeList.title}</a></td>
								<td>${freeList.writer}</td>
								<td>${freeList.readcount}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div style="width:48%; float:right; margin-right:1%; height:498px; border:1px solid #000;">
					<a href="<c:url value="/list/meeting/1"/>"><b style=" font-family:'본고딕'; font-size:30px">모임 게시판</b></a>
					<table class="table table-hover" style="width:100%; font-size:15px; margin-top:5%">
						<tr style="text-align: center; background-color: #f5f5f5; width:100%">	
							<th colspan="3" style="width:100%; text-align: left">최신 게시글</th>
						</tr>
						<c:forEach var="meetingList" items="${meetingList}" varStatus="status" begin="0" end="7">
							<tr>	
								<td><a href="<c:url value="/read/${meetingList.num0}" />">
								        ${meetingList.title}</a></td>
								<td>${meetingList.writer}</td>
								<td>${meetingList.readcount}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		
		
		</div>
<jsp:include page="bottom.jsp"/>

