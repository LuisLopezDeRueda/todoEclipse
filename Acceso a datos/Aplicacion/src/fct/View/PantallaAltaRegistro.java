package fct.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fct.Modelo.Registro;

public class PantallaAltaRegistro extends View {
	protected JComboBox<String> comboBox;

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public PantallaAltaRegistro(AppController appView) {
		super(appView);
		setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 56, 116, 22);
		add(comboBox);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 31, 99, 14);
		add(lblFecha);

		JLabel lblhoras = new JLabel("Horas");
		lblhoras.setBounds(10, 89, 99, 14);
		add(lblhoras);

		JSlider slider = new JSlider();

		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setValue(0);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(16);
		slider.setBounds(151, 138, 310, 23);
		add(slider);

		JLabel lblHorasCambian = new JLabel("0");
		lblHorasCambian.setBounds(471, 138, 46, 22);
		add(lblHorasCambian);

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				BigDecimal valor = new BigDecimal(slider.getValue()).divide(new BigDecimal(2), 1,
						RoundingMode.HALF_DOWN);
				lblHorasCambian.setText(valor.toString());
			}
		});

		JLabel lblTareas = new JLabel("Tareas realizadas: ");
		lblTareas.setBounds(10, 140, 181, 14);
		add(lblTareas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 208, 107);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(272, 279, 89, 23);
		add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse((String) comboBox.getSelectedItem(), formato);
				registro.setDate(date);
				registro.setDescripcion(textArea.getText());
				registro.setNumero_horas(new BigDecimal(lblHorasCambian.getText()));
				appView.registrarRegistro(registro);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(371, 279, 89, 23);
		add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irPatallaBienvenida();
			}
		});

	
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 198382778813266863L;
}
