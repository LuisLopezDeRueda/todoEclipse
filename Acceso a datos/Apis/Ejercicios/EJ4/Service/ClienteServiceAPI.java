package EJ4.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Modelo.Cliente;
import Servicio.ClienteException;
import Servicio.ClienteService;

@RestController
public class ClienteServiceAPI {
	@GetMapping("/Cliente")
	public Cliente cliente(@RequestParam String gmail) throws ClienteExceptionAPI {
		ClienteService clienteService = new ClienteService();
		Map<String, Cliente> mapaClientes = new HashMap<>();
		
		try {
			mapaClientes = clienteService.consultarCliente();
		} catch (ClienteException e) {
	
		}
		if(mapaClientes.get(gmail) == null) {
			throw new ClienteExceptionAPI("No hay cliente con ese correo");
		}
		return mapaClientes.get(gmail);

	}
}
