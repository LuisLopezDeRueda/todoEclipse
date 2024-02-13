package Controllers;

import java.io.IOException;
import java.util.Optional;

import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.Trabajador;
import Service.Service;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AppController {
	public static final String INICIARSESION = "/pantallas/IniciarSersion.fxml";
	public static final String COBRAR = "/pantallas/Cobrar.fxml";
	public static final String CONTRASEÑA = "/pantallas/Contraseña.fxml";
	public static final String REGISTRAR = "/pantallas/Registrar.fxml";
	public static final String USUARIO = "/pantallas/Usuario.fxml";
	public static final String FACTURA = "/pantallas/Factura.fxml";
	public static final String CREARCLIENTE = "/pantallas/CrearCliente.fxml";
	public static final String CONSULTARCLIENTE = "/pantallas/UsuarioConsultar.fxml";
	public static final String ARTICULOCREAR = "/pantallas/ArticuloCrear.fxml";
	private static Stage stage;
	protected static Cliente usuario;
	protected static Trabajador trabajador;
	protected static ObservableList<Articulo> lista;

	protected Service service;

	public AppController() {
		service = new Service();
	}

	public AppController(Stage Loginstage) {
		service = new Service();
		stage = Loginstage;
	}

	public static ObservableList<Articulo> getLista() {
		return lista;
	}

	public static void setLista(ObservableList<Articulo> lista) {
		AppController.lista = lista;
	}

	public static Trabajador getTrabajador() {
		return trabajador;
	}

	public static void setTrabajador(Trabajador trabajador) {
		AppController.trabajador = trabajador;
	}

	public void salirAplicacion() {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText(null);
		a.setContentText("¿Seguro que quieres cerrar la aplicación?");
		a.setTitle("Confirmación");
		Optional<ButtonType> result = a.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}
	}

	public static Cliente getUsuario() {
		return usuario;
	}

	public static void setUsuario(Cliente usuario) {
		AppController.usuario = usuario;
	}

	public AppController cambiarVista(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = null;
			scene = new Scene(loader.load());
			stage.setScene(scene);
			return loader.getController();
		} catch (IOException e) {

			System.out.println("Error con la vista nueva \n Vista destino " + fxml + e);
			e.getStackTrace();
			throw new RuntimeException(e);

		}

	}

	public Parent cargarVista(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			return loader.load();
		} catch (IOException e) {

			System.out.println("Error con la vista nueva \n Vista destino " + fxml + e);
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

	public AppController irIniciarSesion() {
		return cambiarVista(INICIARSESION);

	}

	public AppController irFactura() {
		return cambiarVista(FACTURA);

	}

	public AppController irCobrar() {
		return cambiarVista(COBRAR);

	}

	public AppController irArticuloCrear() {
		return cambiarVista(ARTICULOCREAR);

	}

	public AppController irContraseña() {
		return cambiarVista(CONTRASEÑA);

	}

	public AppController irRegistro() {
		return cambiarVista(REGISTRAR);

	}

	public AppController irUsuario() {
		return cambiarVista(USUARIO);

	}

	public AppController irCrearCliente() {
		return cambiarVista(CREARCLIENTE);

	}

	public AppController irConsultarCliente() {
		return cambiarVista(CONSULTARCLIENTE);

	}

	void salir(ActionEvent event) {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText(null);
		a.setContentText("¿Seguro que quieres cerrar la aplicación?");
		a.setTitle("Confirmación");
		Optional<ButtonType> result = a.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}
	}
}
