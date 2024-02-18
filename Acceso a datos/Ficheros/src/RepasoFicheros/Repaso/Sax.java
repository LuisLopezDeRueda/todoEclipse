package RepasoFicheros.Repaso;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import RepasoFicheros.Modelo.Articulo;
import RepasoFicheros.Modelo.Catalogo;
import RepasoFicheros.Modelo.Categoria;
import RepasoFicheros.Modelo.Modelo;
import RepasoFicheros.Modelo.Pvp;

public class Sax extends DefaultHandler {
	private Catalogo catalogo;
	private Articulo articulo;
	private Modelo modelo;
	private Categoria categoria;
	private Boolean openTag;
	private String texto;
	private Pvp pvp;

	public Sax() {
		openTag = false;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		if (qName.equals("catálogo")) {
			catalogo = new Catalogo();
			catalogo.setTamaño(Integer.parseInt(attributes.getValue("tamaño")));
		} else if (qName.equals("articulos")) {
			catalogo.setArticulos(new ArrayList<>());
		} else if (qName.equals("articulo")) {
			articulo = new Articulo();
			articulo.setPvp(new Pvp());
			catalogo.getArticulos().add(articulo);
		} else if (qName.equals("modelosDisponibles")) {
			articulo.setModelos(new ArrayList<Modelo>());
		} else if (qName.equals("modelo")) {
			modelo = new Modelo();
			articulo.getModelos().add(modelo);
		} else if (qName.equals("categorias")) {
			articulo.setCategorias(new ArrayList<Categoria>());
		} else if (qName.equals("categoria")) {
			categoria = new Categoria();
			articulo.getCategorias().add(categoria);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("descripcion")) {
			articulo.setDescripcion(texto);
		} else if (qName.equals("identificador")) {
			articulo.setSku(texto);
		} else if (qName.equals("precio")) {
			BigDecimal decima = new BigDecimal(texto);
			pvp.setPrecio(decima.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		} else if (qName.equals("talla")) {
			modelo.setTalla(texto);
		} else if (qName.equals("color")) {
			modelo.setColor(texto);
		} else if (qName.equals("codigo")) {
			modelo.getCodigosBarra().add(texto);
		} else if (qName.equals("categoria")) {
			categoria.setNombre(texto);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}
}
