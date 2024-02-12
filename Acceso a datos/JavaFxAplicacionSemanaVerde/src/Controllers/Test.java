package Controllers;

import Modelo.Articulo;
import Modelo.Trabajador;
import Service.ArticuloException;
import Service.Service;
import Service.TrabajadorException;

public class Test {
	public static void main(String[] args) {
		Service service = new Service();

		Articulo articulo = new Articulo();
		articulo.setCodBarras("0002");
		articulo.setDescripcion("Agua");
		articulo.setPrecio(2.0);
		articulo.setCantidad(1);
		try {
			service.insertarArticulo(articulo);
		} catch (ArticuloException e) {
			
			e.printStackTrace();
		}

//		Trabajador trabajador = new Trabajador();
//		trabajador.setNombre("luis");
//		trabajador.setSuperUsuario(true);
//		trabajador.setContraseña("123");
//
//			service.actualizarTrabajador("234", "luis");
//			System.out.println(service.consultarTrabajador(trabajador.getNombre(), "234"));

	}
}
