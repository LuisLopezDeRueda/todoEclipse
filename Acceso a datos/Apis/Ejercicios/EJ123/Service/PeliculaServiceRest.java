package EJ123.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Modelo.Pelicula;
import Servicio.PeliculasException;
import Servicio.PeliculasService;

@RestController
public class PeliculaServiceRest {

	@GetMapping("/Pelicula")
	public List<Pelicula> getPelicula(@RequestParam Integer id) throws PeliculasAPIException {
		PeliculasService pelicservice = new PeliculasService();
		List<Pelicula> listapeliculas = new ArrayList<Pelicula>();
		if(id <= 20 || id >= 300) {
			throw new PeliculasAPIException("La pelicula es muy larga");
		}
		try {
			listapeliculas = pelicservice.consultarPeliculas(id);
		} catch (PeliculasException e) {
			System.out.println("Error con la lista" + e);
		}

		return listapeliculas;

	}

}
