package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipo")
	private Integer id;
	@Column(name = "nombre_equipo")
	private String nombre;
	@Column(name = "num_jugadores")
	private Integer num_jugadores;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estadio", nullable = false)
	private Estadio estadio;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "socio-equipos", joinColumns = { @JoinColumn(name = "id_equipo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_socio") })
	private List<Socio> socio;

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "id_equipo", nullable = false) Se pone el nombre del
	 * atributo de jugador q los une
	 */

	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Jugador> jugadores;

	public Equipo() {
		jugadores = new ArrayList<Jugador>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Socio> getSocio() {
		return socio;
	}

	public void setSocio(List<Socio> socio) {
		this.socio = socio;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNum_jugadores() {
		return num_jugadores;
	}

	public void setNum_jugadores(Integer num_jugadores) {
		this.num_jugadores = num_jugadores;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", num_jugadores=" + num_jugadores + ", estadio=" + estadio
				+  ", jugadores=" + jugadores + "]";
	}

	

}
