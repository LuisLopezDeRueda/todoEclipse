package ejercicio04.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import ejercicio04.modelo.Pedido;
import ejercicio04.modelo.PedidoLinea;
import ejercicio04.service.PedidoException;
import ejercicio04.service.PedidosService;

public class Test {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2023, 12, 1));
		pedido.setCliente("Laura Salmerón");
		
		for (int j = 1; j <= 3; j++) {
			PedidoLinea linea = new PedidoLinea();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getLineas().add(linea);
		}
		
		PedidosService service = new PedidosService();
		try {
			service.crearPedido(pedido);
		} catch (PedidoException e) {
			e.printStackTrace();
		}
		
		
	}

}
