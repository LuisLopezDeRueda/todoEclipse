package RepasoFicheros.Service;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import RepasoFicheros.Modelo.Catalogo;
import RepasoFicheros.Repaso.Dom;
import RepasoFicheros.Repaso.Sax;

public class Ejercicio12Service {

	/**
	 * Recibe un cat�logo y una ruta a un fichero XML donde debe exportarse. El
	 * formato del XML tiene que ser el indicado en el enunciado del ejercicio Si
	 * hay cualquier error, el servicio tendr� que lanzar una CatalogoXMLException
	 * 
	 * @param catalogo
	 * @param pathFile
	 * @throws CatalogoXMLException
	 */
	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException {
		Dom dom = new Dom();
		dom.crearXml(catalogo, pathFile);
	}

	/**
	 * Recibe una ruta donde hay un fichero XML que debe leerse para obtener un
	 * objeto Catalogo. El formato del XML ser� el indicado en el enunciado del
	 * ejercicio Si hay cualquier error, el servicio tendr� que lanzar una
	 * CatalogoXMLException
	 * 
	 * @param catalogo
	 * @param pathFile
	 * @throws CatalogoXMLException
	 */
	public Catalogo importXML(String pathFile) throws CatalogoXMLException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		Sax sax = new Sax();
		try {
			SAXParser parse = factory.newSAXParser();

			File file = new File(pathFile);
			parse.parse(file, sax);

		} catch (Exception e) {
			e.printStackTrace();
			throw new CatalogoXMLException(e);
		}
		return sax.getCatalogo();
	}

}