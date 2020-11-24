package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Customer;
import model.Vehicle;
import service.DBManager;

public class VehicleDao implements VehicleDaoInterface {
	
	private EntityManager em=DBManager.getEntityManager();
	/**
	 * lister toutes les vehicules
	 * @param null
	 * @return List de toutes les vehicules
	 */
	@Override
	public List<Vehicle> getAll() {

			if (em != null) {
				try {
					  List<Vehicle> vehicles = (List<Vehicle>) em.createQuery("select p from Vehicle p").getResultList();
					  return vehicles;
				} catch (Exception exception) {
					System.out.println("Exception occured while reading user data: " + exception.getMessage());
					return null;
				}

			} else {
				System.out.println("DB server down.....");
			}
			return null;
	}
	/**
	 * recuperer un vehicule par id
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	@Override
	public Vehicle getByid(Long id) {
		
		return em.find(Vehicle.class, id);
	}
	/**
	 * ajouter un vehicule
	 * @param un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */
	@Override
	public Vehicle add(Vehicle v) {
		 em.getTransaction().begin();
		 em.persist(v);
		 em.getTransaction().commit();
			return v;
	}
	/**
	 * modifier un vehicule
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	@Override
	public Vehicle update(Vehicle v) {

		 em.getTransaction().begin();
	     em.merge(v);
	     em.getTransaction().commit();
	  	 return v;
				
		  			
	}
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
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
	
	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd){
		if (em != null) {
			try {
				String query = "SELECT v FROM Vehicle v WHERE v.id NOT IN( SELECT h.idVehicle_fk FROM Hire h WHERE ('"+ dateBegin + "' >= h.dateBegining AND '" + dateBegin + "' <= h.dateEnding) OR ('"+ dateEnd + "' >= h.dateBegining AND '"+ dateEnd +"' <= h.dateEnding))";
				  List<Vehicle> vehicles = (List<Vehicle>) em.createQuery(query).getResultList();
				  return vehicles;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
				return null;
			}

		} else {
			System.out.println("DB server down.....");
		}
		return null;		
	}

}
