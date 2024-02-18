package RepasoFicheros.Repaso;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import RepasoFicheros.Modelo.Articulo;
import RepasoFicheros.Modelo.Catalogo;
import RepasoFicheros.Modelo.Categoria;
import RepasoFicheros.Modelo.Modelo;

public class Dom {

	public void crearXml(Catalogo catalogo, String ruta) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document xml = builder.newDocument();

			Element root = xml.createElement("catálogo");
			xml.appendChild(root);
			root.setAttribute("tamaño", catalogo.getTamaño().toString());
			Element articulosTag = xml.createElement("articulos");
			root.appendChild(articulosTag);
			for (Articulo articulo : catalogo.getArticulos()) {
				Element articuloTag = xml.createElement("articulo");
				articulosTag.appendChild(articulosTag);
				Element descripcionTag = xml.createElement("descripcion");
				descripcionTag.setTextContent(articulo.getDescripcion());
				articuloTag.appendChild(descripcionTag);
				Element identificadorTag = xml.createElement("identificador");
				identificadorTag.setTextContent(articulo.getSku());
				articuloTag.appendChild(identificadorTag);
				Element pvpTag = xml.createElement("precio");
				pvpTag.setTextContent(articulo.getPvp().getPrecio().toString());
				articuloTag.appendChild(pvpTag);
				Element modelosDisponiblesTag = xml.createElement("modelosDisponibles");
				articuloTag.appendChild(modelosDisponiblesTag);
				for (Modelo modelo : articulo.getModelos()) {
					Element modeloTag = xml.createElement("modelo");
					modelosDisponiblesTag.appendChild(modeloTag);
					Element tallaTag = xml.createElement("talla");
					tallaTag.setTextContent(modelo.getTalla());
					modeloTag.appendChild(tallaTag);
					Element colorTag = xml.createElement("color");
					colorTag.setTextContent(modelo.getColor());
					modeloTag.appendChild(colorTag);
					Element codigosBarraTag = xml.createElement("codigosBarra");
					modeloTag.appendChild(codigosBarraTag);
					for (String codBarra : modelo.getCodigosBarra()) {
						Element codigoTag = xml.createElement("codigo");
						codigoTag.setTextContent(codBarra);
						modeloTag.appendChild(codigoTag);
					}
				}
				Element categoriasTag = xml.createElement("categorias");
				articuloTag.appendChild(articulosTag);
				for (Categoria categoria : articulo.getCategorias()) {
					Element categoriaTag = xml.createElement("categoria");
					categoriaTag.setTextContent(categoria.getNombre());
					categoriasTag.appendChild(categoriaTag);
				}

			}
			TransformerFactory tranformerFactory = TransformerFactory.newInstance();

			Transformer transformer = tranformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(new File(ruta));

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Catalogo leerXml(String ruta) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		Catalogo catalogo = new Catalogo();
		DocumentBuilder builder;
		try {
			builder = fabrica.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));
			Element root = xml.getDocumentElement();
			catalogo.setTamaño(Integer.parseInt(root.getAttribute("tamaño")));

			Element articulosTag = (Element) root.getElementsByTagName("articulos").item(0);
			NodeList listaArticulos = articulosTag.getElementsByTagName("articulo");
			for (int i = 0; i < listaArticulos.getLength(); i++) {
				Articulo articulo = new Articulo();
				Element articuloTag = (Element) listaArticulos.item(i);
				Element descripcionTag = (Element) articuloTag.getElementsByTagName("descripcion").item(0);
				articulo.setDescripcion(descripcionTag.getTextContent());
				Element identificadorTag = (Element) articuloTag.getElementsByTagName("identificador").item(0);
				articulo.setSku(identificadorTag.getTextContent());
				Element precioTag = (Element) articuloTag.getElementsByTagName("precio").item(0);
				BigDecimal precio = new BigDecimal(precioTag.getTextContent());
				precio = precio.setScale(2, RoundingMode.DOWN);
				articulo.getPvp().setPrecio(precio);

				Element modelosDisponiblesTag = (Element) articuloTag.getElementsByTagName("modelosDisponibles")
						.item(0);
				NodeList listaModelo = modelosDisponiblesTag.getElementsByTagName("modelo");
				for (int j = 0; j < listaModelo.getLength(); j++) {
					Modelo modelo = new Modelo();
					Element modeloTag = (Element) listaModelo.item(j);
					Element tallaTag = (Element) modeloTag.getElementsByTagName("talla").item(0);
					modelo.setTalla(tallaTag.getTextContent());
					Element colorTag = (Element) modeloTag.getElementsByTagName("color").item(0);
					modelo.setColor(colorTag.getTextContent());
					Element codigosBarraTag = (Element) modeloTag.getElementsByTagName("codigosBarra").item(0);
					NodeList listaCodigos = codigosBarraTag.getElementsByTagName("codigo");
					for (int h = 0; h < listaCodigos.getLength(); h++) {
						Element codigo = (Element) listaCodigos.item(h);
						modelo.getCodigosBarra().add(codigo.getTextContent());
					}
					articulo.getModelos().add(modelo);
				}

				Element categoriasTag = (Element) articuloTag.getElementsByTagName("categorias").item(0);
				NodeList listaCategoria = categoriasTag.getElementsByTagName("categoria");
				for (int j = 0; j < listaCategoria.getLength(); j++) {
					Categoria cat = new Categoria();
					cat.setNombre(listaCategoria.item(j).getTextContent());
					articulo.getCategorias().add(cat);
				}

				catalogo.getArticulos().add(articulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catalogo;
	}
}
