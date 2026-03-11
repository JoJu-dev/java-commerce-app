package code.figueroa.controllers.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import code.figueroa.listener.NumeroUsuariosListener;
import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DashboardServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginServices session = new LoginServicesImpl();
		var isSession = session.getSessionUserName(request, "usuario");
		int numeroUsuarios = NumeroUsuariosListener.obtenerNumeroUsuarios();
		
		if(isSession != null) {
			request.setAttribute("nUsuarios", numeroUsuarios);
			
			request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);
			
			
		}else {
			 response.sendRedirect(request.getContextPath()+"/login.jsp");
		 }
	
		
	}

}
