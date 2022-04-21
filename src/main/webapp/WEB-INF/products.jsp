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
        <a href="/produit/${ product.produit_id }">
            <i class="ti-eye"></i>
        </a>
        </div>
    </div>
    <div class="product-btm">
        <a href="/produit/${ product.produit_id }" class="d-block">
        <h4 style="text-align: center">${ product.produit_nom }</h4>
        </a>
        <div class="mt-3" style="text-align: center">
        <span class="mr-4">${ product.produit_prix } DH</span>
        </div>
    </div>
    </div>
</div>
</c:forEach>