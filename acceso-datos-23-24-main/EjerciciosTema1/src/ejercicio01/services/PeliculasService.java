package ejercicio01.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import ejercicio01.dao.PeliculasDao;
import ejercicio01.modelo.Pelicula;

public class PeliculasService {

	public List<Pelicula> consultarPeliculas() throws PeliculasException {
		return consultarPeliculas(100);
	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasException {
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			PeliculasDao dao = new PeliculasDao();
			List<Pelicula> peliculas = dao.consultarPeliculas(conn);
			Iterator<Pelicula> it = peliculas.iterator();
			while (it.hasNext()) {
				if (it.next().getLongitud() > longitud) {
					it.remove();
				}
			}
			return peliculas;
		} catch (SQLException e) {
			System.err.println("Error al consultar peliculas");
			throw new PeliculasException("Error al consultar peliculas en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}

		}

	}

}
