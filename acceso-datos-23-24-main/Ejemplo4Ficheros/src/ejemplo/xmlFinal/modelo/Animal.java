package ejemplo.xmlFinal.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Animal {
	
	@JacksonXmlProperty(isAttribute = true)
	private Integer codigo;
	private String especie;
	private String subespecie;
	@JacksonXmlElementWrapper(localName =  "habitats")
	@JsonProperty("habitat")
	private List<Habitat> habitats;
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getSubespecie() {
		return subespecie;
	}
	public void setSubespecie(String subespecie) {
		this.subespecie = subespecie;
	}
	public List<Habitat> getHabitats() {
		return habitats;
	}
	public void setHabitats(List<Habitat> habitats) {
		this.habitats = habitats;
	}
	@Override
	public String toString() {
		return "Animal [codigo=" + codigo + ", especie=" + especie + ", subespecie=" + subespecie + ", habitats="
				+ habitats + "]";
	}
	
	

}
