package Ejemplo;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Patalla2 extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8833986861687969261L;

	public Patalla2(App app) {
		super(app);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("PANTALLA 2");
		lblNewLabel.setBounds(20, 32, 95, 14);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("Pantalla 3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(132, 100, 111, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				app.irAPantalla3();

			}
		});

	}

}
