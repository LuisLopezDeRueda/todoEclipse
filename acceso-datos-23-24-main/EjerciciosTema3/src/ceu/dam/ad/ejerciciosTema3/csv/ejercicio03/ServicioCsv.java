package ceu.dam.ad.ejerciciosTema3.csv.ejercicio03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ceu.dam.ad.ejerciciosTema3.csv.ejercicio01.FicheroException;

public class ServicioCsv {

	public void convertirCsv(String ficheroEntrada, String ficheroSalida) throws FicheroException {
		try {
			File fileIn = new File(ficheroEntrada);
			File fileOut = new File(ficheroSalida);
			Scanner scanner = new Scanner(fileIn);
			FileWriter writer = new FileWriter(fileOut);
			while (scanner.hasNext()) {
				String linea = scanner.nextLine();
				String[] columnas = linea.split(";");
				for (int i = 0; i < columnas.length; i++) {
					writer.write(columnas[i]);
					if (i != columnas.length-1) {
						writer.write(",");
					}
				}
				if (scanner.hasNext()) {
					writer.write("\n");
				}
			}
			scanner.close();
			writer.close();
			
		} catch (IOException e) {
			throw new FicheroException("Error leyendo/escribiendo ficheros",e);
		}
		
		
		
	}

}
