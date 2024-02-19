package ceu.ad.tema4.ejercicio3.solucion.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import ceu.ad.tema4.ejercicio3.solucion.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio3.solucion.modelo.CentroComercial;
import ceu.ad.tema4.ejercicio3.solucion.modelo.Marca;
import ceu.ad.tema4.ejercicio3.solucion.modelo.Pais;
import ceu.ad.tema4.ejercicio3.solucion.modelo.Tienda;
import jakarta.persistence.PersistenceException;

public class ComercialServiceImpl implements ComercialService{

	private static final String OPERACION_ELIMINAR = "ELIMINAR";
	private static final String OPERACION_INSERTAR = "INSERTAR";

	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			String sql = "select * from pais where descripcion like '" + filtro + "%'";
			NativeQuery<Pais> query = session.createNativeQuery(sql, Pais.class);
			List<Pais> resultados = query.getResultList();
			return resultados;
		} 
		catch (PersistenceException e) {
			System.err.println("Error consultando países: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	

	
	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			CentroComercial cc = session.get(CentroComercial.class, UUID.fromString(uuidCentro));
			if (cc == null) {
				throw new NotFoundException("No existe el centro comercial con id " + uuidCentro);
			}
			return cc;
		}
		catch (PersistenceException e) {
			System.err.println("Error consultando centro comercial: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			Tienda tienda = session.get(Tienda.class, idTienda);
			if (tienda == null) {
				throw new NotFoundException("No existe la Tienda con id " + idTienda);
			}
			return tienda;
		}
		catch (PersistenceException e) {
			System.err.println("Error consultando Tienda: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		actualizarEntidad(marca, OPERACION_INSERTAR);
	}

	@Override
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		actualizarEntidad(cc, OPERACION_INSERTAR);
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		try {
			Tienda tienda = consularTienda(idTienda);
			actualizarEntidad(tienda, OPERACION_ELIMINAR);
		} catch (NotFoundException e) {
			// No nos dicen que hagamos nada si no existe lo que vamos a borrar
		}		
	}

	@Override
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		try {
			CentroComercial cc = consultarCentroComercial(uuidCentro);
			actualizarEntidad(cc, OPERACION_ELIMINAR);
		} catch (NotFoundException e) {
			// No nos dicen que hagamos nada si no existe lo que vamos a borrar
		}
	}


	private void actualizarEntidad(Object o, String operacion) throws ComercialException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			session.getTransaction().begin();
			switch (operacion) {
				case OPERACION_INSERTAR: session.persist(o);break;
				case OPERACION_ELIMINAR: session.remove(o);break;
				default:
					throw new RuntimeException("Se ha indicado un valor incorrecto para operación : "+ operacion);
			}
			session.getTransaction().commit();
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error actualizando objeto en bbdd: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}
	}
	
	
	
}
