package Servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.ActoresDao;
import Modelo.Actor;

public class ActoresService {
	private OpenConnection nc;

	public ActoresService() {
		nc = new OpenConnection();
	}

	public List<Actor> consultarActores() throws ActoresServiceException {
		try {
			Connection conn = null;
			conn = nc.getConection();
			ActoresDao dao = new ActoresDao();
			try {
				conn.close();
			} catch (Exception e) {
			}

			return dao.consultarActor(conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
}
