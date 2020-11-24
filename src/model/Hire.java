package model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Hire {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dateBegining;
	private Date dateEnding;
	private int kmExpected;
	private float priceExpected;
	  @ManyToOne
	  @JoinColumn(name = "idClient_fk")
	private Customer client;

	  @ManyToOne
	  @JoinColumn(name = "idVehicle_fk")
	private Vehicle vehicle;
	
	public Date getDateBegining() {
		return dateBegining;
	}
	public void setDateBegining(Date dateBegining) {
		this.dateBegining = dateBegining;
	}
	public Date getDateEnding() {
		return dateEnding;
	}
	public void setDateEnding(Date dateEnding) {
		this.dateEnding = dateEnding;
	}
	public int getKmExpected() {
		return kmExpected;
	}
	public void setKmExpected(int kmExpected) {
		this.kmExpected = kmExpected;
	}
	public float getPriceExpected() {
		return priceExpected;
	}
	public void setPriceExpected(float priceExpected) {
		this.priceExpected = priceExpected;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Customer getClient()
	{
		return client;
	}

	public void setClient(Customer client)
	{
		this.client = client;
	}

	public Vehicle getVehicle()
	{
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
}
