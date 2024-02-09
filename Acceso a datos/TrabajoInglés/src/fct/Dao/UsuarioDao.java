package fct.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fct.Modelo.Usuario;
import fct.Service.UsuarioException;

public class UsuarioDao {

	public Usuario consultarUsuario(Connection conn, String nombre) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();
		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM alumnos WHERE '" + nombre + "' LIKE nombre";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setNivel(rs.getString("nivel"));
				usuario.setEdad(rs.getInt("edad"));
				usuario.setPassword(rs.getString("password"));

				return usuario;
			} else {
				return null;
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public Long registrarUnUsuarioDao(Connection conn, Usuario user) throws UsuarioException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO alumnos(nombre,apellidos,nivel,edad,contraseña) VALUES (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, user.getNombre());
			stmt.setString(2, user.getApellidos());
			stmt.setString(3, user.getNivel());
			stmt.setInt(4, user.getEdad());
			stmt.setString(5, user.getPassword());

			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			return id;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
