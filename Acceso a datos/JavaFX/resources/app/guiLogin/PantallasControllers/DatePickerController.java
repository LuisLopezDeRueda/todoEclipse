package app.guiLogin.PantallasControllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

public class DatePickerController {
	@FXML
	private DatePicker date;
	@FXML
	private TextField textField;
	@FXML
	private Button boton;
	private DateTimeFormatter formato;

	@FXML
	public void initialize() {
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		date.setConverter(new LocalDateStringConverter(formato, formato));

		date.setValue(LocalDate.now());
	}

	@FXML
	public void leer() {

		textField.setText(date.getValue().format(formato));
	}

}
