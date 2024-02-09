package app.guiLogin.PantallasControllers;

import java.util.ArrayList;
import java.util.List;

import practica.modelo.Persona;

public class PersonaService {
	public List<Persona> getPersonas() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		List<Persona> lista = new ArrayList<Persona>();
		for (Integer i = 0; i < 10; i++) {
			Persona persona = new Persona();
			persona.setDni("" + i);
			persona.setEdad(i);
			persona.setNombre("" + i);
			lista.add(persona);
		}
		return lista;
	}
}
