package code.figueroa.controllers.servlet.login;

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
import java.util.Optional;

import code.figueroa.models.usuario.Rol;
import code.figueroa.models.usuario.Usuario;
import code.figueroa.services.login.LoginServices;
import code.figueroa.services.login.LoginServicesImpl;
import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;

@WebServlet({ "/Actualizar", "/UpdateUserServlet" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserServices userImpl = new UserServicesImpl();

	public UpdateUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 var email = request.getParameter("email");
         		
		 LoginServices session = new LoginServicesImpl();
		 var isSession = session.getSessionUserName(request,"usuario");
			
	    if(isSession != null) {
		 Optional<Usuario> getUser =userImpl.buscarPorCorreo(email);
		 if(getUser.isPresent()) {
		 request.setAttribute("Usuario", getUser.get());
		 }
		 
		 request.getRequestDispatcher("/WEB-INF/views/usuarios/Editar.jsp").forward(request, response);
	    }else {
			 response.sendRedirect(request.getContextPath()+"/login.jsp");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var accion = request.getParameter("accion");
		var email = request.getParameter("email");
		
		Optional<Usuario> getUser =userImpl.buscarPorCorreo(email);
		 if(getUser.isPresent()) {
			 Usuario user = getUser.get();
              var name = request.getParameter("name");
      		  var lastName = request.getParameter("lastName");
      		  var dateOfBirth = request.getParameter("dateOfBirth");
      		  var nickName = request.getParameter("nickName");
      		  var password = request.getParameter("password");
      		 var rol =Integer.parseInt(request.getParameter("rol"));
      		  
      		  Map<String, String> errores = new HashMap<>();
      		  
      		
      		 
    		
              LocalDate fechaNacimiento = LocalDate.parse(dateOfBirth);
              UserServices userServicesImpl = new  UserServicesImpl();
			  List<Rol> listRol = userServicesImpl.listRol();
			  
			  
			  rol =  switch (rol) {
				case 1 -> rol = 0;
				case 2 -> rol =1;
				case 3 -> rol= 2;
			    default -> rol;
			  };
			  
			  Rol accessRol = listRol.get(rol);  
			  if(name == null && name.isBlank()) errores.put("name","Agrege nombre");
			  if(lastName == null && lastName.isBlank())errores.put("lastName","Ingrese Apellido");
			  if(dateOfBirth == null && dateOfBirth.isBlank())errores.put("dateOfBirth", "Seleccione fecha de Nacimiento");
			  if(nickName == null && nickName.isBlank()) errores.put("nickName","Agrege un nickName (alias)");
			  if(email == null && email.isBlank()) errores.put("email","Ingrese email");
			  if(password == null && password.isBlank()) errores.put("password","Agrege password");
			  if( rol > 2 && rol<=0) errores.put("rol", "Agrege un rol correctamente");
		
            if(errores.isEmpty()) {
            	if(!user.getNombre().equalsIgnoreCase(name)) {
            		user.updateNombre(name);
            	}

            	if(user.getApellido() == lastName) {
            		user.updateApellido(user.getApellido());
            	}else 
            	{  
            		user.updateApellido(lastName);
            	}
            	if(user.getFechaNacimiento().equals(fechaNacimiento)) {
            		user.updatefechaNacimeitno(user.getFechaNacimiento());
            	}else {
            		user.updatefechaNacimeitno(fechaNacimiento);
            	}
            	if(user.getNickName().equals(nickName)) {
            		user.updateNickName(user.getNickName());
            	}else {
            		user.updateNickName(nickName);
            	}
            	if(user.getPassword().equals(password)) {
            		user.updatePassword(user.getPassword());
            	}else {
            		user.updatePassword(password);
            	}
            	if(user.getRol().equals(accessRol)) {
            		user.updateRol(user.getRol());
            	}else {
            		user.updateRol(accessRol);
            	}
            }
		 }
                   
         	 response.sendRedirect("DatosUsuario");

	}
}
