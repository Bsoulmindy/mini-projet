<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

    <div class="table-responsive my-5">
      <table class="table table-striped">
          <thead>
              <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Nom des produits</th>
                  <th scope="col">Qté des produits</th>
                  <th scope="col">Prix total</th>
                  <th scope="col">Délivré?</th>
              </tr>
          </thead>
          <tbody>
              <tr>
                <c:forEach items="${ commandes }" var="commande" varStatus="status">
                  <c:forEach items="${ commande.getProduits }" var="produit">
                    <td rowspan="${commande.getProduits.size()}">${ commande.commande_id }</td>
                    <td>${ produit.produit_nom }</td>
                    <td rowspan="${commande.getProduits.size()}">${ commande.commande_prix_total }</td>
                    <td rowspan="${commande.getProduits.size()}">${ commande.commande_is_delivre }</td>
                    </c:forEach>
                </c:forEach>
              </tr>
          </tbody>
      </table>
  </div>

  <c:import url="/inc/footer.jsp"/>
</body>

</html>