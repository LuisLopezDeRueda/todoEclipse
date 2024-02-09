package fct.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fct.Modelo.Usuario;

public class SolicitarAcceso extends View {
	public SolicitarAcceso(AppController appView) {
		super(appView);		
		setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(36, 27, 86, 14);
		add(lblUsuario);

		textUsaurio = new JTextField();
		textUsaurio.setBounds(36, 52, 86, 20);
		add(textUsaurio);
		textUsaurio.setColumns(10);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(36, 84, 86, 14);
		add(lblContraseña);

		passwordField = new JPasswordField();
		passwordField.setBounds(36, 111, 86, 20);
		add(passwordField);

		JLabel lblRepetirContraseña = new JLabel("Repetir Contraseña");
		lblRepetirContraseña.setBounds(36, 142, 141, 14);
		add(lblRepetirContraseña);

		passwordRepetirContraseña = new JPasswordField();
		passwordRepetirContraseña.setBounds(36, 167, 86, 20);
		add(passwordRepetirContraseña);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(166, 27, 86, 14);
		add(lblNombre);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(166, 52, 86, 20);
		add(textNombre);

		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(166, 109, 86, 20);
		add(textApellidos);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(166, 84, 86, 14);
		add(lblApellidos);

		JLabel lblCiclos = new JLabel("Ciclo Formativo");
		lblCiclos.setBounds(166, 142, 105, 14);
		add(lblCiclos);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(166, 166, 88, 22);
		add(comboBox);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(36, 214, 89, 23);
		add(btnAceptar);

		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario user = new Usuario();
				char[] pass = passwordField.getPassword();
				char[] pass2 = passwordRepetirContraseña.getPassword();
				String contraseña = new String(pass);
				String contraseña2 = String.valueOf(pass2);
				if (textUsaurio.getText().isEmpty() || contraseña.isEmpty() || contraseña2.isEmpty()
						|| textNombre.getText().isEmpty() || textApellidos.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAceptar, "TIENE QUE RELLENAR TODOS LOS CAMPOS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!contraseña.equals(contraseña2)) {
						JOptionPane.showMessageDialog(btnAceptar, "LAS CONTRASEÑAS NO SON IGUALES", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}else {
						user.setEmail(textUsaurio.getText());
						user.setPassword(String.valueOf(pass));
						user.setApellidos(textApellidos.getText());
						user.setNombre(textNombre.getText());
						user.setCiclo(comboBox.getSelectedItem().toString());
						 appView.registrarUsuario(user);
					}
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(163, 214, 89, 23);
		add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irPatallaRegistro();
			}
		});

		comboBox.addItem("DAM");
		comboBox.addItem("DAW");
		comboBox.addItem("ASIR");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4631879749034200423L;
	private JTextField textUsaurio;
	private JPasswordField passwordField;
	private JPasswordField passwordRepetirContraseña;
	private JTextField textNombre;
	private JTextField textApellidos;
}
