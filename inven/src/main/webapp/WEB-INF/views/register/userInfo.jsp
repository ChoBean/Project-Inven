<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
/* main elements layouts */

	#Container {
	color: #333;
	clear: both;
	margin: 0px;
	padding: 0;
	width: 95%;
	float: left;
	border: 1px solid #C0C0C0;
	display: block;
	}

	#Content {
	border-top-width: 1px;
	border-top-style: solid;
	border-top-color: #C0C0C0;
	margin: 0px;
	width: 100%;
	height: auto;
	}
	
#Navigation {
	margin: 0px;
	padding: 0px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #333333;
	position: relative;
	height: 50px;
	display: block;
	width: auto;
	}

/* top level list "primary" */
ul#primary {
	margin: 0;
	padding: 0;
	position: absolute;
	bottom: -1px;
}

ul#primary li {
	display: inline;
	list-style: none;
}

ul#primary a,ul#primary a.active {
	display: block;
	float: left;
	text-align: center;
	font-family: tahoma, verdana, sans-serif;
	font-size: 12px;
	text-decoration: none;
	color: #333;
	letter-spacing: .1em;
	margin-top: 0px;
	margin-right: 2px;
	margin-bottom: 0;
	margin-left: 0;
	padding-right: 0;
	padding-left: 0;
}

ul#primary a.active,ul#primary a.active:hover {
	
	color: #333;
	margin-top: 0;
	margin-right: 2px;
	margin-bottom: 0px;
	margin-left: 0px;
	padding-right: 0px;
	padding-left: 0px;
}

</style>

<jsp:include page="top.jsp"/>
	
	<div class="right">
		<div id="Navigation">
			<ul class="list-group list-group-horizontal-sm" id="primary" style="line-height:10px;">
				<li class="list-group-item list-group-item-dark"><a href="/userInfo" class="active">회원 정보</a></li>
				<li class="list-group-item list-group-item-light"><a href="/modify">회원 수정</a></li>
				<li class="list-group-item list-group-item-light"><a href="/delete">회원 탈퇴</a></li>
			</ul>
		</div>
		<div id="Container">
			<div id="Content">
				<div id="TAB1">		
					<h3>${authInfo.name }님의 회원 정보 입니다.</h3>
					<br/><br/>
					<h5>방문수 :${visitcount }회&nbsp;&nbsp;&nbsp;총 게시글 : ${listcount}개&nbsp;&nbsp;&nbsp;총 댓글 : ${listundercount}개</h5>
					<br/><br/>
					<div id="Wrapper">
						<div id="Navigation">
							<ul class="list-group list-group-horizontal-sm"  id="primary" style="line-height:10px;">
								<li class="list-group-item list-group-item-dark"><a href="/userInfo" class="active">내가 쓴 글</a></li>
								<li class="list-group-item list-group-item-light"><a href="/userInfou">내가 쓴 댓글</a></li>
							</ul>
						</div>
						<div id="Content">
							<div id="TAB1">		
							 	<h5>${authInfo.name }님의 글 입니다.</h5>
							 	<table class="table table-bordered">
							 		<tr>
							 			<th style="width: 10%;">No.</th>
							 			<th style="width: 28%;">제목</th>
							 			<th style="width: 20%;">작성자</th>
							 			<th style="width: 28%;">작성일</th>
							 			<th style="width: 14%;">조회수</th>
							 		</tr>
								 	<c:forEach var="userBoard" items="${list}" varStatus="loop">
							 		<tr>
							 			<td>${userBoard.num0 }</td>
							 			<td><a href="/read/${userBoard.num0 }">${userBoard.title}</a></td>
							 			<td>${userBoard.writer }</td>
							 			<td>${userBoard.regdate }</td>
							 			<td>${userBoard.readcount }</td>
							 		</tr>
								 	</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div id="TAB2" style="display: none;">		
				<h5>${authInfo.name }님의 댓글 입니다.</h5>				
				</div>
			</div>
		</div>
	</div> 
	<div class="panel-body">
	    <div class="row">
	        <div class="col-lg-6">
			</div>
		</div>
	</div>

<script>

	$("#primary a").click(function(){
			$("#primary a").removeClass("active");
			$(this).addClass("active");
			$("#Content div").css("display", "none");
			var tabname = $(this).text();
			tabname = tabname.replace(' ','');
			$("#"+tabname).css("display","block");
	 });

</script>
<jsp:include page="bottom.jsp"/>
