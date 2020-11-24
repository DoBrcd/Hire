<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Client</title>
</head>
<body>
	<h1>La liste des Clients</h1>

	<%
		List<Customer> customers = (List<Customer>) request.getAttribute("customers");
		for(Customer customer : customers){
	%>
		<div>
			<p><a href="${pageContext.request.contextPath}/client/sheet?id=<%= customer.getId()%>"> Voir le profil complet</a></p>
			<p><%= customer.getName()%> : <%= customer.getEmail()%><p>
		</div>
	<%
		}
	%>
</body>
</html>