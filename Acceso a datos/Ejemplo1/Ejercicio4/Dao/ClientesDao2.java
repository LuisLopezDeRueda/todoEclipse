package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Modelo.Pago;

public class ClientesDao2 {

	public List<Pago> consultarClientes(Connection conn, Integer idCliente) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		List<Pago> listaPago = new ArrayList<>();

		stmt = conn.createStatement();
		String sql = "SELECT AMOUNT ,payment_date FROM PAYMENT WHERE CUSTOMER_ID = " + idCliente;
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Pago pago = new Pago();
			LocalDate fecha = rs.getDate("payment_date").toLocalDate();
			pago.setFechaPago(fecha);
			pago.setCantidad(rs.getBigDecimal("amount"));
			listaPago.add(pago);
		}
		return listaPago;

	}

}
