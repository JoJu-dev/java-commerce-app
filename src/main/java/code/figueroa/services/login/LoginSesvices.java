package code.figueroa.services.login;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginSesvices {

	boolean inicioSession(String user, String pass);
	
	String getSessionUserName(HttpServletRequest req, String idSession);
	
	void outSession(HttpServletRequest req, String idSession);
}
