package app;

import java.io.IOException;

import app.app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practica.modelo.Usuario;

public class AppController {
	public static final String BIENVENIDA = "/app/guiLogin/Bienvenida/bienvenida.fxml";
	public static final String INICIO = "/app/guiLogin/Login/login.fxml";
	public static final String COMBOBOX = "/app/guiLogin/Pantallas/ComboBox.fxml";
	public static final String DATEPICKER = "/app/guiLogin/Pantallas/DatePicker.fxml";
	public static final String COLORPICKER = "/app/guiLogin/Pantallas/ColorPicker.fxml";
	public static final String SLIDER = "/app/guiLogin/Pantallas/Slider.fxml";
	public static final String WEBVIEW = "/app/guiLogin/Pantallas/tablas.fxml";
	public static final String HTMLEDITOR = "/app/guiLogin/Pantallas/HtmlEditor.fxml";

	protected Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private static Stage stage;

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
