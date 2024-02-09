package EJ17;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Modelo.Pelicula;

public class TableModel17 extends AbstractTableModel{
	private List<Pelicula> listaPelicula;

	public TableModel17() {
		listaPelicula = new ArrayList<>();
	}

	public List<Pelicula> getlistaPelicula() {
		return listaPelicula;
	}

	public void setlistaPelicula(List<Pelicula> listaPelicula) {
		this.listaPelicula = listaPelicula;
	}

	private static final long serialVersionUID = -9107002989344570986L;

	@Override
	public int getRowCount() {
		return listaPelicula.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Longitud";
		}
		return "Titulo";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pelicula PeliculaFila = listaPelicula.get(rowIndex);
		if (columnIndex == 0) {
			return PeliculaFila.getId();
		}if (columnIndex == 1) {
			return PeliculaFila.getLongitud();
		}
		return PeliculaFila.getTitulo();

	}
}
