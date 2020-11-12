package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hire")
public class Hire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date dateBegining;
	private Date dateEnding;
	private int kmExpected;
	private float priceExpected;
	private Long idClient;
	private Long idVehicle;
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
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}


}
