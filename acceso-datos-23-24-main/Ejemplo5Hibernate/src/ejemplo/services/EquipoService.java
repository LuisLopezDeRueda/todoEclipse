package ejemplo.services;

import org.hibernate.Session;

import ejemplo.jpa.HibernateUtil;
import ejemplo.modelo.Equipo;
import jakarta.persistence.PersistenceException;

public class EquipoService {
	
	public void insertarEquipo(Equipo equipo) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(equipo);
			session.getTransaction().commit();
		}
		catch(PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public void actualizarEquipo(Equipo equipo) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.merge(equipo);
			session.getTransaction().commit();
		}
		catch(PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public void borrarEquipo(Equipo equipo) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.remove(equipo);
			session.getTransaction().commit();
		}
		catch(PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public Equipo consultarEquipo(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			return session.get(Equipo.class, id);
		}
		catch(PersistenceException e) {
			throw e;
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
	}


}
