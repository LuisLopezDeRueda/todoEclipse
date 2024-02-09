package Ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Pelicula;
import Service.FicheroException;
import Servicio.PeliculasException;
import Servicio.PeliculasService;

public class CVSServices {

	public void InsertarPelis(String ruta) throws FicheroException {

		PeliculasService service = new PeliculasService();
		List<Pelicula> lista = new ArrayList<>();
		try {
			lista = service.consultarPeliculas(100);
		} catch (PeliculasException e) {

			e.printStackTrace();
		}
		File file = new File(ruta);
		FileWriter filewritter = null;
		try {
			filewritter = new FileWriter(file);// Si no quires q se sobre escriba se pone ,true

			for (Pelicula pelicula : lista) {
				filewritter.write(pelicula.getId() + "\t");
				filewritter.write(pelicula.getTitulo() + "\t");
				filewritter.write(pelicula.getLongitud() + "\n");
			}
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV", e);
		} finally {
			try {
				filewritter.close();
			} catch (Exception ignore) {
			}
		}
	}

}
