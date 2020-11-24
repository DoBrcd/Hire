<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create vehicle</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	  $(".hidevehicle").hide();
  $("#vehicleType").change(function(){
    let type=$(this).val();
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
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">Navbar</a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="./logout">Logout</a>
      </li>
     
    </ul>
  <h3>  <%= session.getAttribute("id")  %> <%= session.getAttribute("position")  %></h3>
  </div>
</nav>
<div class="container">
<form class="needs-validation bg-light p-3 mt-5" action="<%=request.getContextPath()%>/vehicle/create" method="post" >
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Vehicle Type</label>
  </div>
  <select class="custom-select col-md-3" name="vehicleType" id="vehicleType">
    <option selected>Choose...</option>
    <option value="Motorbike">Motorbike</option>
    <option value="Car">Car</option>
    <option value="Aireplane">Aireplane</option>
  </select>
</div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationTooltip01">model</label>
      <input type="text" class="form-control" id="validationTooltip01" name="model" value="Mark" required>
      <div class="valid-tooltip">
        Looks good!
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationTooltip02">brand</label>
      <input type="text" class="form-control" id="validationTooltip02" name="brand" value="BMW" required>
      <div class="valid-tooltip">
        Looks good!
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationTooltipUsername">state</label>    
        <input type="text" class="form-control" id="state"  name="state"aria-describedby="validationTooltipUsernamePrepend" required>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationTooltip03">price</label>
      <input type="text" class="form-control" id="validationTooltip03" name="price" required>
      <div class="invalid-tooltip">
        Please provide a valid city.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="maxSpeed">Maximum Speed</label>
      <input type="text" class="form-control" id="maxSpeed" name="maxSpeed" required>
      <div class="invalid-tooltip">
        Please select a valid state.
      </div>
    </div>
  </div>
   <div class="form-row car hidevehicle">
  <div class="col-md-6 mb-3">
      <label for="validationTooltip03">power</label>
      <input type="text" class="form-control" id="validationTooltip03" name="powercar" >
      <div class="invalid-tooltip">
        Please provide a valid city.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="maxSpeed">KM</label>
      <input type="number" class="form-control" id="maxSpeedcar" name="kmCar" >
      <div class="invalid-tooltip">
        Please select a valid state.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="maxSpeed">sits number</label>
      <input type="number" class="form-control" id="sitsnumber" name="sitsnumber" >
      <div class="invalid-tooltip">
        Please select a valid state.
      </div>
    </div>
  </div>
   <div class="form-row moto hidevehicle">
    <div class="col-md-6 mb-3">
      <label for="validationTooltip03">power</label>
      <input type="text" class="form-control" id="validationTooltip03" name="powerMotor" >
      <div class="invalid-tooltip">

      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="maxSpeed">KM</label>
      <input type="number" class="form-control" id="maxSpeed" name="kmMotor" >
   
    </div>
  </div>
   <div class="form-row aireplane hidevehicle">
    <div class="col-md-6 mb-3">
      <label for="validationTooltip03">NB motors</label>
      <input type="number" class="form-control" id="validationTooltip03" name="nbMotors" >
    
    </div>
    
  </div>
  <button class="btn btn-primary" type="submit">Create vehicle</button>
</form>
</div>

</body>
</html>