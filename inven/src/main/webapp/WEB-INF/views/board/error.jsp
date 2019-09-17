<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<c:choose>
				<c:when test="${errorMessage eq 'login' }">
					<h2>로그인이 필요합니다!</h2><br/>
					<a class="btn btn-success" href="/login">로그인 하러가기</a>
				</c:when>
				<c:when test="${errorMessage eq 'notyou' }">
					<h2>본인 글이 아닙니다!</h2>
					<button class="btn btn-success" onclick="history.go(-1); return false;">뒤로가기</button>
				</c:when>
			</c:choose>
		</div>
<jsp:include page="../register/bottom.jsp"/>
