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
	/**
	 * lister toutes les vehicules
	 * @return List de toutes les vehicules
	 */
	@Override
	public List<Vehicle> getAll() {
		return vehicleDao.getAll();
	}
	/**
	 * lister toutes les vehicules par type
	 * 
	 * @param type string type
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAllParType(String type){
		return vehicleDao.getAllByType(type);
	}
	/**
	 * recuperer un vehicule par id
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	@Override
	public Vehicle getById(int id) {
		//  Auto-generated method stub
		return vehicleDao.getById(id);
	}
	/**
	 * ajouter un vehicule
	 * @param v un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */

	@Override
	public Vehicle add(Vehicle v) {
		//  Auto-generated method stub
		return this.vehicleDao.add(v);
	}
	/**
	 * modifier un vehicule
	 * @param v instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	@Override
	public Vehicle update(Vehicle v) {
		//  Auto-generated method stub
		return vehicleDao.update(v);
	}
	/**
	 * pour supprimer un vehcule
	 * @param v instance conteine le id
	 * @return boolean true ou false
	 */
	@Override
	public boolean delete(int v) {
		//  Auto-generated method stub
		return vehicleDao.delete(v);
	}
	/**
	 * pour recuperer tous les Models
	 * @return liste de tous les Models
	 */
	@Override
	public List<String> getAllModels() {
		//  Auto-generated method stub
		return vehicleDao.getAllModels();
	}
	/**
	 * pour recuperer tous les brand
	 * @return liste de tous les brand
	 */
	@Override
	public List<String> getAllBrand() {
		//  Auto-generated method stub
		return vehicleDao.getAllBrand();
	}
	
	/**
	 * lister toutes les vehicules par critaria
	 * @param model String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Vehicle> getAllByCriteria(String model,String brand){
		return vehicleDao.getAllByCriteria( model, brand);
	}
	
	/**
	 * lister toutes les vehicules par critaria
	 * @param model String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Car> getAllCarByCriteria(String model,String brand){
		return vehicleDao.getAllCarByCriteria( model, brand);
	}
	/**
	 * lister toutes les vehicules par critaria
	 * @param model String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Airplane> getAllAirplaneByCriteria(String model,String brand){
		return vehicleDao.getAllAirplaneByCriteria( model, brand);
	}
	/**
	 * lister toutes les vehicules par critaria
	 * @param model String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Motorbike> getAllMotorbikeByCriteria(String model,String brand){
		return vehicleDao.getAllMotorbikeByCriteria( model, brand);
	}
	
	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd){
		return this.vehicleDao.getFreevehicle(dateBegin, dateEnd);
	}

}
