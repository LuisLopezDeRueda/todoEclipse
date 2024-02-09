package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Dao.DaoLineaPedido;
import Dao.DaoPedido;
import Modelo.Pedido;

public class PedidosService {
	private OpenConnectionPedidos nc;

	public OpenConnectionPedidos getNc() {
		return nc;
	}

	public void setNc(OpenConnectionPedidos nc) {
		this.nc = nc;
	}

	public PedidosService() {
		nc = new OpenConnectionPedidos();
	}

	public void registrarPedido(Pedido pedido) {
		Connection conn = null;
		DaoPedido daoPedido = new DaoPedido();
		DaoLineaPedido daoLineaPedido = new DaoLineaPedido();

		try {

			conn = nc.getConection();
			conn.setAutoCommit(false);
			daoPedido.insertarPedido(conn, pedido);

			for (Integer i = 0; i < pedido.getListaPedidos().size(); i++) {

				daoLineaPedido.insertarLineaPedido(conn, pedido.getListaPedidos().get(i));

			}
			System.out.println("Articulos añadidos");
			conn.commit(); 
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {

				System.out.println("Error con el rollback");
			}
			e.printStackTrace();
		}

	}

}
