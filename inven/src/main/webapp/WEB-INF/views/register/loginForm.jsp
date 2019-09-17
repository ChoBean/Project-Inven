<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="top.jsp"/>
	<div class="right">
		<h2 style="margin-left:2%; margin-top:3%;">로그인</h2>
		<div style="width: 30%; margin-left: 2%; margin-top:2%;">
			<form:form role="form" commandName="loginCommand" action="/login" method="post">
				<fieldset>
					<div class="form-group input-group">
						<span class="input-group-text"><i class="fas fa-user"></i></span>
						<form:input class="form-control" placeholder="ID" path="id" maxlength="20"/>
					</div>
					
					<div class="form-group input-group">
						<span class="input-group-text"><i class="fas fa-lock"></i></span>
						<form:password class="form-control" placeholder="Password" path="pw" maxlength="30"/>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="rememberId"/>아이디 기억
						</label>
					</div>
						<button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
						<a class="btn btn-lg btn-success btn-block" href="/register/step1">회원가입</a>
				</fieldset>
			</form:form>
		</div>
	</div>
<jsp:include page="bottom.jsp"/>