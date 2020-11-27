package com.hire.dao.impl;

import com.hire.dao.VehicleDaoInterface;
import com.hire.model.Airplane;
import com.hire.model.Car;
import com.hire.model.Motorbike;
import com.hire.model.Vehicle;
import com.hire.service.DBManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class VehicleDao implements VehicleDaoInterface
{

	private EntityManager em = DBManager.getEntityManager();

	/**
	 * lister toutes les vehicules
	 * 
	 * @return List de toutes les vehicules
	 */
	@Override
	public List<Vehicle> getAll() {
			if (em != null) {
				try {
					  List<Vehicle> vehicles = (List<Vehicle>) em.createQuery("select p from Vehicle p").getResultList();
					  return vehicles;
				} catch (Exception exception) {
					System.out.println("Exception occured while reading user data: " + exception.getMessage());
					return null;
				}

			} else {
				System.out.println("DB server down.....");
			}
			return null;

	}

	/**
	 * lister toutes les vehicules
	 * 
	 * @param vehicleType The vehicle type
	 * @return List de toutes les vehicules
	 */
	@Override
	public List<Vehicle> getAllParType(String vehicleType) {
		switch (vehicleType) {
		case "Car":
			List<Vehicle> vehiclesCar = (List<Vehicle>) em.createQuery("Select v From "+vehicleType+" v").getResultList();
			return vehiclesCar;
		case "Motorbike":
			List<Vehicle> vehiclesMotorbike = (List<Vehicle>) em.createQuery("Select v From "+vehicleType+" v").getResultList();
			return vehiclesMotorbike;
		case "Airplane":
			List<Vehicle> vehiclesAirplan = (List<Vehicle>) em.createQuery("Select v From "+vehicleType+" v").getResultList();
			return vehiclesAirplan;
		default:
			List<Vehicle> vehicles = (List<Vehicle>) em.createQuery("Select v From "+vehicleType+" v").getResultList();
			return vehicles;
		}
	}

	/**
	 * recuperer un vehicule par id
	 * 
	 * @param id de la vehicule
	 * @return un vehicule ou null
	 */
	@Override
	public Vehicle getById(int id) {
		return em.find(Vehicle.class, id);
	}

	/**
	 * ajouter un vehicule
	 * 
	 * @param v un vehicle (car , moto ou avion)
	 * @return vehicule ajoutée
	 */
	@Override
	public Vehicle add(Vehicle v) {
		em.getTransaction().begin();
		em.persist(v);
		em.flush();
		em.getTransaction().commit();
		return v;
	}

	/**
	 * modifier un vehicule
	 * 
	 * @param v instance de la vehicle modifie (car , moto ou avion)
	 * @return vehicule modifée
	 */
	@Override
	public Vehicle update(Vehicle v) {

		if (em != null) {
			try {
				em.getTransaction().begin();
				em.merge(v);
				em.flush();
				em.getTransaction().commit();
				return v;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
			}
		} else {
			System.out.println("DB server down.....");
		}
		return null;
	}

	/**
	 * pour supprimer un vehicle
	 * 
	 * @param v id du véhicule
	 * @return boolean true ou false
	 */
	@Override
	public boolean delete(int v) {
		if (em != null) {
			try {
				Vehicle vehicle = em.find(Vehicle.class, v);
				em.getTransaction().begin();
				em.remove(vehicle);
				em.flush();
				em.getTransaction().commit();
				return true;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user dara: " + exception.getMessage());
			}
		} else {
			System.out.println("DB server down.....");
			return false;
		}
		return false;

	}

	/**
	 * pour recuperer tous les models
	 * 
	 * @return liste de tous les models
	 */
	@Override
	public List<String> getAllModels() {
		try {
			List<String> models = (List<String>) em
					.createQuery("Select DISTINCT v.model From Vehicle v WHERE v.model IS NOT NULL").getResultList();
			return models;

		} catch (Exception e) {
			System.out.print("" + e);

		}
		return null;
	}

	/**
	 * pour recuperer tous les brand
	 * 
	 * @return liste de tous les brand
	 */
	@Override
	public List<String> getAllBrand() {
		try {
			List<String> brands = (List<String>) em
					.createQuery("Select DISTINCT v.brand From Vehicle v WHERE v.brand IS NOT NULL").getResultList();
			return brands;

		} catch (Exception e) {
			System.out.print("" + e);

		}
		return null;
	}

	/**
	 * lister toutes les voitures par critaria
	 * 
	 * @param model String model,String brand,String type
	 * @return List de toutes les voitures correpondant aux crit�re
	 */

	@Override
	public List<Car> getAllCarByCriteria(String model, String brand) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
		Root<Car> vehicleRoot = criteriaQuery.from(Car.class);
		Predicate predicateForBrand = criteriaBuilder.equal(vehicleRoot.get("brand"), brand);
		Predicate predicateForModel = criteriaBuilder.equal(vehicleRoot.get("com/hire/model"), model);

		Predicate predicate = criteriaBuilder.or(predicateForBrand, predicateForModel);

		try {
			criteriaQuery.where(predicate);
			List<Car> items = em.createQuery(criteriaQuery).getResultList();
			return items;

		} catch (Exception e) {
			System.out.print("" + e);

		}

		return null;

	}
	/**
	 * lister toutes les voitures disponible entre deux dates
	 * 
	 * @param dateBegin Date de debut de la location
	 * @param dateEnd La date de fin
	 * @return List de toutes les voitures correpondant aux crit�re
	 */
	@Override
	public List<Vehicle> getFreevehicle(String dateBegin, String dateEnd){
		if (em != null) {
			try {
				String query = "SELECT DISTINCT v FROM Vehicle v LEFT JOIN v.hires h WHERE h IS NULL OR NOT (('"+ dateBegin + "' >= h.dateBegining AND '" + dateBegin + "' <= h.dateEnding) OR ('"+ dateEnd + "' >= h.dateBegining AND '"+ dateEnd +"' <= h.dateEnding))";
				//String query = "SELECT v FROM Vehicle v WHERE v.id NOT IN( SELECT h.idVehicle_fk FROM Hire h WHERE ('"+ dateBegin + "' >= h.dateBegining AND '" + dateBegin + "' <= h.dateEnding) OR ('"+ dateEnd + "' >= h.dateBegining AND '"+ dateEnd +"' <= h.dateEnding))";
				  List<Vehicle> vehicles = (List<Vehicle>) em.createQuery(query).getResultList();
				  return vehicles;
			} catch (Exception exception) {
				System.out.println("Exception occured while reading user data: " + exception.getMessage());
				return null;
			}

		} else {
			System.out.println("DB server down.....");
		}
		return null;		
	}

	/**
	 * lister toutes les Airplanes par critaria
	 * 
	 * @param model String model,String brand,String type
	 * @return List de toutes les Airplanes correpondant aux critaire
	 */
	@Override
	public List<Airplane> getAllAirplaneByCriteria(String model, String brand) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Airplane> criteriaQuery = criteriaBuilder.createQuery(Airplane.class);
		Root<Airplane> vehicleRoot = criteriaQuery.from(Airplane.class);
		Predicate predicateForBrand = criteriaBuilder.equal(vehicleRoot.get("brand"), brand);
		Predicate predicateForModel = criteriaBuilder.equal(vehicleRoot.get("com/hire/model"), model);
		Predicate predicate = criteriaBuilder.or(predicateForBrand, predicateForModel);

		try {
			criteriaQuery.where(predicate);
			List<Airplane> items = em.createQuery(criteriaQuery).getResultList();
			return items;

		} catch (Exception e) {
			System.out.print("" + e);

		}
		return null;
	}

	/**
	 * lister toutes les Motorbikes par critaria
	 * 
	 * @param model String model,String brand,String type
	 * @return List de toutes les Motorbikes correpondant aux critaire
	 */
	@Override
	public List<Motorbike> getAllMotorbikeByCriteria(String model, String brand) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Motorbike> criteriaQuery = criteriaBuilder.createQuery(Motorbike.class);
		Root<Motorbike> vehicleRoot = criteriaQuery.from(Motorbike.class);
		Predicate predicateForBrand = criteriaBuilder.equal(vehicleRoot.get("brand"), brand);
		Predicate predicateForModel = criteriaBuilder.equal(vehicleRoot.get("com/hire/model"), model);
		Predicate predicate = criteriaBuilder.or(predicateForBrand, predicateForModel);

		try {
			criteriaQuery.where(predicate);
			List<Motorbike> items = em.createQuery(criteriaQuery).getResultList();
			return items;

		} catch (Exception e) {
			System.out.print("" + e);

		}
		return null;
	}

	/**
	 * lister toutes les vehicules par critaria
	 * 
	 * @param model String model,String brand,String type
	 * @return List de toutes les vehicules correpondant aux critaire
	 */
	@Override
	public List<Vehicle> getAllByCriteria(String model, String brand) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
		Root<Vehicle> vehicleRoot = criteriaQuery.from(Vehicle.class);
		Predicate predicateForBrand = criteriaBuilder.equal(vehicleRoot.get("brand"), brand);
		Predicate predicateForModel = criteriaBuilder.equal(vehicleRoot.get("com/hire/model"), model);

		Predicate predicate = criteriaBuilder.or(predicateForBrand, predicateForModel);

		try {
			criteriaQuery.where(predicate);
			List<Vehicle> items = em.createQuery(criteriaQuery).getResultList();
			return items;

		} catch (Exception e) {
			System.out.print("" + e);

		}

		return null;
	}
}
