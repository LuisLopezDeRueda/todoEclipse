package EJ16;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EJ16 {

	private JFrame frame;
	private JTable table;
	private JTextField textNombres;
	private JTextField textApellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EJ16 window = new EJ16();
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
	public EJ16() {
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
		scrollPane.setBounds(50, 69, 329, 159);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		TableModel16 model = new TableModel16();
		table.setModel(model);

		textNombres = new JTextField();
		textNombres.setBounds(50, 27, 131, 20);
		frame.getContentPane().add(textNombres);
		textNombres.setColumns(10);
		Persona persona = new Persona();
		textNombres.addKeyListener(new KeyListener() {

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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!textNombres.getText().isBlank()) {
						persona.setNombre(textNombres.getText());
						textNombres.transferFocus();
					}
				}
			}
		});

		textApellidos = new JTextField();
		textApellidos.setBounds(248, 27, 131, 20);
		frame.getContentPane().add(textApellidos);
		textApellidos.setColumns(10);

		textApellidos.addKeyListener(new KeyListener() {

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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!textApellidos.getText().isBlank()) {
						persona.setApellido(textApellidos.getText());
						model.getlistaPersona().add(persona);
						model.fireTableDataChanged();
					}
				}

			}
		});
	}
}
