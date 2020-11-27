package com.hire.dao;

import com.hire.model.Hire;

import java.util.List;

public interface HireDaoInterface {
	/**
	 * Save a new hire in datasource
	 * 
	 * @param hire The new hire to persist in datasource
	 */
	public void create(Hire hire);
	
	/**
	 * Lists all the hiring
	 * @return List of all the hiring
	 */
	public List<Hire> getAll();

	/**
	 * List of hiring corresponding to a list of different optionnal criteria
	 * @param code Code of a specific research mode
	 * @param model Model criteria
	 * @param brand Brand criteria
	 * @param typeVehicle Vehicle type criteria
	 * @param research The research string
	 * @return List of all vehicle corresponding to the given list of criteria
	 */
	public List<Hire> getAll(int code,String model,String brand,String typeVehicle, String research);

	/**
	 * Retrieves a hire by its id
	 * @param id Hring's identifier
	 * @return The hiring or null if not found
	 */
	public Hire getById(int id);

	/**
	 * Updates an hiring in datasource according to the changes done in given hiring
	 * @param v Modified hiring
	 * @return The newly updated hiring
	 */
	public Hire update(Hire v);

	/**
	 * Deletes an hiring from datasource
	 * @param v Hiring to delete
	 * @return True if deletion went well, else false
	 */
	public boolean delete(int v);
	
	/**
	 * Computes the price of an hiring according to the number of kilometers, the vehicle base price and with or
	 * without a discount
	 *
	 * @param km The number of kilometers to take into account
	 * @param vehiclePrice The base price of the vehicle's hiring (price according to kilometers will be added to this base)
	 * @param reduction True if we gie a discount, else false
	 * @return The computed price
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction);
}
