<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../templates/header.jsp" %>
<%@ page import='com.hire.model.StateVehicle' %>
<%@ page import="com.hire.model.Vehicle"%>
<%@ page import="com.hire.model.Car"%>
<%@ page import="com.hire.model.Motorbike"%>
<%@ page import="com.hire.model.Airplane"%>


	<%String typeVehicle = (String) request.getAttribute("typeVehicle");%>
	<div class="container">
		<form  method="post" class="needs-validation bg-light p-3 mt-5"
			action="<%=request.getContextPath()%>/vehicle/delete" method="post">
			<h3 class="text-center">Mettre à jour vehicule</h3>
			<%
				Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
			%>
			<input type="hidden" name="id" value="<%=vehicle.getId()%>">
			<input type="hidden" name="vehicleType" value="<%=typeVehicle%>">

			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationTooltip01">com.hire.model</label> <input type="text"
						class="form-control" id="validationTooltip01" name="model"
						value="<%=vehicle.getModel()%>" disabled>
				
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationTooltip02">brand</label> <input type="text"
						class="form-control" id="validationTooltip02" name="brand"
						value="<%=vehicle.getBrand()%>"disabled>
					
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationTooltipUsername">state</label> <input
						type="text" class="form-control" id="state" name="state"
						aria-describedby="validationTooltipUsernamePrepend"
						value="<%=vehicle.getState()%>"disabled>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">price</label> <input type="text"
						class="form-control" id="validationTooltip03" name="price"
						value="<%=vehicle.getHirePrice()%>"disabled>
				
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">Maximum Speed</label> <input type="text"
						class="form-control" id="maxSpeed" name="maxSpeed"
						value="<%=vehicle.getMaxSpeed()%>"disabled>
				
				</div>
			</div>
			<%
				Car c =null;
			if (typeVehicle == "Car") {
				c = (Car) vehicle;
			}
			%>
			<div class="form-row car hidevehicle">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">power</label> <input type="text"
						class="form-control" id="validationTooltip03" name="powercar"
						value="<%if(c!= null){%><%=c.getPower()%><%}%>" disabled>
				
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">KM</label> <input type="number"
						class="form-control" id="maxSpeedcar" name="kmCar"
						value="<%if(c!= null){%><%=c.getMaxSpeed()%><%}%>" disabled>
				
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">sits number</label> <input type="number"
						class="form-control" id="sitsnumber" name="sitsnumber" value="<%if(c!= null){%><%=c.getSitsNumber()%><%}%>" disabled>
			
				</div>
			</div>
			<%
				Motorbike m = null;
			if (typeVehicle == "Motorbike") {
				m = (Motorbike) vehicle;
			}
			%>
			<div class="form-row moto hidevehicle">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">power</label> <input type="text"
						class="form-control" id="validationTooltip03" name="powerMotor"
						value="<%if(m!= null){%><%=m.getPower()%><%}%>"disabled>
					<div class="invalid-tooltip"></div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">KM</label> <input type="number"
						class="form-control" id="maxSpeed" name="kmMotor"
						value="<%if(m!= null){%><%=m.getKm()%><%}%>" disabled>

				</div>
			</div>
			<%
				Airplane a =null;
			if (typeVehicle == "Airplane") {
				a = (Airplane) vehicle;
			}
			%>
			<div class="form-row airplane hidevehicle">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">NB motors</label> <input
						type="number" class="form-control" id="validationTooltip03"
						name="nbMotors" value="<%if(a!= null){%><%=a.getNbMotor()%><%}%>" disabled>

				</div>

			</div>
			<button class="btn btn-danger" type="submit">Valider la suppression
				la vehicle</button>
		</form>
	</div>

<script>
window.onload = () => {
    let type="<%= typeVehicle%>";
		$(".hidevehicle").hide();
		switch (type) {
		case 'Car':
			$(".car").show();
			break;
		case 'Motorbike':
			$(".moto").show();
			break;
		case 'Airplane':
			$(".airplane").show();
			break;
		default:
			console.log(`Sorry, we are out of ${type}.`);
		}

	};
</script>

<%@include file="../templates/footer.jsp" %>
