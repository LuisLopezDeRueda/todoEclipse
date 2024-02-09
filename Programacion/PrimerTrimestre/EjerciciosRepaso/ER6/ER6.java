package ER6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ER6 {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ER6 window = new ER6();
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
	public ER6() {
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

		JLabel lblNewLabel = new JLabel("Nueva Ciudad");
		lblNewLabel.setBounds(42, 92, 83, 30);
		frame.getContentPane().add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setToolTipText("Destinos Disponibles");
		comboBox.setBounds(251, 96, 73, 22);
		frame.getContentPane().add(comboBox);

		textField = new JTextField();
		textField.setBounds(141, 97, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(84, 179, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setBounds(214, 179, 110, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(52, 138, 322, 14);
		frame.getContentPane().add(lblNewLabel_1);

		KeyListener keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBox.addItem(textField.getText());
					textField.setText("");
					comboBox.setSelectedIndex(-1);
				}
			}

		};
		ActionListener actionlistenerLimpiar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				
			}
		};
		ActionListener actionListenerSeleccionar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == null) {
					btnNewButton_1.setEnabled(false);
				}else {
					btnNewButton_1.setEnabled(true);
				}
				lblNewLabel_1.setText("Ciudad seleccionada " + comboBox.getSelectedItem());
				
			}
		};
		
		btnNewButton_1.addActionListener(actionListenerSeleccionar);
		btnNewButton.addActionListener(actionlistenerLimpiar);
		textField.addKeyListener(keyListener);
	}
}
