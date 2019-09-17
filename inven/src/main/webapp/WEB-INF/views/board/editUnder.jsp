<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<div class="right">
			<form:form commandName="boardVO" method="POST">
				<table class="table">
					<tr>
						<th>작성자</th>
						<td>${boardVO.writer}
						<!-- form:hidden 으로 변경 -->
						</td>
					</tr>
					<tr>
						<th><form:label path="content">내용</form:label></th>
						<td><form:input path="content" />
						</td>
					</tr>
				</table>
				<div>
					<input class="btn btn-primary" type="submit" value="작성"/>
				</div>
			</form:form>
		</div>
<jsp:include page="../register/bottom.jsp"/>
