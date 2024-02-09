package ER3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ER3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ER3 window = new ER3();
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
	public ER3() {
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
		textField.setBounds(163, 112, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Diga su edad");
		lblNewLabel.setBounds(31, 115, 102, 14);
		frame.getContentPane().add(lblNewLabel);
		textField.setText(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Acepto la política de privacidad");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(163, 174, 221, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Clean");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\llopezderueda0480\\Downloads\\papelera.png"));
		btnNewButton.setBounds(160, 204, 122, 46);
		frame.getContentPane().add(btnNewButton);
		
		
		
		KeyListener keylistener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();

				if (!Character.isDigit(c) || (c.equals('0') && textField.getText().isEmpty())) {
					
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (textField.getText().isEmpty()) {
						textField.setText("1");
					} else {
						Integer numero = Integer.parseInt(textField.getText()) + 1;
						textField.setText(numero + "");
					}

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (textField.getText().equals("1") || textField.getText().isEmpty()
							|| textField.getText().equals("0")) {
						textField.setText("1");
					} else {
						Integer numero = Integer.parseInt(textField.getText()) - 1;
						textField.setText(numero + "");
					}
				}

			}

		};
		ActionListener acli = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected() == false) {
					textField.setEnabled(false);
				}else {
					textField.setEnabled(true);
				}
			}
		};
		ActionListener actionListenerBoton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				
			}
		};
		
		btnNewButton.addActionListener(actionListenerBoton);
		chckbxNewCheckBox.addActionListener(acli);
		
		
		
		textField.addKeyListener(keylistener);
		chckbxNewCheckBox.addKeyListener(keylistener);

	}
}
