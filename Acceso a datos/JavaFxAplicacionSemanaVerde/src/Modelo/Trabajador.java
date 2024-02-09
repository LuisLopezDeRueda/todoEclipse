package Modelo;

public class Trabajador {
	private String UUID_trabajador;
	private String nombre;
	private Boolean superUsuario;

	public Boolean getSuperUsuario() {
		return superUsuario;
	}

	public void setSuperUsuario(Boolean superUsuario) {
		this.superUsuario = superUsuario;
	}

	public String getUUID_trabajador() {
		return UUID_trabajador;
	}

	public void setUUID_trabajador(String uUID_trabajador) {
		UUID_trabajador = uUID_trabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
