<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../templates/header.jsp" %>
<%@ page import="com.hire.model.Customer" %>

	<% Customer customer = (Customer) request.getAttribute("customer"); %>
	<h1>Fiche client numero : <%= customer.getId() %></h1>
	<div>
		<p><strong>Nom</strong> : <%= customer.getName() %></p>
		<p><strong>Prénom</strong> : <%= customer.getFirstName() %></p>
		<p><strong>Adresse</strong> : <%= customer.getAddress() %></p>
		<p><strong>Téléphone</strong> : <%= customer.getPhone() %></p>
		<p><strong>E-mail</strong> : <%= customer.getEmail() %></p>
		<p><button><a href="${pageContext.request.contextPath}/customer/modify?id=<%= customer.getId() %>">Modifier</a></button></p>
	</div>
	<form method="get" action="${pageContext.request.contextPath}/customer/delete">
		<input type="hidden" name="id" value="<%= customer.getId() %>"></input>
		<button type="submit">Supprimer</button>
	</form>

	
<%@include file="../templates/footer.jsp" %>