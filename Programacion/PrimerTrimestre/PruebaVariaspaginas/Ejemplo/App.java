package Ejemplo;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {
	private JFrame frame;

	private Patalla1 pantalla1;
	private Patalla2 pantalla2;
	private Patalla3 pantalla3;

	/**
	 * 
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pantalla1 = new Patalla1(this);
		pantalla2 = new Patalla2(this);
		pantalla3 = new Patalla3(this);

		irAPantalla1();
	}

	public void irAPantalla1() {
		
		frame.setContentPane(pantalla1);
		frame.revalidate();
	}

	public void irAPantalla2() {

		frame.setContentPane(pantalla2);
		frame.revalidate();
	}

	public void irAPantalla3() {

		frame.setContentPane(pantalla3);
		frame.revalidate();
	}

	public void login(String user, String password) {
		//Comprobar si el nombre y la contraseña es null o vacía
		System.out.println(user + " " + password);
		//si va bien ir a pantalla 2
		//si hay un error mostrar el mensaje
		pantalla1.cambiarMensaje("Error con el mensaje");
	}
}
