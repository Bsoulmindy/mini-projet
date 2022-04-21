<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="icon" href="inc/img/favicon.png" type="image/png" />
    <title>Terroir.ma</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="inc/css/bootstrap.css" />
    <link rel="stylesheet" href="inc/vendors/linericon/style.css" />
    <link rel="stylesheet" href="inc/css/font-awesome.min.css" />
    <link rel="stylesheet" href="inc/css/themify-icons.css" />
    <link rel="stylesheet" href="inc/css/flaticon.css" />
    <link rel="stylesheet" href="inc/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="inc/vendors/lightbox/simpleLightbox.css" />
    <link rel="stylesheet" href="inc/vendors/nice-select/css/nice-select.css" />
    <link rel="stylesheet" href="inc/vendors/animate-css/animate.css" />
    <link rel="stylesheet" href="inc/vendors/jquery-ui/jquery-ui.css" />
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700&display=swap&subset=latin-ext" rel="stylesheet">
    <link href="inc/css2/bootstrap.css" rel="stylesheet">
    <link href="inc/css2/fontawesome-all.css" rel="stylesheet">
    <link href="inc/css2/swiper.css" rel="stylesheet">
    <link href="inc/css2/magnific-popup.css" rel="stylesheet">
    <link href="inc/css2/styles.css" rel="stylesheet">
    <!-- main css -->
    <link rel="stylesheet" href="inc/css/style.css" />
    <link rel="stylesheet" href="inc/css/responsive.css" />
</head>
    

    <body>
        <c:import url="/inc/header.jsp"/>

        <!-- Header -->
    <header id="header" class="ex-2-header">

        <c:if test="${errors != null}">
        <div class="d-flex flex-row justify-content-center my-2">
            <div class="alert danger" style="color: white" role="alert">
                <ul>
                      <c:forEach items="${errors}" var="error">
                        <li><c:out value="${error.defaultMessage}" /></li>
                      </c:forEach>
                    </ul>
            </div>
        </div>
        </c:if>
        <c:if test="${success != null && success}">
        <div class="d-flex flex-row justify-content-center my-2">
            <div class="alert primary" style="color: white" role="alert">
                Votre compte a été créée avec succès
            </div>
        </div>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Inscription</h1>
                   <p>Vous avez déjà un compte?  <a class="white" style="text-decoration: underline;" href="/connexion">Connectez-vous</a></p> 
                    <!-- Sign Up Form -->
                    <div class="form-container">
                        <form id="signUpForm" data-toggle="validator" data-focus="false" method="post" action="/inscription">
                            <div class="form-group">
                                <label class="label-control" for="text">Username</label>
                                <input type="text" class="form-control-input" id="semail" name="username" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="label-control" for="name">Nom</label>
                                <input type="text" class="form-control-input" id="sname" name="nom" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="label-control" for="password">Mot de passe</label>
                                <input type="password" class="form-control-input" id="spassword" name="password" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="form-control-submit-button">Inscrire</button>
                            </div>
                            <div class="form-message">
                                <div id="smsgSubmit" class="h3 text-center hidden"></div>
                            </div>
                        </form>
                    </div> <!-- end of form container -->
                    <!-- end of sign up form -->

                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </header> <!-- end of ex-header -->
    <!-- end of header -->

        <c:import url="/inc/footer.jsp"/>
    </body>

  </html>