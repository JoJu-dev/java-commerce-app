package code.figueroa.models.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	
	@Test
	@DisplayName("Probar nuevo Usuario")
	void CrearInstanciaPersona() {
	Rol rolAdmin = new Rol(1, "Admin", "Usuario administrador");	
	LocalDate fecha = LocalDate.of(200,2, 20);
	Usuario persona = new Usuario("Usuario1","usuarioApellido",fecha,"userAdmin","Prueba@gmail.com",rolAdmin);
	
	assertNotNull(persona, "Esta instancia contiene datos");
	assertTrue(persona instanceof Persona,"Usuario deberia heredad de Persona");
	}
	
}