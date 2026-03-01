package code.figueroa.models.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;

public class UsuarioTest {

	private static Rol rolAdmin = new Rol(1, "Admin", "Usuario administrador");	
	private static LocalDate fecha = LocalDate.of(2000,2, 20);
	private static Usuario persona = new Usuario("Usuario1","usuarioApellido",fecha,"userAdmin","Prueba@gmail.com","12345",rolAdmin);
	private static UserServices userServicesImpl = new  UserServicesImpl();
	 
	@Test
	@DisplayName("Probar nuevo Usuario")
	void CrearInstanciaPersona() {
	
	assertNotNull(persona, "Esta instancia contiene datos");
	assertTrue(persona instanceof Persona,"Usuario deberia heredar de Persona");
	}
	
	@Test 
	@DisplayName("Probando credenciales correctas agregando espacio")
	void CredencianlesCorrectasAgregandoEspacio() {
		assertFalse( persona.acceso("Prueba@gmail.com ", " 12345"),"Persona deberia de no coincidir con las credenciales");
	} 
	
	@Test 
	@DisplayName("Probando credenciales incorrectas")
	void CredencianlesIncorrectas() {
		assertFalse( persona.acceso("pepi@gmail.com", "qqqqq"),"Persona deberia de no coincidir con las credenciales");
	}
	
	@Test 
	@DisplayName("Probando credenciales correctas")
	void CredencianlesCorrectas() {
		assertTrue( persona.acceso("Prueba@gmail.com", "12345"),"Persona deberia coincidir con las credenciales");
	}
	
	@Test
	@DisplayName("Prueba de un Usuario de la lista de Registros")
	void PruebaUsuarioDeListaDeRegistros() {
		UserServices listaUsuario = new UserServicesImpl();
		List<Usuario> listadoUsuario = listaUsuario.listar();
	    Usuario Luis = listadoUsuario.get(1);
	    
	    assertEquals("Luis", Luis.getNombre(),"El nombre de usuario debería coincidir");
	
	}
	
	@Test
	@DisplayName("Prueba de un Usuario de la lista de Registros")
	void PruebaUsuarioDeListaDeRegistrosIncorrecto() {
		List<Usuario> listadoUsuario = userServicesImpl.listar();
	    Usuario Luis = listadoUsuario.get(1);
	    
	    assertNotEquals("Pedro", Luis.getNombre(),"El nombre de usuario no debería coincidir");
	
	}
	
	@Test 
	@DisplayName("Agregando registro a lista de usuario")
	void agregarAlistaUsuario() {
		  List<Rol> listRol = userServicesImpl.listRol();
		  Rol accessRol = listRol.get(0);  
		  Usuario userAdd = new Usuario("name","lastName",fecha,"nickName","email@gmail.com","111111",accessRol);
		  userServicesImpl.addUsuario(userAdd);
		  assertEquals("email@gmail.com", userAdd.getCorreo(), "Correo debe de existir en la lista");
		
	}
	
	@Test 
	@DisplayName("Prueba Eliminando usuario")
	void EliminandoUsuario() {
	   Optional<Usuario> user = userServicesImpl.buscarPorCorreo("email@gmail.com");
	   if(user.isPresent()) {
		 Usuario getUser =  user.get();
	   
		userServicesImpl.DeleteUser("email@gmail.com");
		assertNotEquals("email@gmail.com", getUser.getCorreo(), "Usuario no existe");
		assertNull(getUser,"Usuario no existe");
	   }
	  }
}