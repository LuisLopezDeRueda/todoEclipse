package ejercicio03.test;

import java.util.List;
import java.util.Map;

import ejercicio02.modelo.Cliente;
import ejercicio02.service.ClientesException;
import ejercicio03.modelo.Pago;
import ejercicio03.service.PagosException;
import ejercicio03.service.PagosService;

public class App {

	public static void main(String[] args) {
		PagosService service = new PagosService();
		try {
			Map<String, List<Pago>> clientesPagos = service.consultarPagosClientes();
			List<Pago> pagos = clientesPagos.get("MARILYN.ROSS@sakilacustomer.org");
			for (Pago pago : pagos) {
				System.out.println(pago);
			}
		
		} catch (PagosException e) {
			e.printStackTrace();
		}
	}

}
