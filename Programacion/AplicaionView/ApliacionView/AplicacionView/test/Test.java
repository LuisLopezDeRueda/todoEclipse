package test;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Animales a = new Animales();

		a.setColor("Rojo");
		a.setFechaNacimiento(LocalDate.now());
		a.setId(1);
		a.setRaza("Perro");
		System.out.println(a);
	}

}
