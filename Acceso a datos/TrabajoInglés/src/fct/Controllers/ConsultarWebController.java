package fct.Controllers;

import fct.AppController;
import fct.Modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ConsultarWebController extends AppController {

	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private WebView web;

	@FXML
	public void initialize() {
		comboBox.getItems().addAll("Writing", "Listening", "Speaking", "Reading");
	}

	@FXML
	public void ver() {
		Usuario usuario = getUsuario();
		WebEngine webEngine = web.getEngine();
		webEngine.load("https://learnenglish.britishcouncil.org/skills/listening/" + usuario.getNivel() + "-"
				+ comboBox.getValue().toLowerCase());
	}
}
