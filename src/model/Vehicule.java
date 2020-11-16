package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private float hirePrice;
	private String status;
	private int maxSpeed;
	private String model;
	private String state;
	private StateHiring isHiring;
	private String brand;
	
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

}
