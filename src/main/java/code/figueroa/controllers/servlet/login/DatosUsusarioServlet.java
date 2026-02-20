package code.figueroa.controllers.servlet.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;

@WebServlet({"/DatosUsuario", "/DatosUsuario.html"})
public class DatosUsusarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DatosUsusarioServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LoginServices session = new LoginServicesImpl();
		var isSession = session.getSessionUserName(request, "usuario");
		
		if(isSession != null && !isSession.isBlank()) {
			
			getServletContext().getRequestDispatcher("/WEB-INF/DatosUsuario.jsp").forward(request, response);
			//getServletContext().getRequestDispatcher("/WEB-INF/Bienvenidos.jsp").forward(request, response);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
