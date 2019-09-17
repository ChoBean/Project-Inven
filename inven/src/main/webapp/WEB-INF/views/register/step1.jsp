<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="top.jsp"/>
		<div class="right">
			<div class="panel-body" style="margin-left:2%;">
				<h1>회원가입</h1>
				<br/>
				<nav class="navbar navbar-expand-sm bg-light navbar-light">
					&nbsp;<b>step1</b>&nbsp;/&nbsp;step2&nbsp;/&nbsp;step3
				</nav>				
				<br/><br/>
	    			<div class="row">
	        			<div class="col-lg-12">
	            			<h4>회원약관</h4>
	            			<div class="panel-body" style="border: 1px solid #ccc">
	            			<p>제 1 조 (목적)<br/>
							1. 본 약관은 카트라이더 인벤이 제공하는 모든 서비스(이하 "서비스")의 이용조건 및 절차, 이용자와 카트라이더 인벤 사이트의 권리, 의무, 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다.</p>
	        			</div>
	        			<br/>
	        			<h4>개인정보</h4>
	        			<div class="panel-body" style="border: 1px solid #ccc">
	            			<p>카트라이더 인벤은 「개인정보보호법」 제15조 제1항 제1호, 제17조 제1항 제1호, 제23조 제1호, 제24조 제1항 제1호에 따라 <br/>
								아래와 같이 개인정보의 수집. 이용에 관하여 귀하의 동의를 얻고자 합니다. <br/><br/>
								카트라이더 인벤은 이용자의 사전 동의 없이는 이용자의 개인정보를 함부로 공개하지 않으며, 수집된 정보는 아래와 같이 이용하고 있습니다.<br/> 
								이용자가 제공한 모든 정보는 아래의 목적에 필요한 용도 이외로는 사용되지 않으며 이용 목적이 변경될 시에는 이를 알리고 동의를 구할 것입니다.
							</p>	
	        			</div>
	        			<br/>
	        			<form:form action="/register/step2" method="post">
	            			<div class="form-group">
	                			<label class="checkbox-inline">
	                    			<input type="checkbox" name="agree" value="true">동의합니다.
	                			</label>
	            			</div>
	            			<button type="submit" class="btn btn-primary">다음 단계</button>
	       				</form:form>
	    			</div>
				</div>
			</div>
		</div>
<jsp:include page="bottom.jsp"/>