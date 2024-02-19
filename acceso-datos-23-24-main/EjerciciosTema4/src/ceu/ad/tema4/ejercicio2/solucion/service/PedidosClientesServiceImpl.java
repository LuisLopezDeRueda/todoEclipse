package ceu.ad.tema4.ejercicio2.solucion.service;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ceu.ad.tema4.ejercicio2.solucion.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio2.solucion.modelo.Articulo;
import ceu.ad.tema4.ejercicio2.solucion.modelo.Cliente;
import ceu.ad.tema4.ejercicio2.solucion.modelo.Pedido;
import jakarta.persistence.PersistenceException;

public class PedidosClientesServiceImpl implements PedidosClientesService {


	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		crearEntidad(cliente);
	}


	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		for (int i = 0; i<pedido.getLineas().size(); i++) {
			pedido.getLineas().get(i).setNumLinea(i+1);
		}
		return (Pedido) crearEntidad(pedido);

	}


	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		return (Articulo) crearEntidad(articulo);
	}

	
	private Object crearEntidad(Object entidad) throws PedidosClientesServiceException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			session.getTransaction().begin();
			session.persist(entidad);
			session.getTransaction().commit();
			return entidad;
			
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error registrando nueva entidad: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			session.getTransaction().begin();
			session.merge(cliente);
			session.getTransaction().commit();
			
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error actualizando cliente: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}		
	}


	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			Cliente cliente = session.get(Cliente.class, dni);
			if (cliente == null) {
				throw new NotFoundException("El cliente con dni " + dni + " no existe");
			}
			return cliente;
			
		} 
		catch (PersistenceException e) {
			System.err.println("Error consultando cliente: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}
	}


	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			Articulo articulo = session.get(Articulo.class, idArticulo);
			if (articulo == null) {
				throw new NotFoundException("El articulo con id " + idArticulo + " no existe");
			}
			return articulo;
			
		} 
		catch (PersistenceException e) {
			System.err.println("Error consultando articulo: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}
	}


	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactoy();
			session = factory.openSession(); 

			Pedido pedido = session.get(Pedido.class, UUID.fromString(uuid));
			if (pedido == null) {
				throw new NotFoundException("El pedido con uuid " + uuid + " no existe");
			}
			return pedido;
			
		} 
		catch (PersistenceException e) {
			System.err.println("Error consultando pedido: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}
	}
	
	
	
}
