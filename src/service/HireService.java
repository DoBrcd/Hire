package service;

import dao.HireDao;
import model.Hire;

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

}
