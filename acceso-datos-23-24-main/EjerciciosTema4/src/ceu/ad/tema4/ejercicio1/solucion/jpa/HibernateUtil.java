package ceu.ad.tema4.ejercicio1.solucion.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ceu.ad.tema4.ejercicio1.solucion.modelo.Episodio;
import ceu.ad.tema4.ejercicio1.solucion.modelo.Serie;
import ceu.ad.tema4.ejercicio1.solucion.modelo.Temporada;
import ceu.ad.tema4.ejercicio1.solucion.modelo.Trailer;

public class HibernateUtil {

	private static SessionFactory sessionFactoy;

	public static SessionFactory getSessionFactoy() {
		if (sessionFactoy == null) {
			init();
		}
		return sessionFactoy;
	}

	private static void init() {
		try {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg1.xml")
					.build();

			Metadata metadata = new MetadataSources(serviceRegistry)
					.addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Temporada.class)
					.addAnnotatedClass(Trailer.class)
					.addAnnotatedClass(Episodio.class) 
					.getMetadataBuilder().build();

			sessionFactoy = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
}
