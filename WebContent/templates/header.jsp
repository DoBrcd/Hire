<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>:: Home ::</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

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
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Hire</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span
                        class="sr-only">(current)</span></a>
            </li>
            <% if((boolean)request.getAttribute("userCanCreate")) { %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#"
                       data-toggle="dropdown">Création</a>
                    <div class="dropdown-menu">
                        <% if((boolean)request.getAttribute("userCanCreateVehicle")) { %>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/vehicle/create">
                                Véhicule
                            </a>
                        <% } if((boolean)request.getAttribute("userCanCreateCustomer")) { %>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/client/create">
                                Client
                            </a>
                        <% } %>
                    </div>
                </li>
            <% } %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#"
                   data-toggle="dropdown">Recherche</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/vehicle/research">
                        Véhicule
                    </a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/client/search">
                        Client
                    </a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/research">
                        Location
                    </a>
                </div>
            </li>
            <% if((boolean)request.getAttribute("userCanAccessStats")) { %>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/stats">Statistiques</a>
                </li>
            <% } %>
            <% if((boolean)request.getAttribute("userCanCreate") && (boolean)request.getAttribute("userCanCreateHiring")) { %>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/create">Nouvelle location</a>
                </li>
            <% } %>
            <% if((boolean)request.getAttribute("userCanCreate") && (boolean)request.getAttribute("userCanCreateEmployee")) { %>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Nouvel employée</a>
                </li>
            <% } %>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>

        </ul>
        <%--        <h3><%= session.getAttribute("id")  %> <%= session.getAttribute("position")  %>--%>
        </h3>
    </div>
</nav>