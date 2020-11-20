<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Customer</title>
</head>
<body>
	<% Customer customer = (Customer) request.getAttribute("customer"); %>
	<h1>Modifier les informations de votre client</h1>
	<form action="#" method="post" class="form-customer">
		<table>
			<tr class="form-customer">
				<td><label for="name">Nom : </label></td>
				<td><input type="text" name="name" id="name" value=<%= customer.getName() %> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="firstName">Prénom : </label></td>
				<td><input type="text" name="firstName" id="firstName" value=<%= customer.getFirstName() %> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="address">Adresse : </label></td>
				<td><input type="text" name="address" id="address" value=<%= customer.getAddress() %> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="phone">Téléphone : </label></td>
				<td><input type="text" name="phone" id="phone" value=<%= customer.getPhone() %> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="email">Email : </label></td>
				<td><input type="email" name="email" id="email" value=<%= customer.getEmail() %> required></td>
			</tr>
			
			<tr class="form-customer">
				<td><button type="submit">Modifier</button></td>
			</tr>
		</table>
		<p><button><a href="/Hire/client/sheet?id=<%= customer.getId() %>">Retour</a></button></p>
	</form>
</body>
</html>