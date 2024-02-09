package DaoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Usuario;
import Service.UsuarioException;

public class UsuarioDao {

	public Usuario consultarUsuario(Connection conn, String user)  throws SQLException{

		Statement stmt = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();
		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM USUARIOS WHERE " + user + " = EMAIL ";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setCiclo(rs.getString("ciclo"));
				return usuario;
			}else {
				return null;
			}

		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}

	public Long registrarUnUsuarioDao(Connection conn, Usuario user) throws UsuarioException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO USUARIOS(email,password,nombre,apellidos,ciclo,activo) VALUES (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getNombre());
			stmt.setString(4, user.getApellidos());
			stmt.setString(5, user.getCiclo());
			stmt.setBoolean(6, user.getActivo());

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
