package fct.View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fct.Modelo.Fecha;
import fct.Modelo.Registro;
import fct.Modelo.Usuario;
import fct.Service.FechasService;
import fct.Service.RegistroException;
import fct.Service.RegistroService;
import fct.Service.UsuarioException;
import fct.Service.UsuarioService;
import fct.Service.fechasException;

public class AppController {

	private JFrame frame;
	private SolicitarAcceso pantallaSoliciarAcceso;
	private PantallaRegistro patanllaRegistro;
	private PantallaBienvenida patanllaBienvenida;
	private PantallaConsultarRegistros pantallaConRegistro;
	private PantallaAltaRegistro pantallaAltaRegistro;
	private Usuario usuarioPrueba;

	public Usuario getUsuarioPrueba() {
		return usuarioPrueba;
	}

	public void setUsuarioPrueba(Usuario usuarioPrueba) {
		this.usuarioPrueba = usuarioPrueba;
	}

	private JMenuBar menuBar;

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
		usuarioPrueba = new Usuario();
		pantallaSoliciarAcceso = new SolicitarAcceso(this);
		patanllaBienvenida = new PantallaBienvenida(this);
		patanllaRegistro = new PantallaRegistro(this);
		pantallaConRegistro = new PantallaConsultarRegistros(this);
		pantallaAltaRegistro = new PantallaAltaRegistro(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnApp = new JMenu("App");
		menuBar.add(mnApp);

		irPatallaRegistro();

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mnApp.add(mntmCerrarSesion);

		mntmCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irPatallaRegistro();
			}
		});

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnApp.add(mntmSalir);

		mntmSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(mntmSalir, "Estas seguro?", "¿Salir?",
						JOptionPane.YES_NO_OPTION) != 1) {
					System.exit(0);
				} else {

				}
			}
		});

		JMenu mnRegistros = new JMenu("Registros");
		menuBar.add(mnRegistros);

		JMenuItem mntmRegistrarNuevo = new JMenuItem("Registrar registro");
		mnRegistros.add(mntmRegistrarNuevo);

		mntmRegistrarNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irPantallaAltaRegistro();
			}
		});

		JMenuItem mntmConsulRegistro = new JMenuItem("Consultar registro");
		mnRegistros.add(mntmConsulRegistro);
		;
		mntmConsulRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irPatallaConRegistos();
			}
		});
	}

	public void irPatallaSolicitarAcceso() {
		menuBar.setVisible(false);
		frame.setContentPane(pantallaSoliciarAcceso);
		frame.revalidate();
	}

	public void irPatallaBienvenida() {
		menuBar.setVisible(true);
		frame.setContentPane(patanllaBienvenida);
		frame.revalidate();
	}

	public void irPatallaRegistro() {
		menuBar.setVisible(false);
		frame.setContentPane(patanllaRegistro);
		frame.revalidate();
	}

	public void irPatallaConRegistos() {
		pantallaConRegistro.actualizarTabla();
		frame.setContentPane(pantallaConRegistro);
		frame.revalidate();
	}

	public void irPantallaAltaRegistro() {
		añadirListaFechas();
		frame.setContentPane(pantallaAltaRegistro);
		frame.revalidate();
	}

	public void iniciarSesion(String usuario, String contraseña) {
		UsuarioService usuarioService = new UsuarioService();
		try {
			usuarioPrueba = usuarioService.iniciarSesion(usuario, contraseña);
			patanllaBienvenida.actualizar();
			irPatallaBienvenida();

		} catch (UsuarioException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR AL INICIAR SESION", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void registrarUsuario(Usuario user) {
		UsuarioService usuarioService = new UsuarioService();
		try {
			usuarioService.registrarUsuario(user);
			JOptionPane.showMessageDialog(frame, "CORRECTO", "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
		} catch (UsuarioException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR AL CREAR EL USUARIO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void registrarRegistro(Registro registro) {
		RegistroService registroService = new RegistroService();
		try {
			registro.setId_usuario(usuarioPrueba.getId_usuario());
			registroService.insertarRegistros(registro);
			JOptionPane.showMessageDialog(frame, "CORRECTO", "REGISTRO REGISTRADO", JOptionPane.INFORMATION_MESSAGE);
		} catch (RegistroException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "PROBLEMA AL INSERTAR EL REGISTRO",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void añadirListaFechas() {
		JComboBox<String> combobox = pantallaAltaRegistro.getComboBox();
		FechasService fechasSevice = new FechasService();
		List<Fecha> listaFechas = new ArrayList<Fecha>();
		try {
			listaFechas = fechasSevice.consultarFechas();
		} catch (fechasException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "PROBLEMA AL CONSULTAR LAS FECHAS",
					JOptionPane.ERROR_MESSAGE);
		}
		if(listaFechas == null) {
			JOptionPane.showMessageDialog(frame, "ERROR CON LA LISTA ", "PROBLEMA AL CONSULTAR LAS FECHAS",
					JOptionPane.ERROR_MESSAGE);
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (int i = 1; i < listaFechas.size(); i++) {
			combobox.addItem((listaFechas.get(i)).getFecha().format(formato));
		}
	}
	public List<Registro> devolverRegistro(){
		RegistroService rs = new RegistroService();
		try {
			return rs.consultarRegistros(usuarioPrueba.getId_usuario());
		} catch (RegistroException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "PROBLEMA AL CONSULTAR LA LISTA DE REGISTROS",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
