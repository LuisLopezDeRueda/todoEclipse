package Servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Dao.PeliculasDao;
import Modelo.Pelicula;

public class PeliculasService {
	private OpenConnection nc;

	public PeliculasService() {
		nc = new OpenConnection();
	}

	public List<Pelicula> consultarPeliculas(Integer id) throws PeliculasException {
		Connection conn = null;
		List<Pelicula> listapeliculas = new ArrayList<Pelicula>();
		try {

			conn = nc.getConection();
			PeliculasDao dao = new PeliculasDao();
			listapeliculas = dao.consultarPelicula(conn, id);

			Iterator<Pelicula> iterator = listapeliculas.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getLongitud() > 100) {
					iterator.remove();
				}
			}

			return listapeliculas;

		} catch (SQLException e) {

			throw new PeliculasException("Error al consultar las pelicuals en la BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
