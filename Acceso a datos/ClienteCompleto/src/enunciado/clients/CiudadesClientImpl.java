package enunciado.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import enunciado.modelo.Ciudad;

public class CiudadesClientImpl implements CiudadesClient {
	private String urlBase;
	private RestTemplate resTemplate;

	public CiudadesClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory resquestFactory = new HttpComponentsClientHttpRequestFactory();
		resquestFactory.setConnectionRequestTimeout(msTimeout);
		this.resTemplate = new RestTemplate(resquestFactory);
	}

	@Override
	public List<Ciudad> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException {

		try {
			String url = urlBase + "/city?filtroDescripcion=" + filtroDescripcion;
			Ciudad[] cuidades = resTemplate.getForObject(url, Ciudad[].class);
			return Arrays.asList(cuidades);

		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad con el id  ");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("No existe la ciudad con el id  ");
			}
			throw e;
		}
	}

	@Override
	public Ciudad getCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {

		try {
			String url = urlBase + "/city/{id}";
			Ciudad ciudad = resTemplate.getForObject(url, Ciudad.class, id);
			return ciudad;

		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad con el id  " + id);
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("No existe la ciudad con el id  " + id);
			}
			throw e;
		}
	}

	@Override
	public Ciudad createCity(Ciudad city) throws CiudadErrorException {

		try {
			String url = urlBase + "/city";
			return resTemplate.postForObject(url, city, Ciudad.class);

		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("No existe la ciudad con el id  ");
			}
			throw e;
		}
	}

	@Override
	public void updateCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {

		try {
			String url = urlBase + "/city";
			resTemplate.put(url, city);

		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad con el id  ");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("No existe la ciudad con el id  ");
			}
			throw e;
		}
	}

	@Override
	public Ciudad updateSelectiveCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {

		try {
			String url = urlBase + "/city";
			city = resTemplate.patchForObject(url, city, Ciudad.class);
			return city;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad con el id  ");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("No existe la ciudad con el id  ");
			}
			throw e;
		}
	}

	@Override
	public void deleteCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city/{id}";
			resTemplate.delete(url, id);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad con el id  ");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("No existe la ciudad con el id  ");
			}
			throw e;
		}

	}

}
