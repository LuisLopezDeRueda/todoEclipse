package fct.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PantallaConsultarRegistros extends View{
	private JTable table;
	private TableModel tableModel;
	public PantallaConsultarRegistros(AppController appView) {
		super(appView);		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 73, 329, 174);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new TableModel();
		table.setModel(tableModel);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setBounds(264, 258, 114, 23);
		add(btnRefrescar);
		
		btnRefrescar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
	}	
	public void actualizarTabla() {
		tableModel.setListaRegistros(appView.devolverRegistro());
		tableModel.fireTableDataChanged();
	}
	private static final long serialVersionUID = 178404467208789073L;
}
