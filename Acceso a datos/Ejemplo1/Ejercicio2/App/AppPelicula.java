package App;

import java.util.List;

import Modelo.Pelicula;
import Servicio.PeliculasException;
import Servicio.PeliculasService;

public class AppPelicula {

	public static void main(String[] args)   {

		PeliculasService peliculasService = new PeliculasService();
		List<Pelicula> listaPeliculas = null;
			
			try {
				listaPeliculas = peliculasService.consultarPeliculas(2);
			} catch (PeliculasException e) {
				
				e.printStackTrace();
			}
		
			for (Pelicula pelicula : listaPeliculas) {
				System.out.println(pelicula);
			}
		
	
	}

}
