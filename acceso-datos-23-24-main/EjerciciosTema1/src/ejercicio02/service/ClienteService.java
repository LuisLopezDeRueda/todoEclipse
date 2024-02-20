package ejercicio02.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio01.services.OpenConnection;
import ejercicio02.dao.ClientesDao;
import ejercicio02.modelo.Cliente;

public class ClienteService {

	public Map<String, Cliente> consultarMapaClientes() throws ClientesException{
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			ClientesDao dao = new ClientesDao();
			List<Cliente> clientes = dao.consultarClientes(conn);
			
			Map<String, Cliente> mapa = new HashMap<String, Cliente>();
			for (Cliente cliente : clientes) {
				mapa.put(cliente.getEmail(), cliente);
			}
			return mapa;
			
		}
		catch(SQLException e) {
			System.err.println("Error al consultar cliente");
			throw new ClientesException("Error al consultar cliente en BBDD", e);
		}
		finally {
			try {
				conn.close();
			} catch(Exception ignore) {}
			
		}
	}

}
