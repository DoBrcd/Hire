package model;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {
	private String address;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [address=" + address + ", getName()=" + getName() + ", getFirstName()=" + getFirstName()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + "]";
	}
	
}
