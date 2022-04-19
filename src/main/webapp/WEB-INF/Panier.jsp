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
                  <th scope="col" width="50%">Produit</th>
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
                      <div class="d-flex">
                        <img
                          src="${ product.produit_image }"
                          alt=""
                        />
                      </div>
                      <div class="media-body">
                        <p>${ product.produit_nom }</p>
                      </div>
                    </div>
                  </td>
                  <td></td>
                  <td>
                    <h5 id="idPrix">${ product.produit_prix }</h5>
                  </td>
                  <td>
                    <div>
                      <button type="button" class="btn btn-primary btn-sm btnSM me-5" onclick="Decrementer('id')">-</button>
                      <span class="text-center my-0 me-5 nb-products-in-cart" id="id"></span>
                      <button type="button" class="btn btn-primary btn-sm btnSM" onclick="Incrementer('id')">+</button>
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
                      <c:if test='${role == "user"}'>
                        <a  class="main_btn" href="/user/achat">Acheter</a>
                      </c:if>
                      <c:if test='${role == null || role != "user"}'>
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
    <script src="inc/js/panier.js"></script>
    <c:import url="/inc/footer.jsp"/>
  </body>
</html>
