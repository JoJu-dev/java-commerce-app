package code.figueroa.services.login;



import java.time.LocalDate;

import code.figueroa.models.usuario.Rol;
import code.figueroa.models.usuario.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginServicesImpl implements LoginServices {
	
    private Rol roleAdmin = new Rol(2,"Admin","Administrador del sitio");
	private Usuario logeo = new Usuario("José","Figueroa",LocalDate.of(2000, 1, 5),"JoJu","jose@gmail.com","usuario",roleAdmin);
	
	
	@Override
	public boolean inicioSession(String user, String pass) {
		return logeo.acceso(user,pass);
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
	
	/*Prueva de enviar Usuario*/
	public Usuario DatosUsuario() {
		return logeo;
	}
	
}
