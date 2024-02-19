package ejercicio01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio01.modelo.Pelicula;

public class PeliculasDao {

	public List<Pelicula> consultarPeliculas(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pelicula> resultado = new ArrayList<Pelicula>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from film");
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setNombre(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				resultado.add(p);
			}
			return resultado;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception ignore) {}
		}
	}

}
