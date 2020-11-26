<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../templates/header.jsp" %>
	<%@ page import="java.util.List" %>
	<%@ page import="model.Customer" %>

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
	
<%@include file="../templates/footer.jsp" %>