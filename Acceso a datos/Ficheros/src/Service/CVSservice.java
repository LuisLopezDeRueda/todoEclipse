package Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Ficheros.Asignatura;

public class CVSservice {

	public void ConsultarCVSservice(String ruta) throws FicheroException {
		AsignaturaService service = new AsignaturaService();
		List<Asignatura> lista = service.consultarAsgiantura();
		File file = new File(ruta);
		FileWriter filewritter = null;
		try {
			filewritter = new FileWriter(file);// Si no quires q se sobre escriba se pone ,true

			for (Asignatura asignatura : lista) {
				/*
				 * filewritter.write(asignatura.getId() + ";");
				 * filewritter.write(asignatura.getNombre() + ";");
				 * filewritter.write(asignatura.getCiclo() + "\n");
				 */
				filewritter.write(asignatura.toCSV());
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

	public List<Asignatura> LeerCSV(String ruta) throws FicheroException {
		AsignaturaService service = new AsignaturaService();
		List<Asignatura> lista = service.consultarAsgiantura();
		File file = new File(ruta);
		Scanner scanner = null;
		String linea = null;

		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				Asignatura a = new Asignatura();
				linea = scanner.nextLine();
				String[] campos = linea.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				lista.add(a);
			}
			return lista;
		} catch (FileNotFoundException e) {
			throw new FicheroException("No existe el fichero", e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
