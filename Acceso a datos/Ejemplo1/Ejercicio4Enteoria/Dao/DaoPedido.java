package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Pedido;

public class DaoPedido {

	public void insertarPedido(Connection conn, Pedido pedido) throws SQLException {
		PreparedStatement stmt = null;
		try {

			String sql = "INSERT INTO PEDIDOS VALUES(?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, pedido.getIdPedido());
			stmt.setDate(2, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(3, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(4, pedido.getCliente());

			stmt.execute();
		} finally {
			stmt.close();
		}
	}
}
