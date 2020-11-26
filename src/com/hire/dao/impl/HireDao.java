package com.hire.dao.impl;

import com.hire.dao.HireDaoInterface;
import com.hire.model.Hire;
import com.hire.service.DBManager;

import javax.persistence.EntityManager;

public class HireDao implements HireDaoInterface
{

	private EntityManager em = DBManager.getEntityManager();
	/**
	 * Créer une location
	 * 
	 * @param hire une location
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
