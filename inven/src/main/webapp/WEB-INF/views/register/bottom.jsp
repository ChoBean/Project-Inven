<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	</div>
	<div class="bottom">
		
		<label>[회원채팅]</label>
		<div id="babo"style="background-color:white; width: 100%; height: 230px; border: 1px solid; overflow : auto;">
			<div id="chat">
			</div>
		</div>
		<div>
			<c:catch>
				<c:choose>
					<c:when test="${empty authInfo }">
						<form id="chatForm">
							<input type="text" id="message" value="로그인 후 이용" readonly="readonly" style="width: 100%;"/>
						</form>
					</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${!empty authInfo }">
							<div>
								<form id="chatForm">
									<input type="text" id="message" style="width: 67%;"/>
										<button id="btn" style="width:30%">전송</button>
									</form>
								</div>
							</c:when>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:catch>
		</div>
		<div style="margin-top: 40%;">
			<a href="https://tmi.nexon.com/kart?utm_source=KartWeb&utm_medium=referral">
			<img width="60%" src="/webresources/images/mainBanner2.png"></a>
		</div>
	</div>
	<script>
		$(document).ready(function(){
			$("#chatForm").submit(function(event){
				event.preventDefault();
				sock.send($("#message").val());
				$("#message").val('').focus();
			
			});
		});
		
		var sock = new SockJS("/echo");
		
		sock.onmessage = function(e){
			$("#chat").append(e.data + "<br/>");
			
			var objDiv = document.getElementById("babo");
			objDiv.scrollTop = objDiv.scrollHeight;
		}
			
		sock.onclose = function(){
			$("#chat").append("연결이 끊어짐 새로고침 후 이용.");
			var objDiv = document.getElementById("babo");
			objDiv.scrollTop = objDiv.scrollHeight;
		}
		
	</script>
	</body>
	
	<div class="footer">
		<div class="card bg-light mb-3" style="width: 100%;">
			<div align="center" class="card-header">회사소개 | 제휴문의 | 광고문의 | 이용약관 | 개인정보처리방침 | 청소년보호정책 | 찾아오시는 길 | 공지사항</div>
			<div class="card-body" style="text-align: center;">
				<h5 class="card-title">Copyright ⓒ 2019.Choi</h5>
				<p class="card-text">All rights reserved.</p>
			</div>
		</div>
	</div>

</html>