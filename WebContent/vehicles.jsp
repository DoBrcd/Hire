<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Home ::</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
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
</form>
 <table class="table table-striped bg-light">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <c:choose>
  <c:when test="${empty monArrayList}">
    pas d'information
  </c:when>
  <c:otherwise>
    <c:forEach items="${monArrayList}" var"p">
      ${p.info1}
      ${p.info2}
      ...
    </c:forEach>
  </c:otherwise>
</c:choose>
  </tbody>
</table>
</div>

</body>
</html>