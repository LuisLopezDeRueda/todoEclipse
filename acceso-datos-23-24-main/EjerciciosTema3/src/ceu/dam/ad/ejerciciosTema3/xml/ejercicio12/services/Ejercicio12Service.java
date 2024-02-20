package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;

public class Ejercicio12Service {

	/** Recibe un cat�logo y una ruta a un fichero XML donde debe exportarse. 
	 * El formato del XML tiene que ser el indicado en el enunciado del ejercicio
	 * Si hay cualquier error, el servicio tendr� que lanzar una CatalogoXMLException 
	 * @param catalogo
	 * @param pathFile
	 * @throws CatalogoXMLException
	 */
	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException{
		
	}
	
	
	/** Recibe una ruta donde hay un fichero XML que debe leerse para obtener un objeto Catalogo. 
	 * El formato del XML ser� el indicado en el enunciado del ejercicio
	 * Si hay cualquier error, el servicio tendr� que lanzar una CatalogoXMLException 
	 * @param catalogo
	 * @param pathFile
	 * @throws CatalogoXMLException
	 */
	public Catalogo importXML(String pathFile) throws CatalogoXMLException{
		return null;
	}

	
	
}
