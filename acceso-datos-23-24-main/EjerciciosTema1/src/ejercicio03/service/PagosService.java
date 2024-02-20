package ejercicio03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio02.dao.ClientesDao;
import ejercicio02.modelo.Cliente;
import ejercicio02.service.OpenConnection;
import ejercicio03.dao.PagosDao;
import ejercicio03.modelo.Pago;

public class PagosService {

	public Map<String, List<Pago>> consultarPagosClientes() throws PagosException{
		Connection conn = null;
		try {
			ClientesDao clientesDao = new ClientesDao();
			PagosDao pagosDao = new PagosDao();
			Map<String, List<Pago>> mapa = new HashMap<String, List<Pago>>();
			
			// 1. Abrir conexión
			conn = new OpenConnection().abrirConexion();
			// 2. Obtener lista de clientes de ClienteDao
			List<Cliente> clientes = clientesDao.consultarClientes(conn);
			// 3. Recorrer la lista de clientes anterior
			for (Cliente cliente : clientes) {
				// 4. Por cada cliente --> Llamar a PagosDao y obtener su lista de pagos
				List<Pago> pagos = pagosDao.consultarPagos(conn, cliente.getId());
				// 5. Meter en el mapa el email del cliente + su lista de pagos
				mapa.put(cliente.getEmail(), pagos);
			}
			return mapa;
		}
		catch(SQLException e) {
			System.err.println("Error al obtener pagos de clientes de bbdd");
			throw new PagosException("Error al obtener pagos de cliente", e);
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}
}
