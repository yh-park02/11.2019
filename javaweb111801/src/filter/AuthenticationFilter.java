package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/data/update")
public class AuthenticationFilter implements Filter {


    public AuthenticationFilter() {   
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request 형변환
		HttpServletRequest req = (HttpServletRequest)request;
		//세션 가져오기 
		HttpSession session = req.getSession();
		if(session == null) {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("login");
			return;
		}
		//로그인 여부 확인 
		if(session.getAttribute("id") == null) {
			//login 요청으로 리다이렉트
			HttpServletResponse res = (HttpServletResponse)response;
			session.setAttribute("msg", "로그인을 해야 사용할 수 있는 서비스입니다.");
			
			//전체 요청 경로에서 마지막 슬래시 위치 찾아서 슬래시까지 자르기 
			String requestURI = req.getRequestURI();
			int len = requestURI.lastIndexOf("/");
			
			String command = requestURI.substring(len+1);
		
			//마지막 경로를 세션에 url에 저장 : 로그인 된 후 원래 요청 페이지로 이동하기 위해서 저장
			session.setAttribute("url", command);
			
			res.sendRedirect("login");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
