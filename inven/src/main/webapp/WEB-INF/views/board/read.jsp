<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<table class="table table-bordered" style="border: 2px solid #000000;">
				<thead>
					<tr>
						<th style="width: 10%;">No.</th>
						<th style="width: 28%;">제목</th>
						<th style="width: 20%;">작성자</th>
						<th style="width: 25%;">작성일</th>
						<th style="width: 17%;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${boardVO.num1}</td>
						<td>${boardVO.title}</td>
				        <td>${boardVO.writer}</td>
				        <td>${boardVO.regdate}</td>
				        <td>${boardVO.readcount}</td>
				    </tr>
				</tbody>
				<tr style="height: 300px; border: 2px solid #000000;">
					<th>내용</th>
			        <td colspan="4" style="max-width: 600px">${boardVO.content}</td>
				</tr>
				<tr>
					<th>첨부 파일</th>
					<td colspan="2"><a href="/download/${boardVO.num0}">${boardVO.filename}</a></td>
					<th>카테고리</th>
					<td>${boardVO.category}</td>
				</tr>
			</table>
			<table class="table table-bordered" style="width: 98%">
				<tr>
					<th width="15%">작성자</th>
					<th width="60%" colspan="3">내용</th>
				</tr>
				<c:forEach var="board" items="${boardListUnder}" varStatus="loop">
					<tr>
						<td width="15%">${board.writer}</td>
						<td width="60%">${board.content}</td>
						<c:if test="${authInfo.name eq board.writer}">
							<td style="width: 8%; text-align: center;"><a class="btn btn-success btn-sm"
													href="<c:url value="/editUnder/${board.num0}"/>">수정</a></td>
							<td style="width: 8%; text-align: center;"><a class="btn btn-danger btn-sm"
													href="<c:url value="/deleteUnder/${board.num0}"/>">삭제</a></td>
						</c:if>
						<c:if test="${authInfo.grade eq 10}">
							<td style="width: 8%; text-align: center;"><a class="btn btn-danger btn-sm"
													href="<c:url value="/deleteUnderAdmin/${board.num0}"/>">삭제</a></td>
						</c:if>
						
					</tr>
				</c:forEach>
			</table>
			<form action="/writeUnder/${boardVO.num0}" method="POST">
				<table class="table table-bordered table-responsive-sm">
					<tr>
						<th>작성자</th>
						<th colspan="2">내용</th>
					</tr>
					<tr>
						<td>${authInfo.name}</td>
						<td><textarea rows="1" cols="60" id="content" name="content" placeholder="댓글 작성..."></textarea></td>
						<td><input class="btn btn-info" type="submit" value="댓글 작성"/></td>
					</tr>
				</table>
			</form>
			<div>
				<c:if test="${authInfo.name eq boardVO.writer}">
					<a class="btn btn-success" href="<c:url value="/edit/${boardVO.num0}"/>">수정</a>
					<a class="btn btn-danger" href="<c:url value="/delete/${boardVO.num0}"/>">삭제</a>
				</c:if>
				<c:if test="${authInfo.grade eq 10}">
					<a class="btn btn-danger" href="<c:url value="/deleteAdmin/${boardVO.num0}"/>">삭제</a>
				</c:if>
				<a class="btn btn-warning" href="<c:url value="/list/${boardVO.category}/1"/>">목록</a>
			</div>
		</div>
<jsp:include page="../register/bottom.jsp"/>

