package code.figueroa.models.usuario;

import java.time.LocalDate;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;

	
	public Persona() {}
	
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

    public void updateNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void updateApellido(String apellido) {
    	this.apellido = apellido;
    }
    
    public void updatefechaNacimeitno(LocalDate fNacimiento) {
    	this.fechaNacimiento = fNacimiento;
    }

	
	
	
}
