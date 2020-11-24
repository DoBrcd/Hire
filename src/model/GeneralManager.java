package model;


import javax.persistence.Entity;

@Entity
public class GeneralManager extends Employee implements I_CommercialManager, I_CustomerManager, I_TechnicalManager {

	public GeneralManager(String username, String password) {
		super(username, password);
	}

	@Override
	public void createVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTheTenMostSpending() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTheTenMoreHiring() {
		// TODO Auto-generated method stub
		
	}

}
