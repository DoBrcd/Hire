package com.hire.service.impl;

import java.util.List;

import com.hire.dao.impl.HireDao;
import com.hire.model.Hire;
import com.hire.service.HireServiceInterface;

public class HireService implements HireServiceInterface{
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


	@Override
	public List<Hire> getAll(int code,String model,String brand,String typeVehicle, String research) {
		//  Auto-generated method stub
		return hireDao.getAll(code, model, brand, typeVehicle,  research);
	}
	
}
