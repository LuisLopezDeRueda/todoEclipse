package ceu.dam.javafx.examen.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ceu.dam.javafx.examen.model.Coche;

public class ExamenService{


	/** Devuelve la lista de coches de la marca indicada que contengan en su matricula lo que se indique como filtro
	 * @param marca, filtroMatricula
	 * @return
	 */
	public List<Coche> consultarCoches(String marca, String filtroMatricula){
		if (marca == null) {
			return new ArrayList<Coche>();
		}
		marca = marca.toUpperCase().trim();
		if (filtroMatricula==null || filtroMatricula.isEmpty()) {
			return bbdd.get(marca);
		}
		return bbdd.get(marca)
			    .stream()
			    .filter(x -> x.getMatricula().contains(filtroMatricula.toUpperCase()))
			    .collect(Collectors.toList());
	}
	
	
	
	/**Permite hacer login en la aplicación. Usuario válido es "EXAM"
	 * @param usuario y password
	 * @return
	 * @throws LoginIncorrectoException 
	 */
	public void login(String usuario, String password) throws LoginIncorrectoException{
		if (usuario == null) {
			throw new LoginIncorrectoException("Usuario/Password incorrecto");
		}
		if (!usuario.trim().equalsIgnoreCase("EXAM") && !usuario.trim().equalsIgnoreCase("DAM")) {
			throw new LoginIncorrectoException("Usuario/Password incorrecto");
		}
	}	
	
	
	
	
	
	
	
	// Ignorar este código...
	private static Map<String, List<Coche>> bbdd = new HashMap<String, List<Coche>>();
	private static List<Coche> seat = new ArrayList<Coche>();
	private static List<Coche> renault = new ArrayList<Coche>();
	private static List<Coche> bmw = new ArrayList<Coche>();
	private static List<Coche> toyota = new ArrayList<Coche>();
	static {
		toyota.add(new Coche("Toyota", "Auris", "2010", "1521FFD", 8532));
		toyota.add(new Coche("Toyota", "Auris", "2013", "4862DDD", 7896));
		toyota.add(new Coche("Toyota", "Rav4", "2016", "4862BRT", 15000));
		toyota.add(new Coche("Toyota", "Corolla", "2020", "8761DQT", 16100));
		toyota.add(new Coche("Toyota", "Yaris", "2012", "9661JKK", 4350));
		toyota.add(new Coche("Toyota", "Rav4", "2019", "4134NBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2005", "2521RFD", 8000));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000));
		seat.add(new Coche("Seat", "León", "2011", "0114BRT", 15500));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100));
		seat.add(new Coche("Seat", "León", "2020", "9661JKK", 4200));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000));
		seat.add(new Coche("Seat", "Toledo", "2005", "2521RFD", 8000));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000));
		seat.add(new Coche("Seat", "Toledo", "2011", "0114BRT", 15500));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100));
		seat.add(new Coche("Seat", "Toledo", "2020", "9661JKK", 4200));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896));
		renault.add(new Coche("Renault", "Laguna", "2017", "5562CRT", 3245));
		renault.add(new Coche("Renault", "Clío", "2020", "8551CQC", 11500));
		renault.add(new Coche("Renault", "Megane", "2008", "1555FPD", 12000));
		renault.add(new Coche("Renault", "Megane", "2003", "4662RWD", 10012));
		renault.add(new Coche("Renault", "Megane", "2010", "9001VVF", 6588));
		renault.add(new Coche("Renault", "Clío", "2009", "0034BWW", 1500));
		bbdd.put("TOYOTA", toyota);
		bbdd.put("SEAT", seat);
		bbdd.put("RENAULT", renault);
		bbdd.put("BMW", bmw);
		
	}
	
	

	
}
