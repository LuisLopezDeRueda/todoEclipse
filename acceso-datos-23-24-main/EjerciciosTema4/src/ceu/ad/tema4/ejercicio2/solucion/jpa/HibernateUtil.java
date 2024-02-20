package ceu.ad.tema4.ejercicio2.solucion.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ceu.ad.tema4.ejercicio2.solucion.modelo.*;

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
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg2.xml")
					.build();

			Metadata metadata = new MetadataSources(serviceRegistry)
					.addAnnotatedClass(Pedido.class)
					.addAnnotatedClass(PedidoLinea.class)
					.addAnnotatedClass(Articulo.class)
					.addAnnotatedClass(Cliente.class) 
					.getMetadataBuilder().build();

			sessionFactoy = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
}
