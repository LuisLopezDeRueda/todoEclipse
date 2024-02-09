package TerceraFormaXML.Ejemplo;

import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "curso") //Para cambiar el root
public class Curso {

	//@JsonProperty("Descripcion") //Para cambiar el nombre de una etiqueta
	private String nombre;
	//@JsonIgnore // Para q no salga el atributo
	private Integer hora;
	@JacksonXmlElementWrapper(localName = "alumnos")
	@JsonProperty("alumno")
	private List<Alumno> alumnos;

	public Curso() {
		alumnos = new ArrayList<Alumno>();
	}

	public Curso(String nombre, Integer hora) {
		super();
		this.nombre = nombre;
		this.hora = hora;
		alumnos = new ArrayList<Alumno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", hora=" + hora + ", alumnos=" + alumnos + "]";
	}

}