package EJ1;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ej1Ventana extends JFrame {

	private static final long serialVersionUID = -6712448061653904676L;

	public void mostrar() {
		setTitle("Ejemplo titulo");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contenedor = getContentPane();
		GridLayout layout = new GridLayout(3, 2);
		setLayout(layout);

		JPanel penultimaCelda = new JPanel();
		GridLayout penultimaCeldalayout = new GridLayout(2, 2);
		penultimaCelda.setLayout(penultimaCeldalayout);

		for (int i = 0; i < 6; i++) {
			JLabel label = new JLabel();
			if (i != 5) {

				label.setText("Texto " + (1 + i));
				contenedor.add(label);
			} else {
				for (int j = 0; j < 4; j++) {
					JLabel labelfinal = new JLabel();
					labelfinal.setText("Texto 6" + (1 + j));
					penultimaCelda.add(labelfinal);
				}
				contenedor.add(penultimaCelda);
			}
		}
		setVisible(true);

	}

}
