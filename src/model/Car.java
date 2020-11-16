package model;

public class Car extends Vehicle {
	private int power;
	private int km;
	private int sitsNumber;
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getSitsNumber() {
		return sitsNumber;
	}
	public void setSitsNumber(int sitsNumber) {
		this.sitsNumber = sitsNumber;
	}
}
