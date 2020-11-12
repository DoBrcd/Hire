package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private float hirePrice;
	private String status;
	private int maxSpeed;
	private String model;
	public float getHirePrice() {
		return hirePrice;
	}
	public void setHirePrice(float hirePrice) {
		this.hirePrice = hirePrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public hiringState getIsHiring() {
		return isHiring;
	}
	public void setIsHiring(hiringState isHiring) {
		this.isHiring = isHiring;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	private String state;
	private hiringState isHiring;
	private String brand;
}
