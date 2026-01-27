package code.figueroa.models.login;

public class Login {

	private String user;
	private String password;

	public Login(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}



	public boolean acceso(String user, String password) {
		
		if(this.getUser().equals(user) && this.getPassword().equals(password)) {
			return true;
		}		
		
		return false;
	}

}
