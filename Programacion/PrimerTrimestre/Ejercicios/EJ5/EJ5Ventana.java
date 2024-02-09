package EJ5;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EJ5Ventana extends JFrame {

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
		JLabel label = new JLabel();
		JButton boton = new JButton();
		boton.setText("SUMAR");
		contenedor.add(boton);
		label.setText(null);
		ActionListener actionSumar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == null) {
					label.setText("1");
				}else {
					label.setText((Integer.parseInt(label.getText())+1)+"");
				}
				
			}
		};
		boton.addActionListener(actionSumar);
		
		contenedor.add(label);

		setVisible(true);
	}

}
