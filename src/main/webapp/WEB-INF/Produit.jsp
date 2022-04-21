<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>


    <!--================Single Product Area =================-->
    <div class="product_image_area" style="margin-bottom: 5rem;">
      <div class="container">
        <div class="row s_product_inner">
          <div class="col-lg-6">
            <div class="s_product_img">
              <div
                id="carouselExampleIndicators"
                class="carousel slide"
                data-ride="carousel"
              >
                
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      class="d-block w-100"
                      src="${product.produit_image}"
                      alt=""
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-5 offset-lg-1">
            <div class="s_product_text">
              <h3>${product.produit_nom}</h3>
              <h2><span id="idPrix">${product.produit_prix}</span> DH</h2>
              <ul class="list">
                <li>
                  <a class="active" href="#">
                    <span>Catégorie</span> : ${product.produit_categorie}</a
                  >
                </li>
                <li>
                  <span>Unité</span> : ${product.produit_unite}
                </li>
              </ul>
              <p>
                ${product.produit_desc}
              </p>
              <div>
                <label for="qty" style="font-size: 20px;">Votre panier :</label>
                <button type="button" class="btn btn-primary btn-sm btnSM me-5" onclick="Decrementer('${product.produit_id}')">-</button>
                <span class="text-center my-0 me-5 nb-products-in-cart" id="${product.produit_id}"></span>
                <button type="button" class="btn btn-primary btn-sm btnSM" onclick="Incrementer('${product.produit_id}')">+</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--================End Single Product Area =================-->

    <script src="/inc/js/selectionProduits.js"></script>
    <c:import url="/inc/footer.jsp"/>
  </body>
</html>
