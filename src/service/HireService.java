package service;

import java.util.List;

import dao.HireDao;
import model.Hire;

public class HireService implements HireServiceInterface{
	private HireDao hireDao = new HireDao();
	/**
	 * Cr�er une location
	 * 
	 * @param une location
	 */
	@Override
	public void create(Hire hire) {
		hireDao.create(hire);
	}

	
	/**
	 * lister toutes les loactions
	 * @param null
	 * @return List de toutes les loactions
	 */
	public List<Hire> getAll(){
		return hireDao.getAll();
	}
	
	
	
	/**
	 * recuperer un loaction par id
	 * @param id de la loaction
	 * @return un loaction ou null
	 */
	public Hire getById(int id){
		return hireDao.getById(id);
	}

	/**
	 * modifier un loaction
	 * @param instance de la vehcule modifie (car , moto ou avion)
	 * @return loaction modifée
	 */
	public Hire update(Hire v){
		return hireDao.update(v);
	}
	/**
	 * pour supprimer un vehcule
	 * @param instance conteine le id
	 * @return boolean true ou false
	 */
	public boolean delete(int v){
		return hireDao.delete(v);
	}
	
}
