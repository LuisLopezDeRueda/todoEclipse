package ejercicio03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio03.modelo.Pago;

public class PagosDao {

	public List<Pago> consultarPagos(Connection conn, Integer idCliente) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pago> resultado = new ArrayList<Pago>();
			stmt = conn.createStatement();
			String sql = "select * from payment where customer_id = " + idCliente;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pago pago = new Pago();
				pago.setFecha(rs.getDate("payment_date").toLocalDate());
				pago.setImporte(rs.getBigDecimal("amount"));
				resultado.add(pago);
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
