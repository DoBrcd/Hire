<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import='com.hire.model.StateVehicle' %>
<%@include file="../templates/header.jsp" %>

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
    <option value="Airplane">Airplane</option>
  </select>
</div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationTooltip01">com.hire.model</label>
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
      <label for="validationTooltipUsername">state</label><br>
      <select name="state" id="name">
        <% for(StateVehicle state : StateVehicle.values()){ %>
        	<option value="<%= state.name() %>"><%= state.name() %></option>
        <% } %>
        </select>
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
   <div class="form-row airplane hidevehicle">
    <div class="col-md-6 mb-3">
      <label for="validationTooltip03">NB motors</label>
      <input type="number" class="form-control" id="validationTooltip03" name="nbMotors" >
    
    </div>
    
  </div>
  <button class="btn btn-primary" type="submit">Create vehicle</button>
</form>
</div>

<script>
window.onload = () => {
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
}
)};
</script>

<%@include file="../templates/footer.jsp" %>