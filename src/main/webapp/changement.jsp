<!DOCTYPE html5>
<html>
    <head>
        <meta charset="utf-8" name="viweport" content="width=device-width; initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/changement.css">
    </head>
    <body>
          <jsp:include page="/changeFormServlet" />
        <div class="row" id="row1">
         <div><a href="protoacceuil.jsp" style="text-decoration: none;color:white;font-size: 30px;display: inline-block;">HOME</a></div>
        </div>
        <div class="login">
          <div class="container main-box">
            <form action="workServlet" method="post">
                <div class="row" style="font-size: 35px;text-align: center;color:green;">Account:${requestScope.nom}</div>
                <div class="row">
                    <div class="col input-box">
                        <lablel for="UserName" style="font-size: 30px;color: rgb(143, 37, 37)">User Name:${nameVerif}</lable>
                   <input type="text" value="${requestScope.nom}" id="UserName" name="name" class="form-control" placeholder="Saisir votre nom d'utilisateur ici" minlength="4" maxlength="15" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col input-box">
                        <label for="password" style="font-size: 30px;color: rgb(143, 37, 37)">Password:${requestScope.pwdVerif}</label>
                   <input type="password" value="${requestScope.motDePasse}" id="password" name="password" class="form-control" placeholder="saisir votre mot de passe" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$" minlength="4" maxlength="30" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col input-box">
                        <label for="phone" style="font-size: 30px;color: rgb(143, 37, 37)">Phone Number:${requestScope.phoneVerif}</label>
                        <input type="tel" value="${requestScope.telephone}" id="phone" name="phone" class="form-control" required placeholder="XX-XXX-XXX" pattern="[1-9]{2}-[0-9]{3}-[0-9]{3}">
                    </div>
                </div>
                <div class="row">
                    <div class="col input-box">
                        <label for="adress" style="font-size: 30px;color: rgb(143, 37, 37);">E-mail:${mailVerif}</label>
                        <input type="email" value="${requestScope.adresseMail}" id="adress" name="email" class="form-control" required placeholder="saisir votre email ici">
                    </div>
                </div>
                <div class="row">
                        <button class="btn btn-warning" id="change" name="action" value="modifyAcc">Valider</button>
                </div>
            </form>
          </div>
        </div>
    </body>
</html>    