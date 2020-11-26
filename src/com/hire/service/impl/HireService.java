package com.hire.service.impl;

import com.hire.model.Vehicle;
import com.hire.dao.impl.HireDao;
import com.hire.model.Hire;
import com.hire.service.HireServiceInterface;

public class HireService implements HireServiceInterface
{
	private HireDao hireDao = new HireDao();
	/**
	 * Créer une location
	 * 
	 * @param hire une location
	 */
	@Override
	public void create(Hire hire) {
		hireDao.create(hire);
	}

	/**
	 * Faire les calculs puis renvoie le prix de la location
	 *
	 * @param km le nombre de kilomètres, le prix de la location du véhicule et si il y a une réduction
	 * @return le prix
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction) {
		return hireDao.getPayement(km, vehiclePrice, reduction);
	}

	/**
	 * Retourne la location en fonction de l'id
	 * @param idHire l'id de la location
	 * @return la location
	 */
	public Hire getById(int idHire) {
		return hireDao.getById(idHire);
	}

	/**
	 * Met à jour la location après payement
	 * @param hire la nouvelle location
	 */
	@Override
	public void update(Hire hire) {
		hireDao.update(hire);
	}
}
