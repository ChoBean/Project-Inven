<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
	<div class="right">
		 <img src="<c:url value="${characterVO.path }/${characterVO.imageName }"/>">
	</div>		
<jsp:include page="../register/bottom.jsp"/>