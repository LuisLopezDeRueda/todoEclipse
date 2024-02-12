package Modelo;

public class Articulo {
	private Integer cantidad;
	private String descripcion;
	private String codBarras;
	private Double precio;

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	@Override
	public String toString() {
		return "Cantidad : " + cantidad + " Descripcion : " + descripcion + " precio : " + precio + "\n";
	}

}
