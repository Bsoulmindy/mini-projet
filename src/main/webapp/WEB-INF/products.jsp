<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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