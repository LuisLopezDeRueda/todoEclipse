package ceu.dam.ad.ejerciciosTema3.csv.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.modelo.City;
import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.services.CityServiceImpl;
import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.services.ServerErrorException;
import ceu.dam.ad.ejerciciosTema3.csv.ejercicio01.FicheroException;

public class ServicioCiudadesCsv {

	public void importarCiudadesCsv(String nombreFichero) throws FicheroException {
		try {
			File file = new File(nombreFichero);
			Scanner scanner = new Scanner(file);
			CityServiceImpl service = new CityServiceImpl();
			
			while(scanner.hasNext()) {
				City ciudad = new City();
				try {
					String linea = scanner.nextLine();
					String[] lineaTroceada = linea.split("\t");
					ciudad.setDescripcion(lineaTroceada[0]);
					ciudad.setCountryId(Long.parseLong(lineaTroceada[1]));
					service.createCity(ciudad);
				}
				catch(ServerErrorException e) {
					System.err.println("Error creando la ciudad " + ciudad.getDescripcion() + ". Se continuará con el resto de ciudades");
				}
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			throw new FicheroException("Error leyendo fichero de ciudades", e);
		}
		
	}

}
