<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Vehicle" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Louer un véhicule</title>
</head>
<body>
	<% List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles"); %>
	<h1>Louer un véhicule</h1>
	<div>
		<p>Si c'est un nouveau client : <a href="/Hire/client/create">Créer une fiche</a></p>
	</div>
	<div>
		<p>Liste des véhicules à louer</p>
		<select>
			<% for(Vehicle vehicle : vehicles){ %>
				<option><%= vehicle.getModel() %></option>
			<% } %>
		</select>
	</div>
</body>
</html>