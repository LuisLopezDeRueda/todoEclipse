package Prueba;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Persona> lista = Persona();
		for (Integer i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(0).toString());
		}

	}

	public static ArrayList<Persona> Persona() {
		ArrayList<Persona> lista = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		for (Integer i = 0; i < 3; i++) {
			System.out.println("Diga el nombre de la persona " + (1 + i));
			lista.add(new Persona());
			lista.get(i).setNombre(scanner.nextLine());
			System.out.println("Diga el DNI de la persona " + (1 + i));
			lista.get(i).setDni(scanner.nextLine());
		}
		scanner.close();
		return lista;

	}

}
