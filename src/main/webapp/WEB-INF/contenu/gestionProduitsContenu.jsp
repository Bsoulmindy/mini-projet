<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th scope="col" width="35%">Image</th>
            <th scope="col" width="15%">Nom</th>
            <th scope="col" width="15%">Catégorie</th>
            <th scope="col" width="15%">Prix</th>
            <th scope="col" width="10%"></th> <!-- Modifier -->
            <th scope="col" width="10%"></th> <!-- Supprimer -->
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ products }" var="product" varStatus="status">
            <td><img src="${product.produit_image}" alt=""></td>
            <td>${product.produit_nom}</td>
            <td>${product.produit_categorie}</td>
            <td>${product.produit_prix}</td>
            <td><button type="button" class="btn btn-primary btn-modifierProduit" value="${product.produit_id}">Modifier</button></td>
            <td><button type="button" class="btn btn-danger btn-deleteProduit" value="${product.produit_id}">Supprimer</button></td>
        </c:forEach>
    </tbody>
</table>