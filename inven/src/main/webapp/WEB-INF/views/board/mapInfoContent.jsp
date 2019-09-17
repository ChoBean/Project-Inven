<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>

<style>
	tr{
		width: 8%;
		border: 1px solid #000000;
		text-align: center;
		margin-left:2%;
	}
	th{
		border: 1px solid #000000;
		text-align: center;
		margin-left:2%;
	}
</style>
	
	<div class="right" style="margin-top: 4%">
		<h2>${mapInfoVO.mapname }</h2>
		<hr style="color : blue;">
		<img src="${mapInfoVO.filepath }${mapInfoVO.filename }">
		<br/><br/><br/>
		<table style="border: 1px solid #000000; width: 20%">
			<tr>
				<th>난이도</th>
				<th>${mapInfoVO.maplevel }</th>
			</tr >
			<tr>
				<th>랩</th>
				<th>${mapInfoVO.maplap }바퀴</th>
			</tr>
			
		</table>
		<br/><br/><br/>
		${mapInfoVO.mapvideo }
		<br/><br/>
		<a class="btn btn-warning" href="/mapInfo/1">목록</a>
	</div>
	
<jsp:include page="../register/bottom.jsp"/>