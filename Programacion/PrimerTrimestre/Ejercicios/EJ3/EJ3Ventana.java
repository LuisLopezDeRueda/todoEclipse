package EJ3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EJ3Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167243821630843163L;

	public void inicializar() {
		setTitle("Ejercicio3");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(4, 1);
		Container contenedor = getContentPane();
		contenedor.setLayout(layout);
		JLabel label = new JLabel();
		label.setText("Adios");
		ActionListener listenerBotones = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*JButton botonOriginal = (JButton) e.getSource();
				e.getSource();
				label.setText(label.getText() + botonOriginal.getText());*/
				String actionCommandOrigen = e.getActionCommand();
				label.setText(actionCommandOrigen);

			}
		};
			

		for (int i = 1; i <= 3; i++) {
			JButton buton = new JButton();
			buton.addActionListener(listenerBotones);
			buton.setText(i + "");
			buton.setActionCommand("Botón " + i);
			contenedor.add(buton);
		}
		contenedor.add(label);
		
		setVisible(true);
	}

}
