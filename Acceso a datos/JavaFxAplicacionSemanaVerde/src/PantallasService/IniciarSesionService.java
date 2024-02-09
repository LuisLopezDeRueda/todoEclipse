package PantallasService;

import Controllers.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IniciarSesionService extends AppController {
	@FXML
	private TextField usuario;
	@FXML
	private PasswordField contraseña;

	@FXML
	public void salir() {
		salirAplicacion();
	}

	@FXML
	public void crearUsuario() {
		irRegistro();
	}

	@FXML
	public void entrar() {
		if (service.consultarTrabajador(usuario.getText(), contraseña.getText()) == null) {
			alet("El usuario no existe");
			limpiar();
			return;
		}
		irUsuario();
	}
	public void limpiar() {
		usuario.setText("");
		contraseña.setText("");
	}

}
