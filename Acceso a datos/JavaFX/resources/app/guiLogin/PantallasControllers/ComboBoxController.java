package app.guiLogin.PantallasControllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ComboBoxController {
	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private TextField lblResultado;

	@FXML
	public void initialize() {
		comboBox.getItems().addAll("Luis", "Carlos", "Ale");
	}

	@FXML
	public void limpiar() {
		lblResultado.setText("");
		comboBox.setValue("");
	}

	@FXML
	public void mostrar() {
		lblResultado.setText(comboBox.getValue());
	}

}
