package test;

import java.time.LocalDate;

import lombok.Data;

public @Data class Animales {
	private Integer id;
	private String raza;
	private String color;
	private LocalDate fechaNacimiento;
}
