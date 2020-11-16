package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CommercialManager")
public class CommercialManager extends Employee implements I_CommercialManager {

	@Override
	public void getTheTenMostSpending() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTheTenMoreHiring() {
		// TODO Auto-generated method stub
		
	}

}
