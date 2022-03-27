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
        <div class="row s_product_inner" style="align-items: center; justify-content: center;">
          
          <div class="col-lg-5 offset-lg-1">
            <div class="s_product_text">
              <h2>${cooperative.cooperative_nom}</h2>
              
              <ul class="list" style="margin-top:3rem;">
                <li>
                  <h5 style="display: inline-block;width: 140px;">Origine</h5> : ${cooperative.getOrigine().origine_nom}
                </li>
                <li>
                  <h5 style="display: inline-block;width: 140px;">Secteur d'activité</h5> : ${cooperative.cooperative_secteurActivite}
                </li>
              </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--================End Single Product Area =================-->

    <c:import url="/inc/footer.jsp"/>
  </body>
</html>
