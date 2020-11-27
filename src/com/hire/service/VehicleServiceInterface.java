package com.hire.service;

import com.hire.model.Airplane;
import com.hire.model.Car;
import com.hire.model.Motorbike;
import com.hire.model.Vehicle;

import java.util.List;

public interface VehicleServiceInterface {
	/**
	 * Lists all vehicles
	 * @return List of all the vehicles
	 */
	public List<Vehicle> getAll();

	/**
	 * Retrieves a vehicle by its id
	 * @param id Identifier of the vehicle
	 * @return The found vehicle if any, else null
	 */
	public Vehicle getById(int id);

	/**
	 * Lists all vehicles by a specific type (car, plane, ...)
	 *
	 * @param type The type of vehicles we want to get (Car, Motorbike, Airplane)
	 * @return The list of all the vehicles of the given type
	 */
	public List<Vehicle> getAllByType(String type);

	/**
	 * Adds a new vehicle in data source
	 * @param v The new vehicle to add
	 * @return The newly added vehicle
	 */
	public Vehicle add(Vehicle v);

	/**
	 * Updates a vehicle
	 * @param v The vehicle that has been modified. The instance of the corresponding vehicle in datasource will be
	 *          updated according to this given instance
	 * @return The newly modified vehicle
	 */
	public Vehicle update(Vehicle v);

	/**
	 * Returns the list of all free vehicles (not hired) during a period
	 * @param dateBegin Beginning date of the period
	 * @param dateEnd Ending date of the period
	 * @return List of all free vehicles
	 */
	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd);

	/**
	 * Deletes a vehicle
	 * @param v The vehicles to delete in datasource
	 * @return boolean True if it has succeeded, else false
	 */
	public boolean delete(int v);

	/**
	 * Retrieves the list of all available models
	 * @return List of all different vehicles models
	 */
	public List<String> getAllModels();

	/**
	 * Retrieves the list of all available brands
	 * @return List of all different vehciles brands
	 */
	public List<String> getAllBrand();

	/**
	 * List all vehicles according to model and brand criteria
	 *
	 * @param model The searched model
	 * @param brand The searched brand
	 * @return List of all vehicles of the given brand and model
	 */
	public List<Vehicle> getAllByCriteria(String model,String brand);

	/**
	 * List all cars according to model and brand criteria
	 *
	 * @param model The searched model
	 * @param brand The searched brand
	 * @return List of all cars of the given brand and model
	 */
	public List<Car> getAllCarByCriteria(String model,String brand);

	/**
	 * List all airplane according to model and brand criteria
	 *
	 * @param model The searched model
	 * @param brand The searched brand
	 * @return List of all airplane of the given brand and model
	 */
	public List<Airplane> getAllAirplaneByCriteria(String model,String brand);

	/**
	 * List all motorbike according to model and brand criteria
	 *
	 * @param model The searched model
	 * @param brand The searched brand
	 * @return List of all motorbike of the given brand and model
	 */
	public List<Motorbike> getAllMotorbikeByCriteria(String model,String brand);

}
