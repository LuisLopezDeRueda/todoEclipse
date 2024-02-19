package ejercicio01.test;

import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculasException;
import ejercicio01.services.PeliculasService;

public class Test {
	
	public static void main(String[] args) {
		PeliculasService service = new PeliculasService();
		try {
			List<Pelicula> peliculas = service.consultarPeliculas();
			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula);
			}
		} catch (PeliculasException e) {
			e.printStackTrace();
		}
	}

}
