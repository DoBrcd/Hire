package com.hire.service;

import com.hire.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
	public Employee login(String username, String password);


	/**
	 * Registers a new employee in datasource
	 * @param e The new employee to add in datasource
	 * @return The new employee's id
	 */
	 public int registration(Employee e);

	/**
	 * Returns the position of an employee according to it's username
	 * @param s The employee's username
	 * @return The employee's position which is the name of the employee's class
	 */
	 public String getPosition(String s);

	/**
	 * Returns the list of all the employees
	 * @return The list of all the employees
	 */
	 public List<Employee> getAll();

	/**
	 * Retrieves an employee by its id
	 * @param id The employee's id
	 * @return The employee instance or null if not found
	 */
	 public Employee getByid(int id);

	/**
	 * Updates an employee in datasource according to changes done in the given employee instance
	 * @param v The modified employee instance
	 * @return The newly updated instance
	 */
	 public Employee update(Employee v);

	/**
	 * Deletes a givent employee in datasource
	 * @param v The employee to delete in datasrouce
	 * @return True if it succeeds, else false
	 */
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
