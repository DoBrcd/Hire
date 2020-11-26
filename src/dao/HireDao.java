package dao;

import javax.persistence.EntityManager;

import model.Hire;
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
}
