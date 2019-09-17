<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../register/top.jsp"/>
		<script type="text/javascript">
			function radio(radioVal){
				if (radioVal == 'broadcast'){
					window.location.replace("http://localhost:8080/broadcastInfo/broadcast");
				}
				if (radioVal == 'video'){
					window.location.replace("http://localhost:8080/broadcastInfo/video");
				}
			}
        </script>
		<div class="right">
			<div style="display: table; margin-left: auto; margin-right: auto;">
				<div class="form-check form-check-inline" align="center" style="display: inline-block;">
					<input class="form-check-input" type="radio" name="Radios" id="broadcast" value="broadcast" onclick="radio(this.value)">
					<label class="form-check-label" for="broad">생방송</label>
				</div>
				<div class="form-check form-check-inline" align="center" style="display: inline-block;">
					<input class="form-check-input" type="radio" name="Radios" id="video" value="video" onclick="radio(this.value)">
					<label class="form-check-label" for="video">영상</label>
				</div>
			</div>
			<div style="width: 100%; height: 100%;">
				<c:if test="${radioVal eq 'broadcast'}">
					<ul style="margin-left: auto; margin-right: auto; border: 1px solid #000000;">
						<c:forEach var="streamer" items="${youtubeStreamer}" begin="0" end="${youtubeListSize}" varStatus="status">
							<li style="margin-top: 3%; margin-bottom: 5%;">
								<img style="width: 10%; height: 2%;" src="/webresources/images/youtube.png"><h4><a href="${youtubeId[status.index]}" target="_blank">${streamer}</a></h4>
							</li>
						</c:forEach>
	
						<c:forEach var="streamer" items="${twitchStreamer}" begin="0" end="9" varStatus="status">
							<li style="margin-top: 3%; margin-bottom: 5%;">
								<img style="width: 10%; height: 8%;" src="${twitchThumbNail[status.index]}">
								<img style="width: 10%; height: 2%;"  src="/webresources/images/twitch.png"><h4><a href="${twitchId[status.index]}" target="_blank">${streamer}</a></h4>
							</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${radioVal eq 'video'}">
					<ul style="display: table; margin-left: auto; margin-right: auto; border: 1px solid #000000;">
						<li style="margin-top: 3%; margin-bottom: 5%;">
							<img style="width: 20%; height: 4%;" src="/webresources/images/youtube.png">
							<a href="https://www.youtube.com/results?search_query=카트라이더" target="_blank">유튜브 링크</a>
						</li>
						<li style="margin-top: 3%; margin-bottom: 5%;">
							<img style="width: 20%; height: 4%;"  src="/webresources/images/twitch.png">
							<a href="https://www.twitch.tv/search?term=카트라이더" target="_blank">트위치 링크</a>
						</li>
					</ul>
				</c:if>
			</div>
		</div>
<jsp:include page="../register/bottom.jsp"/>