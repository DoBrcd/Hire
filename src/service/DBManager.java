package service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Customer;

public class DBManager
{
    private static EntityManager em = null;

    public static EntityManager getEntityManager()
    {
        if(em == null)
            em = Persistence.createEntityManagerFactory("default").createEntityManager();
        return em;
    }

	public static void addNewCustomer(Customer newClient) {
		getEntityManager().persist(newClient);
	}
}
