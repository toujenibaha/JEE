<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html5>
<html>
<head>
        <meta charest="utf-8" name="viewport" content="width=device-width; initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/acceuil.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
</head>
<body>
  <jsp:include page="/loadServlet" />
    <div class="row" id="row1">
        <div class="col-2 offset-10 d-grid">
         <button id="se-connecter" class="btn btn-primary">Seconnecter</button>
         <br>
        </div>
    </div>
        <h2 id="welcome">Welcome to our cinema!checkout our movies for the week</h2>
        <div id="carouselExampleCaptions" class="carousel slide">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
            </div>         
             <div class="carousel-inner">
              <c:forEach items="${requestScope.myData}" var="film" varStatus="status">
                <c:choose>
                 <c:when test="${status.index == 0}">
               <div class="carousel-item active">
                  <a href="protoUI-film.jsp?idfilm=${film.idfilm}"><img src="${film.img}" class="d-block w-100 h-100" alt="NOSHOW"></a>
                  <div class="carousel-caption d-none d-md-block">
                </div>
              </div>
                </c:when>
                <c:otherwise>
               <div class="carousel-item">
                <img src="${film.img}" class="d-block w-100 h-100" alt="NOSHOW2">
                <div class="carousel-caption d-none d-md-block">
                </div>
              </div>
                </c:otherwise>
               </c:choose> 
              </c:forEach>

            </div> 
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
    <footer id="foot">Powered by Cineroom 2023,all rights reserved.</footer>        
</body>
</html>