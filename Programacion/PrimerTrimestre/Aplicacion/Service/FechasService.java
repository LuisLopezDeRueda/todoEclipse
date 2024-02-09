package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DaoUsuario.DaoFehcas;
import Modelo.Fecha;

public class FechasService {
	public List<Fecha> consultarFechas() throws fechasException {
		Connection conn = null;
		DaoFehcas csf = new DaoFehcas();
		List<Fecha> listaFechas = new ArrayList<>();
		try {
			conn = new OpenConnectionceufct().getConection();
			LocalDate fechaNow = LocalDate.now();
			Integer trimestre = 0;
			if (fechaNow.getMonthValue() >= 9 || fechaNow.getMonthValue() <= 11) {
				trimestre = 1;
			} else if (fechaNow.getMonthValue() >= 12 || fechaNow.getMonthValue() <= 2) {
				trimestre = 2;
			} else if (fechaNow.getMonthValue() >= 3 || fechaNow.getMonthValue() <= 6) {
				trimestre = 3;
			}
			listaFechas = csf.consultarFecha(conn, fechaNow.getYear(), trimestre);
			if (listaFechas != null) {
				throw new fechasException();
			}
		} catch (SQLException e) {
			System.out.println("Problema con las fechas" + e);
		}
		return listaFechas;
	}
}
