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

        

        <header id="header" class="ex-2-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="d-flex flex-row justify-content-center my-2" id="statusDiv">
                        <c:if test="${error}">
                            <div class="d-flex flex-row justify-content-center my-2">
                                <div class="alert alert-danger" role="alert">
                                    ${error}
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${success}">
                            <div class="d-flex flex-row justify-content-center my-2">
                                <div class="alert alert-success" role="alert">
                                    ${success}
                                </div>
                            </div>
                        </c:if>
                    </div>

                    <h1>Devenir un coopérative</h1>
                    
                    <div class="form-container">
                        <form id="logInForm" data-toggle="validator" data-focus="false" method="post" action="/user/devenirCoop">
                            <div class="form-group">
                                <label class="label-control" for="lnom">Nom du coopérative</label>
                                <input type="text" class="form-control-input" id="lnom" name="nom" required>
                            </div>
                            <div class="form-group">
                                <label class="label-control" for="activite">Secteur d'activité</label>
                                <select id="activite" name="activite">
                                    <c:forEach items="${secteurActivites}" var="secteurActivite">
                                        <option value="${secteurActivite}">${secteurActivite}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="label-control" for="origine">Origine</label>
                                <select id="origine" name="origine">
                                    <c:forEach items="${origines}" var="origine">
                                        <option value="${origine.origine_id}">${origine.origine_nom}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group mt-2">
                                <button type="submit" class="form-control-submit-button">Demander</button>
                            </div>
                            <div class="form-message">
                                <div id="lmsgSubmit" class="h3 text-center hidden"></div>
                            </div>
                        </form>
                    </div> 
                    

                </div>
            </div>
        </div>
    </header> 
    


        <c:import url="/inc/footer.jsp"/>
    </body>

  </html>