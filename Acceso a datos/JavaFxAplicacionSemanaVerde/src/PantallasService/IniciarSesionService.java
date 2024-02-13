package PantallasService;

import Controllers.AppController;
import Modelo.Trabajador;
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
		Trabajador trabajador = service.consultarTrabajador(usuario.getText(), contraseña.getText());
		if (trabajador == null) {
			alert("El usuario no existe");
			limpiar();
			return;
		}
		setTrabajador(trabajador);
		UsuarioService services = (UsuarioService) irUsuario();
		services.empezar();
	}

	public void limpiar() {
		usuario.setText("");
		contraseña.setText("");
	}

}
