package code.figueroa.services.user;


import java.util.List; // CORRECTO
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import code.figueroa.models.usuario.Rol;
import code.figueroa.models.usuario.Usuario;

public class UserServicesImpl implements UserServices {

	private List<Rol> listRols = new ArrayList<>();
	{
		listRols.add(new Rol(1,"Administrador","Usuario Administrador"));	
		listRols.add(new Rol(2,"Cliente","Usuario comprador"));	
		listRols.add(new Rol(3,"User","Usuario vendedor"));	
		
	}
	private Rol rolAdmin = listRols.get(0);
    private Rol rolCliente = listRols.get(1);
	private Rol rolUser = listRols.get(2);

	private List<Usuario> UserList = new ArrayList<Usuario>(); {
		UserList.add(new Usuario("Pepito","Alcantara",LocalDate.of(1998, 4, 30),"Pepi","pepi@gmail.com","pepi123",rolAdmin));
		UserList.add(new Usuario("Luis","Manzanares",LocalDate.of(1986, 2,3), "Wicho", "luis@gmail.com","luis123",rolCliente));
		UserList.add(new Usuario("Parito","Cantara",LocalDate.of(1998, 4, 30), "Paparito", "parito@gmail.com","parito123",rolUser));
		UserList.add(new Usuario("Pepito","Alcantara",LocalDate.of(1998, 4, 30), "Pepi", "pepi@gmail.com","pepi123",rolAdmin));
		UserList.add(new Usuario("Luis","Manzanares",LocalDate.of(1986, 2,3), "Wicho", "luis@gmail.com","luis123",rolCliente));
		UserList.add(new Usuario("Parito","Cantara",LocalDate.of(1998, 4, 30), "Paparito", "parito@gmail.com","parito123",rolUser));
		UserList.add(new Usuario("Pepito","Alcantara",LocalDate.of(1998, 4, 30), "Pepi", "pepi@gmail.com","pepi123",rolAdmin));
		UserList.add(new Usuario("Luis","Manzanares",LocalDate.of(1986, 2,3), "Wicho", "luis@gmail.com","luis123",rolCliente));
		UserList.add(new Usuario("Parito","Cantara",LocalDate.of(1998, 4, 30), "Paparito", "parito@gmail.com","parito123",rolUser));
	}
	
		@Override
	public List<Usuario> listar() {
		
		
		return  UserList;
	}
		@Override
		public Optional<Usuario> buscarPorCorreo(String correo) {
			
			return listar().stream().filter(co -> co.getCorreo().equals(correo)).findAny();
		}
		
		@Override
		public void addUsuario(Usuario usuario) {
			UserList.add(usuario);		
		}
		
		

}
