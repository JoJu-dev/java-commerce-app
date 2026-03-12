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
import java.util.Optional;

import code.figueroa.models.usuario.Usuario;
import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;
import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/app/login", "/loginServlet.html", "/panel" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var user = request.getParameter("email");
		var password = request.getParameter("password");

		Map<String, String> errores = new HashMap<>();

		LoginServices credenciales = new LoginServicesImpl();
		boolean login = credenciales.inicioSession(user, password);

		if (!login)
			errores.put("isTrue", "Crededenciales incorrectas, vuelva a intentarlo");

		if (errores.isEmpty()) {

			UserServices usuarioServices = new UserServicesImpl();
			Optional<Usuario> usuarioCapturado = usuarioServices.buscarPorCorreo(user);

			if (usuarioCapturado.isPresent()) {

				Usuario usuario = usuarioCapturado.get();

				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);// Guarda atributo en la session de usuario.

				response.sendRedirect(request.getContextPath() + "/DashboardServlet");// Se realiza una nueva petición.
			}
		} else {

			request.setAttribute("errores", errores);// Guarda el atributo solo durante la peticion actual
			request.getRequestDispatcher("/login.jsp").forward(request, response);// solicitud intermamente dentro del
																					
			
		}

	}

}
