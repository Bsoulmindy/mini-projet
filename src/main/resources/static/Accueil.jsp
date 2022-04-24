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

    <!--================ Inspired Product Area =================-->
    <section class="inspired_product_area section_gap_bottom_custom">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12">
            <div class="main_title">
              <h2><span>QUELQUE PRODUITS</span></h2>
              <p>Essayez les produits achetés par plusieurs utilisateurs</p>
            </div>
          </div>
        </div>

        <div class="d-flex justify-content-around">
        <c:forEach items="${ randomProducts }" var="randomProduct" varStatus="status">
          <div class="col-lg-3 col-md-6">
            <div class="single-product">
              <div class="product-img">
                <img class="w-100" src="${ randomProduct.produit_image }" alt="" height="196" width="256"/>
                <div class="p_icon">
                    <a href="/produit/${ randomProduct.produit_id }">
                      <i class="ti-eye"></i>
                    </a>
                  </div>
              </div>
              <div class="product-btm">
                <a href="#" class="d-block">
                  <h4 style="text-align: center">${ randomProduct.produit_nom }</h4>
                </a>
                <div class="mt-3" style="text-align: center">
                  <span class="mr-4">${ randomProduct.produit_prix } DH</span>
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