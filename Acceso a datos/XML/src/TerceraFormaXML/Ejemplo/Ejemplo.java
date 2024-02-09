package TerceraFormaXML.Ejemplo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class Ejemplo {

	public static void main(String[] args) {
		Curso curso = new Curso("DAM", 7);
		Alumno alumno = new Alumno();
		Alumno alumno1 = new Alumno();
		alumno.setDni("1234K");
		alumno.setNombre("Carlos Camacho Nuñez");
		alumno1.setDni("5678L");
		alumno1.setNombre("Nuñez Camacho Carlos");
		curso.getAlumnos().add(alumno1);
		curso.getAlumnos().add(alumno);
		escribirXML(curso, "C:\\Users\\llopezderueda0480\\Pruebas/curso.xml");
	}

	public static void escribirXML(Curso curso, String path) {
		XmlMapper mapper = new XmlMapper();
		File file = new File(path);
		try {
			mapper.writeValue(file, curso);
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
