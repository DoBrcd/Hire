package com.example.demo.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;


@Entity
@Table(name="employees")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="position", discriminatorType=DiscriminatorType.STRING, length=20)
public class Employee extends Person {

	private String identifiant;
	private String password;
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 */
	
	public void login() {
		
	}
	public void logout() {
		
	}
	public void getClients() {
		
	}
	public void getVehicles() {
		
	}


}
