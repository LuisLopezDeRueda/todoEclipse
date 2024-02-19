package ejercicio04.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejercicio04.dao.PedidoDao;
import ejercicio04.dao.PedidoLineaDao;
import ejercicio04.modelo.Pedido;
import ejercicio04.modelo.PedidoLinea;

public class PedidosService {

	private OpenConnection connProvider;
	
	public PedidosService() {
		connProvider = new OpenConnection();
	}
	
	public void crearPedido(Pedido pedido) throws PedidoException {
		PedidoDao daoPedido = new PedidoDao();
		PedidoLineaDao daoLinea = new PedidoLineaDao();
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			conn.setAutoCommit(false);
			// 1. Insertar los datos de la tabla pedido (los datos principales)
			Long idPedidoGenerado = daoPedido.insertar(conn, pedido);
			// 2. Recorrer todas las líneas del pedido (pedido.getLineas()) ...for..
			List<PedidoLinea> lineas = pedido.getLineas();
			int numLinea = 1;
			for (PedidoLinea linea : lineas) {
				// 3. Para cada línea --> Insertar la línea en tabla pedidos_lineas
				linea.setIdPedido(idPedidoGenerado);
				linea.setNumLinea(numLinea);
				daoLinea.insertar(conn, linea);
				numLinea++;
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.err.println("Error al registrar pedido");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("No se ha podido hacer rollback");
			}
			throw new PedidoException("Error al registrar pedido", e);
		}
		finally {
			try {
				conn.close();
			}catch(Exception ignore) {}
		}
	}
	
}
