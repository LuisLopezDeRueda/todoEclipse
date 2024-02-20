package ejemplorest.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameServices {

	@GetMapping("/name")
	public String getNombre() {
		return "Julio Alberto de los Lugares Comunes";
	}
	
	@GetMapping("/cuadrado")
	public Integer cuadrado(@RequestParam Integer numero) {
		return numero*numero;
	}
	
	@GetMapping("/potencia")
	public Double potencia(@RequestParam Integer base, @RequestParam Integer potencia) {
		return Math.pow(base, potencia);
	}
	
}
