package PantallasService;

import Controllers.AppController;
import Modelo.Articulo;
import Modelo.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private RadioButton rndEfectivo;
	@FXML
	private RadioButton rndTarjeta;

	@FXML
	private Label lblDescuento;
	private Double precioTotal;

	@FXML
	public void initialize() {
		columCanti.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("cantidad"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
		columnaPrecio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("precio"));
		lista = FXCollections.observableArrayList();
		lista = getLista();
		tabla.setItems(lista);
	}

	public void actualizarPrecio(Double precio) {

		if (getUsuario() == null) {
			precioTotal = precio;
			labelPrecio.setText("Precio total: \t" + precio);
		} else {
			precioTotal = precio * 0.95;
			labelPrecio.setText("Precio total: \t" + precio * 0.95);
			lblDescuento.setText("Descuento por ser cliente: " + precio * 0.05);
		}

	}

	@FXML
	public void salir() {
		irCobrar();
	}

	@FXML
	public void terminarCompra() {
		Venta factura = new Venta();
		factura.setCliente(usuario);
		factura.setArticulos(lista);
		factura.setPrecioTotal(precioTotal);
		service.insertarVenta(factura);
		alertInformativa("Pago terminado correctamente");
		irUsuario();
	}

	@FXML
	public void tarjeta() {
		rndEfectivo.setSelected(false);
	}

	@FXML
	public void efectivo() {
		rndTarjeta.setSelected(false);
	}

}
