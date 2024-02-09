package EJ17;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Servicio.PeliculasException;
import Servicio.PeliculasService;

public class EJ17 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EJ17 window = new EJ17();
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
	public EJ17() {
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 43, 360, 149);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		TableModel17 model = new TableModel17();

		table.setModel(model);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(287, 213, 112, 23);
		frame.getContentPane().add(btnConsultar);
		PeliculasService peliculas = new PeliculasService();

		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.setlistaPelicula(peliculas.consultarPeliculas());
					model.fireTableDataChanged();
				} catch (PeliculasException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

}
