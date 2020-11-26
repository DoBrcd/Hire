<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/templates/header.jsp" %>

<%@ page import="com.hire.model.Customer" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<div class="container">
    <h1 class="align-center">Statistiques clients</h1>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="card" style="width: 30rem;">
                    <div class="card-body">
                        <h5 class="card-title">Meilleurs clients</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Nombre location</h6>
                        <% if(request.getAttribute("bestHiring") != null) { %>
                        <ul>
                            <% for(Map.Entry<Customer, Double> entry : (List<Map.Entry<Customer, Double>>)request.getAttribute("bestHiring")) { %>
                            <li><%= entry.getKey().getFirstName() %> <%= entry.getKey().getName() %> - <%= entry.getValue() %></li>
                            <% } %>
                        </ul>
                        <% } else { %>
                        <p>Aucune donnée pour le moment</p>
                        <% } %>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card" style="width: 30rem;">
                    <div class="card-body">
                        <h5 class="card-title">Meilleurs clients</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Total des dépenses</h6>
                        <% if(request.getAttribute("bestBuyer") != null) { %>
                        <ul>
                            <% for(Map.Entry<Customer, Double> entry : (List<Map.Entry<Customer, Double>>)request.getAttribute("bestBuyer")) { %>
                            <li><%= entry.getKey().getFirstName() %> <%= entry.getKey().getName() %> - <%= String.format("%.02f", entry.getValue()) %></li>
                            <% } %>
                        </ul>
                        <% } else { %>
                        <p>Aucune donnée pour le moment</p>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/views/templates/footer.jsp" %>