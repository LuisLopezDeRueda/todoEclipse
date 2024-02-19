package ceu.ad.tema4.ejercicio1.modelo;

public class Trailer {

	private Long id;
	private Integer duracion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Trailer [id=" + id + ", duracion=" + duracion + "]";
	}

	
	
}
