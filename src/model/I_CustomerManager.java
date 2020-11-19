package model;

import java.util.ArrayList;

public interface I_CustomerManager {
	public void createClient();
	public void updateClient();
	public void deleteClient();
	public ArrayList<Customer> getAllClients();
}
