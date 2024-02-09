package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class AltaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7748234473293923610L;
	private JTextField textField;

	public AltaView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblNuevaMarca = new JLabel("Nueva marca");
		lblNuevaMarca.setBounds(115, 124, 76, 14);
		add(lblNuevaMarca);

		textField = new JTextField();
		textField.setBounds(201, 121, 112, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(338, 120, 112, 23);
		add(btnAñadir);
		
		
		JLabel lblMarcas = new JLabel("Marcas");
		lblMarcas.setBounds(115, 178, 76, 14);
		add(lblMarcas);

		

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(201, 174, 112, 22);
		add(comboBox);
		
		appView.listaMarcas(comboBox);
		
		btnAñadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				appView.añadirMarca(textField.getText());
				appView.listaMarcas(comboBox);
			}
		});
	}
	public void limpiar() {
		textField.setText("");
	}
		
}
