<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/views/templates/header.jsp" %>
<% String idHire = (String) request.getAttribute("idHire"); %>

<form method="post">
	<input type="hidden" value="<%= idHire %>" name="idHire">
	<div>
		<label name="km">Km parcourus</label>
		<input type="number" name="km">
	</div>
	<button type="submit">Envoyer</button>
</form>

<%@include file="/views/templates/footer.jsp" %>