<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../templates/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="model.Hire"%>
<%@ page import="model.Customer"%>

<div class="container">
	<form class="needs-validation bg-light p-3 mt-5"
		action="<%=request.getContextPath()%>/hire/research" method="post">
			<div class="input-group mb-6">

				<div class="form-group">
					<label for="exampleInputEmail1">Nom ou mail du client</label> <input
						type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="reqResearch">
				</div>

			</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Vehicle
					Type</label>
			</div>
			<select class="custom-select col-md-3" name="hireType" id="hireType">
				<option selected>Choose...</option>
				<option value="Motorbike">Motorbike</option>
				<option value="Car">Car</option>
				<option value="Airplane">Airplane</option>
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
				<th scope="col">#</th>
				<th scope="col">#</th>
				<th scope="col">#</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Hire> hires = (List<Hire>) request.getAttribute("Hires");
			for (Hire hire : hires) {
				 // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"  
		        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		        Date dateB = dt.parse(hire.getDateBegining().toString());
		        Date dateE = dt.parse(hire.getDateEnding().toString());
		        // *** same for the format String below
		        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		        
			%>
			<tr>

				<td><%=hire.getId()%></td>
				<td><%=hire.getVehicle().getModel()%></td>
				<td><%=hire.getVehicle().getBrand()%></td>
				<td><%=hire.getClient().getName()%></td>
				<td><%=hire.getClient().getFirstName()%></td>
				<td><%=dt1.format(dateB)%></td>
				<td><%=dt1.format(dateE)%></td>
				<td><form class="btn"
						action="<%=request.getContextPath()%>/sheet" method="GET">
						<input type="hidden" name="id" value="<%=hire.getId()%>" />
						<button class=" btn btn-secondary" type="submit">Voir</button>
					</form>
				
						<form class="btn "
						action="<%=request.getContextPath()%>/return" method="GET">
						<input type="hidden" name="id" value="<%=hire.getId()%>" />
						<button class=" btn btn-success" type="submit">Payer</button>
					</form></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</div>

<%@include file="../templates/footer.jsp"%>