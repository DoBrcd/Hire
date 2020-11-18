package service;

import javax.persistence.EntityExistsException;
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

	public static int addNewCustomer(Customer newClient) {
		try {
			getEntityManager().getTransaction().begin();
			em.persist(newClient);
			em.flush();
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			return -1;
		}
		return newClient.getId();
	}
}