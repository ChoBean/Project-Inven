<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	function search(){
		var search = $('input[name=search]').val();
		var temp1 = search.includes("[");
		var temp2 = search.includes("]");
		
		if (temp1 == true){
			search = search.replace("[","%5B");
		}
		
		if (temp2 == true){
			search = search.replace("]","%5D");
		}
		window.location.replace("http://localhost:8080/listAllSearch/1/" + search);
	}
</script>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<div class="input-group input-group-lg">
				<span style="width: 10%;" class="input-group-text" id="inputGroup-sizing-lg">검색창</span>
				<input style="width: 75%;" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"
					placeholder="단어 입력..." name="search">
				<button style="width: 10%;" class="btn btn-outline-secondary" type="button" onclick="search()">검색</button>
			</div>
			<table class="table table-hover">
				<tr>
					<th>NO.</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="board" items="${boardListAll}" varStatus="loop">
					<tr>
						<td>${board.num0}</td>
						<td><a href="<c:url value="/read/${board.num0}" />">
						        ${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.readcount}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination" style="display: table; margin-left: auto; margin-right: auto;">
				<c:forEach var="i" begin="1" end="${pageNum}">
					<li class="page-item" style="display: inline-block;"><a class="page-link" href="<c:url value="/listAll/${i}"/>">${i}</a></li>
				</c:forEach>
			</ul>
		</div>
<jsp:include page="../register/bottom.jsp"/>
