package EjemploApi;

import EjemploApi.Service.Deporte;

public class Test {

	public static void main(String[] args) {
		ejemploCliente client = new ejemploCliente("http://localhost:8080", 3);
		Deporte deporte = client.consultarDeporte(63);
		System.out.println("Deporte consultado :" + deporte);
		Deporte deporte1 = client.crearDeporte(deporte);
		System.out.println("Deporte creado : " + deporte1);
	}
}
