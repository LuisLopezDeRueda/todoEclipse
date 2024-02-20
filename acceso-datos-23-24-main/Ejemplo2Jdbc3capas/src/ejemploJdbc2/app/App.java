package ejemploJdbc2.app;

import java.util.List;

import ejemploJdbc2.modelo.Actor;
import ejemploJdbc2.servicios.ActoresServiceException;
import ejemploJdbc2.servicios.ActoresServices;

public class App {
	public static void main(String[] args) {
		ActoresServices service = new ActoresServices();
		List<Actor> actores;
		try {
			actores = service.consultarActores();
			for (Actor actor : actores) {
				System.out.println(actor);
			}
		} catch (ActoresServiceException e) {
			e.printStackTrace();
		}
	}
}
