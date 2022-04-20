<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th scope="col" width="30%">Image</th>
            <th scope="col" width="10%">Nom</th>
            <th scope="col" width="10%">Catégorie</th>
            <th scope="col" width="10%">Prix</th>
            <th scope="col" width="10%">Matières premières</th>
            <th scope="col" width="10%">Origines</th>
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
            <td>
                <ul>
                <c:forEach items="${ product.getProduitMatieresAsso() }" var="pma">
                    <li>${pma.getMatierePremiere().getMatiere_premiere_nom()}</li>
                </c:forEach>
                </ul>
            </td>
            <td>
                <ul>
                <c:forEach items="${ product.getProduitMatieresAsso() }" var="pma">
                    <li>${pma.getOrigine().getOrigine_nom()}</li>
                </c:forEach>
                </ul>
            </td>
            <td><button type="button" class="btn btn-black btn-associerProduit" value="${product.produit_id}">Associer</button></td>
            <td><button type="button" class="btn btn-primary btn-modifierProduit" value="${product.produit_id}">Modifier</button></td>
            <td><button type="button" class="btn btn-danger btn-deleteProduit" value="${product.produit_id}">Supprimer</button></td>
        </c:forEach>
    </tbody>
</table>