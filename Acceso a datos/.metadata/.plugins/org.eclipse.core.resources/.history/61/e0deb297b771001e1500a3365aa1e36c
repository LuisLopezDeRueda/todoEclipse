package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PantallaRegistro {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistro window = new PantallaRegistro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(162, 64, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel LanelUsuario = new JLabel("Usuario");
		LanelUsuario.setBounds(162, 37, 66, 14);
		frame.getContentPane().add(LanelUsuario);
		
		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setBounds(162, 95, 86, 14);
		frame.getContentPane().add(LabelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(162, 120, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton BotonSesion = new JButton("Iniciar Sesión");
		BotonSesion.setBounds(272, 153, 118, 23);
		frame.getContentPane().add(BotonSesion);
	}
}
