package code.figueroa.models.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import code.figueroa.services.user.UserServices;
import code.figueroa.services.user.UserServicesImpl;
import jdk.jfr.Name;

public class UsuarioImplTest {
	
	@Test
	@Name("Verificando que la lista devulva valor")
	void RecibirListaDeUsuario() {
		
		UserServices listaUsuario = new UserServicesImpl();
		
		assertNotNull(listaUsuario.listar(),"Debe de retornar lista de usuarios");
	}
	
	@Test
	@Name("Verificando que la lista devuelva un valor especifico")
	void RecibirUsuario() {
		
		UserServices listaUsuario = new UserServicesImpl();
		List<Usuario> listaUsuarios = listaUsuario.listar();
		Usuario pepito =  listaUsuarios.get(0);
		assertEquals("Pepito",pepito.nombre,"Debe de retornar lista de usuarios");
	}
	
	@Test
	@Name("Prueba de funcionamiento de buscar usuario por correo")
	void BusquedaUsuarioPorCorreoNoExistente() {
		UserServices usuarioServices = new UserServicesImpl();
	    assertNotEquals("pepito@gmail.com", usuarioServices.buscarPorCorreo("pepito@gmail.com"));
	}

	@Test
	@Name("Prueba de funcionamiento de buscar usuario por correo")
	void BusquedaUsuarioPorCorreo() {
		UserServices usuarioServices = new UserServicesImpl();
	    assertNotEquals("pepi@gmail.com", usuarioServices.buscarPorCorreo("pepi@gmail.com"));
	}
	
}
