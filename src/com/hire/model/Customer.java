package com.hire.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		uniqueConstraints= {@UniqueConstraint(columnNames={"firstName", "name"})}
)
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
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getId()" + getId() + "]";
	}
	
}
