package ejemploclienterest;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import ejemplorest.modelo.Deporte;

public class DeporteClient {
	private String urlBase;
	private RestTemplate restTemplate;
	
	public DeporteClient(String urlBase, Integer timeoutMs) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(timeoutMs);
		restTemplate = new RestTemplate(factory);
	}
	
	public Deporte consultarDeporte(Integer id) {
		String url = urlBase + "/deporte?id=" + id;
		Deporte d = restTemplate.getForObject(url, Deporte.class);
		return d;
	}
	
	public Deporte crearDeporte(Deporte deporte) {
		String url = urlBase + "/deporte";
		Deporte d = restTemplate.postForObject(url, deporte, Deporte.class);
		return d;
	}
	
	
	
	

}
