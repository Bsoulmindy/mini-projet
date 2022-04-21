<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th scope="col" width="30%">Nom du coopérative</th>
            <th scope="col" width="20%">Secteur d'activité</th>
            <th scope="col" width="20%">Origine</th>
            <th scope="col" width="15%"></th> <!-- Accepter -->
            <th scope="col" width="15%"></th> <!-- Rejeter -->
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ demandeCooperatives }" var="demandeCooperative" varStatus="status">
        <tr>
            <td>${demandeCooperative.getCooperative().getCooperative_nom()}</td>
            <td>${demandeCooperative.getCooperative().getCooperative_secteur_activite()}</td>
            <td>${demandeCooperative.getCooperative().getOrigine().getOrigine_nom()}</td>
            <td><button type="button" class="btn btn-primary btn-accepterCoop" value="${demandeCooperative.getCooperative().getCooperative_id()}">Accepter</button></td>
            <td><button type="button" class="btn btn-danger btn-refuserCoop" value="${demandeCooperative.getCooperative().getCooperative_id()}">Refuser</button></td>
        </tr>
        </c:forEach>
    </tbody>
</table>