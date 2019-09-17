<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<p>전체 게시글 번호 : ${boardVO.num0}</p><br/>
			<p>카테고리별 게시글 번호 : ${boardVO.num1}</p><br/>
			<p>제목 : ${boardVO.title}</p><br/>
			<p>작성자 : ${boardVO.writer}</p><br/>
			<p>등록일 : ${boardVO.regdate}</p><br/>
			<form action="/delete/${boardVO.num0}" method="POST">
				<p>해당 글을 정말로 삭제하시겠습니까?</p><br/>
				<button class="btn btn-danger btn-sm" type="submit">삭제</button>>
				<a class="btn btn-warning btn-sm" onclick="history.go(-1); return false;">취소</a>
			</form>
		</div>
<jsp:include page="../register/bottom.jsp"/>
