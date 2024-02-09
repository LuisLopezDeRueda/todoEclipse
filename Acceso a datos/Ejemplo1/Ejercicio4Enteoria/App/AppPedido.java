package App;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modelo.LineaPedido;
import Modelo.Pedido;
import Service.PedidosService;

public class AppPedido {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		pedirPedido(scanner);

	}

	public static void pedirPedido(Scanner sc) {

		Pedido pedido = new Pedido();

		pedido.setIdPedido(1);
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.now());
		pedido.setCliente("Luis");
		List<LineaPedido> listaLineaPedido = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedido();
		lineaPedido.setIdPedido(1);
		lineaPedido.setNumeroLinea(1);
		lineaPedido.setArticulo("Leche");
		lineaPedido.setPrecio(new BigDecimal(2));
		LineaPedido lineaPedido2 = new LineaPedido();
		lineaPedido2.setIdPedido(1);
		lineaPedido2.setNumeroLinea(2);
		lineaPedido2.setArticulo("Agua");
		lineaPedido2.setPrecio(new BigDecimal(1));

		listaLineaPedido.add(lineaPedido);
		listaLineaPedido.add(lineaPedido2);

		PedidosService pedidoService = new PedidosService();
		pedido.setListaPedidos(listaLineaPedido);
		pedidoService.registrarPedido(pedido);

	}

}
