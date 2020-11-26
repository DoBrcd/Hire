package com.hire.dao;

import com.hire.model.Hire;

public interface HireDaoInterface {
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
	 * @param hire l'id de la location
	 * @return la location
	 */
	public void update(Hire hire);
}
