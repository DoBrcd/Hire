package com.hire.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Static class which gives access to the unique instance of JPA entity manager.
 */
public class DBManager {
	/**
	 * Reference to the shared instance of the entity manager.
	 */
	private static EntityManager em = null;

	/**
	 * Returns the entity manager
	 *
	 * If the entity manager doesn't exist yet, creates it and finally returns it
	 *
	 * @return The entity manager
	 */
	public static EntityManager getEntityManager() {
		try {
			if (em == null)
				em = Persistence.createEntityManagerFactory("default").createEntityManager();

		} catch (Exception e) {
			System.out.print("exption : " + e);
		}
		return em;
	}
}