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
              <div class="row" style="flex-direction: column;">
                <c:forEach items="${ cooperatives }" var="cooperative" varStatus="status">
                <div>
                  <div class="single-product" style="margin-bottom: 0px;">
                    
                    <div class="product-btm">
                      <a href="/cooperativeDesc?cooperative_id=${ cooperative.cooperative_id }" class="d-block">
                        <h4>${ cooperative.cooperative_nom }</h4>
                      </a>
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
                  <h3>Secteur d'activités</h3>
                </div>
                <div class="widgets_inner">
                  <ul class="list">
                  <c:forEach items="${ secteurActivites }" var="secteurActivite" varStatus="status">
                    <li>
                      <a href="/cooperative?secteurActivite=${ secteurActivite }">${ secteurActivite }</a>
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
