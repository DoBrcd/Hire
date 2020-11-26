package com.hire.service.impl;

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

}
