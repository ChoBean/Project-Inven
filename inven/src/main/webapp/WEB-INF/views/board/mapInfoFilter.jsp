<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
				<table style="border : 1px solid; margin-left: 15%; margin-bottom :2%; margin-top :2%; text-align:center; width: 60%; height: 100%;">
					<tr>
						<td colspan="9" style="background-color:#0d5fa6; height:12px;"></td>
					</tr>
					
					<tr>
						<td colspan="9" style="text-align: center;">
							<br>
							<strong>카트라이더 트랙</strong>
							
						</td>
					</tr>
					
					<tr>
						<td>
							<a href="/mapInfoFilter/forest"><img src="<c:url value="/webresources/images/mapImages/아이콘/포레스트.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/desert"><img src="<c:url value="/webresources/images/mapImages/아이콘/사막.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/village"><img src="<c:url value="/webresources/images/mapImages/아이콘/빌리지.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/ice"><img src="<c:url value="/webresources/images/mapImages/아이콘/아이스.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/cemetery"><img src="<c:url value="/webresources/images/mapImages/아이콘/공동묘지.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/mine"><img src="<c:url value="/webresources/images/mapImages/아이콘/광산.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/planet"><img src="<c:url value="/webresources/images/mapImages/아이콘/노르테유.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/factory"><img src="<c:url value="/webresources/images/mapImages/아이콘/팩토리.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/pirate"><img src="<c:url value="/webresources/images/mapImages/아이콘/해적.png"/>"></a>
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td>
							<a href="/mapInfoFilter/fairytale"><img src="<c:url value="/webresources/images/mapImages/아이콘/동화.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/moonhill"><img src="<c:url value="/webresources/images/mapImages/아이콘/문힐시티.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/gold"><img src="<c:url value="/webresources/images/mapImages/아이콘/황금문명.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/china"><img src="<c:url value="/webresources/images/mapImages/아이콘/차이나.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/mansion"><img src="<c:url value="/webresources/images/mapImages/아이콘/대저택.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/nymph"><img src="<c:url value="/webresources/images/mapImages/아이콘/님프.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/mechanic"><img src="<c:url value="/webresources/images/mapImages/아이콘/메카닉.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/wkc"><img src="<c:url value="/webresources/images/mapImages/아이콘/WKC.png"/>"></a>
						</td>
						<td>
							<a href="/mapInfoFilter/brody"><img src="<c:url value="/webresources/images/mapImages/아이콘/브로디.png"/>"></a>
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
					<td colspan="9" style="background-color:#0d5fa6; height:12px;"></td>
					</tr>
				</table>
				<table class="table table-bordered">
					<tr>
			 			<th style="width: 10%;">트랙 이름</th>
			 			<th style="width: 28%;">트랙 사진</th>
			 		</tr>
					<c:forEach var="mapInfo" items="${mapInfoFilter}" varStatus="loop">
				 		<tr>
				 			<td><a href="/mapInfoContent/${mapInfo.mapnum }">${mapInfo.mapname }</a></td>
				 			<td><img src="${mapInfo.filepath}${mapInfo.filename}"></td>
				 		</tr>
					 </c:forEach>
				</table>
				<ul>
					<c:forEach var="i" begin="1" end="${pageNum}">
						<li class="page-item" style="display: inline-block;"><a class="page-link" href="/mapInfo/${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</div>
			
<jsp:include page="../register/bottom.jsp"/>
		
		