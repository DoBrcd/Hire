<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>

body {
  background-image: url("https://source.unsplash.com/1600x900/?car,plane");
background-attachment: fixed;
background-position: center;
background-size: cover;
}
</style>
<body>
	<%@ page import="controller.RegisterController" %>
	<div align="center" class="container">
	<h2 align="center">
	<% if(request.getAttribute("msg2") != null) { %>
		<p style="color: red">
			<%= request.getAttribute("msg2") %>
		</p>
	<% } %>
	</h2>
		
		<form action="<%=request.getContextPath()%>/register" method="post" class="form bg-light p-2" style="width: 18rem;">
		<h1>Employee Login Form</h1>
		<% if(request.getAttribute("msg") != null) { %>
		<div class="alert alert-danger" role="alert">
			  <%=request.getAttribute("msg") %>
			</div>
			<% } %>				
			<div class="form-group">
			    <label for="exampleInputEmail1">Username</label>
			    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
			</div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword2">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword2" name="confirmPassword">
			  </div>
			  <div class="form-group">
			    <label for="inputPosition">State</label>
			    <select id="inputPosition" class="form-control" name="position">
			    	<% 
			    		for (int i = 0; i < RegisterController.getPositionsList().length; i++ ) {
			    			%>
			    			<option value=<%=RegisterController.getPositionsList()[i] %>><%=RegisterController.getPositionsList()[i] %></option>
			    			<%
			    		}
			    	%>
			    </select>
			  </div>
			
			  <button type="submit" class="btn btn-primary">Register</button>
			</form>
	</div>
</body>
</html>