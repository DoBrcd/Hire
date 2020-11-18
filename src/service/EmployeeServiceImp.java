package service;

import dao.EmployeeDao;
import model.Employee;

public class EmployeeServiceImp implements EmployeeServiceInterface{
	 private EmployeeDao loginDao = new EmployeeDao();

	 @Override
	 public boolean login(String username, String password) {
	  return loginDao.login(username, password);
	 }

	

	@Override
	public String registration(Employee e) {
		 return loginDao.register(e);
	}

}
