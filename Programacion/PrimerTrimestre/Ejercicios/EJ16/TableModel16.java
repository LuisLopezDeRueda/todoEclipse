package EJ16;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel16 extends AbstractTableModel {
	private List<Persona> listaPersona;

	public TableModel16() {
		listaPersona = new ArrayList<>();
	}

	public List<Persona> getlistaPersona() {
		return listaPersona;
	}

	public void setlistaPersona(List<Persona> listaPersona) {
		this.listaPersona = listaPersona;
	}

	private static final long serialVersionUID = -9107002989344570986L;

	@Override
	public int getRowCount() {
		return listaPersona.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "nombre";
		} else if (column == 1) {
			return "apellidos";
		}
		return "Persona";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Persona PersonaFila = listaPersona.get(rowIndex);
		if (columnIndex == 0) {
			return PersonaFila.getNombre();
		}
		return PersonaFila.getApellido();

	}
}
