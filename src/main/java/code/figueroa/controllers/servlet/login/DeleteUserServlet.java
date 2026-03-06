package code.figueroa.controllers.servlet.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;


@WebServlet({"/Delete","/DeleteUserServlet"})
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserServices userImpl = new UserServicesImpl();
    
    public DeleteUserServlet() {
        super();

    }


	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var email = request.getParameter("email");
		
	
		
			request.setAttribute("UserEmail", email);
	        userImpl.DeleteUser(email);
	        response.sendRedirect("DatosUsuario");
	}

}
