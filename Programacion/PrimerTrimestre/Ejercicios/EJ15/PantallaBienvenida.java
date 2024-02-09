package EJ15;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PantallaBienvenida extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3542008314438255677L;

	/**
	 * Create the application.
	 */
	public PantallaBienvenida(App15 app14) {
		super(app14);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setBounds(178, 54, 180, 21);
		add(lblNewLabel);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(165, 102, 103, 23);
		add(btnEntrar);

		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				app14.irAPantalla1();

			}
		});
	}
}
