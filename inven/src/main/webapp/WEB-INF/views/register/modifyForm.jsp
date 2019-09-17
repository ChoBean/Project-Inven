<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
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
<div id="Wrapper">
	<div id="Navigation">
		<ul class="list-group list-group-horizontal-sm" id="primary" style="line-height:10px;">
			<li class="list-group-item list-group-item-light"><a href="/userInfo">회원 정보</a></li>
			<li class="list-group-item list-group-item-dark"><a href="/modify" class="active">회원 수정</a></li>
			<li class="list-group-item list-group-item-light"><a href="/delete">회원 탈퇴</a></li>
		</ul>
	</div>
	<div id="Container">
		<div id="Content">
			<div id="TAB1" style="display: none;">		
				 									
			</div>
			<div id="TAB2">		
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<h3>회원정보 수정</h3><br/>
							<form:form role="form" commandName="modifyRequest" action="/modifySuc" method="post">
					            <div class="form-group input-group">
									<span class="input-group-text"><i class="fa fa-id-badge"></i></span>
									<form:input type="text" class="form-control"  path="id" value="${authInfo.id }" readonly="true"/>
								</div>
					            <div class="form-group input-group">
									<span class="input-group-text"><i class="fa fa-envelope"></i></span>
					                <form:input type="email" class="form-control" placeholder="이메일" path="email"/>
									<form:errors cssStyle="font-weight : bold; color : #ff0000;" path="email"/>
								</div>
								<div class="form-group input-group">
									<span class="input-group-text"><i class="fa fa-user"></i></span>
									<form:input type="text" class="form-control" placeholder="닉네임" path="name"/>
									<form:errors cssStyle="font-weight : bold; color : #ff0000;" path="name"/>
								</div>
					                
								<div class="form-group input-group">
									<span class="input-group-text"><i class="fa fa-lock"></i></span>
									<form:password class="form-control" placeholder="기존 비밀번호" path="existPw"/>
									<form:errors cssStyle="font-weight : bold; color : #ff0000;" path="existPw"/>
					            </div>
					            <br/>
					                
					            <div class="form-group input-group">
									<span class="input-group-text"><i class="fa fa-lock"></i></span>
									<form:password class="form-control" placeholder="변경 할 비밀번호" path="pw"/>
									<form:errors cssStyle="font-weight : bold; color : #ff0000;" path="pw"/>
								</div>
								<div class="form-group input-group">
									<span class="input-group-text"><i class="fa fa-lock"></i></span>
									<form:password class="form-control" placeholder="비밀번호 확인" path="checkPw"/>
									<form:errors cssStyle="font-weight : bold; color : #ff0000;" path="checkPw"/>
								</div>
									<button type="submit" class="btn btn-primary" style="margin-top:2%;" >수정</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div id="TAB3" style="display: none;">		
				 
			</div>
		</div>
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
