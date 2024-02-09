package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PantallaRegistro extends View {
	public PantallaRegistro(AppController appView) {
		super(appView);		
		setLayout(null);

		JLabel LanelUsuario = new JLabel("Usuario");
		LanelUsuario.setBounds(10, 28, 107, 14);
		add(LanelUsuario);

		JPasswordField passwordField;
		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setBounds(10, 82, 79, 14);
		add(LabelPassword);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(10, 108, 136, 20);
		add(passwordField);

		JButton botonEntrar = new JButton("Entrar");
		botonEntrar.setBounds(106, 139, 92, 23);
		add(botonEntrar);

		botonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char[] contraseña = passwordField.getPassword();
				appView.iniciarSesion(textUsuario.getText(), String.valueOf(contraseña));
			}
		});

		JButton btnSolicitarAcceso = new JButton("Solicitar Acceso");
		btnSolicitarAcceso.setBounds(181, 206, 137, 23);
		add(btnSolicitarAcceso);

		btnSolicitarAcceso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irPatallaSolicitarAcceso();
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(328, 206, 69, 23);
		add(btnSalir);

		textUsuario = new JTextField();
		textUsuario.setBounds(10, 53, 136, 20);
		add(textUsuario);
		textUsuario.setColumns(10);

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnSalir, "Estas seguro?", "¿Salir?",
						JOptionPane.YES_NO_OPTION) != 1) {
					System.exit(0);
				} else {

				}
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 669453377663969951L;
	private JTextField textUsuario;

}
