package app.guiLogin.Bienvenida;

import java.util.Optional;

import app.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BienvenidaController extends AppController {
	@FXML
	private Label lblBienvenida;
	@FXML
	private BorderPane panel;

	@FXML
	void cerrarSesion(ActionEvent event) {
		panel.setCenter(cargarVista(INICIO));
	}

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

	public void setNombreBienvenida(String nombre) {
		lblBienvenida.setText("Bienvenido " + nombre);
	}

	@FXML
	void irInicio(ActionEvent event) {
		panel.setCenter(cargarVista(INICIO));
	}

	@FXML
	void irBienvenida(ActionEvent event) {
		panel.setCenter(cargarVista(BIENVENIDA));
	}

	@FXML
	void irComboBox(ActionEvent event) {
		panel.setCenter(cargarVista(COMBOBOX));
	}

	@FXML
	void irColopicker(ActionEvent event) {
		panel.setCenter(cargarVista(COLORPICKER));
	}

	@FXML
	void irSlider(ActionEvent event) {
		panel.setCenter(cargarVista(SLIDER));
	}
	@FXML
	void irDatePicker(ActionEvent event) {
		panel.setCenter(cargarVista(DATEPICKER));
	}
	@FXML
	void irWebWiew(ActionEvent event) {
		panel.setCenter(cargarVista(WEBVIEW));
	}
	@FXML
	void irHTMLEditor(ActionEvent event) {
		panel.setCenter(cargarVista(HTMLEDITOR));
	}

}
