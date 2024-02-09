package fct.Controllers;

import javafx.fxml.FXML;
import javafx.scene.web.HTMLEditor;

public class WritingController {
	@FXML
	private HTMLEditor html;

	@FXML
	public void limpiar() {
		html.setHtmlText("");
	}
}
