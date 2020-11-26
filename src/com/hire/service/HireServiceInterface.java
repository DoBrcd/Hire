package com.hire.service;

import java.util.List;

import com.hire.model.Hire;

public interface HireServiceInterface {
	/**
	 * Cr�er une location
	 * 
	 * @param une location
	 */
	public void create(Hire hire);
	
	
	/**
	 * lister toutes les loactions
	 * @param null
	 * @return List de toutes les loactions
	 */
	public List<Hire> getAll();
	
	/**
	 * lister toutes les loactions
	 * @param code de rechrche corrposndant au cas de filtre
	 * @return List de toutes les loactions correpondants
	 */
	public List<Hire> getAll(int code,String model,String brand,String typeVehicle, String research);
	
	
	/**
	 * recuperer un loaction par id
	 * @param id de la loaction
	 * @return un loaction ou null
	 */
	public Hire getById(int id);

	/**
	 * modifier un loaction
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return loaction modifée
	 */
	public Hire update(Hire v);
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
	public boolean delete(int v);
	

	/**
	 * Faire les calculs puis renvoie le prix de la location
	 *
	 * @param km le nombre de kilomètres, le prix de la location du véhicule et si il y a une réduction
	 * @return le prix
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction);
}
