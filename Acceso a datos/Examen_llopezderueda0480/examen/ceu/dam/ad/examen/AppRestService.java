package ceu.dam.ad.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ceu.dam.ad.examen.exceptions.InvalidParamException;

@SpringBootApplication
@EnableAutoConfiguration
public class AppRestService {

	public static void main(String[] args) throws InvalidParamException {
		SpringApplication.run(AppRestService.class, args);
	}

}
