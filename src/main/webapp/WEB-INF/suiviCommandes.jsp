<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

    <div class="d-flex justify-content-center my-2">
          <h1>Suivi des commandes clients</h1>
    </div>

    <section class="cat_product_area section_gap">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col" width="10%">ID</th>
                    <th scope="col" width="20%">Nom du personne</th>
                    <th scope="col" width="20%">Produits commandés</th>
                    <th scope="col" width="20%">Quantité</th>
                    <th scope="col" width="10%">Prix total</th>
                    <th scope="col" width="20%">Est délivré?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ commandes }" var="commande" varStatus="status">
                <tr>
                    <td>${commande.commande_id}</td>
                    <td>${commande.getCompte().getPersonne().getPersonne_nom()}</td>
                    <td>
                        <ul>
                        <c:forEach items="${ commande.getCommandeProduitAssos() }" var="cpa">
                            <li>${cpa.getProduit().getProduit_nom()}</li>
                        </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <ul>
                        <c:forEach items="${ commande.getCommandeProduitAssos() }" var="cpa">
                            <li>${cpa.getQuantite()}</li>
                        </c:forEach>
                        </ul>
                    </td>
                    <td>${commande.commande_prix_total} DH</td>
                    <td><input class="btn-toggleCommande" type="checkbox" idCommande="${commande.commande_id}" ${commande.commande_is_delivre ? 'checked' : ''}></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>

    <script src="/inc/js/jquery-3.2.1.min.js"></script>
    <script src="/inc/js/popper.js"></script>
    <script src="/inc/js/bootstrap.min.js"></script>
    <script src="/inc/js/stellar.js"></script>
    <script src="/inc/vendors/lightbox/simpleLightbox.min.js"></script>
    <script src="/inc/vendors/nice-select/js/jquery.nice-select.min.js"></script>
    <script src="/inc/vendors/isotope/imagesloaded.pkgd.min.js"></script>
    <script src="/inc/vendors/isotope/isotope-min.js"></script>
    <script src="/inc/vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="/inc/js/jquery.ajaxchimp.min.js"></script>
    <script src="/inc/vendors/counter-up/jquery.waypoints.min.js"></script>
    <script src="/inc/vendors/counter-up/jquery.counterup.js"></script>
    <script src="/inc/js/mail-script.js"></script>
    <script src="/inc/js/theme.js"></script>
    <script src="/inc/js/gestionProduits.js"></script>
  </body>
</html>
