package service;

import javax.servlet.http.HttpServletRequest;

public interface JobService {
	//로그인 요청을 처리하기 위한 메소드
	//로그인은 폼에 입력한 데이터를 읽어야 하기 때문에 request가 필요합니다.
	//로그인을 처리하고 Controller 에게 알려줄 때 성공과 실패로만 구분해서 알려줄 생각이라서 
	//리턴 타입은 boolean 으로 설정했습니다.
	public boolean login(HttpServletRequest request);
}
