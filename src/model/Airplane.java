package model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Airplane")
public class Airplane extends Vehicle {

	private int nbMotor;

	public int getNbMotor() {
		return nbMotor;
	}

	public void setNbMotor(int nbMotor) {
		this.nbMotor = nbMotor;
	}

}
