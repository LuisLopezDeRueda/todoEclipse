package ejercicio02.test;

import java.util.Map;

import ejercicio02.modelo.Cliente;
import ejercicio02.service.ClienteService;
import ejercicio02.service.ClientesException;

public class Test {

	public static void main(String[] args) {
		ClienteService service = new ClienteService();
		try {
			Map<String, Cliente> clientes = service.consultarMapaClientes();
			Cliente cliente = clientes.get("MARILYN.ROSS@sakilacustomer.org");
			System.out.println(cliente);
		
		
		} catch (ClientesException e) {
			e.printStackTrace();
		}
	}

}
