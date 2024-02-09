package Modelo;

import java.time.LocalDate;

public class Registro {

	private Integer id_registro;
	private Long id_usuario;
	private LocalDate date;
	private Integer numero_horas;
	private String descripcion;
	public Integer getId_registro() {
		return id_registro;
	}
	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getNumero_horas() {
		return numero_horas;
	}
	public void setNumero_horas(Integer numero_horas) {
		this.numero_horas = numero_horas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
