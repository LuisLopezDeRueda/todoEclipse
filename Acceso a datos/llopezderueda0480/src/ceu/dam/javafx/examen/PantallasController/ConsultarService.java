package ceu.dam.javafx.examen.PantallasController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ceu.dam.javafx.examen.AppController;
import ceu.dam.javafx.examen.model.Coche;
import ceu.dam.javafx.examen.services.ExamenService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultarService extends AppController {
	@FXML
	private Button btnFiltrar;

	@FXML
	private TableColumn<Coche, String> columMarca;

	@FXML
	private TableColumn<Coche, String> columMatrícula;

	@FXML
	private TableColumn<Coche, String> columModelo;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextField filtro;

	@FXML
	private Label lblUsuaio;

	@FXML
	private TableView<Coche> tabla;
	private ObservableList<Coche> lista;
	private DateTimeFormatter formato;

	@FXML
	public void initialize() {
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		columMarca.setCellValueFactory(new PropertyValueFactory<Coche, String>("marca"));
		columMatrícula.setCellValueFactory(new PropertyValueFactory<Coche, String>("matricula"));
		columModelo.setCellValueFactory(new PropertyValueFactory<Coche, String>("modelo"));

		lista = FXCollections.observableArrayList();
		tabla.setItems(lista);

		comboBox.getItems().addAll("Toyota", "Seat", "Renault");
		lblUsuaio.setText(usuario + " - " + formato.format(getDate()));
	}

	@FXML
	public void buscarCoche() {
		Task<Void> task = new Task<Void>() {
			List<Coche> listaCoches;

			@Override
			protected Void call() throws Exception {
				lista.clear();
				listaCoches = new ExamenService().consultarCoches(comboBox.getValue(), filtro.getText());
				return null;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				lista.addAll(listaCoches);
				btnFiltrar.setDisable(false);
			}

			@Override
			protected void failed() {
				super.failed();
			}

		};
		new Thread(task).start();

	}

	public void salir() {
		irIniciarSesion();
	}

}
