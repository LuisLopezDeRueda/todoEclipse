package practica.services;

import java.util.Date;

import practica.modelo.Usuario;

public class LoginService {

	public Usuario login(String username, String password) throws LoginDenegadoException {
		Usuario usuario = new Usuario("Laura Santos Rioja", "Sevilla", new Date());
		if ("test".equals(username) && "pass".equals(password)) {
			return usuario;
		}
		throw new LoginDenegadoException("Usuario/Password incorrectos");
	}

}