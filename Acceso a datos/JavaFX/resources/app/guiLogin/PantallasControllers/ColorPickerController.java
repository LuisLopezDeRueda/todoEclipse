package app.guiLogin.PantallasControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class ColorPickerController {
	@FXML
	private ColorPicker color;
	@FXML
	private Button boton;
	@FXML
	private Label label;

	@FXML
	public void aplicar() {
		label.setTextFill(color.getValue());

	};
}
