package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.DataService1;
import service.DataServiceImpl;

@WebServlet("*.do")
public class DoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Service 변수 선언 
	private DataService1 dataService;
	
       
    public DoController() {
        super();
        
        //Service 객체 생성 
        dataService = DataServiceImpl.sharedInstance();
    }

	//get 요청이 오면 처리하는 메소드
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//GET과 POST 구분
		//request.getMethod()를 호출하면 요청방식이 리턴 
		
		//공통 부분을 제외한 요청 부분을 추출하기 
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		//자바 버전에 따라서 switch에 문자열을 사용할 수 없는 경우가 있는데 
		//이 경우는 if로 수정하던가 자바 버전을 상위 버전으로 변경해야 한다. 
		switch(command){
		case "/create.do":
			dataService.create();
			break;
		case "/read.do":
			dataService.read();
			break;
		case "/update.do":
			dataService.update();
			break;
		case "/delete.do":
			dataService.delete();
			break;
		default:
			System.out.println("잘못된 요청");
			break;
		}
	}

	//post 요청이 오면 호출하는 메소드
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
