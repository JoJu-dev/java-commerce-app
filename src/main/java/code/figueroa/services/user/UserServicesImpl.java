package code.figueroa.services.user;


import java.util.List; // CORRECTO
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;


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

	private static List<Usuario> UserList = new ArrayList<Usuario>(); {
		if(UserList.isEmpty()) {
		UserList.add(new Usuario("Pepito","Alcantara",LocalDate.of(1998, 4, 30),"Pepi","pepi@gmail.com","pepi123",rolAdmin));
		UserList.add(new Usuario("Luis","Manzanares",LocalDate.of(1986, 2,3), "Wicho", "luis@gmail.com","luis123",rolCliente));
		UserList.add(new Usuario("Parito","Cantara",LocalDate.of(1998, 4, 30), "Paparito", "parito@gmail.com","parito123",rolUser));
		
	}
		}
	
		@Override
	public List<Usuario> listar() {
		
		
		return  UserServicesImpl.UserList;
	}
		@Override
		public Optional<Usuario> buscarPorCorreo(String correo) {
			
			return listar().stream().filter(co -> co.getCorreo().equals(correo)).findAny();
		}
		
		@Override
		public void addUsuario(Usuario usuario) {
			UserServicesImpl.UserList.add(usuario);		
		}
		
		@Override
		public void DeleteUser(String correo) {
			Optional<Usuario> getUser = buscarPorCorreo(correo);
	        if(getUser.isPresent()) {
	        	Usuario user = getUser.get();
	        	UserServicesImpl.UserList.remove(user);	
	        }		
			
		}
		public List<Rol> listRol(){
			return this.listRols;
		}
		
		public Optional<Rol> buscarRol(int idRol) {
			return listRols.stream().filter(rol -> rol.IdRol() ==idRol).findAny();
		}
		

}
