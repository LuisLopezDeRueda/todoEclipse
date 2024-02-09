package Modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pago {
	LocalDate fechaPago;
	BigDecimal cantidad;
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Pagos [fechaPago=" + fechaPago + ", cantidad=" + cantidad + "]";
	}
}
