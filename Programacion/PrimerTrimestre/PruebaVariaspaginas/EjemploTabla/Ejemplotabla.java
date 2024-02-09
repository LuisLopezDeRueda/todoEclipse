package EjemploTabla;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Ejemplotabla {

	private JFrame frame;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplotabla window = new Ejemplotabla();
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
	public Ejemplotabla() {
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
		scrollPane.setBounds(52, 66, 322, 148);
		frame.getContentPane().add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		TableModel model = new TableModel();
		
		tabla.setModel(model);
		
		JButton btnNuevoPais = new JButton("Añadir País");
		btnNuevoPais.setBounds(244, 225, 133, 23);
		frame.getContentPane().add(btnNuevoPais);
		
		btnNuevoPais.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais();
				pais.setCodigo("ES");
				pais.setNobre("ESPAÑA");
				pais.setPoblacion(45000000);
				model.getListaPaises().add(pais);
				model.fireTableDataChanged();
			}
		});
	}
}
