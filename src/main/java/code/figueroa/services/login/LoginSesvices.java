package code.figueroa.services.login;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginSesvices {

	boolean inicioSession(String user, String pass);
	
	String getSessionUserName(HttpServletRequest req, String idSession);
}
