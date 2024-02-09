package Ejercicio7.App;

import java.util.ArrayList;
import java.util.List;

import Ejercicio6.Modelo.Pelicula;
import Ejercicio7.Service.PeliculasException;
import Ejercicio7.Service.Service;

public class App {

	public static void main(String[] args) {
		Service service = new Service();
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		try {
			listaPelicula = service.leerXML("C:\\Users\\llopezderueda0480\\Pruebas/peliculas.xml");
		} catch (PeliculasException e) {

			e.printStackTrace();
		}
		for (Pelicula pelicula : listaPelicula) {
			System.out.println(pelicula);
		}

	}

}
