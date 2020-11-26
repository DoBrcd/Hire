<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hire.model.Customer" %>
<%@include file="/views/templates/header.jsp"%>

<div class="container">
	<h1>La liste des Clients</h1>
	<form class="needs-validation bg-light p-3 mt-5"
		  action="<%=request.getContextPath()%>/customer/research" method="post">
		<% if(request.getAttribute("msg") != null) { %>
		<div class="alert alert-danger" role="alert">
			<%=request.getAttribute("msg") %>
		</div>
		<% } %>
		<div class="input-group mb-3">

			<div class="form-group">
				<label for="exampleInputEmail1">Nom ou mail du client</label>
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="reqResearch">
			</div>

		</div>
		<button type="submit" class="btn btn-success">Rechercher</button>
	</form>
	<table class="table table-striped bg-light">
		<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nom</th>
			<th scope="col">Email</th>
		</tr>
		</thead>
		<tbody>
		<%
			List<Customer> customers = (List<Customer>) request.getAttribute("customers");
			for (Customer customer : customers) {
		%>
		<tr>

			<td><%=customer.getId()%></td>
			<td><%=customer.getName()%></td>
			<td><%=customer.getEmail()%></td>
			<td><form  class="btn"
					   action="<%=request.getContextPath()%>/customer/sheet" method="GET"><input type="hidden" name="id" value="<%=customer.getId()%>"/> <button  class=" btn btn-secondary" type="submit" >Voir</button></form>
				<form class="btn "
					  action="<%=request.getContextPath()%>/customer/modify" method="GET"><input type="hidden" name="id" value="<%=customer.getId()%>" /><button class=" btn btn-success" type="submit" >Modifier</button></form>
				<form class="btn "
					  action="<%=request.getContextPath()%>/customer/delete" method="GET"><input type="hidden" name="id" value="<%=customer.getId()%>"/><button class=" btn btn-danger" type="submit" >Supprimer</button></form></td>
		</tr>
		<%
			}
		%>

		</tbody>
	</table>
</div>

<%@include file="/views/templates/footer.jsp"%>