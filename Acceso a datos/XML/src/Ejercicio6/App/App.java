package Ejercicio6.App;

import Ejercicio6.Modelo.Pelicula;
import Ejercicio6.Service.Service;

public class App {
	public static void main(String[] args) {
		Service service = new Service();

		service.crearXml(Pelicula.createRandomList(10), "C:\\Users\\llopezderueda0480\\Pruebas/peliculas.xml");
	}
}
