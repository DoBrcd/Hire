<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Client</title>
</head>
<body>
	<h1>La liste des Clients</h1>
	<%
		java.util.List<model.Customer> customers = (java.util.List<model.Customer>) request.getAttribute("customers");
		for(model.Customer customer : customers){
	%>
		<div>
			<p><a href="/Hire/client/sheet?id=<%= customer.getId()%>"> Voir le profil complet</a></p>
			<p><%= customer.getName()%><p>
			<p><%= customer.getEmail()%></p>
		</div>
	<%
		}
	%>
</body>
</html>