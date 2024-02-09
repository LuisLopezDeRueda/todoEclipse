package fct.DaoUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fct.Modelo.Fecha;

public class FechasDao {

	public List<Fecha> consultarFecha(Connection conn, Integer año, Integer evaluacion) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Fecha> listaFechas = new ArrayList<Fecha>();
		Fecha fecha1 = new Fecha();
		listaFechas.add(fecha1);
		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM FECHAS WHERE AÑO = " + año + " AND EVALUACION = " + evaluacion;
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Fecha fecha = new Fecha();
				fecha.setFecha(rs.getDate("fecha").toLocalDate());
				fecha.setAño(rs.getInt("año"));
				fecha.setEvaluación(rs.getInt("evaluacion"));
				fecha.setDisponibilidad(rs.getBoolean("disponibilidad"));
				listaFechas.add(fecha);
			}
			return listaFechas;

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
