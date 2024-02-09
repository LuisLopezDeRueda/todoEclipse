package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.ClientesDao;
import Dao.ClientesDao2;
import Modelo.Cliente;
import Modelo.Pago;
import Servicio.OpenConnectionClinte;

public class PagoService {
	private OpenConnectionClinte nc;

	public OpenConnectionClinte getNc() {
		return nc;
	}

	public void setNc(OpenConnectionClinte nc) {
		this.nc = nc;
	}

	public PagoService() {
		nc = new OpenConnectionClinte();
	}

	public Map<String, List<Pago>> consultarPago() throws PagoException {
		Connection conn = null;
		Map<String, List<Pago>> mapaClientes = new HashMap<>();
		ClientesDao2 clienteDao2 = new ClientesDao2();
		ClientesDao clienteDao = new ClientesDao();
		List<Cliente> listaCliente = new ArrayList<>();
		try {
			conn = nc.getConection();
			listaCliente = clienteDao.consultarClientes(conn);
			for (Integer i = 0; i < listaCliente.size(); i++) {
				mapaClientes.put(listaCliente.get(i).getEmail(),
						clienteDao2.consultarClientes(conn, listaCliente.get(i).getId()));
			}

			return mapaClientes;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new PagoException("Error al consultar las pelicuals en la BBDD", e);
		}
	}
}
