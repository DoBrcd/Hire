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
	<% boolean reduction = (boolean) request.getAttribute("reduction"); %>
	<% String dateBegin = (String) request.getAttribute("dateBegin"); %>
	<% String dateEnd = (String) request.getAttribute("dateEnd"); %>
	<h1>Louer un véhicule</h1>
	<div>
		<p>Si c'est un nouveau client : <a href="/Hire/client/create">Créer une fiche</a></p>
	</div>
	<form method="post" action="#">
		<div>
			<label name="customer">La liste des clients</label>
			<select name="customer">
				<% for(Customer customer : customers){ %>
					<option value="<%= customer.getId() %>"><%= customer.getFirstName() %> <%= customer.getName() %></option>
				<% } %>
			</select>
		</div>
		<div>
			<label name="vehicle">La liste des véhicles à louer</label>
			<select name="vehicle">
				<% for(Vehicle vehicle : vehicles){ %>
					<option value="<%= vehicle.getId() %>"> <%= vehicle.getBrand() %> <%= vehicle.getModel() %></option>
				<% } %>
			</select>
		</div>
		<div>
			<label name="km">Nombre de kilomètres prévues</label>
			<input type="number" name="km">
		</div>
		<div>
			<label name="prix">Prix prévionnel</label>
			<input type="number" name="prix">
		</div>
		<div>
			<input type="checkbox" name="reduction" id="reduction" value="yes">
			<label name="reduction" disabled>Appliquer une réduction</label>
		</div>
		<input type="hidden" value="<%= dateBegin %>" name="dateBegin">
		<input type="hidden" value="<%= dateEnd %>" name="dateEnd">
		<button type="submit">Louer</button>
	</form>
	<% if(!reduction){ %>
	<script>
		document.getElementById("reduction").disabled = true;
	</script>
	<% } %>
</body>
</html>