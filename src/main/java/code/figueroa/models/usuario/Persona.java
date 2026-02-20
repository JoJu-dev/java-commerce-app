package code.figueroa.models.usuario;

import java.time.LocalDate;

public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;

	
	public Persona() {}
	
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

}
