package model;

import javax.persistence.Entity;

@Entity
public class Airplane extends Vehicule {

	private int nbMotor;

	public int getNbMotor() {
		return nbMotor;
	}

	public void setNbMotor(int nbMotor) {
		this.nbMotor = nbMotor;
	}

}
