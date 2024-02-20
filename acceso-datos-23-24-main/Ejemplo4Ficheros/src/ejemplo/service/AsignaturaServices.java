package ejemplo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ejemplo.modelo.Asignatura;

public class AsignaturaServices {

	
	public List<Asignatura> consultarAsignaturas(){
		List<Asignatura> lista = new ArrayList<Asignatura>();
		for (int i = 0; i < 100; i++) {
			Asignatura a = new Asignatura();
			if (i%2==0) {
				a.setCiclo("DAM");
			}
			else {
				a.setCiclo("DAW");
			}
			a.setNombre("Ejemplo " + new Random().nextInt(1,292383));
			a.setId(i);
			lista.add(a);
		}
		return lista;
	}
}
