package service;

import java.util.List;

import model.Airplane;
import model.Car;
import model.Motorbike;
import model.Vehicle;

public interface VehicleServiceInterface {
	/**
	 * lister toutes les vehicules
	 * @param null
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAll();
	/**
	 * recuperer un vehicule par id
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	public Vehicle getById(int id);
	/**
	 * lister toutes les vehicules par type
	 * 
	 * @param string type
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAllParType(String type);
	/**
	 * ajouter un vehicule
	 * @param un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */
	public Vehicle add(Vehicle v);
	/**
	 * modifier un vehicule
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	public Vehicle update(Vehicle v);
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */

	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd);

	public boolean delete(int v);
	/**
	 * pour recuperer tous les models
	 * @param null
	 * @return liste de tous les model
	 */
	public List<String> getAllModels();
	/**
	 * pour recuperer tous les brand
	 * @param null
	 * @return liste de tous les brand
	 */
	public List<String> getAllBrand();
	
	/**
	 * lister toutes les vehicules par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Vehicle> getAllByCriteria(String model,String brand);
	
	/**
	 * lister toutes les voitures par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les voitures correpondant aux critaire
	 */
	public List<Car> getAllCarByCriteria(String model,String brand);
	/**
	 * lister toutes les avions par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les avions correpondant aux critaire
	 */
	public List<Airplane> getAllAirplaneByCriteria(String model,String brand);
	/**
	 * lister toutes les moto par critaria
	 * @param String model,String brand,String type
	 * @return List de toutes les moto correpondant aux critaire
	 */
	public List<Motorbike> getAllMotorbikeByCriteria(String model,String brand);

}
