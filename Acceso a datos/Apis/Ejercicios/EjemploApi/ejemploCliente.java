 package EjemploApi;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import EjemploApi.Service.Deporte;

public class ejemploCliente {
	private String urlBase;
	private RestTemplate resTemplate;

	public ejemploCliente(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory resquestFactory = new HttpComponentsClientHttpRequestFactory();
		resquestFactory.setConnectionRequestTimeout(msTimeout);
		this.resTemplate = new RestTemplate(resquestFactory);
	}

	public Deporte consultarDeporte(Integer id) {
		String url = urlBase + "/Deporte?id=" + id;
		return resTemplate.getForObject(url, Deporte.class);
	}

	public Deporte crearDeporte(Deporte deporte) {
		String url = urlBase +"/Deportes";
		return resTemplate.postForObject(url, deporte, Deporte.class);
	}

}
