package Servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.ClientesDao;
import Modelo.Cliente;

public class ClienteService {
	private OpenConnectionClinte nc;

	public ClienteService() {
		nc = new OpenConnectionClinte();
	}

	public Map<String, Cliente> consultarCliente() throws ClienteException {
		Connection conn = null;
		List<Cliente> listaClientes = new ArrayList<>();
		Map<String, Cliente> mapaClientes = new HashMap<>();
		try {

			conn = nc.getConection();
			ClientesDao dao = new ClientesDao();
			listaClientes = dao.consultarClientes(conn);

			for (int i = 0; i < listaClientes.size(); i++) {
				mapaClientes.put(listaClientes.get(i).getEmail(), listaClientes.get(i));
			}
			return mapaClientes;

		} catch (SQLException e) {
			throw new ClienteException("Error al consultar los clientes en la BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
