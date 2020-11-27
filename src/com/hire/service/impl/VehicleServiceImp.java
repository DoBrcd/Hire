package com.hire.service.impl;

import com.hire.dao.VehicleDaoInterface;
import com.hire.dao.impl.VehicleDao;
import com.hire.model.Airplane;
import com.hire.model.Car;
import com.hire.model.Motorbike;
import com.hire.model.Vehicle;
import com.hire.service.VehicleServiceInterface;

import java.util.List;

public class VehicleServiceImp implements VehicleServiceInterface
{
	VehicleDaoInterface vehicleDao=new VehicleDao();

	@Override
	public List<Vehicle> getAll() {
		return vehicleDao.getAll();
	}

	public List<Vehicle> getAllParType(String type){
		return vehicleDao.getAllByType(type);
	}

	@Override
	public Vehicle getById(int id) {
		//  Auto-generated method stub
		return vehicleDao.getById(id);
	}

	@Override
	public Vehicle add(Vehicle v) {
		//  Auto-generated method stub
		return this.vehicleDao.add(v);
	}

	@Override
	public Vehicle update(Vehicle v) {
		//  Auto-generated method stub
		return vehicleDao.update(v);
	}

	@Override
	public boolean delete(int v) {
		//  Auto-generated method stub
		return vehicleDao.delete(v);
	}

	@Override
	public List<String> getAllModels() {
		//  Auto-generated method stub
		return vehicleDao.getAllModels();
	}

	@Override
	public List<String> getAllBrand() {
		//  Auto-generated method stub
		return vehicleDao.getAllBrand();
	}

	public List<Vehicle> getAllByCriteria(String model,String brand){
		return vehicleDao.getAllByCriteria( model, brand);
	}

	public List<Car> getAllCarByCriteria(String model,String brand){
		return vehicleDao.getAllCarByCriteria( model, brand);
	}

	public List<Airplane> getAllAirplaneByCriteria(String model,String brand){
		return vehicleDao.getAllAirplaneByCriteria( model, brand);
	}

	public List<Motorbike> getAllMotorbikeByCriteria(String model,String brand){
		return vehicleDao.getAllMotorbikeByCriteria( model, brand);
	}
	
	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd){
		return this.vehicleDao.getFreevehicle(dateBegin, dateEnd);
	}

}
