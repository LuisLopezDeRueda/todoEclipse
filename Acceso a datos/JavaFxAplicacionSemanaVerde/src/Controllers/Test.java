package Controllers;

import Modelo.Articulo;
import Modelo.Trabajador;
import Service.Service;
import Service.TrabajadorException;

public class Test {
	public static void main(String[] args) {
		Service service = new Service();
		/*
		 * Articulo articulo = new Articulo(); articulo.setCodBarras("0001");
		 * articulo.setDescripcion("Leche"); articulo.setPrecio(1.5);
		 * articulo.setId(1L); service.insertarArticulo(articulo);
		 */
		Trabajador trabajador = new Trabajador();
		trabajador.setNombre("luis");
		trabajador.setSuperUsuario(true);
		trabajador.setContraseña("123");

			service.actualizarTrabajador("234", "luis");
			System.out.println(service.consultarTrabajador(trabajador.getNombre(), "234"));
	
	}
}