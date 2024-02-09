package app.guiLogin;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import app.AppController;
import app.guiLogin.Bienvenida.BienvenidaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import practica.modelo.Usuario;
import practica.services.LoginDenegadoException;
import practica.services.LoginService;

public class LoginController extends AppController {

	@FXML
	private TextField tfNombre;
	@FXML
	private PasswordField tfPassword;
	@FXML
	private Label label;
	@FXML
	private Button btnSalir;
	@FXML
	private Label lblInformation;

	@FXML
	public void escribirTexto(ActionEvent event) {
		LoginService service = new LoginService();
		try {
			Usuario user = service.login(tfNombre.getText(), tfPassword.getText());
			String usuario = "";
			usuario = user.getNombre() + " ";
			usuario += user.getOrigen() + " -- ";
			usuario += new SimpleDateFormat("dd/MM/yyyy").format(user.getFechaRegistro());

			lblInformation.setText(usuario);
			label.setId("verde");
			label.setText("Acceso Permitido");

			BienvenidaController controller = (BienvenidaController) cambiarVista(BIENVENIDA);
			controller.setNombreBienvenida(tfNombre.getText());
			// label.getStyleClass().add(fondo); se le puede añadir un #

		} catch (LoginDenegadoException e) {
			label.setId("rojo");
			label.setText("Usuario o contraseña incorrectos");
		}

	}

	@FXML
	public void salirAplicacion(ActionEvent event) {

		System.exit(0);

	}

	@FXML // Cuando iniciamos la pantalla pasara
	public void initalize() {
		tfNombre.requestFocus();
	}

	public void cambairTexto() {

	}

}
