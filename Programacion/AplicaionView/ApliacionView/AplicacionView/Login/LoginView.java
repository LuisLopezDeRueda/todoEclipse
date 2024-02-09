package Login;

import View.View;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6949769976463813989L;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JButton btnEntrar;

	public LoginView() {
		setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(119, 61, 84, 14);
		add(lblUsuario);

		JLabel label = new JLabel("New label");
		label.setBounds(119, 127, 21, -6);
		add(label);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(119, 127, 117, 14);
		add(lblContraseña);

		textUsuario = new JTextField();
		textUsuario.setBounds(119, 86, 117, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		// Pagina de inicio hay que hacer en la app todos los metodos y llamarlos desde las views 

		passwordField = new JPasswordField();
		passwordField.setBounds(119, 155, 117, 20);
		add(passwordField);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(147, 186, 89, 23);
		add(btnEntrar);

		JButton btnIniciarSercion = new JButton("Iniciar Sesion");
		btnIniciarSercion.setBounds(328, 266, 112, 23);
		add(btnIniciarSercion);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 266, 89, 23);
		add(btnSalir);
		
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

}
