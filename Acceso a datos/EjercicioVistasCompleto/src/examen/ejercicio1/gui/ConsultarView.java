package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6804179973286968512L;
	private JTable table;
	private TableModel tableModel;
	private JRadioButton rdbtnTodos; 
	private JRadioButton rdbtnSi; 
	private JRadioButton rdbtnNo; 
	
	public ConsultarView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblDisponibles = new JLabel("Sólo disponibles:");
		lblDisponibles.setBounds(142, 84, 112, 14);
		add(lblDisponibles);

		rdbtnSi = new JRadioButton("Sí");
		rdbtnSi.setBounds(240, 80, 45, 23);
		add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(287, 80, 45, 23);
		add(rdbtnNo);

		rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setSelected(true);
		rdbtnTodos.setBounds(334, 80, 79, 23);
		add(rdbtnTodos);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnNo) {
					rdbtnNo.setSelected(true);
					rdbtnSi.setSelected(false);
					rdbtnTodos.setSelected(false);
				}
				if (e.getSource() == rdbtnSi) {
					rdbtnNo.setSelected(false);
					rdbtnSi.setSelected(true);
					rdbtnTodos.setSelected(false);
				}
				if (e.getSource() == rdbtnTodos) {
					rdbtnNo.setSelected(false);
					rdbtnSi.setSelected(false);
					rdbtnTodos.setSelected(true);
				}
			}
		};
		rdbtnNo.addActionListener(actionListener);
		rdbtnSi.addActionListener(actionListener);
		rdbtnTodos.addActionListener(actionListener);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(419, 80, 89, 23);
		add(btnConsultar);

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNo.isSelected()) {
					appView.consultar(false);
				} else if (rdbtnSi.isSelected()) {
					appView.consultar(true);
				} else if (rdbtnTodos.isSelected()) {
					appView.consultarTodosCoches();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 115, 366, 174);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		tableModel = new TableModel();
		table.setModel(tableModel);

	}

	public void actualizar() {
		tableModel.setListaCoches(appView.getListaCoches());
		tableModel.fireTableDataChanged();
	} 
	public void limpiar() {
		rdbtnTodos.setSelected(true);
		rdbtnSi.setSelected(false);
		rdbtnNo.setSelected(false);
	}
}
