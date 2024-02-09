package App;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelo.Pago;
import Service.PagoException;
import Service.PagoService;

public class PagosApp {

	public static void main(String[] args) {
		PagoService pagoService = new PagoService();
		Map<String, List<Pago>> mapaClientes = new HashMap<>();
		try {
			mapaClientes = pagoService.consultarPago();
			
			String correo = "MARILYN.ROSS@sakilacustomer.org";
			
			System.out.println("Las copras para el correo " + correo + "\n" + mapaClientes.get(correo));
			
			
			
		} catch (PagoException e) {
			System.err.println("Problema con el pago " + e.getMessage());
		}

	}
}
