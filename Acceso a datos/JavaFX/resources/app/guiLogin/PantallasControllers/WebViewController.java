package app.guiLogin.PantallasControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewController {
	@FXML
	private Button boton;
	@FXML
	private TextField textField;
	@FXML
	private WebView web;
	
	
	
	@FXML
	public void ver() {
		WebEngine webEngine = web.getEngine();
		webEngine.load(textField.getText());
	}

}
