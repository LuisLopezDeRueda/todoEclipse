package fct;

import java.io.IOException;

import fct.app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fct.Modelo.Usuario;

public class AppController {
	public static final String BIENVENIDA = "/fct/Pantallas/bienvenida.fxml";
	public static final String INICIARSESION = "/fct/Pantallas/iniciarSesion.fxml";
	public static final String CONSULTAWEB = "/fct/Pantallas/consultaWeb.fxml";
	public static final String PREGUNTAS = "/fct/Pantallas/preguntas.fxml";
	public static final String REGISTRO = "/fct/Pantallas/registro.fxml";
	public static final String WRITING = "/fct/Pantallas/writing.fxml";

	private static Stage stage;

	protected Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AppController() {
	}

	public AppController(Stage Loginstage) {
		stage = Loginstage;
	}

	public AppController cambiarVista(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = null;
			scene = new Scene(loader.load());
			stage.setScene(scene);
			return loader.getController();
		} catch (IOException e) {

			System.out.println("Error con la vista nueva \n Vista destino " + fxml);
			e.getStackTrace();
			throw new RuntimeException(e);

		}

	}

	public Parent cargarVista(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			return loader.load();
		} catch (IOException e) {

			System.out.println("Error con la vista nueva \n Vista destino " + fxml);
			e.getStackTrace();
			throw new RuntimeException(e);

		}

	}
}
