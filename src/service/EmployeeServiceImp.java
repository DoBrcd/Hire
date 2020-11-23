package service;

import java.util.List;

import dao.EmployeeDao;
import model.*;

public class EmployeeServiceImp implements EmployeeServiceInterface
{
    private EmployeeDao emDao = new EmployeeDao();

    @Override
    public boolean login(String username, String password)
    {
        return emDao.login(username, password);
    }


    @Override
    public String registration(Employee e)
    {
        return emDao.register(e);
    }


    @Override
    public String getPosition(String s)
    {
        return emDao.getPosition(s);
    }


    @Override
    public Employee createEmployee(Employee e)
    {
        return emDao.CreateEmployee(e);
    }

    /**
     * Tells if a given position can do a creation, whatever it is
     * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
     * @return True if the user is allowed to do a creation, else false
     */
    @Override
    public boolean canCreate(String position)
    {
        return position.equals(TechnicalManager.class.getName()) ||
                position.equals(CustomerManager.class.getName()) ||
                position.equals(GeneralManager.class.getName());
    }

    /**
     * Tells if a given position can create a vehicle
     * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
     * @return True if the user is allowed to create a vehicle, else false
     */
    @Override
    public boolean canCreateVehicle(String position)
    {
        return position.equals(TechnicalManager.class.getName())
                || position.equals(GeneralManager.class.getName());
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


    /**
     * Tells if a given position can create a customer
     * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
     * @return True if the user is allowed to create a customer, else false
     */
    @Override
    public boolean canCreateCustomer(String position)
    {
        return position.equals(CustomerManager.class.getName())
                || position.equals(GeneralManager.class.getName());
    }

    /**
     * Tells if a given position can create a hiring
     * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
     * @return True if the user is allowed to create an hiring, else false
     */
    @Override
    public boolean canCreateHiring(String position)
    {
        return position.equals(GeneralManager.class.getName());
    }

    /**
     * Tells if a given position can access to statistics
     * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
     * @return True if the user is allowed to access statistics, else false
     */
    @Override
    public boolean canAccessStats(String position)
    {
        return position.equals(CommercialManager.class.getName())
                || position.equals(GeneralManager.class.getName());
    }

}
