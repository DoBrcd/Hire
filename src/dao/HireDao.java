package dao;

import javax.persistence.EntityManager;

import model.Customer;
import model.Hire;
import model.StatePayement;
import model.Vehicle;
import service.DBManager;

public class HireDao implements HireDaoInterface {

	private EntityManager em = DBManager.getEntityManager();
	/**
	 * Créer une location
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
	 * Faire les calculs puis renvoie le prix de la location
	 * 
	 * @param le nombre de kilomètres, le prix de la location du véhicule et si il y a une réduction
	 * @return le prix
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction) {
		float prix = vehiclePrice;
		km -= 50;
		if(km > 0 && km <= 50) {
			prix += km * 0.5;
		}else if(km > 51 && km <= 150) {
			prix += 50 * 0.5;
			km -= 50;
			prix += km * 0.3;
		}else if(km > 151 && km <= 250) {
			prix += 50 * 0.5;
			km -= 50;
			prix += 100 * 0.3;
			km -= 100;
			prix += km * 0.2;
		}else {
			prix += 50 * 0.5;
			km -= 50;
			prix += 100 * 0.3;
			km -= 100;
			prix += 100 * 0.2;
			km -= 100;
			prix += km * 0.10;
		}
		
		if(reduction) {
			prix = (float) (prix * 0.9);
		}
		
		return prix;
	}
	/**
	 * Retourne la location en fonction de l'id
	 * @param l'id de la location
	 * @return la location
	 */
	public Hire getById(int idHire) {
		return em.find(Hire.class, idHire);
	}
	/**
	 * Met à jour la location après payement
	 * @param la nouvelle location
	 */	
	public void update(Hire hire) {
		if(em != null) {
			try {
				Hire entityHire = em.find(Hire.class, hire.getId());
				em.getTransaction().begin();
				entityHire.setKmExpected(hire.getKmExpected());
				entityHire.setPriceExpected(hire.getPriceExpected());
				entityHire.setPayement(StatePayement.Paid);
				em.getTransaction().commit();
			}catch(Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
			}
		} else {
			System.out.println("DB server down.....");
		}
	}

}
