package code.figueroa.services.user;



import java.util.List;
import java.util.Optional;

import code.figueroa.models.usuario.Rol;
import code.figueroa.models.usuario.Usuario;

public interface UserServices {

	
	List<Usuario> listar();
	
	Optional<Usuario> buscarPorCorreo(String correo);
	
	void addUsuario(Usuario usuario);
	
	List<Rol>listRol();
	
    Optional<Rol> buscarRol(int idRol);
}
