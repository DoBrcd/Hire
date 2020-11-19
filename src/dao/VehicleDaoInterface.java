package dao;

import java.util.List;

import model.Vehicle;

public interface VehicleDaoInterface {
	public List<Vehicle> getAll();
	public Vehicle getByid(Long id);
	public Vehicle add(Vehicle v);
	public Vehicle update(Vehicle v);
	public boolean delete(Vehicle v);
}