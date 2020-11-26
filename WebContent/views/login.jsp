
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
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

	<div align="center" class="container">
	<h2 align="center">
	<% if(request.getAttribute("msg2") != null) { %>
		<p style="color: red">
			<%= request.getAttribute("msg2") %>
		</p>
	<% } %>
	</h2>
		
		<form action="<%=request.getContextPath()%>/" method="post" class="form bg-light p-2" style="width: 18rem;">
		<h1>Employee Login Form</h1>
		<% if(request.getAttribute("msg") != null) { %>
		<div class="alert alert-danger" role="alert">
			  <%=request.getAttribute("msg") %>
			</div>
			<% } %>				
						 <div class="form-group">
			    <label for="exampleInputEmail1">Username</label>
			    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" autofocus>
			   	  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
			  </div>
			
			  <button type="submit" class="btn btn-primary">Login</button>
			</form>
	</div>
	
<%@include file="templates/footer.jsp" %>