
package PantallasService;

import java.util.ArrayList;

import Controllers.AppController;
import Modelo.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;

public class CobrarService extends AppController {
	@FXML
	private TextField textField;
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
	private ProgressBar consultarBar;
	@FXML
	private Label labelPrecio;
	private Boolean entrar;

	public CobrarService() {
		entrar = true;
	}

	@FXML
	public void initialize() {
		columCanti.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("cantidad"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
		columnaPrecio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("precio"));

		lista = FXCollections.observableArrayList();
		lista.setAll(new ArrayList<Articulo>());
		tabla.setItems(lista);

	}

	public void buscar() {
		tabla.setEffect(new BoxBlur());
		Task<Void> task = new Task<Void>() {

			Articulo articulo = new Articulo();

			@Override
			protected Void call() throws Exception {
				articulo = service.consultarArticulo(textField.getText());
				return null;
			}

			@Override
			protected void succeeded() {
				tabla.setEffect(null);
				super.succeeded();
				updateProgress(100, 100);
				actualizarLista(articulo);
				tabla.setOpacity(1.0);
				actualizarPrecio();
				// textField.setText("");
			}

			@Override
			protected void failed() {
				super.failed();
				tabla.setEffect(null);
				updateProgress(100, 100);
				alert("Datos no encontrados");
			}
		};
		new Thread(task).start();
		consultarBar.progressProperty().bind(task.progressProperty());
	}

	@FXML
	public void escribir(ActionEvent event) {
		Button boton = (Button) event.getSource();
		textField.setText(textField.getText() + boton.getText());
	}

	@FXML
	public void atras() {
		irUsuario();
	}

	@FXML
	public void factura() {
		setLista(lista);
		irFactura();
	}

	public void actualizarPrecio() {
		Double precio = 0.0;
		for (Articulo articulo : lista) {
			Double precioMeter = articulo.getPrecio() * articulo.getCantidad();
			precio += precioMeter;
		}
		labelPrecio.setText("Precio total: " + precio);
	}

	public void actualizarLista(Articulo arti) {
		for (Articulo articulo : lista) {
			if (arti.getCodBarras().equals(articulo.getCodBarras())) {
				articulo.setCantidad(articulo.getCantidad() + 1);
				entrar = false;
				break;
			}
		}
		if (entrar) {
			lista.add(arti);
			entrar = true;
		}

	}
}
