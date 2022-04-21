<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

    <!--================Cart Area =================-->
    <section class="cart_area">
      <div class="container">
        <div class="cart_inner">
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col" width="50%" style="text-align: center;">Produit</th>
                  <th scope="col"></th>
                  <th scope="col">Prix</th>
                  <th scope="col">Quantité</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${ products }" var="product" varStatus="status">
                <tr>
                  <td>
                    <div class="media">
                      <div class="d-flex justify-content-center">
                        <img
                          src="${ product.produit_image }"
                          alt=""
                          height="196"
                          width="256"
                        />
                      </div>
                      <div class="media-body">
                        <p style="text-align: center;font-size: xx-large;color: black;margin-top: 1rem;">
                          ${ product.produit_nom }
                        </p>
                      </div>
                    </div>
                  </td>
                  <td></td>
                  <td>
                    <h5 id="${product.produit_id}Prix">${ product.produit_prix } DH</h5>
                  </td>
                  <td>
                    <div>
                      <button type="button" class="btn btn-primary btn-sm btnSM me-5" onclick="Decrementer('${product.produit_id}')">-</button>
                      <span class="text-center my-0 me-5 nb-products-in-cart" id="${product.produit_id}"></span>
                      <button type="button" class="btn btn-primary btn-sm btnSM" onclick="Incrementer('${product.produit_id}')">+</button>
                    </div>
                </tr>
                </c:forEach>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>
                    <h3>Total : <span id="coutTotal" class="price-total"></span> DH</h3>
                  </td>
                </tr>
                <tr class="out_button_area">
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>
                    <div class="checkout_btn_inner">
                      <a class="gray_btn" href="/magasin">Retour au magasin</a>
                      <c:if test='${role == "User" || role == "Cooperative" || role == "Admin"}'>
                        <a  class="main_btn" href="/user/achat">Acheter</a>
                      </c:if>
                      <c:if test='${role == null || (role != "User" && role != "Cooperative" && role != "Admin")}'>
                        <a role="link" aria-disabled="true" class="main_btn">Connecter pour continuer</a>
                      </c:if>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
    <!--================End Cart Area =================-->
    <script src="/inc/js/panier.js"></script>
    <c:import url="/inc/footer.jsp"/>
  </body>
</html>
