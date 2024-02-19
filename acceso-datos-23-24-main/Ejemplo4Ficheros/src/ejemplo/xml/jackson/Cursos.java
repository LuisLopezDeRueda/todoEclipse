package ejemplo.xml.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import ejemplo.modelo.Curso;

@JacksonXmlRootElement(localName = "cursos")
public class Cursos {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("curso")
	private List<Curso> cursos;

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	
	
}
