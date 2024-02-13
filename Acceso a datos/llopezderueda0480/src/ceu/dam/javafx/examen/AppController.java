package ceu.dam.javafx.examen;

import java.io.IOException;
import java.time.LocalDate;

import ceu.dam.javafx.examen.services.ExamenService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {
	public static final String CONSULTAR = "/Pantallas/Consultar.fxml";
	public static final String INICIARSESION = "/Pantallas/IniciarSesion.fxml";

	private static Stage stage;
	protected ExamenService service;
	protected static String usuario;
	protected static LocalDate date;

	public AppController() {
		service = new ExamenService();
	}

	public AppController(Stage Loginstage) {
		stage = Loginstage;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		AppController.usuario = usuario;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		AppController.date = date;
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

	public void alert(String contenido) {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("ERROR");
		a.setContentText(contenido);
		a.show();
	}

	public void alertInformativa(String contenido) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("INFORMACION");
		a.setContentText(contenido);
		a.show();
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

	public AppController irIniciarSesion() {
		return cambiarVista(INICIARSESION);

	}

	public AppController irConsultar() {
		return cambiarVista(CONSULTAR);

	}

}
