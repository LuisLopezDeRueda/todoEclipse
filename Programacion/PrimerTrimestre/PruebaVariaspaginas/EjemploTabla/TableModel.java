package EjemploTabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private List<Pais> listaPaises;

	public TableModel() {
		listaPaises = new ArrayList<>();
	}

	public List<Pais> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<Pais> listaPaises) {
		this.listaPaises = listaPaises;
	}

	private static final long serialVersionUID = -9107002989344570986L;

	@Override
	public int getRowCount() {
		return listaPaises.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "código";
		} else if (column == 1) {
			return "nombre";
		} else if (column == 2) {
			return "poblacion";
		}
		return "poblacion";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pais paisFila = listaPaises.get(rowIndex);
		if(columnIndex == 0) {
			return paisFila.getCodigo();
		}if(columnIndex == 1) {
			return paisFila.getNobre();
		}
		return paisFila.getPoblacion();
	}

}
