package ceu.dam.javafx.examen.model;

public class Coche {

	private String marca;
	private String modelo;
	private String año;
	private String matricula;
	private Integer precio;
	
	
	public Coche(String marca, String modelo, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
	}

	public Coche(String marca, String modelo, String año, String matricula, Integer precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.matricula = matricula;
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	
	

}
