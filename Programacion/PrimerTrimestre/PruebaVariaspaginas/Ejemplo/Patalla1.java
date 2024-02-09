package Ejemplo;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Patalla1 extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8833986861687969261L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblpantalla1;
	
	public Patalla1(App app) {
		super(app);
		setLayout(null);

		lblpantalla1 = new JLabel("PANTALLA 1");
		lblpantalla1.setBounds(36, 27, 150, 14);
		add(lblpantalla1);

		JButton Btnpantalla2 = new JButton("Pantalla2");
		Btnpantalla2.setBounds(190, 114, 89, 23);
		add(Btnpantalla2);
		
		textField = new JTextField();
		textField.setBounds(190, 54, 89, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton loginboton = new JButton("Login");
		loginboton.setBounds(190, 154, 89, 23);
		add(loginboton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 85, 89, 20);
		add(passwordField);
		Btnpantalla2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.irAPantalla2();
				
			}
		});
		loginboton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				app.login(textField.getText(),new String( passwordField.getPassword()));
				
			}
		});
		
	}
	
	public void cambiarMensaje(String mensaje) {
		lblpantalla1.setText(mensaje);
		lblpantalla1.setForeground(Color.red);
	}
}
