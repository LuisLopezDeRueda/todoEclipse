package PantallasService;

import Controllers.AppController;
import Modelo.Articulo;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class FacturaService extends AppController {
	@FXML
	private TableView<Articulo> tabla;
	private ObservableList<Articulo> lista;
	@FXML
	private TableColumn<Articulo, Long> columnaID;
	@FXML
	private TableColumn<Articulo, String> columnaNombre;
	@FXML
	private TableColumn<Articulo, Double> columnaPrecio;
	
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
