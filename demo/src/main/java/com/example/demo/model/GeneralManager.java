package com.example.demo.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GeneralManager")
public class GeneralManager extends Employee implements TechnicalManagerInterface,CommercialManagerInterface,ClientManagerInterface {

	@Override
	public void CreatClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateClient() {
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

	@Override
	public void CreatVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVehicle() {
		// TODO Auto-generated method stub
		
	}

}
