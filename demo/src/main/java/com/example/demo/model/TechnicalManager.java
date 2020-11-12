package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TechnicalManager")
public class TechnicalManager extends Employee implements TechnicalManagerInterface{

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
