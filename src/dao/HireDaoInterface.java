package dao;

import model.Hire;

public interface HireDaoInterface {
	/**
	 * Cr�er une location
	 * 
	 * @param une location
	 */
	public void create(Hire hire);
	/**
	 * Faire les calculs puis renvoie le prix de la location
	 * 
	 * @param le nombre de kilom�tres, le prix de la location du v�hicule et si il y a une r�duction
	 * @return le prix
	 */
	public float getPayement(int km, float vehiclePrice, boolean reduction);
	
	/**
	 * Retourne la location en fonction de l'id
	 * @param l'id de la location
	 * @return la location
	 */
	public Hire getById(int idHire);
	
	/**
	 * Met � jour la location apr�s payement
	 * @param l'id de la location
	 * @return la location
	 */	
	public void update(Hire hire);
}
