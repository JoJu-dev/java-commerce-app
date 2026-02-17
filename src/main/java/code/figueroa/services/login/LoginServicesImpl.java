package code.figueroa.services.login;



import code.figueroa.models.login.Login;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginServicesImpl implements LoginSesvices {
	private static final String USER = "prueba";
	private static final String PASSWORD = "usuario";
	
	
	
	@Override
	public boolean inicioSession(String user, String pass) {
		var logeo = new Login(USER,PASSWORD);
		return logeo.acceso(user,pass);
	}



	@Override
	public String getSessionUserName(HttpServletRequest req, String idSession) {
		//OPTIONAL no se utiliza para sesiones http
		
		HttpSession session = req.getSession();
        String sessionName = null;	
		if(session != null) {
			
		  sessionName = (String) session.getAttribute(idSession); 
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
