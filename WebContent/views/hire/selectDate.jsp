<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../templates/header.jsp" %>
	<h1>Selectionnez une fourchette de date pour la location</h1>
	<form method="get">
		<div>
			<p><label name="dateDebut">Une date de début</label></p>
			<p><input type="date" name="dateDebut"></input></p>
		</div>
		<div>
			<p><label name="dateDebut">Une date de fin</label></p>
			<p><input type="date" name="dateFin"></input></p>
		</div>
		<button type="submit">Envoyer</button>
	
	</form>
<%@include file="../templates/footer.jsp" %>