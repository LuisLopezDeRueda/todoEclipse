package fct.DaoUsuario;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fct.Modelo.Registro;

public class RegistroDao {
	public List<Registro> consultarTodosRegistro(Connection conn, Long user) {

		Statement stmt = null;
		ResultSet rs = null;

		List<Registro> listaRegistros = new ArrayList<>();
		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM REGISTROS WHERE id_usuario = " + user;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setId_registro(rs.getInt("id_registro"));
				registro.setId_usuario(rs.getLong("id_usuario"));
				registro.setDate(rs.getDate("fecha").toLocalDate());
				registro.setNumero_horas(new BigDecimal(rs.getInt("num_horas")));
				registro.setDescripcion(rs.getString("descripcion"));
				listaRegistros.add(registro);
			}

		} catch (SQLException e) {
			System.out.println("Error con la base de datos consultando registro" + e);

		}
		return listaRegistros;

	}

	public Registro consultarUnRegistros(Connection conn, Long user, LocalDate fecha) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Registro registro = new Registro();
		try {
			String sql = "SELECT * FROM REGISTROS WHERE ID_USUARIO = ? fecha = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setLong(1, user);
			stmt.setDate(2, Date.valueOf(fecha));

			rs = stmt.executeQuery();
			if (rs.next()) {
				registro.setDate(rs.getDate("fecha").toLocalDate());
				registro.setDescripcion(rs.getString("descripcion"));
				registro.setId_registro(rs.getInt("id_registro"));
				registro.setId_usuario(rs.getLong("id_usuario"));
				registro.setNumero_horas(new BigDecimal(rs.getInt("num_horas")));
				return registro;
			}

		}

		catch (SQLException e) {
			System.out.println("Error con la base de datos consultando registro" + e);

		}
		return null;
	}

	public Long registrarUnRegistro(Connection conn, Registro registro) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO REGISTROS(id_usuario,fecha,num_horas,descripcion) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, registro.getId_usuario());
			stmt.setDate(2, Date.valueOf(registro.getDate()));
			stmt.setBigDecimal(3, registro.getNumero_horas());
			stmt.setString(4, registro.getDescripcion());

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
