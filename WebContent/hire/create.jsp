<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Vehicle" %>
<%@ page import="model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Louer un véhicule</title>
</head>
<body>
	<% List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles"); %>
	<% List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>
	<h1>Louer un véhicule</h1>
	<div>
		<p>Si c'est un nouveau client : <a href="/Hire/client/create">Créer une fiche</a></p>
	</div>
	<form method="post" action="#">
		<div>
			<label name="client">La liste des clients</label>
			<select name="client">
				<% for(Customer customer : customers){ %>
					<option value="<%= customer.getId() %>"><%= customer.getFirstName() %> <%= customer.getName() %></option>
				<% } %>
			</select>
		</div>
		<div>
			<label name="vehicle">La liste des véhicles à louer</label>
			<select name="vehicle">
				<% for(Vehicle vehicle : vehicles){ %>
					<option value="<%= vehicle.getId() %>"><%= vehicle.getModel() %></option>
				<% } %>
			</select>
		</div>
		<button type="submit">Louer</button>
	</form>

</body>
</html>