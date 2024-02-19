package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.modelo.Articulo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.services.CatalogoXMLException;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.services.Ejercicio12Service;

public class Test { // JACKSON

	public static void main(String[] args) {
		// cambia esta ruta para que coincida con una carpeta de tu disco
		String ruta = "c:/temporal/catalogo.xml";
		
		try {
			Catalogo catalogo = Catalogo.createRandomObject(10);
			Ejercicio12Service service = new Ejercicio12Service();
			service.exportXML(catalogo, ruta);
			
			// Comprueba que el XML generado es correcto e igual al que se solicita
			
			catalogo = service.importXML(ruta);
			System.out.println("Catálogo leído con tamaño: " + catalogo.getTamaño());
			System.out.println("Cantidad de artículos (DEBE SER IGUAL AL TAMAÑO): " + catalogo.getArticulos().size());
			for (Articulo articulo : catalogo.getArticulos()) {
				System.out.println("\t" + articulo);
			}
			
			// Comprueba que lo impreso es igual al contenido del XML
			
			
		} catch (CatalogoXMLException e) {
			System.err.println("Error al intentar leer o escribir XML");
			e.printStackTrace();
		}
	}

}
