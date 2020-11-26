package com.hire.service;

import com.hire.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
	public Employee login(String username, String password);


	 public int registration(Employee e);
	 public String getPosition(String s);
	 
	 public List<Employee> getAll();
	 public Employee getByid(int id);
	 public Employee update(Employee v);
	 public boolean delete(Employee v);

	/**
	 * Tells if a given employee can manage vehicles
	 * @param employee as an Employee object
	 * @return True if the user is allowed to manage (create, update, delete) vehicles, else false
	 */
	public boolean canManageVehicle(Employee employee);

	/**
	 * Tells if a given employee can manage customers
	 * @param employee as an Employee object
	 * @return True if the user is allowed to manage (create, update, delete) customers, else false
	 */
	public boolean canManageCustomer(Employee employee);

	/**
	 * Tells if a given employee can manage hiring
	 * @param employee as an Employee object
	 * @return True if the user is allowed to manage (create, update, delete, ...) hiring, else false
	 */
	public boolean canManageHiring(Employee employee);

	/**
	 * Tells if a given employee can access to statistics
	 * @param employee as an Employee object
	 * @return True if the user is allowed to access statistics, else false
	 */
	public boolean canAccessStats(Employee employee);

	/**
	 * Tells if a given employee can manage employees
	 * @param employee as an Employee object
	 * @return True if the user is allowed to manage (create, update, delete) employees, else false
	 */
	public boolean canManageEmployee(Employee employee);

	/**
	 * Tells if a given employee can manage, whatever it is
	 * @param employee as an Employee object
	 * @return True if the user is allowed to do management, else false
	 */
	boolean canManage(Employee employee);

}
