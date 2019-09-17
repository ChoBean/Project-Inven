package board.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandshakeInterceptor  extends HttpSessionHandshakeInterceptor{

	@Override 
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> map	) throws Exception {//파라미터값은 다 웹컨테이너에서 만들어줌
		
		//위의 파라미터 중, attributes 에 값을 저장하면 웹소켓 핸들러 클래스의 WebSocketSession에 전달된다
		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
		HttpServletRequest req = ssreq.getServletRequest(); //아파치에서 생성해주는 HttpServletRequest

		if((AuthInfo)req.getSession().getAttribute("authInfo") != null) {
		AuthInfo authInfo = (AuthInfo)req.getSession().getAttribute("authInfo");
			map.put("userId", authInfo.getName());


		}else {
			map.put("userId", "Unknown");
		 //테스트용
		}

		return super.beforeHandshake(request, response, wsHandler, map);
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, 
			WebSocketHandler wsHandler, Exception ex) {
		
		super.afterHandshake(request, response, wsHandler, ex);
	}
}
