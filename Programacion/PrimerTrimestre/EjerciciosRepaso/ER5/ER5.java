package ER5;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class ER5 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ER5 window = new ER5();
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
	public ER5() {
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
		comboBox.setBounds(52, 133, 73, 22);
		frame.getContentPane().add(comboBox);

		textField = new JTextField();
		textField.setBounds(141, 97, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

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
		textField.addKeyListener(keyListener);
	}
}
