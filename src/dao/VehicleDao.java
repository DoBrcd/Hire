package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Vehicle;
import service.DBManager;

public class VehicleDao implements VehicleDaoInterface {
	
	private EntityManager em=DBManager.getEntityManager();
	
	@Override
	public List<Vehicle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle getByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle add(Vehicle v) {
		  EntityTransaction transac = em.getTransaction();
		    transac.begin();
		    em.merge(v);
		    transac.commit();
			return v;
	}

	@Override
	public Vehicle update(Vehicle v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Vehicle v) {
		// TODO Auto-generated method stub
		return false;
	}

}
