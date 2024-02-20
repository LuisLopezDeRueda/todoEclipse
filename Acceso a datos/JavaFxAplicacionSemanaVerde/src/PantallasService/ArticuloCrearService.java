package PantallasService;

import java.util.List;

import Controllers.AppController;
import Modelo.Articulo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ArticuloCrearService extends AppController {
	@FXML
	private TextField tfPrecio;
	@FXML
	private TextField tfNombre;

	@FXML
	public void crearArticulo() {
		try {
			service.insertarArticulo(
					new Articulo(tfNombre.getText(), Double.parseDouble(tfPrecio.getText()), codBarras()));
			alertInformativa("Articulo " + tfNombre.getText() + " creado correctamente");
			tfNombre.setText("");
			tfPrecio.setText("");
		} catch (

		NumberFormatException e) {
			alert("Datos indicados no validos");
		}
	}

	public String codBarras() {
		List<Articulo> lista = service.consultarArticulos();
		Articulo art = lista.get(lista.size() - 1);
		Integer numero = Integer.parseInt(art.getCodBarras()) + 1;
		return "000" + numero;
	}

	@FXML
	public void atras() {
		irUsuario();
	}
}
