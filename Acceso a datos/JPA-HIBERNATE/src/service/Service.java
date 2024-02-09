package service;

import org.hibernate.Session;

import OpenConection.HibernateUtil;
import jakarta.persistence.PersistenceException;
import modelo.Equipo;
import modelo.Estadio;
import modelo.Jugador;

public class Service {

	private Session session;

	public void insertarEquipo(Equipo equipo) {

		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			// Aqui hacemos la insercion
			session.persist(equipo);

			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	public void borrarEquipo(Equipo equipo) {
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			// Aqui hacemos la insercion
			session.remove(equipo);

			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}

	}

	public void actualiarEquipo(Equipo equipo) {
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			// Aqui hacemos la insercion
			session.merge(equipo);

			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	public Equipo consultarEquipo(Integer numero) {
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			Equipo equipo = session.get(Equipo.class, numero);
			// Aqui hacemos la insercion
			return equipo;

		} catch (PersistenceException e) {
			throw e;
		}
	}

	public Estadio consultarEstadio(Integer numero) {
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			Estadio equipo = session.get(Estadio.class, numero);
			// Aqui hacemos la insercion
			return equipo;

		} catch (PersistenceException e) {
			throw e;
		}

	}

	public Jugador consultarJugador(String numero) {
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			Jugador equipo = session.get(Jugador.class, numero);
			// Aqui hacemos la insercion
			return equipo;

		} catch (PersistenceException e) {
			throw e;
		}

	}

}
