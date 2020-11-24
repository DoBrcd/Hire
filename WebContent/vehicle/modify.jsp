<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Vehicle"%>
<%@ page import="model.Car"%>
<%@ page import="model.Motorbike"%>
<%@ page import="model.Airplane"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier une vehicle</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){

	<%String typeVehicle = (String) request.getAttribute("typeVehicle");%>
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

	});
</script>
<style>
body {
	background-image: url("https://source.unsplash.com/1600x900/?BMW");
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}
</style>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="#">Navbar</a>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="./logout">Logout</a>
			</li>

		</ul>
		<h3>
			<%=session.getAttribute("id")%>
			<%=session.getAttribute("position")%></h3>
	</div>
	</nav>
	<div class="container">
		<form  method="post" class="needs-validation bg-light p-3 mt-5"
			action="<%=request.getContextPath()%>/vehicle/modify" method="post">
			<h3 class="text-center">Mettre à jour vehicule</h3>
			<%
				Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
			%>
			<input type="hidden" name="id" value="<%=vehicle.getId()%>">
			<input type="hidden" name="vehicleType" value="<%=typeVehicle%>">

			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationTooltip01">model</label> <input type="text"
						class="form-control" id="validationTooltip01" name="model"
						value="<%=vehicle.getModel()%>">
					<div class="valid-tooltip">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationTooltip02">brand</label> <input type="text"
						class="form-control" id="validationTooltip02" name="brand"
						value="<%=vehicle.getBrand()%>">
					<div class="valid-tooltip">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationTooltipUsername">state</label> <input
						type="text" class="form-control" id="state" name="state"
						aria-describedby="validationTooltipUsernamePrepend"
						value="<%=vehicle.getState()%>">
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">price</label> <input type="text"
						class="form-control" id="validationTooltip03" name="price"
						value="<%=vehicle.getHirePrice()%>">
					<div class="invalid-tooltip">Please provide a valid city.</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">Maximum Speed</label> <input type="text"
						class="form-control" id="maxSpeed" name="maxSpeed"
						value="<%=vehicle.getMaxSpeed()%>">
					<div class="invalid-tooltip">Please select a valid state.</div>
				</div>
			</div>
			<%
				Car c = new Car();
			if (typeVehicle == "Car") {
				c = (Car) vehicle;
			}
			%>
			<div class="form-row car hidevehicle">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">power</label> <input type="text"
						class="form-control" id="validationTooltip03" name="powercar"
						value="<%=c.getPower()%>">
					<div class="invalid-tooltip">Please provide a valid city.</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">KM</label> <input type="number"
						class="form-control" id="maxSpeedcar" name="kmCar"
						value="<%=c.getMaxSpeed()%>">
					<div class="invalid-tooltip">Please select a valid state.</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">sits number</label> <input type="number"
						class="form-control" id="sitsnumber" name="sitsnumber" value="<%=c.getSitsNumber()%>">
					<div class="invalid-tooltip">Please select a valid state.</div>
				</div>
			</div>
			<%
				Motorbike m = new Motorbike();
			if (typeVehicle == "Motorbike") {
				m = (Motorbike) vehicle;
			}
			%>
			<div class="form-row moto hidevehicle">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">power</label> <input type="text"
						class="form-control" id="validationTooltip03" name="powerMotor"
						value="<%=m.getPower()%>">
					<div class="invalid-tooltip"></div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="maxSpeed">KM</label> <input type="number"
						class="form-control" id="maxSpeed" name="kmMotor"
						value="<%=m.getKm()%>">

				</div>
			</div>
			<%
				Airplane a = new Airplane();
			if (typeVehicle == "Airplane") {
				a = (Airplane) vehicle;
			}
			%>
			<div class="form-row airplane hidevehicle">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">NB motors</label> <input
						type="number" class="form-control" id="validationTooltip03"
						name="nbMotors" value="<%=a.getNbMotor()%>">

				</div>

			</div>
			<button class="btn btn-primary" type="submit">Mettre à jour
				la vehicle</button>
		</form>
	</div>

</body>
</html>