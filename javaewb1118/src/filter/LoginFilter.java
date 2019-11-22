package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter({ "/create.do", "/update.do", "/delete.do" })
public class LoginFilter implements Filter {

	//1번으로 객체가 만들어질 때 한번만 호출
    public LoginFilter() {
        
    }

	//4번으로 한 번만 호출
	public void destroy() {
		
	}

	//3번으로 패턴에 해당하는 요청이 올 때 마다 호출 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청을 처리하기 전에 수행되는 코드 
		System.out.println("로그인이 안되어 있으면 로그인 페이지로 이동");

		chain.doFilter(request, response);
		//요청을 처리한 후에 호출되는 코드 
		
	}
	
	//2번으로 한 번만 호출
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
