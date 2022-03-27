<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

    <!--================Category Product Area =================-->
    <section class="cat_product_area section_gap">
      <div class="container">
        <div class="row flex-row-reverse">
          <div class="col-lg-9">
            
            <div class="latest_product_inner">
              <div class="row">
                <c:forEach items="${ products }" var="product" varStatus="status">
                <div class="col-lg-4 col-md-6">
                  <div class="single-product">
                    <div class="product-img">
                      <img
                        class="card-img"
                        src="${ product.produit_image }"
                        alt=""
                      />
                      <div class="p_icon">
                        <a href="/produit?produit_id=${ product.produit_id }">
                          <i class="ti-eye"></i>
                        </a>
                      </div>
                    </div>
                    <div class="product-btm">
                      <a href="/produit?produit_id=${ product.produit_id }" class="d-block">
                        <h4>${ product.produit_nom }</h4>
                      </a>
                      <div class="mt-3">
                        <span class="mr-4">${ product.produit_prix }</span>
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>
            </div>
          </div>

          <div class="col-lg-3">
            <div class="left_sidebar_area">
              <aside class="left_widgets p_filter_widgets">
                <div class="l_w_title">
                  <h3>Catégories</h3>
                </div>
                <div class="widgets_inner">
                  <ul class="list">
                    <c:forEach items="${ categories }" var="categorie" varStatus="status">
                    <li>
                      <a href="/category?categorie=${ categorie }">${ categorie }</a>
                    </li>
                    </c:forEach>
                  </ul>
                </div>
              </aside>

              <aside class="left_widgets p_filter_widgets">
                <div class="l_w_title">
                  <h3>Matières premières</h3>
                </div>
                <div class="widgets_inner">
                  <ul class="list">
                    <c:forEach items="${ matierePremieres }" var="matierePremiere" varStatus="status">
                    <li>
                      <a href="/category?matierePremiere=${ matierePremiere }">${ matierePremiere }</a>
                    </li>
                    </c:forEach>
                  </ul>
                </div>
              </aside>

              <aside class="left_widgets p_filter_widgets">
                <div class="l_w_title">
                  <h3>Origines</h3>
                </div>
                <div class="widgets_inner">
                    <%-- <select id="origineInput" class="nice-select" aria-label="" name="origine">
                        <c:forEach items="${ origines }" var="origine">
                            <option value="${origine.getId()}">${origine.getNomOrigine()}</option>
                        </c:forEach>
                      </select> --%>
                      <ul class="list">
                        <c:forEach items="${ origines }" var="origine" varStatus="status">
                        <li>
                          <a href="/category?origine=${ origine }">${ origine }</a>
                        </li>
                        </c:forEach>
                      </ul>
                </div>
              </aside>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Category Product Area =================-->

    <c:import url="/inc/footer.jsp"/>
  </body>
</html>
