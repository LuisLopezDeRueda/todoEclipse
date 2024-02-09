package ceu.dam.ad.examen.ej4restServicesClients;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaRestClientImpl implements CategoriaRestClient {

	private String urlBase;
	private RestTemplate resTemplate;

	public CategoriaRestClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory resquestFactory = new HttpComponentsClientHttpRequestFactory();
		resquestFactory.setConnectionRequestTimeout(msTimeout);
		this.resTemplate = new RestTemplate(resquestFactory);
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) throws InvalidParamException, AccessDatabaseException {
		try {
			String url = urlBase + "/categoria";
			Categoria categoriaa = resTemplate.postForObject(url, categoria, Categoria.class);
			return categoriaa;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new InvalidParamException();
			}
			if (e.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
				throw new AccessDatabaseException();
			}
			throw e;
		}
	}

	@Override
	public Categoria consultarCategoria(Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		try {
			String url = urlBase + "/categoria/{id}";
			Categoria categoria = resTemplate.getForObject(url, Categoria.class, id);
			return categoria;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new InvalidParamException();
			}
			if (e.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
				throw new AccessDatabaseException();
			}
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException();
			}
			throw e;
		}
	}

}
