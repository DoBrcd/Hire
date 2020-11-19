package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Customer;
import service.DBManager;

public class CustomerDao implements CustomerDaoInterface {
	EntityManager em = DBManager.getEntityManager();
	@Override
	public int createNew(Customer newClient) {
		try {
			em.getTransaction().begin();
			em.persist(newClient);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			return -1;
		}
		return newClient.getId();
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(int id) {
		return em.find(Customer.class, id);
	}

}
