package App;

import Modelo.Usuario;
import Service.UsuarioException;
import Service.UsuarioService;

public class App {

	public static void main(String[] args) {
		UsuarioService us = new UsuarioService();
		Usuario user = new Usuario();
		user.setApellidos("López");
		user.setCiclo("DAM");
		user.setEmail("llopezderueda");
		user.setNombre("Luis");
		user.setPassword("contraseña");
		try {
			us.registrarUsuario(user);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}

}
