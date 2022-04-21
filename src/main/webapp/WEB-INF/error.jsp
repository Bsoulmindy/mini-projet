<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <c:import url="/inc/head.jsp"/>

  <body>
    <c:import url="/inc/header.jsp"/>

    <div style="min-height: 600px;margin-top: 10rem;">
        <h1 style="text-align: center">Erreur <span style="color: red">${error}</span> occuré!</h1>
    </div>

    <c:import url="/inc/footer.jsp"/>
  </body>
</html>