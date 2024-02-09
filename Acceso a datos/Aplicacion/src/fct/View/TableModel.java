package fct.View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fct.Modelo.Registro;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3821400823373654691L;
	private List<Registro>  listaRegistros;

	public TableModel() {
		listaRegistros = new ArrayList<Registro>();
	}

	public List<Registro> getListaRegistros() {
		return listaRegistros;
	}

	public void setListaRegistros(List<Registro> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	@Override
	public int getRowCount() {

		return listaRegistros.size();
	}

	@Override
	public int getColumnCount() {

		return 3;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Fecha";
		} else if (column == 1) {
			return "Horas";
		}
		return "Tareas";

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Registro registro = listaRegistros.get(rowIndex);
		if(columnIndex == 0) {
			return registro.getDate();
		}
		if(columnIndex == 1) {
			return registro.getNumero_horas();
		}
		return registro.getDescripcion();
		
	}

}
