<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

        <c:import url="/inc/formGestionProduits.jsp"/>

        <section class="cat_product_area section_gap">
            <div id="contenu">
                <c:import url="/WEB-INF/contenu/gestionProduitsContenu.jsp"/>
            </div>

            <div class="d-flex justify-content-center my-2">
                <button type="button" class="btn btn-success btn-ajouterProduit">Ajouter un nouveau produit</button>
            </div>
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
