<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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