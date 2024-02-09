package Ejercicio1;
import Service.FicheroException;

public class TestEjercicio1 {

	public static void main(String[] args) {
		CVSServices service = new CVSServices();
		try {
			// service.ConsultarCVSservice("C:\\Users\\llopezderueda0480\\OneDrive -
			// Fundación Universitaria San Pablo CEU\\Escritorio\\Cosas\\asignatura.csv");

			service.InsertarPelis(
					"C:\\Users\\llopezderueda0480\\OneDrive - Fundación Universitaria San Pablo CEU\\Escritorio\\Cosas\\Peliculas.csv");

		} catch (FicheroException e) {

			e.printStackTrace();
		}

	}

}
