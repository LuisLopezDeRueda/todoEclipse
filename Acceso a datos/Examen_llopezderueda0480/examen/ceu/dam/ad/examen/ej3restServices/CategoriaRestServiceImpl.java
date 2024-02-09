package ceu.dam.ad.examen.ej3restServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.examen.ej2services.CategoriaServiceImpl;
import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

@RestController
public class CategoriaRestServiceImpl implements CategoriaRestService {

	@Override
	@PostMapping("/categoria")
	public Categoria crearCategoria(@RequestBody Categoria categoria)
			throws InvalidParamException, AccessDatabaseException {

		CategoriaServiceImpl service = new CategoriaServiceImpl();
		return service.crearCategoria(categoria.getName());
	}

	@Override
	@GetMapping("/categoria/{id}")
	public Categoria consultarCategoria(@PathVariable Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {

		CategoriaServiceImpl service = new CategoriaServiceImpl();
		return service.consultarCategoria(id);
	}

}
