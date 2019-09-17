<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<h3><span class="badge badge-secondary">카테고리 : ${category}</span></h3>
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