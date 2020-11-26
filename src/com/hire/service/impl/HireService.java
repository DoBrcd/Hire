package com.hire.service.impl;

import com.hire.dao.impl.HireDao;
import com.hire.model.Hire;
import com.hire.service.HireServiceInterface;

public class HireService implements HireServiceInterface
{
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

}
