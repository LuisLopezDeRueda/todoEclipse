package Ejemplo;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Patalla3 extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8833986861687969261L;

	public Patalla3(App app) {
		super(app);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("PATANLLA 3");
		lblNewLabel.setBounds(20, 27, 87, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Pantalla 1");
		btnNewButton.setBounds(156, 104, 110, 23);
		add(btnNewButton);
		btnNewButton.setBounds(132, 100, 111, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				app.irAPantalla1();

			}
		});
	}

	
}
