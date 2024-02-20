package ejemploJdbc1.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemploJdbc1.modelo.Actor;

public class ActoresServices {

	private OpenConnection openConnection;
	
	public ActoresServices() {
		openConnection = new OpenConnection();
	}
	
	
	public List<Actor> consultarActores() throws ActoresServiceException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Actor> actores = new ArrayList<Actor>();
			conn = openConnection.abrirConexion();
			String sql = "select * from actor";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Actor a = new Actor();
				a.setId(rs.getInt("actor_id"));
				a.setNombre(rs.getString("first_name"));
				a.setApellidos(rs.getString("last_name"));
				actores.add(a);
			}
			return actores;
		}
		catch(SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new ActoresServiceException("Error al obtener actores de la bbdd", e);
			
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
			try {
				conn.close();
			}catch(Exception e) {}
		}
	
	
	}
	
}
