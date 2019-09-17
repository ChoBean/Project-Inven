<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<table class="table table-hover">
				<tr>
					<th>이미지</th>
					<th>이름</th>
					<th>엔진</th>
					<th>종류</th>
					<th>등급</th>
				</tr>
				<c:forEach var="kart" items="${kartList}" varStatus="status">
					<tr>
						<td><img class="kartImage" class="${kart.kartnum}" src="${kart.filepath}preview/${kart.filename}" width="70%" height="70%"
								onmouseover="this.src='${kart.filepath}${kart.filename}'" onmouseout="this.src='${kart.filepath}preview/${kart.filename}'"></td>
						<td>${kart.kartname}</td>
						<td>${kart.engine}</td>
						<td>${kart.type}</td>
						<td>${kart.rate}</td>
					</tr>
					
				</c:forEach>
			</table>
			<ul class="pagination" style="display: table; margin-left: auto; margin-right: auto;">
				<c:forEach var="i" begin="1" end="${pageNum}">
					<li class="page-item" style="display: inline-block;"><a class="page-link" href="<c:url value="${pageName}${i}"/>">${i}</a></li>
				</c:forEach>
			</ul>
		</div>
<jsp:include page="../register/bottom.jsp"/>