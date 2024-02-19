package ejemplo.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejemplo.modelo.Asignatura;
import ejemplo.service.AsignaturaServices;

public class CsvSampleService {

	public void escribirCsvAsignaturas(String rutaDestino) throws FicheroException {
		AsignaturaServices services = new AsignaturaServices();
		List<Asignatura> asignaturas = services.consultarAsignaturas();
		File file = new File(rutaDestino);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			for (Asignatura asignatura : asignaturas) {
//				writer.write(asignatura.getId() + ";");
//				writer.write(asignatura.getNombre() + ";");
//				writer.write(asignatura.getCiclo() + "\n");
				writer.write(asignatura.toCsv() + "\n");
			}
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV", e);
		} finally {
			try {
				writer.close();
			}catch(Exception ignore) {}
		}
		
		
	}
	
	
	public List<Asignatura> leerCsvAsignaturas(String rutaOrigen) throws FicheroException{
		File file = new File(rutaOrigen);
		Scanner sc = null;
		try {
			List<Asignatura> asignaturas = new ArrayList<Asignatura>();
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				Asignatura a = new Asignatura();
				String[] campos = line.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				asignaturas.add(a);
			}
			return asignaturas;
		} catch (FileNotFoundException e) {
			throw new FicheroException("No existe el fichero en la ruta indicada", e);
		}
		finally{
			if (sc != null) {
				sc.close();
			}
		}
		
		
		
		
	}
	
}




