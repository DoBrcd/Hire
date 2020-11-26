<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>selection date</title>
</head>
<body>
	<h1>Selectionnez une fourchette de date pour la location</h1>
	<form method="get" action="#">
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
</body>
</html>