package Modelo;

public class Cliente {
	private Integer id;
	private String fisrtName;
	private String lastName;
	private String email;
	private Boolean activo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrt_Name) {
		this.fisrtName = fisrt_Name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_Name) {
		this.lastName = last_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Datos del cliente [id=" + id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", email=" + email
				+ ", activo=" + activo + "]";
	}
	
}
