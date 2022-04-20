<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--================Header Menu Area =================-->
    <header class="header_area">
      <div class="top_menu">
        <div class="container">
          <div class="row">
            <div class="col-lg-7">
              <div class="float-left">
                <p>Phone: +212 49 84 21 32</p>
                <p>email: contact@terroir.ma</p>
              </div>
            </div>
            <div class="col-lg-5">
              <div class="float-right">
                <ul class="right_side">
                  <c:if test="${authentified == null || !authentified}">
                  <li>
                    <a href="/connexion">
                      Connexion
                    </a>
                  </li>
                  </c:if>
                  <c:if test="${authentified != null && authentified}">
                    <li>
                      <a href="/auth/deconnexion">
                        Déconnexion
                      </a>
                    </li>
                  </c:if>
                  <c:if test='${authentified != null && authentified && role == "User"}'>
                    <li>
                      <a href="/user/devenirCoop">
                        Devenir un coopérative
                      </a>
                    </li>
                  </c:if>
                  <li>
                    <a href="/contact">
                      Contacter-nous
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="main_menu">
        <div class="container">
          <nav class="navbar navbar-expand-lg navbar-light w-100">
            <!-- Brand and toggle get grouped for better mobile display -->
            <a class="navbar-brand logo_h" href="/">
              <img src="/inc/img/logo.png" alt="" />
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse offset w-100" id="navbarSupportedContent">
              <div class="row w-100 mr-0">
                <div class="col-lg-11 pr-0">
                  <ul class="nav navbar-nav center_nav pull-right">
                    <li class='nav-item ${active == "Accueil" ? "active" : ""}'>
                      <a class="nav-link" href="/">Accueil</a>
                    </li>
                    <li class='nav-item submenu dropdown ${active == "Category" || "Panier" ? "active" : ""}'>
                      <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                        aria-haspopup="true" aria-expanded="false">Magasin</a>
                      <ul class="dropdown-menu">
                        <li class='nav-item ${active == "Category" ? "active" : ""}'>
                          <a class="nav-link" href="/produits">Catégories</a>
                        </li>
                        <li class='nav-item ${active == "Panier" ? "active" : ""}'>
                          <a class="nav-link" href="/panier">Panier</a>
                        </li>
                      </ul>
                    </li>
                    <li class='nav-item ${active == "Cooperatives" ? "active" : ""}'>
                      <a class="nav-link" href="/cooperatives">Coopératives</a>
                    </li>
                    <li class='nav-item ${active == "Contact" ? "active" : ""}'>
                      <a class="nav-link" href="/contact">Contact</a>
                    </li>
                    <!-- Espace utilisateur/coopérative/admin -->
                    <li class='nav-item submenu dropdown ${active == "Espace" ? "active" : ""}'>
                      <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                        aria-haspopup="true" aria-expanded="false">Espace</a>
                      <ul class="dropdown-menu">
                        <c:if test='${role == "User"}'>
                          <li class='nav-item'>
                            <a class="nav-link" href="/user/tracking">Suivre votre commande</a>
                          </li>
                        </c:if>
                        <c:if test='${role == "Cooperative"}'>
                          <li class='nav-item'>
                            <a class="nav-link" href="/cooperative/gererProduits">Gérer mes produits</a>
                          </li>
                        </c:if>
                        <c:if test='${role == "Cooperative"}'>
                          <li class='nav-item'>
                            <a class="nav-link" href="/cooperative/suiviCommande">Suivre commandes clients</a>
                          </li>
                        </c:if>
                        <c:if test='${role == "Admin"}'>
                          <li class='nav-item'>
                            <a class="nav-link" href="/admin/gererCooperatives">Gérer les coopératives</a>
                          </li>
                        </c:if>
                        <c:if test='${role == "Admin"}'>
                          <li class='nav-item'>
                            <a class="nav-link" href="/admin/gererMatieresPremieres">Gérer les matières premières</a>
                          </li>
                        </c:if>
                      </ul>
                    </li>
                  </ul>
                </div>

                <div class="col-lg-1 pr-0">
                  <ul class="nav navbar-nav navbar-right right_nav pull-right">
                  <c:if test="${authentified != null || authentified}">
                    <li class="nav-item" style="font: 400 16px/80px Heebo, sans-serif;">
                      Bonjour, ${personneNom}
                    </li>
                  </c:if>
                    <li class="nav-item">
                      <a href="/panier" class="icons">
                        <i class="ti-shopping-cart"></i>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </header>
    <!--================Header Menu Area =================-->