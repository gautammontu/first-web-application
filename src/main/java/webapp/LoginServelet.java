package webapp;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/login.do")
public class LoginServelet  extends HttpServlet {
	
	private userValidationService service = new userValidationService();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//PrintWriter out=response.getWriter();
		
		//out.println("Gautam Webpage");
		System.out.println(request.getParameter("name"));
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("password", request.getParameter("password"));
		
	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	
	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	
		boolean value = service.isUserValid(request.getParameter("name"), request.getParameter("password"));
		
		if(value==true) {
			
			
		request.setAttribute("name",request.getParameter("name"));
		request.setAttribute("password",request.getParameter("password"));
		request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
		
		}else {
			System.out.println("in else");
			request.setAttribute("errormsg", "Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
			
	
	

}
