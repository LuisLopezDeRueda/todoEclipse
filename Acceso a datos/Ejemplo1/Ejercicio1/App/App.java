package App;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
	public static void main(String[] args) {

		Set<Integer> set = new HashSet<Integer>();

		for (Integer i = 0; i < 6; i++) {
			set.add(i);
		}
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(4);
		set2.add(6);
		set2.add(8);
		set2.add(10);
		set2.add(12);

		Set<Integer> set3 = new HashSet<Integer>();
		for (Integer i = 0; i < 6; i++) {
			set3.add(i);
		}

		for (Integer i = 0; i < set.size(); i++) {
			if (set.contains(i) && set2.contains(i)) {
				set3.remove(i);
			} else {
				set3.add(i);
			}
		}
		System.out.println(set3);

		for (Integer i = 0; i < 25; i++) {
			if (i % 3 == 0) {
				System.out.println("Fizz " + i);
			}
			if (i % 5 == 0) {
				System.out.println("Buzz " + i);
			}
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("Fizz Buzz " + i);
			}
		}

		List<Integer> lista = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		List<Integer> lista3 = new ArrayList<>();
		for (Integer i = 0; i < 6; i++) {
			lista.add(i);
			lista2.add(i);
		}
		
		

		/*
		 * ActoresService actoreService = new ActoresService(); List<Actor> listaActores
		 * =new ArrayList<>(); try { listaActores = actoreService.consultarActores();
		 * for (Actor actor : listaActores) { System.out.println(actor); } } catch
		 * (ActoresServiceException e) { e.printStackTrace();
		 */
	}

}
