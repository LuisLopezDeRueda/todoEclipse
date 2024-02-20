package ejemploclienterest;

import ejemplorest.modelo.Deporte;

public class Test {

	public static void main(String[] args) {
		DeporteClient client = new DeporteClient("http://10.50.22.7:8080", 2000);
		Deporte deporte = client.consultarDeporte(63);
		System.out.println("Deporte consultado: " + deporte);
		Deporte deporte2 = client.crearDeporte(deporte);
		System.out.println("Deporte creado: " + deporte2);
	}

}
