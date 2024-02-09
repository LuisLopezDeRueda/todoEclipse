package EJ6;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EJ6Ventana extends JFrame {

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
		
		ActionListener actionSumar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				if(textField.getText().isEmpty()) {
					textField.setText("1");
				}else {
					textField.setText((Integer.parseInt(textField.getText())+1)+"");
				}
				}catch(NumberFormatException error) {
					textField.setText(null);
					
					JOptionPane.showMessageDialog(boton, "Has puesto una palabra ", "Error de palabra" , JOptionPane.ERROR_MESSAGE, null);;
					
				}
			}
		};
		boton.addActionListener(actionSumar);
		
		contenedor.add(textField);

		setVisible(true);
	}
	

}
