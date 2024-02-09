package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Ficheros.Asignatura;

public class AsignaturaService {

	public List<Asignatura> consultarAsgiantura() {
		List<Asignatura> lista = new ArrayList<>();
		for (Integer i = 0; i < 100; i++) {
			Asignatura a = new Asignatura();
			if (i % 2 == 0) {
				a.setCiclo("DAM");
			} else {
				a.setCiclo("DAW");
			}
			a.setNombre("Ejemplo " + new Random().nextInt(1, 150));
			a.setId(i);
			lista.add(a);
		}
		return lista;

	}
}
