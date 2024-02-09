package examen.ejercicio1.gui;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;

public class ViewBienvenida extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1137389173270482608L;
	
	private JCheckBox checkBox;
	private JButton btnEntrar;

	public ViewBienvenida(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblBienvenida = new JLabel("Bienvenido a CarShop");
		lblBienvenida.setForeground(new Color(255, 0, 255));
		lblBienvenida.setFont(new Font("Freestyle Script", Font.PLAIN, 80));
		lblBienvenida.setBounds(144, 11, 542, 103);
		add(lblBienvenida);

		JLabel lblCondiciones = new JLabel("Acepta las condiciones");
		lblCondiciones.setBounds(213, 149, 160, 14);
		add(lblCondiciones);

		checkBox = new JCheckBox("");
		checkBox.setBounds(379, 138, 110, 38);
		add(checkBox);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(313, 224, 89, 23);
		add(btnEntrar);

		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irConsultarView();
			}
		});
		btnEntrar.setEnabled(false);
		checkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					btnEntrar.setEnabled(true);
				}else {
					btnEntrar.setEnabled(false);
				}
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(470, 224, 89, 23);
		add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				appView.salir();
			}
		});
	}
	public void limpiar() {
		btnEntrar.setEnabled(false);
		checkBox.setSelected(false);
	}
}
