package code.figueroa.controllers.servlet.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/loginServlet", "/loginServlet.html" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginServices sessionServices = new LoginServicesImpl();
		var nombreSession = sessionServices.getSessionUserName(request,"usuario");
		
		if((nombreSession != null) && !nombreSession.isBlank()) {
		    getServletContext().getRequestDispatcher("/WEB-INF/Bienvenidos.jsp").forward(request, response);
			
		}else {
			//getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);// devuelve ruta absoluta
			response.sendRedirect("login.jsp");//Se realiza una nueva petición.
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var user = request.getParameter("user");
		var password = request.getParameter("password");
		
		Map<String,String> errores = new HashMap<>();
		

		LoginServices credenciales = new LoginServicesImpl();
		boolean login = credenciales.inicioSession(user, password);


		if(!login)errores.put("isTrue", "Crededenciales incorrectas, vuelva a intentarlo");
		
		if(errores.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", user);//Guarda atributo en la session de usuario.

			response.sendRedirect("loginServlet.html");//Se realiza una nueva petición. 
		} else {
		
			request.setAttribute("errores", errores);// Guarda el atributo solo durante la peticion actual
			request.getRequestDispatcher("/login.jsp").forward(request, response);// solicitud intermamente dentro del servidor, No cambia la URL
		}

		
		
		
	}

}
