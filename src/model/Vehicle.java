package model;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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

	private String state;
	private StateHiring isHiring=StateHiring.Free;
	private String brand;
	
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

}
