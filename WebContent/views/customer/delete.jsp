<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hire.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fiche client</title>
</head>
<body>
	<% Customer customer = (Customer) request.getAttribute("customer"); %>
	<h1>Fiche client numero : <%= customer.getId() %></h1>
	<div>
		<p><strong>Nom</strong> : <%= customer.getName() %></p>
		<p><strong>Prénom</strong> : <%= customer.getFirstName() %></p>
		<p><strong>Adresse</strong> : <%= customer.getAddress() %></p>
		<p><strong>Téléphone</strong> : <%= customer.getPhone() %></p>
		<p><strong>E-mail</strong> : <%= customer.getEmail() %></p>
	</div>
	<form method="post" action="${pageContext.request.contextPath}/customer/delete" class="form-customer">
	
		<p><strong>Etes vous sur de vouloir supprimer ce client ?</strong> </p>
		<input type="hidden" name="id" value="<%= customer.getId() %>"></input>
		<button type="submit">Oui</button>
	</form>
</body>
</html>