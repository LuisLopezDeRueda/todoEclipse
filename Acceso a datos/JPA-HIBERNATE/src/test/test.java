package test;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.Estadio;
import modelo.Jugador;
import modelo.Socio;
import service.Service;

public class test {
	// Cuando sea un many to many se pone el joincolum donde este al fk en la bd
	public static void main(String[] args) {
		/*
		 * Equipo equipo = new Equipo(); equipo.setNombre("Chicago Bulls");
		 * equipo.setNum_jugadores(13); Service service = new Service(); Estadio estadio
		 * = new Estadio(); estadio.setDireccion("1231"); estadio.setNombre("Carlos");
		 * equipo.setEstadio(estadio); service.insertarEquipo(equipo); Equipo equipo1 =
		 * service.consultarEquipo(18); System.out.println(equipo1);
		 * System.out.println(equipo1.getEstadio()); //service.borrarEquipo(equipo);
		 * //System.out.println("Consultar el equipo despues de borrar " +
		 * service.consultarEquipo(equipo.getId())); Estadio estadio1 =
		 * service.consultarEstadio(10); System.out.println(estadio1);
		 * System.out.println(estadio.getEquipo());
		 *
		 * Service service = new Service(); Equipo equipo = new Equipo();
		 * equipo.setNombre("Chicago Bulls"); equipo.setNum_jugadores(13); Estadio
		 * estadio = new Estadio(); estadio.setDireccion("1231");
		 * estadio.setNombre("Carlos"); equipo.setEstadio(estadio); Jugador jugador =
		 * new Jugador(); jugador.setCodigo("uno"); jugador.setDorsal(1);
		 * jugador.setNombre("uno"); Jugador jugador2 = new Jugador();
		 * jugador2.setCodigo("dos"); jugador2.setDorsal(2); jugador2.setNombre("dos");
		 * jugador.setEquipo(equipo); jugador2.setEquipo(equipo);
		 * equipo.getJugadores().add(jugador); equipo.getJugadores().add(jugador2);
		 * service.insertarEquipo(equipo); System.err.
		 * println("Equipo -------------------------------------------------------------"
		 * ); System.out.println(service.consultarEquipo(equipo.getId()) + "\n" +
		 * equipo.getJugadores()); System.err.
		 * println("Jugador ------------------------------------------------------------"
		 * ); Jugador jugadorfianl = service.consultarJugador("uno");
		 * System.out.println(jugadorfianl);
		 * System.out.println(jugadorfianl.getEquipo());
		 */
		Service service = new Service();

		Equipo equipo = new Equipo();

		Estadio estadio = new Estadio();

		estadio.setDireccion("ad2");
		estadio.setNombre("nombre");

		equipo.setNombre("nombre");
		equipo.setNum_jugadores(1);
		equipo.setEstadio(estadio);

		List<Socio> listaSocio = new ArrayList<Socio>();
		Socio socio = new Socio();
		socio.setNombre("Socio");
		listaSocio.add(socio);
		equipo.setSocio(listaSocio);

		service.insertarEquipo(equipo);
		Equipo equipo2 = service.consultarEquipo(41);
		System.out.println(equipo2);
		System.out.println(equipo2.getSocio());

	}
}
