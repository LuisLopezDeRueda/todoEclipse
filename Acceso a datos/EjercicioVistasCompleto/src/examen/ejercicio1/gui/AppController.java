package examen.ejercicio1.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import examen.ejercicio1.modelo.Coche;
import examen.ejercicio1.services.ExamenService;

public class AppController {

	private JFrame frame;
	private ExamenService service;
	private List<Coche> listaCoches;
	private ViewBienvenida bienvenidaView;
	private ConsultarView consultarView;
	private AltaView altaView;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem irAlta;
	private JMenuItem irConsultar;
	private JMenuItem item;

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public ExamenService getService() {
		return service;
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController window = new AppController();
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
	public AppController() {
		irAlta = new JMenuItem();
		irConsultar = new JMenuItem();
		service = new ExamenService();
		listaCoches = new ArrayList<>();
		bienvenidaView = new ViewBienvenida(this);
		consultarView = new ConsultarView(this);
		altaView = new AltaView(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		menu = new JMenu();
		frame.setResizable(false);		
		frame.setBounds(100, 100, 746, 443);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		irBienvenida();
	}

	public void irAltaView() {
		menu();
		altaView.limpiar();
		irAlta.setVisible(false);
		irConsultar.setVisible(true);
		frame.setContentPane(altaView);
		frame.revalidate();
	}

	public void irConsultarView() {
		consultarView.limpiar();
		menu();
		irConsultar.setVisible(false);
		irAlta.setVisible(true);
		frame.setContentPane(consultarView);
		frame.revalidate();
	}

	public void irBienvenida() {
		menu.setVisible(false);
		bienvenidaView.limpiar();
		frame.setContentPane(bienvenidaView);
		frame.revalidate();
	}

	public void consultarTodosCoches() {
		listaCoches = service.consultarCoches();
		consultarView.actualizar();
	}

	public void consultar(Boolean disponibles) {
		if(disponibles) {
			listaCoches = service.consultarCochesDisponibles(true);
			
		}else
			listaCoches = service.consultarCochesDisponibles(false);
		
		consultarView.actualizar();
	}
	public void menu() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		menu = new JMenu("Menú");
		menuBar.add(menu);

		irAlta = new JMenuItem("Alta");
		irAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		menu.add(irAlta);

		irAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAltaView();
			}
		});
		
		irConsultar = new JMenuItem("Consultar");
		irConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		menu.add(irConsultar);
		
		irConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				irConsultarView();
			}
		});

		JMenuItem mntmCerrarSersion = new JMenuItem("Cerrar Sesión");
		mntmCerrarSersion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		menu.add(mntmCerrarSersion);

		mntmCerrarSersion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irBienvenida();
			}
		});

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		menu.add(mntmSalir);

		mntmSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salir();
				
			}
		});
	}
	
	public void añadirMarca(String marca) {
		if(marca.isBlank() || marca.isEmpty()) {
			
		}else
		service.añadirMarca(marca);
	}
	public void listaMarcas(JComboBox<String> combo) {
		combo.removeAllItems();
		List<String> listaMarcas = service.consultarMarcas();
		for(Integer i = 0; i < listaMarcas.size();i++) {
			combo.addItem(listaMarcas.get(i));
		}
	}
	public void salir() {
		if (JOptionPane.showConfirmDialog(item, "Estas seguro?", "¿Salir?",
				JOptionPane.YES_NO_OPTION) != 1) {
			System.exit(0);
		} else {

		}

	}

}
