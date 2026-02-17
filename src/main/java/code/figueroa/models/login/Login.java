package code.figueroa.models.login;

public class Login {

	private String user;
	private String password;

	public Login(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	
	public String getUser() {
		return user.replace(" ","");
	}

	public String getPassword() {
		return password.replace(" ","");
	}



	public boolean acceso(String user, String password) {
		
		if(this.getUser().equals(user.replace(" ", "")) && this.getPassword().equals(password.replace(" ", ""))) {
			return true;
		}		
		
		return false;
	}
	
	public boolean equals(Object obj) {
		return obj instanceof Login l && this.user == l.user && this.password == l.password; 
	}

}
