package service;

import dao.EmployeeDao;
import model.Employee;

public class EmployeeServiceImp implements EmployeeServiceInterface{
	 private EmployeeDao emDao = new EmployeeDao();

	 @Override
	 public boolean login(String username, String password) {
	  return emDao.login(username, password);
	 }

	

	@Override
	public String registration(Employee e) {
		 return emDao.register(e);
	}



	@Override
	public String getPosition(String s) {
		//  Auto-generated method stub
		return emDao.getPosition(s);
	}



	@Override
	public Employee createEmployee(Employee e) {
		//  Auto-generated method stub
		return emDao.CreateEmployee(e);
	}

}
