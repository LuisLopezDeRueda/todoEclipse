package EJ6Otraforma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EJ6OJVentana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167243821630843163L;

	public void inicializar() {
		setTitle("Ejercicio3");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(2, 1);
		Container contenedor = getContentPane();
		contenedor.setLayout(layout);
		JTextField textField = new JTextField();
		JButton boton = new JButton();
		boton.setText("SUMAR");
		contenedor.add(boton);
		
		InicializarEJ6OJ listener = new InicializarEJ6OJ(boton, textField);
		
		boton.addActionListener(listener);
		
		contenedor.add(textField);

		setVisible(true);
	}
	

}
