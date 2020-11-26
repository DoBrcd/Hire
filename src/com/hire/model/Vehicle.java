package com.hire.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)

@DiscriminatorColumn(name="vehicule_type", discriminatorType=DiscriminatorType.STRING, length=20)

public  class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private float hirePrice;
	private int maxSpeed;
	private String model;

	private StateVehicle state = StateVehicle.Good;
	private StateHiring isHiring=StateHiring.Free;
	private String brand;
	
	@OneToMany(mappedBy="vehicle")
	private Collection<Hire> hires;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getHirePrice() {
		return hirePrice;
	}
	public void setHirePrice(float hirePrice) {
		this.hirePrice = hirePrice;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public StateHiring getIsHiring() {
		return isHiring;
	}
	public void setIsHiring(StateHiring isHiring) {
		this.isHiring = isHiring;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public StateVehicle getState() {
		return state;
	}
	public void setState(StateVehicle state) {
		this.state = state;
	}

	public void setState(String state)
	{
		return;
	}

}
