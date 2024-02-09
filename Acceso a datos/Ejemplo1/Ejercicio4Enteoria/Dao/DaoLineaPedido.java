package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.LineaPedido;

public class DaoLineaPedido {

	public void insertarLineaPedido(Connection conn, LineaPedido pedido) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO PEDIDOS_LINEAS VALUES(?,?,?,?)";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, pedido.getIdPedido());
			stmt.setInt(2, pedido.getNumeroLinea());
			stmt.setString(3, pedido.getArticulo());
			stmt.setBigDecimal(4, pedido.getPrecio());

			stmt.execute();
		} finally {
			stmt.close();
		}

	}
}
