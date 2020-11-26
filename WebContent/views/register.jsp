<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="templates/header.jsp" %>

	<%@ page import="com.hire.controller.RegisterController" %>
	<div align="center" class="container">
	<h2 align="center">
	<% if(request.getAttribute("msg2") != null) { %>
		<p style="color: red">
			<%= request.getAttribute("msg2") %>
		</p>
	<% } %>
	</h2>
		
		<form action="<%=request.getContextPath()%>/register" method="post" class="form bg-light p-2" style="width: 18rem;">
		<h1>Employee Register Form</h1>
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
<%@include file="templates/footer.jsp" %>