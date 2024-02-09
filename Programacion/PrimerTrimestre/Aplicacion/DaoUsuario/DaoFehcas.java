package DaoUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Fecha;

public class DaoFehcas {

	public List<Fecha> consultarFecha(Connection conn, Integer año, Integer evalucaion) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Fecha> listaFechas = new ArrayList<Fecha>();
		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM FECHAS WHERE AÑO = " + año + " AND EVALUACION = " + evalucaion;
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Fecha fecha = new Fecha();
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
