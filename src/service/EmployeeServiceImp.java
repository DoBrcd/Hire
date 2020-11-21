package service;

import java.util.List;

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



	@Override
	public List<Employee> getAll() {
		return emDao.getAll();
	}



	@Override
	public Employee getByid(Long id) {
		return emDao.getByid(id);
	}



	@Override
	public Employee update(Employee v) {
		return emDao.update(v);
	}



	@Override
	public boolean delete(Employee v) {
		return emDao.delete(v);
	}

}
