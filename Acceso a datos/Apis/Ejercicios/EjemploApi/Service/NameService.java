package EjemploApi.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameService {
	
	@GetMapping("/nombre")
	public String getNombre() {
		return "Carlos Camacho Nuñez";
	}
	@GetMapping("/cuadrado")
	public Integer cuadrado(@RequestParam Integer numero) {
		return numero*numero;
	}
	@GetMapping("/potencia")
	public double potencia(@RequestParam Integer numero,@RequestParam Integer numero2) {
		return Math.pow(numero, numero2);
	}
	
	@GetMapping("/potencia2/{id}/{id2}")
	public double potencia2(@PathVariable Long id,@PathVariable Long id2) {
	    return Math.pow(id, id2);
	}
	@GetMapping("/Deporte")
	public Deporte getDeporte(@RequestParam Integer id) throws DeporteException {
		Deporte deporte = new Deporte();
		if(id == 99) {
			throw new DeporteException("No existe el deporte");
		}
		deporte.setId(id);
		deporte.setNombre("Futbol");
		deporte.setPersonas(id);
	    return deporte;
	}
	@PostMapping("/Deportes")
	public Deporte crearDeporte(@RequestBody Deporte deporte) { 
		deporte.setId(99);
		return deporte;
	}
}
