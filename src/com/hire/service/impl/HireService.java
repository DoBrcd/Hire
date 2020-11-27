package com.hire.service.impl;

import com.hire.dao.impl.HireDao;
import com.hire.model.Hire;
import com.hire.service.HireServiceInterface;

import java.util.List;

public class HireService implements HireServiceInterface{
	private HireDao hireDao = new HireDao();

	@Override
	public void create(Hire hire) {
		hireDao.create(hire);
	}

	public List<Hire> getAll(){
		return hireDao.getAll();
	}

	public Hire getById(int id){
		return hireDao.getById(id);
	}

	public Hire update(Hire v){
		return hireDao.update(v);
	}

	public boolean delete(int v){
		return hireDao.delete(v);
	}

	@Override
	public List<Hire> getAll(int code,String model,String brand,String typeVehicle, String research) {
		//  Auto-generated method stub
		return hireDao.getAll(code, model, brand, typeVehicle,  research);
	}

	public float getPayement(int km, float vehiclePrice, boolean reduction) {
		return hireDao.getPayement(km, vehiclePrice, reduction);
	}
}
