package PantallasService;

import Controllers.AppController;
import Modelo.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class FacturaService extends AppController {
	@FXML
	private TableView<Articulo> tabla;
	private ObservableList<Articulo> lista;
	@FXML
	private TableColumn<Articulo, Integer> columCanti;
	@FXML
	private TableColumn<Articulo, String> columnaNombre;
	@FXML
	private TableColumn<Articulo, Double> columnaPrecio;
	@FXML
	private Label labelPrecio;

	@FXML
	public void initialize() {
		columCanti.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("cantidad"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
		columnaPrecio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("precio"));
		lista = FXCollections.observableArrayList();
		lista = getLista();
		tabla.setItems(lista);
	}

	public void actualizarPrecio() {
		Double precio = 0.0;
		for (Articulo articulo : lista) {
			Double precioMeter = articulo.getPrecio() * articulo.getCantidad();
			precio += precioMeter;
		}
		labelPrecio.setText("Precio total: " + precio);
	}

	@FXML
	public void salir() {
		irCobrar();
	}

	@FXML
	public void terminarCompra() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Correcto");
		a.setContentText("Pedido terminado correctamente");
		a.show();
		irUsuario();
	}

}
