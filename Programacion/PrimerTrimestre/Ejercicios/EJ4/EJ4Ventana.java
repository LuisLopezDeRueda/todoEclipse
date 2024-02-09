package EJ4;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EJ4Ventana extends JFrame {

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
		MouseListener mouseListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				JButton botonOriginal = (JButton) e.getSource();
				botonOriginal.setBackground(null);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				JButton botonOriginal = (JButton) e.getSource();
				botonOriginal.setBackground(Color.red);
			}

			
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton botonOriginal = (JButton) e.getSource();
				botonOriginal.setText(botonOriginal.getText() + "!");
				
			}
		};
		ActionListener listenerBotones = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String actionCommandOrigen = e.getActionCommand();
				label.setText(actionCommandOrigen);

				
			}
		};

		for (int i = 1; i <= 3; i++) {
			JButton buton = new JButton();
			buton.addActionListener(listenerBotones);
			buton.addMouseListener(mouseListener);
			buton.setText(i + "");
			buton.setActionCommand("Botón " + i);
			contenedor.add(buton);
		}
		contenedor.add(label);

		setVisible(true);
	}

}
