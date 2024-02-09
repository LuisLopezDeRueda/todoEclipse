package Test;

import java.util.ArrayList;
import java.util.List;

import Ficheros.Asignatura;
import Service.CVSservice;
import Service.FicheroException;

public class Test {

	public static void main(String[] args) {
		CVSservice service = new CVSservice();
		List<Asignatura> lista = new ArrayList<>();
		try {
		//	service.ConsultarCVSservice("C:\\Users\\llopezderueda0480\\OneDrive - Fundación Universitaria San Pablo CEU\\Escritorio\\Cosas\\asignatura.csv");
			
			lista = service.LeerCSV("C:\\Users\\llopezderueda0480\\OneDrive - Fundación Universitaria San Pablo CEU\\Escritorio\\Cosas\\asignatura.csv");
			
		} catch (FicheroException e) {
			
			e.printStackTrace();
		}
		for (Asignatura asignatura : lista) {
			System.out.println(asignatura);
		}
	}

}
