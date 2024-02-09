package EJ2;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ej2Ventana extends JFrame {

	private static final long serialVersionUID = -6712448061653904676L;

	public void mostrar() {
		setTitle("Ejemplo titulo");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contenedor = getContentPane();
		GridLayout layout = new GridLayout(4, 2); 
		setLayout(layout);
		
		JLabel nombre = new JLabel();
		nombre.setText("Nombre:");
		contenedor.add(nombre);
		JTextField Tfnombre = new JTextField();
		contenedor.add(Tfnombre);
		
		JLabel dni = new JLabel();
		dni.setText("DNI:");
		contenedor.add(dni);
		JTextField Tfdni = new JTextField();
		contenedor.add(Tfdni);
		
		JLabel fecha = new JLabel();
		fecha.setText("Fecha de nacimiento:");
		contenedor.add(fecha);
		
		JPanel fnacimiento = new JPanel();
		
		for (int i = 0; i < 5; i++) {
			if( i == 0 || i == 2 || i == 4) {
				JTextField fntf = new JTextField(3);
				fnacimiento.add(fntf);
			}
			if( i == 1 || i == 3 ) {
				JLabel barra = new JLabel();
				barra.setText("/");
				fnacimiento.add(barra);
			}
		}
		contenedor.add(fnacimiento);
		
		JButton aceptar = new JButton();
		aceptar.setText("Aceptar");
		
		contenedor.add(aceptar);
		
		JButton cancelar = new JButton();
		cancelar.setText("Cancelar");
		contenedor.add(cancelar);
		
		
		setVisible(true);

	}

}
