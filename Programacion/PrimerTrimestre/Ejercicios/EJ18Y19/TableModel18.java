package EJ18Y19;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Modelo.Pelicula;

public class TableModel18 extends AbstractTableModel {
	private List<Pelicula> listaPelicula;
	private List<String> listaColumna;

	public TableModel18() {
		listaPelicula = new ArrayList<>();
		listaColumna = new ArrayList<String>();
		listaColumna.add("ID");
		listaColumna.add("Longitud");
		listaColumna.add("Titulo");
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

	public List<String> getListaColumna() {
		return listaColumna;
	}

	public void setListaColumna(List<String> listaColumna) {
		this.listaColumna = listaColumna;
	}

	@Override
	public int getColumnCount() {
		return listaColumna.size();
	}

	@Override
	public String getColumnName(int column) {
		return listaColumna.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int column) {
		Pelicula PeliculaFila = listaPelicula.get(rowIndex);
		String nombreColum = listaColumna.get(column);
		if (nombreColum.equals("ID")) {
			return PeliculaFila.getId();
		} else if (nombreColum.equals("Longitud")) {
			return PeliculaFila.getLongitud();
		}
		return PeliculaFila.getTitulo();

	}
}
