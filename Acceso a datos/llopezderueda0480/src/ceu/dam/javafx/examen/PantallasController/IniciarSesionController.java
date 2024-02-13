package ceu.dam.javafx.examen.PantallasController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ceu.dam.javafx.examen.AppController;
import ceu.dam.javafx.examen.services.LoginIncorrectoException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

public class IniciarSesionController extends AppController {

	@FXML
	private TextField tfNombre;

	@FXML
	private PasswordField psContrseña;
	@FXML
	private DatePicker datePicker;
	@FXML
	private CheckBox chkBox;
	@FXML
	private Button btAceptar;
	private DateTimeFormatter formato;

	@FXML
	public void initialize() {
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		datePicker.setConverter(new LocalDateStringConverter(formato, formato));
		datePicker.setValue(LocalDate.now());
		setDate(datePicker.getValue());
	}

	@FXML
	public void entrar() {
		try {
			String usuario = tfNombre.getText();
			String pass = psContrseña.getText();
			if (usuario == null) {
				alert("Es obligatorio indicar un usuario");
				return;
			}
			service.login(usuario, pass);
			setUsuario(usuario);
			irConsultar();
		} catch (LoginIncorrectoException e) {
			alert(e.getMessage());
		}
	}

	@FXML
	public void activarBoton() {
		if (chkBox.isSelected()) {
			btAceptar.setDisable(false);
		} else {
			btAceptar.setDisable(true);
		}
	}

	@FXML
	public void elegirFecha() {
		setDate(datePicker.getValue());
	}

}
