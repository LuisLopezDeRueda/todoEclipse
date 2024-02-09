package fct.Controllers;

import fct.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnviarPreguntarController extends AppController {
	@FXML
	private TextField tf;

	@FXML
	public void enviar() {
		tf.setText("");
	}

}
