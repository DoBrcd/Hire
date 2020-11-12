package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="motorbikes")
public class Motorbike extends Vehicle{
	
	private String power;
	private int km;
	
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}

}
