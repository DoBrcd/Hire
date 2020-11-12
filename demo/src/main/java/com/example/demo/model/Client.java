package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends Person{

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

}
