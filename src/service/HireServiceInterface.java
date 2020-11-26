package service;

import java.util.List;

import model.Hire;

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
	
}
