package examen.ejercicio1.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.ejercicio1.modelo.Coche;

public class TableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112205562326517127L;
	private List<Coche> listaCoches;

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public TableModel() {
		listaCoches = new ArrayList<>();
	}

	@Override
	public int getRowCount() {

		return listaCoches.size();
	}

	@Override
	public int getColumnCount() {

		return 5;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Marca";
		} else if (column == 1) {
			return "Modelo";
		} else if (column == 2) {
			return "Matrícula";
		} else if (column == 3) {
			return "Año";
		} else {
			return "Disponible";
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coche coche = listaCoches.get(rowIndex);
		if (columnIndex == 0) {
			return coche.getMarca();
		}
		if (columnIndex == 1) {
			return coche.getModelo();
		}
		if (columnIndex == 2) {
			return coche.getMatricula();
		}
		if (columnIndex == 3) {
			return coche.getAño();
		}
		if(coche.getDisponible()) {
			return "Si";
		}else
			return "No";

	}

}
