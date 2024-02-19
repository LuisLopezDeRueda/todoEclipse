package ceu.dam.ad.ejerciciosTema2.ejercicio6.solucion.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ceu.dam.ad.ejerciciosTema2.ejercicio6.solucion.modelo.Ciudad;


public class CiudadesClientImpl implements CiudadesClient {

	private String urlBase;
	private RestTemplate restTemplate;
	
	public CiudadesClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public List<Ciudad> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city?filtroDescripcion={filtroDescripcion}";
			System.out.println("Invocando API REST con URL " + url);
			return Arrays.asList(restTemplate.getForObject(url, Ciudad[].class, filtroDescripcion));
		}
		catch(HttpStatusCodeException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				throw new CiudadNoEncontradaException("No hay ciudades con el filtro indicado");
			}
			if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new CiudadErrorException("Error en el servidor", e);
			}
			throw e;
		}
	}

	@Override
	public Ciudad getCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city/{id}";
			System.out.println("Invocando API REST con URL " + url);
			return restTemplate.getForObject(url, Ciudad.class, id);
		}
		catch(HttpStatusCodeException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				throw new CiudadNoEncontradaException("No se ha encontrado la ciudad con id " + id);
			}
			if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new CiudadErrorException("Error en el servidor", e);
			}
			throw e;
		}
	}

	@Override
	public Ciudad createCity(Ciudad city) throws CiudadErrorException {
		try {
			String url = urlBase + "/city";
			System.out.println("Invocando API REST con URL " + url);
			return restTemplate.postForObject(url, city, Ciudad.class);
		}
		catch(HttpStatusCodeException e) {
			if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new CiudadErrorException("Error en el servidor", e);
			}
			throw e;
		}
	}

	@Override
	public void updateCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city";
			System.out.println("Invocando API REST con URL " + url);
			restTemplate.put(url, city);
		}
		catch(HttpStatusCodeException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				throw new CiudadNoEncontradaException("No se ha encontrado la ciudad con id " + city.getId());
			}
			if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new CiudadErrorException("Error en el servidor", e);
			}
			throw e;
		}
	}

	@Override
	public Ciudad updateSelectiveCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city";
			System.out.println("Invocando API REST con URL " + url);
			return restTemplate.patchForObject(url, city, Ciudad.class);
		}
		catch(HttpStatusCodeException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				throw new CiudadNoEncontradaException("No se ha encontrado la ciudad con id " + city.getId());
			}
			if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new CiudadErrorException("Error en el servidor", e);
			}
			throw e;
		}
	}

	@Override
	public void deleteCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city/{id}";
			System.out.println("Invocando API REST con URL " + url);
			restTemplate.delete(url, id);
		}
		catch(HttpStatusCodeException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				throw new CiudadNoEncontradaException("No se ha encontrado la ciudad con id " + id);
			}
			if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new CiudadErrorException("Error en el servidor", e);
			}
			throw e;
		}
	}

}
