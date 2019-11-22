package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.JobService;
import service.JobServiceImpl;

@WebServlet("/data/*")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public JobService jobService;
       
    public DataController() {
        super();
        jobService = JobServiceImpl.sharedInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청 중에서 구분되는 부분만 잘라내기
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		
		RequestDispatcher dispatcher = null;
		//GET 을 구분해서 처리
		if("/data/login".equals(command) && "GET".equals(request.getMethod())) {
			//세션에 msg에 데이터가 있으면 request에 옮기고 삭제하기 
			request.setAttribute("msg", request.getSession().getAttribute("msg"));
			request.getSession().removeAttribute("msg");
			
			//job 디렉토리에 login.jsp 로 포워딩
			dispatcher = request.getRequestDispatcher("../job/login.jsp");
			dispatcher.forward(request, response);
		}else if("/data/login".equals(command) && "POST".equals(request.getMethod())) {
			//서비스의 메소드 호출
			boolean r = jobService.login(request);
			//로그인을 성공했을 때 
			if(r == true) {
				//세션에 url이 저장되었는지 확인해서 값을 가져온다.
				String url = (String)request.getSession().getAttribute("url");
				//필터에서 저장한 곳으로 리다이렉트 
				if(url != null) {
					request.getSession().setAttribute("url", null);
					response.sendRedirect(url);
					return;
				}
				//로그인에 성공한 경우 메인 페이지로 리다이렉트
				response.sendRedirect("../");
			}else {
				//로그인에 실패한 경우 로그인 페이지로 리다이렉트
				response.sendRedirect("login");
			}
		}
		else if("/data/update".equals(command)) {
			dispatcher = request.getRequestDispatcher("../job/update.jsp");
			dispatcher.forward(request, response);
		}else if("/data/read".equals(command)) {
			dispatcher = request.getRequestDispatcher("../job/read.jsp");
			dispatcher.forward(request, response);
		}else if("/data/logout".equals(command)) {
			//세션 초기화
			HttpSession session = request.getSession();
			session.invalidate();
			//메인 페이지로 이동
			response.sendRedirect("../");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}