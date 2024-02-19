package ejercicio04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio04.modelo.PedidoLinea;

public class PedidoLineaDao {

	public void insertar(Connection conn, PedidoLinea linea) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into pedidos_lineas (id_pedido, numero_linea, articulo, precio) values (?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, linea.getIdPedido());
			stmt.setInt(2, linea.getNumLinea());
			stmt.setString(3, linea.getArticulo());
			stmt.setBigDecimal(4, linea.getPrecio());
			stmt.execute();
		}
		finally {
			try {
				stmt.close();
			}catch(Exception ignore) {}
		}
	}

}
