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
              <div class="row" id="sectionProducts">
                
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
                      <a class="category" href="/category/get/category?categorie=${ categorie }">${ categorie }</a>
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
                      <a class="matierePremiere" href="/category/get/matierePremiere?matierePremiere=${ matierePremiere.getMatiere_premiere_id() }">${ matierePremiere.getMatiere_premiere_nom() }</a>
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
                          <a class="origine" href="/category/get/origine?origine=${ origine.getOrigine_id() }">${ origine.getOrigine_nom() }</a>
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
    <script src="inc/js/category.js"></script>
  </body>
</html>
