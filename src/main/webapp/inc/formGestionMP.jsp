<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="login_signup_option">
    <div class="l-modal is-hidden--off-flow js-ajouterMP-form">
        <div class="l-modal__shadow js-ajouterMP-hide"></div>
        <div class="login_popup login_modal_body">
            <div class="Popup_title d-flex justify-content-between">
                <h2 class="hidden">&nbsp;</h2>
                <!-- Nav tabs -->
                <div class="row" style="margin: 0px;width: 100%;">
                    
                    
                    <div class="col-12 col-lg-12 col-md-12 col-lg-12">
                        <!-- Tab panels -->
                        <div class="tab-content card">
                            <!--Panel-->
                            <div class="tab-pane fade show active" id="panelMP" role="tabpanel">
                                <form action="#" class="ajouterMP needs-validation" id="formMP">
                                    <div class="d-flex justify-content-center">
                                        <div class="mt-2" id="ajouterMPMessage">
                                            
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <label for="ajouterMPNom" class="form-label auth-label">Nom du MP</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div class="" style="width: 100%; margin: 5px;">
                                            <input type="text" class="form-control auth-input" value="" id="ajouterMPNom" required>
                                            <div class="invalid-feedback" id="ajouterMPNomInvalid">
                                                Nb de caractères permises : [3 - 60]
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-lg-12 col-md-12 col-lg-12 d-flex justify-content-center login_option">
                                            <button type="submit" class="btn btn-default login_btn" onClick="ajouterMP(event)">Créer le MP</button>
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