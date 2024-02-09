package EJ15;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class App15 {
	private JFrame frame;
	private JMenuBar menuBar;

	private Patanlla1 pantalla1;
	private Patanlla2 pantalla2;
	private Patanlla3 pantalla3;
	private PantallaBienvenida pb;

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
					App15 window = new App15();
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
	public App15() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnPantallas = new JButton("Ir a las pantallas");
		btnPantallas.setBounds(151, 109, 138, 23);
		frame.getContentPane().add(btnPantallas);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		frame.getContentPane().add(menuBar);
		frame.setJMenuBar(menuBar);

		menuBar.setVisible(false);

		JMenu mnPaginas = new JMenu("Páginas");
		menuBar.add(mnPaginas);

		JMenuItem mntmPag1 = new JMenuItem("Página 1");
		mntmPag1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
		mnPaginas.add(mntmPag1);

		mntmPag1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla1();

			}
		});

		JMenuItem mntmPag2 = new JMenuItem("Página 2");
		mntmPag2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
		mnPaginas.add(mntmPag2);

		mntmPag2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla2();

			}
		});

		JMenuItem mntmPag3 = new JMenuItem("Página 3");
		mntmPag3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
		mnPaginas.add(mntmPag3);

		mntmPag3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla3();

			}
		});

		JMenuItem mntmBien = new JMenuItem("Ir al menú");
		mntmBien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
		mnPaginas.add(mntmBien);

		mntmBien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantallaBien();
			}
		});

		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnSalir.add(mntmSalir);

		ActionListener salirAc = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(mntmSalir, "Estas seguro?", "¿Salir?",
						JOptionPane.YES_NO_OPTION) != 1) {
					System.exit(0);
				} else {

				}
			}
		};
		mntmSalir.addActionListener(salirAc);

		pantalla1 = new Patanlla1(this);
		pantalla2 = new Patanlla2(this);
		pantalla3 = new Patanlla3(this);
		pb = new PantallaBienvenida(this);

		pantallaActual = pantalla1;

		irAPantallaBien();
	}

	public void irAPantalla1() {
		menuBar.setVisible(true);
		irAPantalla(pantalla1);
	}

	public void irAPantalla2() {
		menuBar.setVisible(true);
		irAPantalla(pantalla2);
	}

	public void irAPantalla3() {
		menuBar.setVisible(true);
		irAPantalla(pantalla3);
	}

	public void irAPantalla(View pantalla) {
		String msj = pantallaActual.getTexto();
		frame.setContentPane(pantalla);
		frame.revalidate();
		pantallaActual = pantalla;
		pantalla.setTexto(msj);
	}

	public void irAPantallaBien() {
		menuBar.setVisible(false);
		frame.setContentPane(pb);
		frame.revalidate();
	}
}
