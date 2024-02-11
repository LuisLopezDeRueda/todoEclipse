package PantallasService;

import Controllers.AppController;
import Modelo.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CrearClienteService extends AppController {
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField dni;

	@FXML
	public void crearCliente() {
		if (service.consultarCliente(dni.getText()) == null) {
			service.insertarCliente(new Cliente(dni.getText(), tfNombre.getText()));
			aletInformativa("El cliente con el dni " + dni.getText() + " ha sido añadido correctamente");
			atras();
		} else {
			alet("Cliente existente con ese dni");
		}
	}

	@FXML
	public void atras() {
		irUsuario();
	}
}