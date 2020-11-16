package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CustomerManager")
public class CustomerManager extends Employee implements I_CustomerManager {

	@Override
	public void CreatClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClient() {
		// TODO Auto-generated method stub
		
	}

}
