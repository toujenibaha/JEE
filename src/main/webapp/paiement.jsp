<!DOCTYPE html5>
<html>
    <head>
        <meta charest="utf-8" name="viewport" content="width=device-width; initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/paiement.css">
        <style>
          #row1{
            border-bottom: 5px solid rgb(5, 30, 3);
            background:linear-gradient(to top,red,black)
           }
       </style>
    </head>
    <body>
        <div class="row" id="row1">
         <div><a href="protoacceuil.jsp" style="text-decoration: none;color:white;font-size: 30px;display: inline-block;">HOME</a></div>
        </div>
        <div class="login">
        <div class="container main-box">
            <form action="workServlet" method="post">
              <div class="row"><div class="col"><p style="color:blue;text-align:center;font-size: 30px">${requestScope.confirmation}</h2></div></div>            
                <div class="row">
                    <div class="col input-box">
                        <label style="font-size: 30px;" for="Date">Date d'expiration:</label>
                       <input type="text" id="Date" name="Date" class="form-control" placeholder="Saisir la date d'expiration de votre carte ici" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" required>
                    </div>
                </div>
                <div class="row">     
                   <div class="col input-box">
                      <label style="font-size: 30px" for="code">code secret de la carte:</label>
                      <div class="input-group">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                            <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                          </svg>
                       <input type="password" id="code" name="code" class="form-control" placeholder="votre code doit etre de 4 chiffres long" pattern="[0-9]{4}" required>
                       </div>
                   </div>
                </div>
                <div class="row">     
                   <div class="col input-box">
                      <label style="font-size: 30px" for="code">Numero de la carte:</label>
                      <div class="input-group">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                            <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                          </svg>
                       <input type="password" id="num" name="num" class="form-control" placeholder="votre numero doit etre de 18chiffres long" pattern="[0-9]{18}" required>
                       </div>
                   </div>
                </div>
                <div class="row">
                    <button id="pay" type="submit" name="action" value="enregistrer ticket" class="btn" style="color:white;background: rgb(13, 162, 13);">enregistrer paiement</button>
                </div>
            </form>
        </div>
        </div>
    </body>
</html>