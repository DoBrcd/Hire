package com.hire.service.impl;

import com.hire.dao.impl.EmployeeDao;
import com.hire.model.*;
import com.hire.service.EmployeeServiceInterface;

import java.util.List;

public class EmployeeServiceImp implements EmployeeServiceInterface
{
    private EmployeeDao emDao = new EmployeeDao();

    @Override
    public Employee login(String username, String password)
    {
        return emDao.login(username, password);
    }


    @Override
    public int registration(Employee e)
    {
        return emDao.register(e);
    }


    @Override
    public String getPosition(String s)
    {
        return emDao.getPosition(s);
    }

    @Override
	public List<Employee> getAll() {
		return emDao.getAll();
	}

	@Override
	public Employee getByid(int id) {
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


	@Override
	public boolean canManageVehicle(Employee employee) {
		return employee instanceof I_TechnicalManager;
	}


	@Override
	public boolean canManageCustomer(Employee employee) {
		return employee instanceof I_CustomerManager;
	}


	@Override
	public boolean canManageHiring(Employee employee) {
		return employee instanceof GeneralManager; 
	}


	@Override
	public boolean canAccessStats(Employee employee) {
		return employee instanceof I_CommercialManager;
	}


	@Override
	public boolean canManageEmployee(Employee employee) {
		return employee instanceof GeneralManager;
	}


	@Override
	public boolean canManage(Employee employee) {
		return employee instanceof I_CustomerManager 
				|| employee instanceof I_TechnicalManager;
	}
}
