package code.figueroa.controllers.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import code.figueroa.services.login.LoginServicesImpl;
import code.figueroa.services.login.LoginSesvices;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/loginServlet", "/loginServlet.html" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginSesvices sessionServices = new LoginServicesImpl();
		var nombreSession = sessionServices.getSessionUserName(request,"usuario");
		
		if((nombreSession != null) && (!nombreSession.isBlank())) {
		response.setContentType("text/html;Charset=UTF-8");		
		try (PrintWriter out = response.getWriter()) {

			out.println("<!Doctype html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset = \"UTF-8\">");
			out.println("<title>Login</title>");
			out.println("</head>");
			out.println("<body>");
			out.print("<h1>Bienvenidos<h1>");
			out.print("<h1 ><a href='" + request.getContextPath() +"/logout'>Cerrar Session</a><h1>");
			out.println("</body>");
			out.println("</html>");
		}
		}else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);// devuelve ruta absoluta
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var user = request.getParameter("user");
		var password = request.getParameter("password");
		
		Map<String,String> errores = new HashMap<>();
		

		LoginSesvices credenciales = new LoginServicesImpl();
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
