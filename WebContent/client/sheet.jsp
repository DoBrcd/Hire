<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Customer</title>
</head>
<body>
	<h1>Fiche client numero : <%out.print(request.getParameter("id")); %></h1>
	<form action="#" method="post" class="form-customer">
		<table>
			<tr class="form-customer">
				<td><label for="name">Nom : </label></td>
				<td><input type="text" name="name" id="name" value=<%out.print(request.getAttribute("name"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="firstName">Prénom : </label></td>
				<td><input type="text" name="firstName" id="firstName" value=<%out.print(request.getAttribute("firstName"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="address">Adresse : </label></td>
				<td><input type="text" name="address" id="address" value=<%out.print(request.getAttribute("address"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="phone">Téléphone : </label></td>
				<td><input type="text" name="phone" id="phone" value=<%out.print(request.getAttribute("phone"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="email">Email : </label></td>
				<td><input type="email" name="email" id="email" value=<%out.print(request.getAttribute("email"));%> required></td>
			</tr>
		</table>
	</form>
</body>
</html>