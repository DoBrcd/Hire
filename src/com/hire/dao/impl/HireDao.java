package com.hire.dao.impl;

import com.hire.dao.HireDaoInterface;
import com.hire.model.Hire;
import com.hire.model.Vehicle;
import com.hire.service.DBManager;

import javax.persistence.EntityManager;
import java.util.List;

public class HireDao implements HireDaoInterface {
    
	private EntityManager em = DBManager.getEntityManager();

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

	public List<Hire> getAll() {
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

	public Hire getById(int id) {
		return em.find(Hire.class, id);
	}

	public Hire update(Hire v) {

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

	public boolean delete(int v) {
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

	@Override
	public List<Hire> getAll(int code, String model, String brand, String typeVehicle, String research) {
		String query = "";
	
		switch (code) {
		/*** 1 **/
		case 0:
			query = "select p from Hire p";
			break;
		case 1://0001
			query = "select p from Hire p";
			break;
		case 2://0010
			query = "select h from Hire h inner join Vehicle v  where v.brand='"+brand+"'";
			break;
		case 3:
			query = "select p from Hire p";
			break;

		/** 2 ***/
		case 4:
			query = "select p from Hire p";
			break;
		case 5:
			query = "select p from Hire p";
			break;

		case 6:
			query = "select p from Hire p";
			break;
		case 7:
			query = "select p from Hire p";
			break;

		/**** 3 ****/
		case 8:
			query = "select p from Hire p";
			break;

		case 9:
			query = "select p from Hire p";
			break;
		case 10:
			query = "select p from Hire p";
			break;
		case 11:
			query = "select p from Hire p";
			break;
		/**** 4 ***/
		case 13:
			query = "select p from Hire p";
			break;

		case 14:
			query = "select p from Hire p";
			break;
		case 15:
			query = "select p from Hire p";
			break;
		default:

		}
		query = "select p from Hire p";
		if (em != null) {
			try {
			
				List<Hire> hires = (List<Hire>) em.createQuery(query).getResultList();
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
}
