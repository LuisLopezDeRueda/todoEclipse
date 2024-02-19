package ejemplo.xmlFinal;

import java.util.List;

import ejemplo.xmlFinal.modelo.Animal;
import ejemplo.xmlFinal.service.AnimalService;
import ejemplo.xmlFinal.service.AnimalesXMLException;

public class Test {

	public static void main(String[] args) {
		try {
			AnimalService service = new AnimalService();
			List<Animal> animales = service.leerXMLSax("c:/temporal/xml/animales.xml");
			service.escribirXMLDom(animales, "c:/temporal/xml/animalesDom.xml");
			animales = service.leerXMLDom("c:/temporal/xml/animalesDom.xml");
			System.out.println(animales);
			
			service.escribirXMLJackson(animales, "c:/temporal/xml/animalesJackson.xml");
			System.out.println(service.leerXMLJackson("c:/temporal/xml/animalesDom.xml"));
			
		} catch (AnimalesXMLException e) {
			e.printStackTrace();
		}
	}
}
