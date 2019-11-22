package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerImpl implements HttpSessionListener {

	//세션이 만들어 질 때 호츨되는 메소드
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("한 명의 유저가 접속했습니다.");
	}

	//세션이 소멸될 때 호출되는 메소드
	//로그아웃 할 때-session이 invalidate될 때 
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("한 명의 유저가 접속을 해제했습니다.");
	}
}
