<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
	<c:if test="${category ne 'ucc'}">
		<script>
			$(function(){
				CKEDITOR.replace("content");
				CKEDITOR.height = 700;
			});
		    $("#submit").click(function(){
		       //에디터 내용 가져옴
		        var content = CKEDITOR.instances.content.getData();
			});
		</script>
	</c:if>
		<div class="right">
			<form:form commandName="boardVO" method="POST" encType="multipart/form-data">
				<c:if test="${category eq 'free'}">
					<select name="subTitle" class="custom-select  custom-select-sm" id="subTitle">
						<option value="">-- 분류 선택 --</option>
						<option value="잡담">잡담</option>
						<option value="토론">토론</option>
						<option value="개인 견해">개인 견해</option>
					</select>
					<!-- 다른 카테고리는 다르게 -->
				</c:if>
				<c:if test="${category eq 'incident'}">
					<select name="subTitle" class="custom-select  custom-select-sm" id="subTitle">
						<option value="">-- 분류 선택 --</option>
						<option value="비매너 유저 신고">비매너 유저 신고</option>
						<option value="버그 리포트">버그 리포트</option>
					</select>
				</c:if>
				<c:if test="${category eq 'playtip'}">
					<select name="subTitle" class="custom-select  custom-select-sm" id="subTitle">
						<option value="">-- 분류 선택 --</option>
						<option value="카트 공략">카트 공략</option>
						<option value="맵 공략">맵 공략</option>
						<option value="시나리오 공략">시나리오 공략</option>
					</select>
				</c:if>
				<c:if test="${category eq 'meeting'}">
					<select name="subTitle" class="custom-select  custom-select-sm" id="subTitle">
						<option value="">-- 분류 선택 --</option>
						<option value=""></option>
						<option value=""></option>
					</select>
				</c:if>
				<c:if test="${category eq 'ucc'}">
					<script>	
						$(function(){
				 	   		$("#content").summernote({
				        	height : 700,
				        	
				  	  		});
						});		
					</script>
					<select name="subTitle" class="custom-select  custom-select-sm" id="subTitle">
						<option value="">-- 분류 선택 --</option>
						<option value="image">image</option>
						<option value="video">video</option>
					</select>
					
				</c:if>
				<c:if test="${category eq 'Q&A'}">
					<select name="subTitle" class="custom-select  custom-select-sm" id="subTitle">
						<option value="">-- 분류 선택 --</option>
						<option value="질문">질문</option>
						<option value="답변">답변</option>
					</select>
				</c:if>
				
				<table class="table table-hover">	
					<tr>
						<th><form:label path="title">제목</form:label></th>
						<td><form:input path="title" required="required"/>
						</td>
					</tr>
					<tr>
						<th><form:label path="content">내용</form:label></th>
						<td><form:textarea id="content" path="content" />
						</td>
					</tr>
					<tr>
						<th><label>파일 : </label></th>
						<td><input type="file" name="file">
						</td>
					</tr>
				</table>
				<div>
					<input id="submit" class="btn btn-primary" type="submit" value="등록"/>
				</div>
			</form:form>
		</div>
<jsp:include page="../register/bottom.jsp"/>
