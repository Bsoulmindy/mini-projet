<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="login_signup_option">
    <div class="l-modal is-hidden--off-flow js-ajouterProduit-form">
        <div class="l-modal__shadow js-ajouterProduit-hide"></div>
        <div class="login_popup login_modal_body">
            <div class="Popup_title d-flex justify-content-between">
                <h2 class="hidden">&nbsp;</h2>
                <!-- Nav tabs -->
                <div class="row" style="margin: 0px;width: 100%;">
                    
                    
                    <div class="col-12 col-lg-12 col-md-12 col-lg-12">
                        <!-- Tab panels -->
                        <div class="tab-content card">
                            <!--Panel-->
                            <div class="tab-pane fade show active" id="panelProduit" role="tabpanel">
                                <form action="#" class="ajouterProduit needs-validation" id="formProduit">
                                    <div class="d-flex justify-content-center">
                                        <div class="mt-2" id="ajouterProduitMessage">
                                            
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="ajouterProduitNom" class="form-label auth-label">Nom du produit</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <input type="text" class="form-control auth-input" value="" id="ajouterProduitNom" required>
                                            <div class="invalid-feedback" id="ajouterProduitNomInvalid">
                                                Nb de caractères permises : [3 - 60]
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="ajouterProduitPrix" class="form-label auth-label">Prix</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <input type="number" class="form-control auth-input" value=1 id="ajouterProduitPrix" required>
                                            <div class="invalid-feedback" id="ajouterProduitPrixInvalid">
                                                Doît être un nombre
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="newProduitUnite" class="form-label auth-label">Unité</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <select class="form-control auth-input" id="newProduitUnite" required>
                                                <c:forEach items="${ unites }" var="unite" varStatus="status">
                                                    <option value="${unite}">${unite}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="invalid-feedback" id="newProduitUniteInvalid">
                                                
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="newProduitCategorie" class="form-label auth-label">Catégorie</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <select class="form-control auth-input" id="newProduitCategorie" required>
                                                <c:forEach items="${ categories }" var="categorie" varStatus="status">
                                                    <option value="${categorie}">${categorie}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="invalid-feedback" id="newProduitCategorieInvalid">
                                                
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="newProduitImage" class="form-label auth-label">Image</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-start">
                                        <div class="" style="width: 100%; margin: 5px;color: rgb(121,121,121)">
                                            <input type="file" class="" id="newProduitImage" required>
                                            <div class="invalid-feedback" id="newProduitInvalid">
                                                Image doit être en format .png ou .jpg, et ne doit pas dépassé 1Mo
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-lg-12 col-md-12 col-lg-12 d-flex justify-content-center login_option">
                                            <button type="submit" class="btn btn-default login_btn" onClick="ajouterProduit(event)">Créer le produit</button>
                                        </div> 
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section> 





<section class="login_signup_option">
    <div class="l-modal is-hidden--off-flow js-modifierProduit-form">
        <div class="l-modal__shadow js-modifierProduit-hide"></div>
        <div class="login_popup login_modal_body">
            <div class="Popup_title d-flex justify-content-between">
                <h2 class="hidden">&nbsp;</h2>
                <!-- Nav tabs -->
                <div class="row" style="margin: 0px;width: 100%;">
                    
                    
                    <div class="col-12 col-lg-12 col-md-12 col-lg-12">
                        <!-- Tab panels -->
                        <div class="tab-content card">
                            <!--Panel-->
                            <div class="tab-pane fade show active" id="panelProduit" role="tabpanel">
                                <form action="#" class="modifierProduit needs-validation" id="formProduit">
                                    <input type="hidden" id="idProduit" value="">
                                    <div class="d-flex justify-content-center">
                                        <div class="mt-2" id="modifierProduitMessage">
                                            
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="modifierProduitNom" class="form-label auth-label">Nom du produit</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <input type="text" class="form-control auth-input" value="" id="modifierProduitNom" required>
                                            <div class="invalid-feedback" id="modifierProduitNomInvalid">
                                                Nb de caractères permises : [3 - 60]
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="modifierProduitPrix" class="form-label auth-label">Prix</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <input type="number" class="form-control auth-input" value=1 id="modifierProduitPrix" required>
                                            <div class="invalid-feedback" id="modifierProduitPrixInvalid">
                                                Doît être un nombre
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="newProduitUnite" class="form-label auth-label">Unité</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <select class="form-control auth-input" id="newProduitUnite" required>
                                                <c:forEach items="${ unites }" var="unite" varStatus="status">
                                                    <option value="${unite}">${unite}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="invalid-feedback" id="newProduitUniteInvalid">
                                                
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="newProduitCategorie" class="form-label auth-label">Catégorie</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <select class="form-control auth-input" id="newProduitCategorie" required>
                                                <c:forEach items="${ categories }" var="categorie" varStatus="status">
                                                    <option value="${categorie}">${categorie}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="invalid-feedback" id="newProduitCategorieInvalid">
                                                
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="newProduitImage" class="form-label auth-label">Image</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-start">
                                        <div class="" style="width: 100%; margin: 5px;color: rgb(121,121,121)">
                                            <input type="file" class="" id="newProduitImage" required>
                                            <div class="invalid-feedback" id="newProduitInvalid">
                                                Image doit être en format .png ou .jpg, et ne doit pas dépassé 1Mo
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-lg-12 col-md-12 col-lg-12 d-flex justify-content-center login_option">
                                            <button type="submit" class="btn btn-default login_btn" onClick="modifierProduit(event)">Modifier le produit</button>
                                        </div> 
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section> 