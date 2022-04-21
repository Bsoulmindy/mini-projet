<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th scope="col" width="20%">Image</th>
            <th scope="col" width="10%">Nom</th>
            <th scope="col" width="10%">Catégorie</th>
            <th scope="col" width="7%">Prix</th>
            <th scope="col" width="10%">Matières premières</th>
            <th scope="col" width="8%">Quantité</th>
            <th scope="col" width="7%">Unité</th>
            <th scope="col" width="10%">Origines</th>
            <th scope="col" width="6%"></th> <!-- Associer -->
            <th scope="col" width="6%"></th> <!-- Modifier -->
            <th scope="col" width="6%"></th> <!-- Supprimer -->
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ products }" var="product" varStatus="status">
        <tr style="vertical-align: middle;">
            <td><img src="${product.produit_image}" alt="" width="256" height="169" style="width:100%;height:100%"></td>
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
                    <li>${pma.getMatiere_premiere_quantite()}</li>
                </c:forEach>
                </ul>
            </td>
            <td>
                <ul>
                <c:forEach items="${ product.getProduitMatieresAsso() }" var="pma">
                    <li>${pma.getMatiere_premiere_unite()}</li>
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
            <td><button type="button" class="btn btn-dark btn-associerProduit" value="${product.produit_id}">Associer</button></td>
            <td><button type="button" class="btn btn-primary btn-modifierProduit" value="${product.produit_id}">Modifier</button></td>
            <td><button type="button" class="btn btn-danger btn-deleteProduit" value="${product.produit_id}">Supprimer</button></td>
        </tr>
        </c:forEach>
    </tbody>
</table>