package Ejercicio4.App;

import Ejercicio4.Modelo.Libro;
import Ejercicio4.Service.Service;

public class App {
	public static void main(String[] args) {
		Service service = new Service();

		service.crearXml(Libro.createRandomList(10), "C:\\Users\\llopezderueda0480\\Pruebas/libros.xml");
	}
}
