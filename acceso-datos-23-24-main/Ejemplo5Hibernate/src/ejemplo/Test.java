package ejemplo;

import java.util.ArrayList;
import java.util.Random;

import ejemplo.modelo.Equipo;
import ejemplo.modelo.Estadio;
import ejemplo.modelo.Jugador;
import ejemplo.services.EquipoService;
import ejemplo.services.EstadioService;

public class Test {

	public static void main(String[] args) {
		EquipoService serviceEquipo = new EquipoService();
		EstadioService serviceEstadio = new EstadioService();
		
		Equipo equipo = new Equipo();
		equipo.setNombre("Bulls");
		equipo.setNumJugadores(13);
		Estadio estadio = new Estadio();
		estadio.setNombre("Estadio Maravilla");
		estadio.setDireccion("Avda de los lugares perdidos");
		equipo.setEstadio(estadio);
		
		equipo.setJugadores(new ArrayList<Jugador>());
		for (int i = 0; i < 3; i++) {
			Jugador jugador = new Jugador();
			jugador.setCodigo("COD"+i+10);
			jugador.setDorsal(new Random().nextInt(10,30));
			jugador.setNombre("Lucía de los Ángeles " + i);
			equipo.getJugadores().add(jugador);
		}
		
		
		serviceEquipo.insertarEquipo(equipo);
		Long idEquipo = equipo.getId();
		System.out.println("\n>>> Id generado: " + idEquipo);
		
		equipo = serviceEquipo.consultarEquipo(idEquipo);
		System.out.println("\n>>> Equipo consultado: " + equipo);
		System.out.println("  >> Jugadores: " + equipo.getJugadores());
//		
//		equipo.setNombre("Sevilla Basket");
//		equipo.setNumJugadores(98);
//		service.actualizarEquipo(equipo);
		
//		equipo = service.consultarEquipo(2L);
//		System.out.println("\n>>> Equipo consultado tras actualizar: " + equipo);
//		
//		service.borrarEquipo(equipo);
//		equipo = service.consultarEquipo(2L);
//		System.out.println("\n>>> Equipo consultado tras borrar: " + equipo);
		
//		
		
	}

}
