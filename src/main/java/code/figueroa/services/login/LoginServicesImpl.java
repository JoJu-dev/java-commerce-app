package code.figueroa.services.login;


import java.util.Optional;

import code.figueroa.models.usuario.Usuario;
import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginServicesImpl implements LoginServices {
	
  
	@Override
	public boolean inicioSession(String correo, String pass) {
		UserServices userServiece = new UserServicesImpl();
		Optional<Usuario> user = userServiece.buscarPorCorreo(correo);
	  
	  if(user.isPresent()) {	
	  Usuario usuarioEncontrado = user.get();
	  Usuario userCredentials = new Usuario(usuarioEncontrado.getNombre(), usuarioEncontrado.getApellido(),usuarioEncontrado.getFechaNacimiento(),
			  usuarioEncontrado.getNickName(), usuarioEncontrado.getCorreo(), usuarioEncontrado.getPassword(), usuarioEncontrado.getRol());
	  return userCredentials.acceso(correo,pass);
	  }
	  
	  return false;
		
	}



	@Override
	public Usuario getSessionUserName(HttpServletRequest req, String idSession) {
		//OPTIONAL no se utiliza para sesiones http
		
		HttpSession session = req.getSession();
        Usuario sessionName = null;	
		if(session != null) {
			
		  sessionName = (Usuario) session.getAttribute(idSession); 
		}
	     return sessionName;
	}



	@Override
	public void outSession(HttpServletRequest req, String idSession) {
	    
		HttpSession session = req.getSession();
		if(session != null) {
			session.removeAttribute(idSession);
		}
		
	}



	

	
}
