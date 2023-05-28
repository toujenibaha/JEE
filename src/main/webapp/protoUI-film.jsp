<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html5>
<html>
<head>
<meta charest="utf-8" name="viewport" content="width=device-width; initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/UI-film.css">
<style>
 #row1{
    border-bottom: 5px solid rgb(5, 30, 3);
    background:linear-gradient(to top,red,black)
}
</style>
</head>
<body>
 <jsp:include page="/showFilmServlet" />
     <div class="row" id="row1">
         <div><a href="protoacceuil.jsp" style="text-decoration: none;color:white;font-size: 30px;display: inline-block;">HOME</a></div>
      </div>
<form action="workServlet">
         <div class="container">
            <br>
            <div class="row">
               <div class="col-md-4">
                    <img class="im-in" src="${requestScope.image}" alt="film image"/>
               </div>
               <div class="col-md-8" id="desc">
               <h5 name="title"  id="title" style="color: gold;text-align: center;">
                    ${requestScope.title}
                </h5>                         
                   <p style="text-align:center">
                   ${requestScope.descript}
                   </p>
               </div>
            </div>
            <br>
                   <h5 style="color:white">See Trailer here: <a href="${requestScope.trailer}" target="_blank">${requestScope.trailer}</a></h5>
            <br>
            <h4 style="color: rgb(230, 230, 232);">Choisir votre date de reservation:</h4>
            <div class="row">
              <div class="col-md-4">
                <select class="form-control">
                   <c:forEach items="${requestScope.plans}" var="plan">
                   <option>${plan.dateP} ${plan.heure}</option>
                   </c:forEach>
                </select>
              </div> 
            </div>
            <br>
            <div class="row">
                <div class="col-md-4 d-grid">
                    <button name="action" value="${requestScope.button}" id="reserv" class="btn btn-primary" type="submit">${requestScope.button}</button>
                </div>
            </div>
         </div>
</form>
</body>
</html>