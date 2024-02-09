package fct.Service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fct.DaoUsuario.UsuarioDao;
import fct.Modelo.Usuario;

@RestController
public class UsuarioService {

	@GetMapping("/login")//login?usuario=b&password=b
	public Usuario iniciarSesion(@RequestParam String usuario, @RequestParam String password) throws UsuarioException {

		Connection conn = null;
		UsuarioDao csu = new UsuarioDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			Usuario user = new Usuario();
			user = csu.consultarUsuario(conn, usuario);
			if (user != null && user.getPassword().equals(password)) {
				return user;
			} else {
				throw new UsuarioException();
			}
		} catch (SQLException e) {
			System.out.println("Problema con comprobar usuario " + e);
		}
		return null;

	}

	@PostMapping("/altaUsuario")
	public void registrarUsuario(@RequestBody Usuario usuario) throws UsuarioException {

		Connection conn = null;
		UsuarioDao csu = new UsuarioDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			Usuario user = csu.consultarUsuario(conn, usuario.getEmail());
			if (user == null) {

			} else {
				throw new UsuarioException();
			}
		} catch (SQLException e) {
			System.out.println("Problema con registrar usuario " + e);
		}

	}

}
