<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th scope="col" width="100%">Nom</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ matierePremieres }" var="matierePremiere" varStatus="status">
            <tr>
                <td>${matierePremiere.matiere_premiere_nom}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>