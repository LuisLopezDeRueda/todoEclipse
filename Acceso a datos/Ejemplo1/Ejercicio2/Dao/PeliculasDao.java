package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Pelicula;

public class PeliculasDao {

	public List<Pelicula> consultarPelicula(Connection conn, Integer id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		List<Pelicula> listaPeliculas = new ArrayList<>();

		stmt = conn.createStatement();
		String sql = "SELECT * FROM FILM WHERE length < " + id;
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Pelicula peli = new Pelicula();
			peli.setId(rs.getInt("film_id"));
			peli.setTitulo(rs.getString("title"));
			peli.setLongitud(rs.getInt("length"));
			listaPeliculas.add(peli);
		}

		return listaPeliculas;

	}
}