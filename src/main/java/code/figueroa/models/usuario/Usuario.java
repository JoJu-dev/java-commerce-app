package code.figueroa.models.usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario extends Persona {
    
	
	private String nickName;
	private LocalDateTime horaRegistroUsiario;
	private Rol idRol;
	private String correo; 
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String nickName, String correo, Rol idRol) {
		super(nombre, apellido, fechaNacimiento);
	     this.nickName = nickName;
	     this.idRol = idRol;
	     this.horaRegistroUsiario = LocalDateTime.now();
	     this.correo = correo;
	     
	}
	
	
}
