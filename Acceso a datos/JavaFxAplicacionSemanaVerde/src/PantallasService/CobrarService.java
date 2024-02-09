package PantallasService;

import java.util.ArrayList;
import java.util.List;

import Controllers.AppController;
import Modelo.Articulo;
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
import javafx.scene.effect.BoxBlur;

public class CobrarService extends AppController {
	@FXML
	private TextField textField;
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
	private ProgressBar consultarBar;
	@FXML
	private Label labelPrecio;

	public void buscar() {
		lista.setAll(new ArrayList<Articulo>());
		tabla.setEffect(new BoxBlur());
		Task<Void> task = new Task<Void>() {

			List<Articulo> listaArticulo;

			@Override
			protected Void call() throws Exception {
				// Service de consultar los articulos
				return null;
			}

			@Override
			protected void succeeded() {
				tabla.setEffect(null);
				super.succeeded();
				updateProgress(100, 100);
				lista.addAll(listaArticulo);
				tabla.setOpacity(1.0);
			}

			@Override
			protected void failed() {
				super.failed();
				updateProgress(100, 100);
				alet("Datos no encontrados");
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
		irFactura();
	}
}
