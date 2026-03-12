package code.figueroa.controllers.servlet.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import code.figueroa.services.login.LoginServicesImpl;
import code.figueroa.services.login.LoginServices;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
    public LogoutServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginServices cerrarSesvices = new LoginServicesImpl();
		//cerrarSesvices.outSession(request, "usuario");
		  request.getSession().invalidate();
		  response.sendRedirect("login.jsp");

	}


}
