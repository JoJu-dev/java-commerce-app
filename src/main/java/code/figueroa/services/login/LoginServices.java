package code.figueroa.services.login;

import code.figueroa.models.usuario.Usuario;
import jakarta.servlet.http.HttpServletRequest;

public interface LoginServices {

	boolean inicioSession(String user, String pass);
	
	Usuario getSessionUserName(HttpServletRequest req, String idSession);
	
	void outSession(HttpServletRequest req, String idSession);
	
}
