package service;

import java.util.List;

import model.Vehicle;

public interface VehicleServiceInterface {
	/**
	 * lister toutes les vehicules
	 * @param null
	 * @return List de toutes les vehicules
	 */
	public List<Vehicle> getAll();
	/**
	 * recuperer un vehicule par id
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	public Vehicle getByid(Long id);
	/**
	 * ajouter un vehicule
	 * @param un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */
	public Vehicle add(Vehicle v);
	/**
	 * modifier un vehicule
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	public Vehicle update(Vehicle v);
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
	public boolean delete(Vehicle v);
}
