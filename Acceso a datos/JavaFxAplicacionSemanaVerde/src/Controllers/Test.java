package Controllers;

import java.util.List;

import Modelo.Articulo;
import Service.Service;

public class Test {
	public static void main(String[] args) {
		Service service = new Service();

//		Articulo articulo = new Articulo();
//		articulo.setCodBarras("0002");
//		articulo.setDescripcion("Agua");
//		articulo.setPrecio(2.0);
//		articulo.setCantidad(1);
//		try {
//			service.insertarArticulo(articulo);
//		} catch (ArticuloException e) {
//			
//			e.printStackTrace();
//		}

//		Trabajador trabajador = new Trabajador();
//		trabajador.setNombre("luis");
//		trabajador.setSuperUsuario(true);
//		trabajador.setContraseña("123");
//
//			service.actualizarTrabajador("234", "luis");
//			System.out.println(service.consultarTrabajador(trabajador.getNombre(), "234"));

		List<Articulo> lista = service.consultarArticulos();
		
		
		
	}
}
