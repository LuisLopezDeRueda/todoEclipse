package EJ11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class EJ11Ventana {

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
					EJ11Ventana window = new EJ11Ventana();
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
	public EJ11Ventana() {
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
		textField.setBounds(208, 37, 156, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField1 = new JTextField();
		textField1.setBounds(208, 93, 156, 45);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(208, 149, 156, 45);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(208, 205, 156, 45);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 75, 77, 22);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Rojo");
		comboBox.addItem("Azul");
		comboBox.addItem("Verde");
		comboBox.setFocusable(false);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Rojo");
		rdbtnNewRadioButton.setBounds(10, 100, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton1 = new JRadioButton("Azul");
		rdbtnNewRadioButton1.setBounds(10, 120, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton1);

		JRadioButton rdbtnNewRadioButton2 = new JRadioButton("Verde");
		rdbtnNewRadioButton2.setBounds(10, 140, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton2);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNewRadioButton);
		grupo.add(rdbtnNewRadioButton1);
		grupo.add(rdbtnNewRadioButton2);

		// Integer index = comboBox.getSelectedIndex(); // Da un integer que empieza en
		// 0
		// String item = (String) comboBox.getSelectedItem(); //Da el item que se ha
		// seleccionado

		// Cuando cambia el comboBox se cambia el boton redondo

		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				rdbtnNewRadioButton.setSelected(comboBox.getSelectedItem().equals("Rojo"));
				rdbtnNewRadioButton1.setSelected(comboBox.getSelectedItem().equals("Azul"));
				rdbtnNewRadioButton2.setSelected(comboBox.getSelectedItem().equals("Verde"));

			}
		};
		comboBox.addItemListener(itemListener);

		FocusListener focusListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				((JTextField) e.getSource()).setBackground(Color.WHITE);

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (comboBox.getSelectedItem().equals("Rojo")) {
					((JTextField) e.getSource()).setBackground(Color.red);
				}
				if (comboBox.getSelectedItem().equals("Azul")) {
					((JTextField) e.getSource()).setBackground(Color.blue);
				}
				if (comboBox.getSelectedItem().equals("Verde")) {
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

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JTextField) e.getSource()).transferFocus();
				}

			}
		};
		// Cambiar boton redondo se cambia el comboBox
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comboBox.setSelectedItem(((JRadioButton) e.getSource()).getText());

				/*
				 * if (rdbtnNewRadioButton.isSelected()) { comboBox.setSelectedItem("Rojo"); }
				 * if (rdbtnNewRadioButton1.isSelected()) { comboBox.setSelectedItem("Azul"); }
				 * if (rdbtnNewRadioButton2.isSelected()) { comboBox.setSelectedItem("Verde"); }
				 */

			}
		};

		rdbtnNewRadioButton.addActionListener(actionListener);
		rdbtnNewRadioButton1.addActionListener(actionListener);
		rdbtnNewRadioButton2.addActionListener(actionListener);

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
