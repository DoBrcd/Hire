<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../templates/header.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="model.Vehicle"%>

	<div class="container">
	<form class="needs-validation bg-light p-3 mt-5"
		action="<%=request.getContextPath()%>/vehicle/research" method="post">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Vehicle
					Type</label>
			</div>
			<select class="custom-select col-md-3" name="vehicleType"
				id="vehicleType">
				<option selected>Choose...</option>
				<option value="Motorbike">Motorbike</option>
				<option value="Car">Car</option>
				<option value="Aireplane">Aireplane</option>
			</select>
			<div class="input-group-prepend">
				<label class="input-group-text" for="model">Vehicle model</label>
			</div>
			<select class="custom-select col-md-3" name="model" id="model">
				<option selected>Choose...</option>
				<%
					List<String> models = (List<String>) request.getAttribute("models");
				for (String model : models) {
				%>
				<option><%=model%></option>
				<%
					}
				%>
			</select>
			<div class="input-group-prepend">
				<label class="input-group-text" for="brand">Vehicle marque</label>
			</div>
			<select class="custom-select col-md-3" name="brand" id="brand">
				<option selected>Choose...</option>
				<%
					List<String> brands = (List<String>) request.getAttribute("brands");
				for (String brand : brands) {
				%>
				<option><%=brand%></option>
				<%
					}
				%>

			</select>

		</div>
		<button type="submit" class="btn btn-success">Rechercher</button>
	</form>
	<table class="table table-striped bg-light">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Model</th>
				<th scope="col">Marque</th>
				<th scope="col">Location</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
			for (Vehicle vehicle : vehicles) {
			%>
			<tr>

				<td><%=vehicle.getId()%></td>
				<td><%=vehicle.getModel()%></td>
				<td><%=vehicle.getBrand()%></td>
				<td><%=vehicle.getIsHiring()%></td>
				<td><form  class="btn"
		action="<%=request.getContextPath()%>/vehicle/sheet" method="GET"><input type="hidden" name="id" value="<%=vehicle.getId()%>"/> <button  class=" btn btn-secondary" type="submit" >Voir</button></form>
					<form class="btn "
		action="<%=request.getContextPath()%>/vehicle/modify" method="GET"><input type="hidden" name="id" value="<%=vehicle.getId()%>" /><button class=" btn btn-success" type="submit" >Modifier</button></form>
					<form class="btn "
		action="<%=request.getContextPath()%>/vehicle/delete" method="GET"><input type="hidden" name="id" value="<%=vehicle.getId()%>"/><button class=" btn btn-danger" type="submit" >Supprimer</button></form></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</div>

<%@include file="../templates/footer.jsp" %>