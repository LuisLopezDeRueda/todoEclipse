package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Modelo {
	private String talla;
	private String color;
	@JacksonXmlElementWrapper(localName= "codigosBarra")
	@JsonProperty("codigo")
	private List<String> codigosBarra;
	
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<String> getCodigosBarra() {
		return codigosBarra;
	}
	public void setCodigosBarra(List<String> codigosBarra) {
		this.codigosBarra = codigosBarra;
	}
	@Override
	public String toString() {
		return "Modelo [talla=" + talla + ", color=" + color + ", codigosBarra=" + codigosBarra + "]";
	}
	


}
