package code.figueroa.controllers.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;

@WebServlet({"/Usuario/DatosUsuario", "/DatosUsuario.html"})
public class DatosUsusarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DatosUsusarioServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			getServletContext().getRequestDispatcher("/WEB-INF/views/usuarios/DatosUsuario.jsp").forward(request, response);
			
		}

	


}
