package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculasException;
import ejercicio01.services.PeliculasService;

public class ServicioPeliculasCsv {

	public void exportarPeliculasCsv(String nombreFichero) throws FicheroException {
		try {
			// 1. Llamar al servicio de peliculas para obtener la lista
			PeliculasService service = new PeliculasService();
			List<Pelicula> peliculas = service.consultarPeliculas();
		
			// 2. Crear el fichero y fileWriter
			File file = new File(nombreFichero);
			FileWriter writer = new FileWriter(file);
			
			// 3. Recorremos la lista y vamos escribiendo en cada l�nea un película
			for (Pelicula pelicula : peliculas) {
				writer.write(pelicula.getId() + "\t" + pelicula.getNombre() + "\t" + pelicula.getLongitud() + "\n");
			}
			
			// 4. Cerramos el fileWriter
			writer.close();
		
		} catch (PeliculasException | IOException e) {
			System.err.println("Error consultando o exportando pel�culas");
			throw new FicheroException("Error al generar CSV", e );
		}
		
		
	}
	

}
