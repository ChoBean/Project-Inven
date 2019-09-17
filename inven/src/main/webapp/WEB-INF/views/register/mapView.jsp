<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="top.jsp"/>
	<script>
		Image1 = new Image(750,500)
		Image1.src = "/webresources/images/trackview/vs.jpg"
		
		Image2 = new Image(750,500)
		Image2.src = "/webresources/images/trackview/vs1.jpg"
		
		Image3 = new Image(750,500)
		Image3.src = "/webresources/images/trackview/vs2.jpg"
		
		Image4 = new Image(750,500)
		Image4.src = "/webresources/images/trackview/vs3.jpg"
		
		Image5 = new Image(750,500)
		Image5.src = "/webresources/images/trackview/vs4.jpg"
		
		Image6 = new Image(750,500)
		Image6.src = "/webresources/images/trackview/vs5.jpg"
		
	</script> 
		
	<script>
		function original() {
			document.emp.src = Image1.src; return true;
		}	
	
		function change1() {
			document.emp.src = Image2.src; return true;
		}
		
		function change2() {
			document.emp.src = Image3.src; return true;
		}
			
		function change3() {
			document.emp.src = Image4.src; return true;
		}
				
		function change4() {
			document.emp.src = Image5.src; return true;
		}
					
		function change5() {
			document.emp.src = Image6.src; return true;
		}
	</script>
		
		<div class="right">
		<h1 style="color : blue;">카트라이더 트랙 뷰</h1>
		<hr>
		
		<h2>빌리지 손가락</h2>
		<hr>
		<p style="color:red;">● 위에 마우스를 올려 보세요.</p>
			<div id="picture" style="margin-left:1%;">
			<img id="test" name="emp" src="<c:url value="/webresources/images/trackview/vs.jpg"/>" usemap="#Map">
	
			<map name="Map" id="Map">
    			<area shape="circle" coords="252,161,7.5" onMouseOver="change5()" onMouseOut="original()"/>
    			<area shape="circle" coords="353,122,7.5" onMouseOver="change3()" onMouseOut="original()"/>
    			<area shape="circle" coords="482,190,9.5" onMouseOver="change1()" onMouseOut="original()"/>
    			<area shape="circle" coords="472,324,8.5" onMouseOver="change2()" onMouseOut="original()"/>
    			<area shape="circle" coords="249,250,7.5" onMouseOver="change4()" onMouseOut="original()"/>
			</map>
			</div>
		</div>
	
	 
<jsp:include page="bottom.jsp"/>