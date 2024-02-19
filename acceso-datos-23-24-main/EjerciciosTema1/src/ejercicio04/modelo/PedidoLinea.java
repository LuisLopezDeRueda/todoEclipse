package ejercicio04.modelo;

import java.math.BigDecimal;

public class PedidoLinea {

	private Long idPedido;
	private Integer numLinea;
	private String articulo;
	private BigDecimal precio;
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getNumLinea() {
		return numLinea;
	}
	public void setNumLinea(Integer numLinea) {
		this.numLinea = numLinea;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "PedidoLinea [idPedido=" + idPedido + ", numLinea=" + numLinea + ", articulo=" + articulo + ", precio="
				+ precio + "]";
	}
	
	

}
