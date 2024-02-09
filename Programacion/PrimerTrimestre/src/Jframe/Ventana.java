package Jframe;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		JButton boton = new JButton();
		boton.setText("Boton");

		contenedor.add(boton);

		for (Integer i = 0; i < 10; i++) {
			JButton boton1 = new JButton();
			boton1.setText("Numero " + (i + 1));
			contenedor.add(boton1);
		}

		// Crear Layout
		FlowLayout layout = new FlowLayout();

		setLayout(layout);
		setVisible(true);// Para que se vea

	}

}
