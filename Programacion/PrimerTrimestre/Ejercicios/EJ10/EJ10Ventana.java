package EJ10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EJ10Ventana {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EJ10Ventana window = new EJ10Ventana();
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
	public EJ10Ventana() {
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
		textField.setBounds(141, 37, 156, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField1 = new JTextField();
		textField1.setBounds(141, 93, 156, 45);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(141, 149, 156, 45);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(141, 205, 156, 45);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 104, 77, 22);
		frame.getContentPane().add(comboBox);		
		comboBox.addItem("Rojo");
		comboBox.addItem("Azul");
		comboBox.addItem("Verde");
		comboBox.setFocusable(false);
		//Integer index = comboBox.getSelectedIndex(); // Da un integer que empieza en 0
	    //String item = (String) comboBox.getSelectedItem(); //Da el item que se ha seleccionado 
		
		/*ItemListener itemListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				color = (String) comboBox.getSelectedItem();
				
			}
		};
		comboBox.addItemListener(itemListener);*/
		
		
		
		
		FocusListener focusListener = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				((JTextField) e.getSource()).setBackground(Color.WHITE);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(comboBox.getSelectedItem().equals("Rojo")) {
					((JTextField) e.getSource()).setBackground(Color.red);
				}
				if(comboBox.getSelectedItem().equals("Azul")) {
					((JTextField) e.getSource()).setBackground(Color.blue);
				}
				if(comboBox.getSelectedItem().equals("Verde")) {
					((JTextField) e.getSource()).setBackground(Color.green);
				}
				
			}
		};
		
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
				if (e.getKeyCode() == KeyEvent.VK_UP) {

					((JTextField) e.getSource()).transferFocusBackward();

				}else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JTextField) e.getSource()).transferFocus();
				}

			}
		};
		
		textField.addFocusListener(focusListener);
		textField1.addFocusListener(focusListener);
		textField2.addFocusListener(focusListener);
		textField3.addFocusListener(focusListener);
		
		
		textField.addKeyListener(keyListener);
		textField1.addKeyListener(keyListener);
		textField2.addKeyListener(keyListener);
		textField3.addKeyListener(keyListener);
	}
}
