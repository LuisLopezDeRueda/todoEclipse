package ejemplo.xmlFinal.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Habitat {
	private String pais;
	private String zona;
	@JsonIgnore
	private String clima;
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	@Override
	public String toString() {
		return "Habitat [pais=" + pais + ", zona=" + zona + ", clima=" + clima + "]";
	}
	
	
}
