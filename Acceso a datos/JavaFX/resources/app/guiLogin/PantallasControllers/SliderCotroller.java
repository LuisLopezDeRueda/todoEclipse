package app.guiLogin.PantallasControllers;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SliderCotroller {
	@FXML
	private Slider slider;
	@FXML
	private Button boton;
	@FXML
	private TextField textField;

	@FXML
	private void aplicar() {
		DecimalFormat format = new DecimalFormat("#.##");
		textField.setText(String.valueOf(format.format(slider.getValue())));
	}

}
