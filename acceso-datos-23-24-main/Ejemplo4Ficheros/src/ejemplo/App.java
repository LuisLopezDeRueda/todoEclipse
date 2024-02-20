package ejemplo;

import java.util.ArrayList;
import java.util.List;

import ejemplo.modelo.Alumno;
import ejemplo.modelo.Curso;
import ejemplo.xml.CursosXMLException;
import ejemplo.xml.dom.XmlCursosDomServices;
import ejemplo.xml.jackson.XMLJacksonService;
import ejemplo.xml.sax.XMLCursosSaxServices;

public class App {

	public static void main(String[] args) {
		// testCrearXMLCurso();
		
		// testLeerXMLCurso();
		
		// testLeerXMLCursoSax();
	
		testCrearXMLCursoJackson();
		
	}
	
	private static void testCrearXMLCursoJackson() {
		// Nos creamos un curso
		Alumno a1 = new Alumno("4324X", "Alberto Ávila");
		Alumno a2 = new Alumno("3432D", "Carlos Camacho");
		Curso c1 = new Curso("DAM", 7);
		c1.getAlumnos().add(a1);
		c1.getAlumnos().add(a2);
		Curso c2 = new Curso("ASIR", 2);
		c2.getAlumnos().add(a1);
		c2.getAlumnos().add(a2);
		List<Curso> cursos = new ArrayList<>();
		cursos.add(c1);
		cursos.add(c2);
			
		// Llamamos al servicio para que genere el XML
		XMLJacksonService service = new XMLJacksonService();
		try {
			service.escribirXMLCurso("c:/temporal/cursoJackson.xml", cursos);
			System.out.println("Todo OK");
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
	}


	private static void testLeerXMLCursoSax() {
		XMLCursosSaxServices service = new XMLCursosSaxServices();
		try {
			List<Curso> cursos = service.leerCursos("c:/temporal/cursos.xml");
			for (Curso curso : cursos) {
				System.out.println(curso);
			}

		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void testLeerXMLCurso() {
		XmlCursosDomServices service = new XmlCursosDomServices();
		try {
			List<Curso> cursos = service.leerXMLCursos("c:/temporal/cursos.xml");
			System.out.println(cursos);
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
	}

	private static void testCrearXMLCurso() {
		// Generamos lista de cursos de ejemplo para probar el XML
		List<Curso> cursos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Alumno a1 = new Alumno("4324X", "Alberto Ávila");
			Alumno a2 = new Alumno("3432D", "Carlos Camacho");
			Curso c1 = new Curso("DAM", 7);
			c1.getAlumnos().add(a1);
			c1.getAlumnos().add(a2);
			
			Curso c2 = new Curso("ASIR", 7);
			c2.getAlumnos().add(a1);
			c2.getAlumnos().add(a2);
			cursos.add(c1);
			cursos.add(c2);
		}
		
		// Llamamos al servicio para que genere el XML
		XmlCursosDomServices service = new XmlCursosDomServices();
		try {
			service.crearXMLCursos(cursos, "c:/temporal/cursos.xml");
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
	}

}
