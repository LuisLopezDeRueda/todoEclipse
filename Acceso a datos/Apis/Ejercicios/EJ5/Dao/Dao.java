package EJ5.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import EJ5.Modelo.Ciudad;

public class Dao {

	public List<Ciudad> filtrarLista(String filtro, Connection conn) throws SQLException {

		List<Ciudad> listaCiudades = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.createStatement();

			String sql = "SELECT * FROM city WHERE city LIKE '%" + filtro + "%'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Ciudad cuidad = new Ciudad();
				cuidad.setId(rs.getLong("city_id"));
				cuidad.setCountryId(rs.getLong("country_id"));
				cuidad.setDescripcion(rs.getString("city"));
				listaCiudades.add(cuidad);
			}
			return listaCiudades;

		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public Ciudad buscarCiudad(Long filtro, Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();

			String sql = "SELECT * FROM city WHERE city_id = " + filtro;
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				Ciudad cuidad = new Ciudad();
				cuidad.setId(rs.getLong("city_id"));
				cuidad.setCountryId(rs.getLong("country_id"));
				cuidad.setDescripcion(rs.getString("city"));
				return cuidad;
			}
			return null;

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public Long registrarUnaCiudad(Connection conn, Ciudad ciudad) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO CITY(city,country_id) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, ciudad.getDescripcion());
			stmt.setLong(2, ciudad.getCountryId());

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

	public Integer actualizarCiudad(Connection conn, Ciudad ciudad) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE CITY SET city = ?, country_id = ? where city_id = " + ciudad.getId());

			if (ciudad.getCountryId() == null) {
				stmt.setNull(2, Types.BIGINT);
			} else {
				stmt.setLong(2, ciudad.getCountryId());
			}
			stmt.setString(1, ciudad.getDescripcion());
			return stmt.executeUpdate();

		} finally {
			stmt.close();
		}

	}

	public Integer actualizarCiudadBien(Connection conn, Ciudad ciudad, Integer numero) throws SQLException {
		PreparedStatement stmt = null;
		try {
			if (numero == 2) {
				stmt = conn.prepareStatement("UPDATE CITY SET  country_id = ? where city_id = " + ciudad.getId());
				stmt.setLong(1, ciudad.getCountryId());
			} else if (numero == 3) {
				stmt = conn.prepareStatement("UPDATE CITY SET city = ? where city_id = " + ciudad.getId());
				stmt.setString(1, ciudad.getDescripcion());
			}
			return stmt.executeUpdate();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

	public Integer borrarCiudad(Connection conn, Long id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE FROM CITY WHERE CITY_ID = " + id);
			return stmt.executeUpdate();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
