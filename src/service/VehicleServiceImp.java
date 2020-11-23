package service;

import java.util.List;

import dao.VehicleDao;
import dao.VehicleDaoInterface;
import model.Vehicle;

public class VehicleServiceImp implements VehicleServiceInterface {
	VehicleDaoInterface vehicleDao=new VehicleDao();
	/**
	 * lister toutes les vehicules
	 * @param null
	 * @return List de toutes les vehicules
	 */
	@Override
	public List<Vehicle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * recuperer un vehicule par id
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	@Override
	public Vehicle getByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * ajouter un vehicule
	 * @param un vehcule (car , moto ou avion)
	 * @return vehicule ajoutée
	 */

	@Override
	public Vehicle add(Vehicle v) {
		//  Auto-generated method stub
		return this.vehicleDao.add(v);
	}
	/**
	 * modifier un vehicule
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	@Override
	public Vehicle update(Vehicle v) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
	@Override
	public boolean delete(Vehicle v) {
		// TODO Auto-generated method stub
		return false;
	}

}
