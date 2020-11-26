package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Hire;
import model.Vehicle;
import service.DBManager;

public class HireDao implements HireDaoInterface {

	private EntityManager em = DBManager.getEntityManager();
	/**
	 * Cr�er une location
	 * 
	 * @param une location
	 */
	public void create(Hire hire) {
		try {
			em.getTransaction().begin();
			em.persist(hire);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * lister toutes les loactions
	 * @param null
	 * @return List de toutes les loactions
	 */
	public List<Hire> getAll(){
		if (em != null) {
			try {
				  List<Hire> hires = (List<Hire>) em.createQuery("select p from Hire p").getResultList();
				  return hires;
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
	 * recuperer un loaction par id
	 * @param id de la loaction
	 * @return un loaction ou null
	 */
	public Hire getById(int id){
		return em.find(Hire.class, id);
	}

	/**
	 * modifier un loaction
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return loaction modifée
	 */
	public Hire update(Hire v){

		if (em != null) {
			try {
				em.getTransaction().begin();
				em.merge(v);
				em.flush();
				em.getTransaction().commit();
				return v;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
			}
		} else {
			System.out.println("DB server down.....");
		}
		return null;
	}
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
	public boolean delete(int v){
		if (em != null) {
			try {
				Vehicle hire = em.find(Vehicle.class, v);
				em.getTransaction().begin();
				em.remove(hire);
				em.flush();
				em.getTransaction().commit();
				return true;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user dara: " + exception.getMessage());
			}
		} else {
			System.out.println("DB server down.....");
			return false;
		}
		return false;
	}
}
