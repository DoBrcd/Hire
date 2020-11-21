package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Vehicle;
import service.DBManager;

public class VehicleDao implements VehicleDaoInterface {
	
	private EntityManager em=DBManager.getEntityManager();
	
	@Override
	public List<Vehicle> getAll() {
		  List<Vehicle> vehicles = em.createQuery("Select v From Vehicle v",
				  Vehicle.class).getResultList();
		  return vehicles;
	}

	@Override
	public Vehicle getByid(Long id) {
		
		return em.find(Vehicle.class, id);
	}

	@Override
	public Vehicle add(Vehicle v) {
		 em.getTransaction().begin();
		 em.persist(v);
		 em.getTransaction().commit();
			return v;
	}

	@Override
	public Vehicle update(Vehicle v) {

		 em.getTransaction().begin();
	     em.merge(v);
	     em.getTransaction().commit();
	  	 return v;
				
		  			
	}

	@Override
	public boolean delete(Vehicle v) {
			try {
			  em.getTransaction().begin();
			  em.remove(v);
			  em.getTransaction().commit();
			  return true;
				
			}catch(Exception e) {
				return false;
			}
		 
	}

}
