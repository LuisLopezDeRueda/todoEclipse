package app.guiLogin.PantallasControllers;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import practica.modelo.Persona;

public class TableController {

	@FXML
	private TableColumn<Persona, String> columnDNI;

	@FXML
	private TableColumn<Persona, Integer> columnEdad;

	@FXML
	private TableColumn<Persona, String> columnNombre;
	@FXML
	private ProgressBar barra;

	@FXML
	private TableView<Persona> tabla;

	private ObservableList<Persona> lista;

	@FXML
	public void initialize() {
		columnDNI.setCellValueFactory(new PropertyValueFactory<Persona, String>("dni"));
		columnEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
		columnNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));

		lista = FXCollections.observableArrayList();
		tabla.setItems(lista);
	}

	@FXML
	public void crearPersona() {
		Task<Void> task = new Task<Void>() {
			List<Persona> listaPersonas;

			@Override
			protected Void call() throws Exception {

				listaPersonas = new PersonaService().getPersonas();
				return null;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				updateProgress(100, 100);
				lista.addAll(listaPersonas);
			}

			@Override
			protected void failed() {
				super.failed();
				updateProgress(100, 100);
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("ERROR");
				a.show();
			}

		};
		new Thread(task).start();
		barra.progressProperty().bind(task.progressProperty());
	}

}
