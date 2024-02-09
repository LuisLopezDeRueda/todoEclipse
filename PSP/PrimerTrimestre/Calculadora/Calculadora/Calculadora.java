package Calculadora;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Ejercicio1.LanzadorProcesos;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Calculadora {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
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
		
		JButton btnNewButton = new JButton("Bloc de notas");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\llopezderueda0480\\Downloads\\calculadorabuena.png"));
		btnNewButton.setBounds(10, 95, 208, 75);
		frame.getContentPane().add(btnNewButton);
		LanzadorProcesos lp = new LanzadorProcesos();
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ruta = "C:\\WINDOWS\\System32\\notepad.exe";
				
					lp.ejecutar(ruta);

				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Calculadora");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\llopezderueda0480\\Downloads\\calculadora.png"));
		btnNewButton_1.setBounds(228, 95, 196, 75);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ruta = "C:\\WINDOWS\\System32\\calc.exe";
				lp.ejecutar(ruta);
				
			}
		});
		
	}
}