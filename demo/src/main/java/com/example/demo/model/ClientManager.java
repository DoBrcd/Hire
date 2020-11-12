package com.example.demo.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ClientManager")
public class ClientManager extends Employee implements ClientManagerInterface {

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

}
