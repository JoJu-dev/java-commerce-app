package code.figueroa.models.usuario;

public class Rol {

	private int idRol;
	private String nombre;
	private String descripcion;
	
	
	public Rol(int idRol, String nombre, String descripcion) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public int IdRol() {
		return idRol;
	}

	public String Nombre() {
		return nombre;
	}


	public String Descripcion() {
		return descripcion;
	}


	
	
	
	
}
