package fct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import fct.Modelo.Fecha;
import fct.Modelo.Registro;
import fct.Modelo.Usuario;

public class AppCliente {
	public static void main(String[] args) {
		String url = "http://10.50.22.0:8080";
		FCTCliente client = new FCTCliente(url, 3000);
		Registro registro =  new Registro();

		List<Fecha> listaFechas = client.consultarFechas();
		for (int i = 0; i < listaFechas.size(); i++) {
			System.out.println(listaFechas.get(i));
		}
		List<Registro> listaRegistros = client.consultarRegistros(2L);
		for (int i = 0; i < listaRegistros.size(); i++) {
			System.out.println(listaRegistros.get(i));
		}
		registro.setDate(LocalDate.now());
		registro.setDescripcion("OLE");
		registro.setId_usuario(2L);
		registro.setNumero_horas(new BigDecimal(2));
		client.insertarRegistros(registro);
		System.out.println(client.iniciarSesion("amos", "amos"));
		Usuario usuario = new Usuario();
		usuario.setActivo(false);
		usuario.setApellidos("Camacho");
		usuario.setCiclo("DAM");
		usuario.setEmail("Nashao");
		usuario.setNombre("Nashao");
		usuario.setPassword("Nashao");
		client.insertarUsuario(usuario);
	}

}
