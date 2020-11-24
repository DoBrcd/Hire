<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List" %>
	<%@ page import="model.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche Client</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
body {
	background-image: url("https://source.unsplash.com/1600x900/?BMW");
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}
</style>
</head>

<body>
	<h1>La liste des Clients</h1>


	
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
		aria-expanded="false" aria-label="Toggle navigation">
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
  <h3>  <%=session.getAttribute("id")%> <%=session.getAttribute("position")%></h3>
  </div>
</nav><div class="container">
	<form class="needs-validation bg-light p-3 mt-5"
		action="<%=request.getContextPath()%>/customer/research" method="post">
		<div class="input-group mb-3">

			<div class="form-group">
			    <label for="exampleInputEmail1">Nom ou mail du client</label>
			    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
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
</body>
</html>