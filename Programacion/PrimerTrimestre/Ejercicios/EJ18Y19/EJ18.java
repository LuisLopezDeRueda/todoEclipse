package EJ18Y19;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Modelo.Pelicula;
import Servicio.PeliculasException;
import Servicio.PeliculasService;
import javax.swing.JCheckBox;

public class EJ18 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EJ18 window = new EJ18();
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
	public EJ18() {
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

		TableModel18 model = new TableModel18();

		table.setModel(model);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(287, 213, 112, 23);
		frame.getContentPane().add(btnConsultar);

		JCheckBox chckbxID = new JCheckBox("ID");
		chckbxID.setSelected(true);
		chckbxID.setBounds(39, 195, 97, 23);
		frame.getContentPane().add(chckbxID);

		JCheckBox chckbxLongitud = new JCheckBox("Longitud");
		chckbxLongitud.setSelected(true);
		chckbxLongitud.setBounds(39, 213, 97, 23);
		frame.getContentPane().add(chckbxLongitud);

		JCheckBox chckbxTitulo = new JCheckBox("Titulo");
		chckbxTitulo.setSelected(true);
		chckbxTitulo.setBounds(39, 231, 97, 23);
		frame.getContentPane().add(chckbxTitulo);
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

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> listaComlum = new ArrayList<String>();
				if (chckbxID.isSelected()) {
					listaComlum.add("ID");

				}
				if (chckbxLongitud.isSelected()) {
					listaComlum.add("Longitud");
				}
				if (chckbxTitulo.isSelected()) {
					listaComlum.add("Titulo");

				}
				model.setListaColumna(listaComlum);
				model.fireTableStructureChanged();
			}
		});
		Comparator<Pelicula> comparatorTitulo = new Comparator<Pelicula>() {

			@Override
			public int compare(Pelicula o1, Pelicula o2) {
				return o1.getTitulo().compareTo(o2.getTitulo());
			}

		};
		Comparator<Pelicula> comparatorLongitud = new Comparator<Pelicula>() {

			@Override
			public int compare(Pelicula o1, Pelicula o2) {
				return o1.getLongitud().compareTo(o2.getLongitud());
			}

		};
		Comparator<Pelicula> comparatorID = new Comparator<Pelicula>() {

			@Override
			public int compare(Pelicula o1, Pelicula o2) {
				return o1.getId().compareTo(o2.getId());
			}

		};
		table.getTableHeader().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Integer colum = table.columnAtPoint(e.getPoint());
				if (colum == 0) {
					model.getlistaPelicula().sort(comparatorID);
				}
				if (colum == 1) {
					model.getlistaPelicula().sort(comparatorLongitud);
				}
				if (colum == 2) {
					model.getlistaPelicula().sort(comparatorTitulo);
				}
			}
		});

	}
}
