package ejemploJdbc2.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejemploJdbc2.dao.ActoresDao;
import ejemploJdbc2.modelo.Actor;

public class ActoresServices {

	private OpenConnection openConnection;
	
	public ActoresServices() {
		openConnection = new OpenConnection();
	}
	
	
	public List<Actor> consultarActores() throws ActoresServiceException{
		Connection conn = null;
		try {
			conn = openConnection.abrirConexion();
			ActoresDao dao = new ActoresDao();
			return dao.consultarActores(conn);
		}
		catch(SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new ActoresServiceException("Error al obtener actores de la bbdd", e);
			
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	
	
	}
	
}
