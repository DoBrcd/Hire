package com.hire.dao;

import com.hire.model.Employee;

import java.util.List;

public interface EmployeeDaoInterface {
	/**
	 * Tries to log in an employee according to an username and a password (already encrypted).
	 * @param username The employee username
	 * @param password The employee password
	 * @return If log in succeeds, the employee data, null otherwise
	 */
	 public Employee login(String username, String password);

	/**
	 * Registers a new employee in datasource
	 * @param user The new employee to add in datasource
	 * @return The new employee's id
	 */
	public int register(Employee user);

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

}
