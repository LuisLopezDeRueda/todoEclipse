package ejemplo.services;

import org.hibernate.Session;

import ejemplo.jpa.HibernateUtil;
import ejemplo.modelo.Estadio;
import jakarta.persistence.PersistenceException;

public class EstadioService {
	
	public Estadio consultarEstadio(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			return session.get(Estadio.class, id);
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
