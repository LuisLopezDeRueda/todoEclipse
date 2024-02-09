package fct.Controllers;

import fct.AppController;
import fct.Modelo.Usuario;
import fct.Service.UsuarioException;
import fct.Service.UsuarioService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegistroController extends AppController {
	@FXML
	private TextField nombre;
	@FXML
	private TextField apellidos;
	@FXML
	private ComboBox<String> nivel;
	@FXML
	private Slider edad;
	@FXML
	private PasswordField tfPassword;

	@FXML
	public void initialize() {
		nivel.getItems().addAll("A1", "A2", "B1", "B2", "C1", "C2");
	}

	@FXML
	public void botonRegistrar() {
		UsuarioService service = new UsuarioService();
		Alert information = new Alert(AlertType.INFORMATION);
		Usuario usuario = new Usuario();

		usuario.setNombre(nombre.getText());
		usuario.setApellidos(apellidos.getText());
		String valor = nivel.getValue();
		if (valor.isEmpty() || valor.isBlank()) {
			information.setHeaderText(null);
			information.setContentText("Debe de elegir un nivel");
			information.setTitle("Infomación");
		}
		usuario.setNivel(valor);
		Integer valorEdad = (int) edad.getValue();
		if (valorEdad == 0) {
			information.setHeaderText(null);
			information.setContentText("La edad tiene que ser mayor a un año");
			information.setTitle("Infomación");
		}
		usuario.setEdad(valorEdad);
		usuario.setNombre(tfPassword.getText());
		try {
			service.registrarUsuario(usuario);
			botonCancelar();
		} catch (UsuarioException e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setContentText("Error registrando el usuario");
			alerta.setTitle("Error");
		}

	}

	public void botonCancelar() {
		cambiarVista(INICIARSESION);
	}

}
