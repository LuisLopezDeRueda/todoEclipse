package TerceraFormaXML.Ejercicio1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "libros")
public class Libros {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("libro")
	private List<Libro> libros;

	public void setPeliculas(List<Libro> peliculas) {
		this.libros = peliculas;
	}

	@Override
	public String toString() {
		return "Libros [libros=" + libros + "]";
	}
	
}
