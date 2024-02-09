package App;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Modelo.Cliente;
import Servicio.ClienteException;
import Servicio.ClienteService;


public class AppClientes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String,Cliente> mapaClientes = new HashMap<>();
		
		ClienteService clienteService = new ClienteService();
		try {
			mapaClientes = clienteService.consultarCliente();
		} catch (ClienteException e) {
			
			e.printStackTrace();
		}
		System.out.println("Diga el correo del cliente que quiera buscar");
		String correo = scanner.nextLine();
		System.out.println("Los datos del cliente del correo " + correo + " \n" + mapaClientes.get(correo));
		scanner.close();
	}

}
