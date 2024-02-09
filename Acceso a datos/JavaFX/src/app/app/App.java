package app.app;

import app.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController app = new AppController(primaryStage);
		app.cambiarVista(AppController.INICIO);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
