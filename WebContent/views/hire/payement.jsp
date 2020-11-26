<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@include file="../templates/header.jsp" %>

<form method="post">
	<input type="number" value="12" name="idHire">
	<div>
		<label name="km">Km parcourus</label>
		<input type="number" name="km">
	</div>
	<button type="submit">Envoyer</button>
</form>

<%@include file="../templates/footer.jsp" %>