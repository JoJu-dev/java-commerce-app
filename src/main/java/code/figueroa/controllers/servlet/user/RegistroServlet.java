package code.figueroa.controllers.servlet.user;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import code.figueroa.models.usuario.Rol;
import code.figueroa.models.usuario.Usuario;
import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;
import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;


@WebServlet({"/Usuario/Registro","/RegistroServlet"})
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegistroServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			getServletContext().getRequestDispatcher("/WEB-INF/views/usuarios/Registro.jsp").forward(request, response);
			
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  var name = request.getParameter("name");
		  var lastName = request.getParameter("lastName");
		  var dateOfBirth = request.getParameter("dateOfBirth");
		  var nickName = request.getParameter("nickName");
		  var email = request.getParameter("email");
		  var password = request.getParameter("password");
		  var rol =Integer.parseInt(request.getParameter("rol"));
		  
		  Map<String, String> errores = new HashMap<>();
		  
		  if(name == null && name.isBlank()) errores.put("name","Agrege nombre");
		  if(lastName == null && lastName.isBlank())errores.put("lastName","Ingrese Apellido");
		  if(dateOfBirth == null && dateOfBirth.isBlank())errores.put("dateOfBirth", "Seleccione fecha de Nacimiento");
		  if(nickName == null && nickName.isBlank()) errores.put("nickName","Agrege un nickName (alias)");
		  if(email == null && email.isBlank()) errores.put("email","Ingrese email");
		  if(password == null && password.isBlank()) errores.put("password","Agrege password");
		  if( rol > 2 && rol<=0) errores.put("rol", "Agrege un rol correctamente");
		  
		  rol =  switch (rol) {
			case 1 -> rol = 0;
			case 2 -> rol =1;
			case 3 -> rol= 2;
		    default -> rol;
		  };
		  if(errores.isEmpty()) {
			UserServices userServicesImpl = new  UserServicesImpl();
			  List<Rol> listRol = userServicesImpl.listRol();
			  Rol accessRol = listRol.get(rol);  
			  LocalDate fechaNacimiento = LocalDate.parse(dateOfBirth);
			  
			  Usuario userAdd = new Usuario(name,lastName,fechaNacimiento,nickName,email,password,accessRol);
			  
			  userServicesImpl.addUsuario(userAdd);
		  }
		  response.sendRedirect(request.getContextPath() + "/Usuario/DatosUsuario");
 
	}

}
