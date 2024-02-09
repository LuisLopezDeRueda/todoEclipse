package fct.Controllers;

import java.sql.SQLException;

import fct.AppController;
import fct.Service.UsuarioException;
import fct.Service.UsuarioService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IniciarSesionController extends AppController {

	private UsuarioService service;
	@FXML
	private TextField nombre;
	@FXML
	private PasswordField tfPassword;

	@FXML
	public void iniciarSesion() {
		Alert alerta = new Alert(AlertType.ERROR);
		try {
			service.iniciarSesion(nombre.getText(), tfPassword.getText());
			setUsuario(usuario);
			cambiarVista(BIENVENIDA);
		} catch (UsuarioException e) {
			alerta.setHeaderText(null);
			alerta.setContentText("Usuario no encontrado");
			alerta.setTitle("Error");
		} catch (SQLException e) {
			alerta.setHeaderText(null);
			alerta.setContentText("Error con la base de datos");
			alerta.setTitle("Error");
		}
	}

	@FXML
	public void irRegistro() {
		cambiarVista(REGISTRO);
	}

}
