<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../templates/header.jsp" %>
	<h1>Créer une nouvelle fiche client</h1>
	<form action="#" method="post" class="form-customer">
		<table>
			<tr class="form-customer">
				<td><label for="name">Nom : </label></td>
				<td><input type="text" name="name" id="name" value=<%out.print(request.getParameter("name"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="firstName">Prénom : </label></td>
				<td><input type="text" name="firstName" id="firstName" value=<%out.print(request.getParameter("firstName"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="address">Adresse : </label></td>
				<td><input type="text" name="address" id="address" value=<%out.print(request.getParameter("address"));%> required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="phone">Téléphone : </label></td>
				<td><input type="text" name="phone" id="phone" required></td>
			</tr>
			<tr class="form-customer">
				<td><label for="email">Email : </label></td>
				<td><input type="email" name="email" id="email" required></td>
			</tr>
			<tr class="form-customer">
				<td><input type="submit" value="Créer client"></td>
			</tr>
		</table>
	</form>

<%@include file="../templates/footer.jsp" %>
	