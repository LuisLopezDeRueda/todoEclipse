package ceu.ad.tema4.ejercicio1.modelo;

public class Episodio {
	private Long id;
	private String titulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Episodio [id=" + id + ", titulo=" + titulo + "]";
	}
	
	

}
