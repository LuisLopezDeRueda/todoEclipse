package ceu.dam.ad.examen.ej1dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	@Override
	public Long insertarCategoria(Connection conn, String nombreCategoria) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO category(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, nombreCategoria);

			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			if (id == 0) {
				throw new SQLException();
			}
			return id;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	@Override
	public Categoria consultarCategoria(Connection conn, Long id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Categoria categoria = new Categoria();
		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM category WHERE '" + id + "' = category_id";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				categoria.setId(id);
				categoria.setLastUpdate(rs.getDate("last_update"));
				categoria.setName(rs.getString("name"));
				return categoria;
			} else {
				return null;
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

}
