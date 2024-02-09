package EJ12;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App12 {
	private JFrame frame;

	private Patanlla1 pantalla1;
	private Patanlla2 pantalla2;
	private Patanlla3 pantalla3;

	private View pantallaActual;

	/**
	 * 
	 * Launch the App12lication.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App12 window = new App12();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the App12lication.
	 */
	public App12() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pantalla1 = new Patanlla1(this);
		pantalla2 = new Patanlla2(this);
		pantalla3 = new Patanlla3(this);

		pantallaActual = pantalla1;
		
		irAPantalla1();
	}

	public void irAPantalla1() {
		irAPantalla(pantalla1);
	}

	public void irAPantalla2() {
		irAPantalla(pantalla2);
	}

	public void irAPantalla3() {
		irAPantalla(pantalla3);
	}
	public void irAPantalla(View pantalla) {
		String msj = pantallaActual.getTexto();
		frame.setContentPane(pantalla);
		frame.revalidate();
		pantallaActual = pantalla;
		pantalla.setTexto(msj);
	}
}
