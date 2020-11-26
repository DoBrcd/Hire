package com.hire.dao;

import com.hire.model.Airplane;
import com.hire.model.Car;
import com.hire.model.Motorbike;
import com.hire.model.Vehicle;

import java.util.List;

public interface VehicleDaoInterface {
	/**
	 * lister toutes les vehicules
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAll();
	
	
	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd);
	
	/**
	 * lister toutes les vehicules
	 * 
	 * @param type null
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAllParType(String type);
	/**
	 * recuperer un vehicule par id
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	public Vehicle getById(int id);
	/**
	 * ajouter un vehicule
	 * @param v un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */
	public Vehicle add(Vehicle v);
	/**
	 * modifier un vehicule
	 * @param v instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	public Vehicle update(Vehicle v);
	/**
	 * pour supprimer un vehcule
	 * @param v instance conteine le id
	 * @return boolean true ou false
	 */
	public boolean delete(int v);
	
	
	/**
	 * pour recuperer tous les models
	 * @return liste de tous les model
	 */
	public List<String> getAllModels();
	/**
	 * pour recuperer tous les brand
	 * @return liste de tous les brand
	 */
	public List<String> getAllBrand();
	
	/**
	 * lister toutes les vehicules par critaria
	 * @param model String model,String brand,String type
	 * @param brand The brand
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	public List<Vehicle> getAllByCriteria(String model,String brand);
	
	/**
	 * lister toutes les voitures par critaria
	 * @param model model,String brand,String type
	 * @return List de toutes les voitures correpondant aux critaire
	 */
	public List<Car> getAllCarByCriteria(String model,String brand);
	/**
	 * lister toutes les avions par critaria
	 * @param model String model,String brand,String type
	 * @return List de toutes les avions correpondant aux critaire
	 */
	public List<Airplane> getAllAirplaneByCriteria(String model,String brand);
	/**
	 * lister toutes les moto par critaria
	 * @param model String model,String brand,String type
	 * @return List de toutes les moto correpondant aux critaire
	 */
	public List<Motorbike> getAllMotorbikeByCriteria(String model,String brand);
}