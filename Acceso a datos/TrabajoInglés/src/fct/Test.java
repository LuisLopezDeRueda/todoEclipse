package fct;

import fct.Modelo.Usuario;
import fct.Service.UsuarioException;
import fct.Service.UsuarioService;

public class Test {
	public static void main(String[] args) {
		UsuarioService user = new UsuarioService();
		Usuario usuario = new Usuario();
		usuario.setApellidos("aa");
		usuario.setNombre("dd");
		usuario.setNivel("B1");
		usuario.setEdad(12);
		usuario.setPassword("123");
		try {
			user.registrarUsuario(usuario);
		} catch (UsuarioException e) {
			
			e.printStackTrace();
		}
		
	}
}
