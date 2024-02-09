package fct;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import fct.Modelo.Fecha;
import fct.Modelo.Registro;
import fct.Modelo.Usuario;

public class FCTCliente {
	private String urlBase;
	private RestTemplate resTemplate;

	public FCTCliente(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory resquestFactory = new HttpComponentsClientHttpRequestFactory();
		resquestFactory.setConnectionRequestTimeout(msTimeout);
		this.resTemplate = new RestTemplate(resquestFactory);
	}

	public List<Fecha> consultarFechas() {
		String url = urlBase + "/fechasActuales";
		Fecha[] fechas = resTemplate.getForObject(url, Fecha[].class);
		return Arrays.asList(fechas);
	}

	public List<Registro> consultarRegistros(Long idUsuario) {
		String url = urlBase + "/registros/usuario/" + idUsuario;
		Registro[] registros = resTemplate.getForObject(url, Registro[].class);
		return Arrays.asList(registros);
	}

	public void insertarRegistros(Registro registro) {
		String url = urlBase + "/registro";
		resTemplate.postForObject(url, registro, Registro.class);
	}

	public Usuario iniciarSesion(String usuario, String password) {
		String url = urlBase + "/login?email=" + usuario + "&password=" + password;
		Usuario usuario2 = resTemplate.getForObject(url, Usuario.class);
		return usuario2;
	}

	public void insertarUsuario(Usuario usuario) {
		String url = urlBase + "/usuario";
		resTemplate.postForObject(url, usuario, Usuario.class);
	}

}
