package com.hire.service;

import com.hire.model.Hire;

public interface HireServiceInterface {
	/**
	 * Créer une location
	 * 
	 * @param hire une location
	 */
	public void create(Hire hire);

	/**
	 * Faire les calculs puis renvoie le prix de la location
	 *
	 * @param km le nombre de kilomètres, le prix de la location du véhicule et si il y a une réduction
	 * @return le prix
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction);
	/**
	 * Retourne la location en fonction de l'id
	 * @param idHire l'id de la location
	 * @return la location
	 */
	public Hire getById(int idHire);

	/**
	 * Met à jour la location après payement
	 * @param hire la nouvelle location
	 */
	public void update(Hire hire);
}
