package fct.Controllers;

import java.util.Optional;

import fct.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class BienvenidoController extends AppController {
	@FXML
	private Label lblBienvenida;
	@FXML
	private BorderPane panel;

	@FXML
	void salir(ActionEvent event) {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText(null);
		a.setContentText("¿Seguro que quieres cerrar la aplicación?");
		a.setTitle("Confirmación");
		Optional<ButtonType> result = a.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}
	}

	@FXML
	public void initialize() {
		lblBienvenida.setText("Bienvenido " + usuario.getNombre() + " " + usuario.getApellidos());
	}

	@FXML
	void irCerrarSesion(ActionEvent event) {
		panel.setCenter(cargarVista(INICIARSESION));
	}

	@FXML
	void irBienvenida(ActionEvent event) {
		panel.setCenter(cargarVista(BIENVENIDA));
	}

	@FXML
	void irConsultarWeb(ActionEvent event) {
		panel.setCenter(cargarVista(CONSULTAWEB));
	}

	@FXML
	void irPreguntas(ActionEvent event) {
		panel.setCenter(cargarVista(PREGUNTAS));
	}

	@FXML
	void irWriting(ActionEvent event) {
		panel.setCenter(cargarVista(WRITING));
	}

}
