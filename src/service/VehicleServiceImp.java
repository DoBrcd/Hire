package service;

import java.util.List;

import dao.VehicleDao;
import dao.VehicleDaoInterface;
import model.Vehicle;

public class VehicleServiceImp implements VehicleServiceInterface {
	VehicleDaoInterface vehicleDao=new VehicleDao();
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
		//  Auto-generated method stub
		return this.vehicleDao.add(v);
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
