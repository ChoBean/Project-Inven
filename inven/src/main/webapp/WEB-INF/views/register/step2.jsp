<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="top.jsp"/>
	<div class="right">
		<div class="panel-body" style="margin-left:2%;">
			<h1>회원가입</h1>
			<br/>
			<nav class="navbar navbar-expand-sm bg-light navbar-light">
				&nbsp;step1&nbsp;/&nbsp;<b>step2</b>&nbsp;/&nbsp;step3
			</nav>	
			<br/><br/>
		    <div class="row">
        		<div class="col-lg-6">
            		<form:form role="form" commandName="registerRequest" action="/register/step3" method="post">
                		<div class="form-group input-group">
                    		<span class="input-group-text"><i class="fas fa-user"></i></span>
                    		<form:input type="text" class="form-control" placeholder="ID" path="id" maxlength="20" minlength="4"/>
                    		<form:errors cssStyle="font-weight : bold; color : #ff0000;" path="id"/>
		                </div>
		                <div class="form-group input-group">
		                    <span class="input-group-text"><i class="fa fa-envelope"></i></span>
		                   <form:input type="text" class="form-control" placeholder="E-mail" path="email" maxlength="40"/>
		                   <form:errors cssStyle="font-weight : bold; color : #ff0000;" path="email"/> 
		                </div>
		                <div class="form-group input-group">
		                    <span class="input-group-text"><i class="far fa-smile"></i></span>
		                    <form:input type="text" class="form-control" placeholder="Nickname" path="name" maxlength="15" minlength="2"/>
		                    <form:errors cssStyle="font-weight : bold; color : #ff0000;" path="name"/>
		                </div>
		                <div class="form-group input-group">
		                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
		                    <form:password class="form-control" placeholder="Password" path="pw" maxlength="30" minlength="4"/>
		                    <form:errors cssStyle="font-weight : bold; color : #ff0000;" path="pw"/>
		                </div>
		                <div class="form-group input-group">
		                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
		                    <form:password class="form-control" placeholder="Password Check" path="checkPw" maxlength="20" minlength="4"/>
		                    <form:errors cssStyle="font-weight : bold; color : #ff0000;" path="checkPw"/>
		                </div>
		                <button type="submit" class="btn btn-primary">회원가입</button>
		                <button onclick="location.href='/'; return false;" class="btn btn-warning">취소하기</button>
		            </form:form>
		        </div>
		    </div>
		</div>
	</div>
<jsp:include page="bottom.jsp"/>
</html>