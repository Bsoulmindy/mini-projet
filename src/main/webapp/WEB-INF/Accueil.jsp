<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html lang="en">

  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

    <!--================Home Banner Area =================-->
    <section class="home_banner_area mb-40">
      <div class="banner_inner d-flex align-items-center">
        <div class="container">
          <div class="banner_content row">
            <div class="col-lg-12">
              <h3><span>Tout ce que<br />vous rêvez</span></h3>
              <h4><strong>Produits terroirs marocains de differents matières.</strong></h4>
              <a class="main_btn mt-40" href="/category">Voir notre magasin</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!-- Start feature Area -->
    <section class="feature-area section_gap_bottom_custom">
      <div class="container">
        <div class="row" style="justify-content: center;">

          <div class="col-lg-3 col-md-6">
            <div class="single-feature">
              <i class="flaticon-truck"></i>
              <h3>Délivration gratuit</h3>
              <p>Achetez sans déplacer</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6">
            <div class="single-feature">
              <i class="flaticon-support"></i>
              <h3>24/7</h3>
              <p>Support est toujours disponible</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6">
            <div class="single-feature">
              <i class="flaticon-blockchain"></i>
              <h3>Sécurité</h3>
              <p>Achetez en tout sécurité</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End feature Area -->

    <!--================ New Product Area =================-->
    <section class="new_product_area section_gap_top section_gap_bottom_custom">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12">
            <div class="main_title">
              <h2><span>nouveaux produits</span></h2>
              <p>Essayez nos nouveaux produits qui ont mis dans notre magasin</p>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-6">
            <div class="new_product">
              <h3 class="text-uppercase">${newProducts[0].produit_nom}</h3>
              <div class="product-img">
                <img class="img-fluid" src="${newProducts[0].produit_image}" alt="" />
              </div>
              <h4>${newProducts[0].produit_prix}</h4>
                <c:if test="${!newProducts.isEmpty() && newProducts != null}">
                  <a href="/produit?produit_id=${ newProducts[0].produit_id }" class="main_btn">Voir le produit</a>
                </c:if>
            </div>
          </div>

          

          <div class="col-lg-6 mt-5 mt-lg-0">
            <div class="row">
              <c:forEach items="${ newProducts }" var="newProduct" varStatus="status">
                <c:if test="${status.count > 1}">
                <div class="col-lg-6 col-md-6">
                  <div class="single-product">
                    <div class="product-img">
                      <img class="img-fluid w-100" src="${ newProduct.produit_image }" alt="" />
                      <div class="p_icon">
                        <a href="/produit?produit_id=${ newProduct.produit_id }">
                          <i class="ti-eye"></i>
                        </a>
                      </div>
                    </div>
                    <div class="product-btm">
                      <a href="#" class="d-block">
                        <h4>${ newProduct.produit_nom }</h4>
                      </a>
                      <div class="mt-3">
                        <span class="mr-4">${ newProduct.produit_prix }</span>
                      </div>
                    </div>
                  </div>
                </div>
                </c:if>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================ End New Product Area =================-->

    <!--================ Inspired Product Area =================-->
    <section class="inspired_product_area section_gap_bottom_custom">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12">
            <div class="main_title">
              <h2><span>Produits les plus populaires</span></h2>
              <p>Essayez les produits achetés par plusieurs utilisateurs</p>
            </div>
          </div>
        </div>

        <div class="row">
        <c:forEach items="${ popularProducts }" var="popularProduct" varStatus="status">
          <div class="col-lg-3 col-md-6">
            <div class="single-product">
              <div class="product-img">
                <img class="img-fluid w-100" src="${ popularProduct.produit_image }" alt="" />
                <div class="p_icon">
                    <a href="/produit?produit_id=${ popularProduct.produit_id }">
                      <i class="ti-eye"></i>
                    </a>
                  </div>
              </div>
              <div class="product-btm">
                <a href="#" class="d-block">
                  <h4>${ popularProduct.produit_nom }</h4>
                </a>
                <div class="mt-3">
                  <span class="mr-4">${ popularProduct.produit_prix }</span>
                </div>
              </div>
            </div>
          </div>
          </c:forEach>
        </div>
      </div>
    </section>
    <!--================ End Inspired Product Area =================-->

    <c:import url="/inc/footer.jsp"/>
  </body>

  </html>