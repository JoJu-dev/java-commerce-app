package code.figueroa.controllers.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import code.figueroa.services.login.LoginServicesImpl;
import code.figueroa.services.login.LoginSesvices;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginSesvices cerrarSesvices = new LoginServicesImpl();
		cerrarSesvices.outSession(request, "usuario");
		
			response.sendRedirect(request.getContextPath()+"/login.jsp");
	}


}
