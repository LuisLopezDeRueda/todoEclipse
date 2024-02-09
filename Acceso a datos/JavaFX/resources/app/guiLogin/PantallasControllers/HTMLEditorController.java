package app.guiLogin.PantallasControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;

public class HTMLEditorController {
	@FXML
	private HTMLEditor html;
	@FXML
	private Button boton;
	@FXML
	private Label label;

	@FXML
	public void imprimir() {
		label.setText(html.getHtmlText());
	}
}
