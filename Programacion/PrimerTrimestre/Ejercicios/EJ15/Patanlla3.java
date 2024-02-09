package EJ15;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Patanlla3 extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8833986861687969261L;
	
	private JLabel lblpantalla1;

	public Patanlla3(App15 app) {
		super(app);
		setLayout(null);

		lblpantalla1 = new JLabel("PANTALLA 3");
		lblpantalla1.setBounds(36, 27, 150, 14);
		add(lblpantalla1);

		textField = new JTextField();
		textField.setBounds(184, 80, 106, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Pantalla 1");
		btnNewButton.setBounds(68, 111, 106, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				app.irAPantalla1();

			}
		});

		JButton btnNewButton_1 = new JButton("Pantalla 2");
		btnNewButton_1.setBounds(184, 111, 106, 23);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				app.irAPantalla2();

			}
		});

		JButton btnNewButton_1_1 = new JButton("Pantalla 3");
		btnNewButton_1_1.setBounds(300, 111, 106, 23);
		add(btnNewButton_1_1);
		
		btnNewButton_1_1.setEnabled(false);
	}
}
