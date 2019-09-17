<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
	<div class="right">
	<style>
		table.scenarioTable{
			border:2px solid #ffffff;
			width:100%
		
		}
		table.searchBar{
			width: 100%; 
			background-color:#f5f5f5; 
			height: 70px; 
			border:2px solid #0d5fa6;
		}
	</style>
	<table class="scenarioTable" style="border:2px solid #0d5fa6;">
			<tr>
				<td colspan="4" style="background-color:#f5f5f5; text-align:center; ">
					캐릭터 시나리오
				</td>
			</tr>
			<tr>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/붐힐 마을" />">붐힐 마을</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/GOD" />">GOD</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/차이나" />">차이나</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/도검" />">도검</a></td>	
			</tr>
			<tr>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/황금문명 오르에트" />">황금문명 오르에트</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/붐남해의 해적" />">붐남해의 해적</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/님프 요정의 문장" />">님프 요정의 문장</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/붐붐랜드" />">붐붐랜드</a></td>	
			</tr>	
			<tr>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/블랙 컴퍼니" />">블랙 컴퍼니</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/카트라이더 온 더 비치" />">카트라이더 온 더 비치</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/1920" />">1920</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/쥐라기" />">쥐라기</a></td>
			</tr>
			<tr>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/월드" />">월드</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/네모" />">네모</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/문힐시티" />">문힐시티</a></td>
				<td style="text-align:center;"><a href="<c:url value="/characterSelectByScenario/노르테유" />">노르테유</a></td>
			</tr>			
		</table>
		<br>
		<table class="searchBar">
				<tr>	
					<th><b>이름</b></th>
					<td>
					<form action="/characterSelectByName" method="post" >
						<input type="text" name="keyWord" placeholder="검색어를 입력하세요" style="height: 50px"/>
						<input type="submit" value="검색" class="btn btn-outline-dark" style="margin-left:2%"/>
					</form>
					</td>
				</tr>	
		</table>
		<br>			
		<table class="table table-hover">
			<tr style="background-color:#f5f5f5">
				<th>icon</th>
				<th>시나리오</th>
				<th>캐릭터 명</th>
			</tr>
			
			<c:forEach var="character" items="${characterListAll}" varStatus="loop">
			<tr>
				<td><a href="<c:url value="/characterRead/${character.name}" />">
					<img src="<c:url value="${character.path }/${character.iconName }"/>"></a></td>
				<td><a href="<c:url value="/characterSelectByScenario/${character.scenario}" />">${character.scenario}</a></td>
				<td><a href="<c:url value="/characterRead/${character.name}" />">${character.name}</a></td>
			</tr>
			</c:forEach>	
		</table>	
		<ul class="pagination">
				<li class="page-item"><a class="page-link" href="/characterListAll/1">1</a></li>
				<li class="page-item"><a class="page-link" href="/characterListAll/2">2</a></li>
				<li class="page-item"><a class="page-link" href="/characterListAll/3">3</a></li>
				<li class="page-item"><a class="page-link" href="/characterListAll/4">4</a></li>
				<li class="page-item"><a class="page-link" href="/characterListAll/5">5</a></li>
		</ul>	
	</div>
			
<jsp:include page="../register/bottom.jsp"/>