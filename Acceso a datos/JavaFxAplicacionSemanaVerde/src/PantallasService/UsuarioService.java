package PantallasService;

import Controllers.AppController;
import javafx.fxml.FXML;

public class UsuarioService extends AppController{
	@FXML
	public void clienteExistente() {
		irUsuario();
	}
	@FXML
	public void atras() {
		irIniciarSesion();
	}
	@FXML
	public void noUsuario() {
		irCobrar();
	}
	@FXML
	public void crearClietne() {
		
	}
	
}
