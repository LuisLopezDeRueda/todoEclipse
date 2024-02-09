package Ejercicio2.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import EJ5.Modelo.Ciudad;
import EJ5.Service.NotFoundException;
import EJ5.Service.ServerErrorException;
import EJ5.Service.Service;
import Service.FicheroException;

public class Csv {
	public List<Ciudad> escribirCiudad(String ruta) throws FicheroException {
		Service servicio = new Service();
		List<Ciudad> listaciudad = null;
		try {
			listaciudad = servicio.getCities("");
		} catch (NotFoundException | ServerErrorException e) {

			e.printStackTrace();
		}
		File fichero = new File(ruta);
		FileWriter escribidor = null;
		try {
			escribidor = new FileWriter(fichero);
			for (Ciudad peli : listaciudad) {

				escribidor.write(peli.getDescripcion() + "\n");

			}
			return listaciudad;
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo csv.", e);
		} finally {
			try {
				escribidor.close();
			} catch (Exception ignore) {

			}

		}
	}
}
