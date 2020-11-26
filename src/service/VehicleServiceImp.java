package service;

import java.util.List;

import dao.VehicleDao;
import dao.VehicleDaoInterface;
import model.Airplane;
import model.Car;
import model.Motorbike;
import model.Vehicle;

public class VehicleServiceImp implements VehicleServiceInterface {
	VehicleDaoInterface vehicleDao=new VehicleDao();
	/**
	 * lister toutes les vehicules
	 * @param null
	 * @return List de toutes les vehicules
	 */
	@Override
	public List<Vehicle> getAll() {
		//  Auto-generated method stub
		return vehicleDao.getAll();
	}
	/**
	 * lister toutes les vehicules par type
	 * 
	 * @param string type
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAllParType(String type){
		return vehicleDao.getAllParType(type);
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
	 * @param un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */

	@Override
	public Vehicle add(Vehicle v) {
		//  Auto-generated method stub
		return this.vehicleDao.add(v);
	}
	/**
	 * modifier un vehicule
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	@Override
	public Vehicle update(Vehicle v) {
		//  Auto-generated method stub
		return vehicleDao.update(v);
	}
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
	@Override
	public boolean delete(int v) {
		//  Auto-generated method stub
		return vehicleDao.delete(v);
	}
	/**
	 * pour recuperer tous les Models
	 * @param null
	 * @return liste de tous les Models
	 */
	@Override
	public List<String> getAllModels() {
		//  Auto-generated method stub
		return vehicleDao.getAllModels();
	}
	/**
	 * pour recuperer tous les brand
	 * @param null
	 * @return liste de tous les brand
	 */
	@Override
	public List<String> getAllBrand() {
		//  Auto-generated method stub
		return vehicleDao.getAllBrand();
	}
	
	/**
	 * lister toutes les vehicules par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Vehicle> getAllByCriteria(String model,String brand){
		return vehicleDao.getAllByCriteria( model, brand);
	}
	
	/**
	 * lister toutes les vehicules par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Car> getAllCarByCriteria(String model,String brand){
		return vehicleDao.getAllCarByCriteria( model, brand);
	}
	/**
	 * lister toutes les vehicules par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Airplane> getAllAirplaneByCriteria(String model,String brand){
		return vehicleDao.getAllAirplaneByCriteria( model, brand);
	}
	/**
	 * lister toutes les vehicules par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Motorbike> getAllMotorbikeByCriteria(String model,String brand){
		return vehicleDao.getAllMotorbikeByCriteria( model, brand);
	}

}
