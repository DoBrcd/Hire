package com.hire.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBManager {
	private static EntityManager em = null;

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