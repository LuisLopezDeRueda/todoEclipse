package ejemplorest.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejemplorest.modelo.Deporte;

@RestController
public class DeporteServices {

	@GetMapping("/deporte")
	public Deporte getDeporte(@RequestParam Long id) throws DeporteNotFoundException {
		Deporte d = new Deporte();
		if (id == 99) {
			throw new DeporteNotFoundException("No existe el deporte con id 99");
		}
		d.setId(id);
		d.setNombre("Baloncesto");
		d.setTipo("Equipos");
		return d;
	}
	@PostMapping("/deporte")
	public Deporte crearDeporte(@RequestBody Deporte deporte) {
		System.out.println("Creando deporte en BBDD....");
		System.out.println(deporte);
		deporte.setId(99L);
		System.out.println("Deporte creado!!");
		return deporte;
	}
	
}
