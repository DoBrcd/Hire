package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="airplanes")
public class Airplane extends Vehicle{
	
	private int nbMotor;

	public int getNbMotor() {
		return nbMotor;
	}

	public void setNbMotor(int nbMotor) {
		this.nbMotor = nbMotor;
	}

}
