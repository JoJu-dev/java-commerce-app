package code.figueroa.models.login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




public class LoginTest {
	
	private String USER = "prueba";
	private String PASSWORD = "12345";
	
	@Test
	@DisplayName("input- Contraseña y password output contraseña o password incorrecto.")
	void CasoDePruebaLogin(){
		
		var credenciales = new Login("prueba", "111111111");
		
		assertEquals(false,credenciales.acceso(USER, PASSWORD),"Prueba no debe admitir password");
	}
	@Test
	@DisplayName("input- Contraseña y password output contraseña o password incorrecto.")
	void CasoDePruebaUserIncorrecto(){
		
		var credenciales = new Login("pruebas", "12345");
		
		assertEquals(false,credenciales.acceso(USER, PASSWORD),"Prueba no debe admitir user");
	}
	
	@Test
	@DisplayName("input- Contraseña y password output contraseña o password incorrecto.")
	void CasoDePruebaCredencialesIncorrectas(){
		
		var credenciales = new Login("pruebas", "s12345");
		
		assertEquals(false,credenciales.acceso(USER, PASSWORD),"Prueba no debe admitir Credenciales");
	}
	
	@Test
	@DisplayName("input- Contraseña y password output contraseña o password incorrecto.")
	void CasoDePruebaCredencialesCorrectas(){
		
		var credenciales = new Login(USER, PASSWORD);
		
		assertEquals(true,credenciales.acceso(USER, PASSWORD),"Prueba  debe admitir Credenciales");
	}

}