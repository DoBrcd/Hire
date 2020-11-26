package service;

import model.Vehicle;
import dao.HireDao;
import model.Hire;

public class HireServiceImp implements HireServiceInterface{
	private HireDao hireDao = new HireDao();
	/**
	 * Créer une location
	 * 
	 * @param une location
	 */
	@Override
	public void create(Hire hire) {
		hireDao.create(hire);
	}
	/**
	 * Faire les calculs puis renvoie le prix de la location
	 * 
	 * @param le nombre de kilomètres, le prix de la location du véhicule et si il y a une réduction
	 * @return le prix
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction) {
		return hireDao.getPayement(km, vehiclePrice, reduction);
	}
	/**
	 * Retourne la location en fonction de l'id
	 * @param l'id de la location
	 * @return la location
	 */
	public Hire getById(int idHire) {
		return hireDao.getById(idHire);
	}
	/**
	 * Met à jour la location après payement
	 * @param la nouvelle location
	 */	
	public void update(Hire hire) {
		hireDao.update(hire);
		
	}


}
