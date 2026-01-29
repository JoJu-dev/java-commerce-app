package code.figueroa.services.login;

import code.figueroa.models.login.Login;

public class LoginServicesImpl implements LoginSesvices {
	private String USER = "prueba";
	private String PASSWORD = "usuario";
	
	
	
	@Override
	public boolean inicioSession(String user, String pass) {
		var logeo = new Login(USER,PASSWORD);
		System.out.println("Logeo " +logeo.acceso(user, pass));
		return logeo.acceso(user, pass);
	}
	
	
	
}
