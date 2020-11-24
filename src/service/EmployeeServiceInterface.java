package service;

import java.util.List;

import model.Employee;

public interface EmployeeServiceInterface {
	public boolean login(String username, String password);


	 public int registration(Employee e);
	 public String getPosition(String s);
	 
	 public List<Employee> getAll();
	 public Employee getByid(Long id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

	/**
	 * Tells if a given position can create a vehicle
	 * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
	 * @return True if the user is allowed to create a vehicle, else false
	 */
	public boolean canCreateVehicle(String position);

	/**
	 * Tells if a given position can create a customer
	 * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
	 * @return True if the user is allowed to create a customer, else false
	 */
	public boolean canCreateCustomer(String position);

	/**
	 * Tells if a given position can create a hiring
	 * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
	 * @return True if the user is allowed to create an hiring, else false
	 */
	public boolean canCreateHiring(String position);

	/**
	 * Tells if a given position can access to statistics
	 * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
	 * @return True if the user is allowed to access statistics, else false
	 */
	public boolean canAccessStats(String position);

	/**
	 * Tells if a given position can access to employee
	 * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
	 * @return True if the user is allowed to access employee, else false
	 */
	public Object canCreateEmployee(String position);

	/**
	 * Tells if a given position can do a creation, whatever it is
	 * @param position The user's position as a String (user's class name: TechnicalManager, GeneralManager, ...)
	 * @return True if the user is allowed to do a creation, else false
	 */
	boolean canCreate(String position);

}
