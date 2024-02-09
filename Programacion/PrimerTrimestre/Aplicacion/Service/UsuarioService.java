package Service;

import java.sql.Connection;
import java.sql.SQLException;

import DaoUsuario.UsuarioDao;
import Modelo.Usuario;

public class UsuarioService {

	public Usuario iniciarSesion(String usuario, String password) throws UsuarioException {

		Connection conn = null;
		UsuarioDao csu = new UsuarioDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			Usuario user = new Usuario();
			user =  csu.consultarUsuario(conn, usuario);
			if (user != null && user.getPassword().equals(password)) {
				return user;
			} 
			else {
				throw new UsuarioException(); //Esto en un futuro hará un popup de usuario no existe
			}
		} catch (SQLException e) {
			System.out.println("Problema con comprobar usuario " + e);
		}
		return null;

	}

	public void registrarUsuario(Usuario usuario) throws UsuarioException {

		Connection conn = null;
		UsuarioDao csu = new UsuarioDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			conn.setAutoCommit(false);
			Usuario user = csu.consultarUsuario(conn, usuario.getEmail());
			if (user == null) {

				csu.registrarUnUsuarioDao(conn, usuario);
				conn.commit();
			} else {
				throw new UsuarioException();//Esto en un futuro hará un popup de usuario ya existe
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Problema con hacer rollback" + e);
			}
			System.out.println("Problema con comprobar usuario " + e);
		}

	}

}
