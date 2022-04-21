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
              
                <c:forEach items="${ commandes }" var="commande" varStatus="status">
                <tr>
                  <c:forEach items="${ commande.getCommandeProduitAssos() }" var="cpa">
                    <td rowspan="${commande.getCommandeProduitAssos().size()}">${ commande.commande_id }</td>
                    <td>${cpa.getProduit().getProduit_nom()}</td>
                    <td>${cpa.getQuantite()}</td>
                    <td rowspan="${commande.getCommandeProduitAssos().size()}">${ commande.commande_prix_total } DH</td>
                    <td rowspan="${commande.getCommandeProduitAssos().size()}">${ commande.commande_is_delivre }</td>
                    </c:forEach>
                  </tr>
                </c:forEach>
              
          </tbody>
      </table>
  </div>

  <c:import url="/inc/footer.jsp"/>
</body>

</html>