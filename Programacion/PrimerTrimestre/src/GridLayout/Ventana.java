package GridLayout;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -8982105919967336596L;

	public void Mostrar() {
		setTitle("Ejemplo titulo"); // Titulo
		setSize(600, 400);
		; // Tamaño
		setLocationRelativeTo(null);// Si es null la ventana sale centrada en la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cuando salgamos del programa termine el proceso

		// Crear boton
		Container contenedor = getContentPane();
		GridLayout layout = new GridLayout(4,2);
		setLayout(layout);
		
		//Creamos nuevo panel para la primera celda y le damos tu propio layout
		JPanel panelPrimeraCelda = new JPanel();
		GridLayout layout2 = new GridLayout(1,2);//primero fila segundo columna
		panelPrimeraCelda.setLayout(layout2);
		JButton botonPrimeraParte = new JButton();
		botonPrimeraParte.setText("1º Parte");
		JButton botonSegundaParte = new JButton();
		botonSegundaParte.setText("2º Parte");
		//Creamos los botones y se lo metemos a panel
		panelPrimeraCelda.add(botonPrimeraParte);
		panelPrimeraCelda.add(botonSegundaParte);
		contenedor.add(panelPrimeraCelda);
		
		
		for (Integer i = 0; i < 7; i++) {
			JButton boton1 = new JButton();
			boton1.setText("Numero " + (i + 1));
			contenedor.add(boton1);
		}
		
		setVisible(true);// Para que se vea

	}

}
