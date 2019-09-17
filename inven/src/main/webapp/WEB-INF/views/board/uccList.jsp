<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<h3><span class="badge badge-secondary">카테고리 : UCC</span></h3>
			<img src="<c:url value="/webresources/images/금메달.png"/>"/><label>BestImage 게시글</label>
			<table class="table table-hover">
				<tr>	
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>		
				</tr>
				<c:forEach var="bestImage" items="${bestImageReadCount}" varStatus="status" begin="0" end="4"> 
					<c:if test="${bestImage.readcount > 0}">
					
						<tr>
							<td><a href="<c:url value="/read/${bestImage.num0}" />">${bestImage.title }</a></td>
							<td>${bestImage.writer }</td>
							<td>${bestImage.readcount}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
				<img src="<c:url value="/webresources/images/금메달.png"/>"/><label>BestVideo 게시글</label>
				<table class="table table-hover">
					<tr>	
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>		
					</tr>
					<c:forEach var="bestVideo" items="${bestVideoReadCount}" varStatus="status" begin="0" end="4"> 
						<tr>
							<td><a href="<c:url value="/read/${bestVideo.num0}" />">${bestVideo.title }</a></td>
							<td>${bestVideo.writer }</td>
							<td>${bestVideo.readcount}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<label>UCC 전체 게시글</label>
				<table class="table table-hover">
				<tr>
					<th>NO.</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			
				<c:forEach var="board" items="${boardList}" varStatus="loop">
					<tr>
						<td>${board.num1}</td>
						<td><a href="<c:url value="/read/${board.num0}" />">
						        ${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.readcount}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination" style="display: table; margin-left: auto; margin-right: auto;">
				<c:forEach var="i" begin="1" end="${pageNum}">
					<li class="page-item" style="display: inline-block;"><a class="page-link" href="<c:url value="/list/${category}/${i}"/>">${i}</a></li>
				</c:forEach>
			</ul>
			<a class="btn btn-outline-success" href="<c:url value="/write/${category}" />">새 글 쓰기</a>
		</div>
<jsp:include page="../register/bottom.jsp"/>