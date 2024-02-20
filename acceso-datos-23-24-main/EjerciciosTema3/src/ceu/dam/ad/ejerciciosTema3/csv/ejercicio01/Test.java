package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;

public class Test {


	public static void main(String[] args) {
		ServicioPeliculasCsv service = new ServicioPeliculasCsv();
		try {
			service.exportarPeliculasCsv("c:/temporal/peliculas.csv");
		} catch (FicheroException e) {
			e.printStackTrace();
		}
	}

}
