package code.figueroa.models.usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario extends Persona {
    
	
	private String nickName;
	private LocalDateTime horaRegistroUsiario;
	private String correo; 
	private String password;
	private Rol rol;
	
	public Usuario() {
	}
	
	
	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String nickName, String correo,String password, Rol rol) {
		super(nombre, apellido, fechaNacimiento);
	     this.nickName = nickName;
	     this.correo = correo;  
	     this.password = password;
	     this.horaRegistroUsiario = LocalDateTime.now();
	     this.rol = rol;
	}
	
	public Usuario(String correo , String password) {
		this.correo = correo;
		this.password = password;
	}


	public String getNickName() {
		return nickName;
	}

	public LocalDateTime getHoraRegistroUsiario() {
		return horaRegistroUsiario;
	}

	public String getCorreo() {
		return correo;
	}

	public String getPassword() {
		return password;
	}

	public Rol getRol() {
		return rol;
	}

	
	public boolean acceso(String correo, String password) {
		return this.getCorreo().equals(correo) && this.getPassword().equals(password);
	}

	public boolean equals(Object obj) {
		return obj instanceof Usuario user && user.correo == this.correo && user.password == this.password;
	}
	
	
	
}
