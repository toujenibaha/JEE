<!DOCTYPE html5>
<html>
    <head>
        <meta charest="utf-8" name="viewport" content="width=device-width; initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/connexion.css">
    </head>
    <body>
        <div class="login">
        <div class="container main-box">
            <form action="workServlet">
                <div class="row">
                  <h3 style="color:white;text-align:center">${requestScope.message}</h3>
                <div class="row">
                    <div class="col input-box">
                        <label style="font-size: 30px;" for="name">Username:</label>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                          </svg>
                       <input type="text" id="name" name="name" class="form-control" placeholder="Saisir votre nom d'utilisateur ici" required>
                    </div>
                </div>
                <div class="row">     
                   <div class="col input-box">
                      <label style="font-size: 30px" for="password">Password:</label>
                      <div class="input-group">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                            <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                          </svg>
                       <input type="password" id="password" name="password" class="form-control" placeholder="saisir votre mot de passe" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$" minlength="4" maxlength="30" required>
                       <div class="invalid-feedback" style="color: blue;font-size: 20px;">Attention!votre mot de passe doit etre de 4 chars long
                       et incluant au moin un char min,un char maj et un chiffre.
                       </div>
                       </div>
                   </div>
                </div>
                <div class="row d-grid">
                    <button id="connect" type="submit" class="btn btn-primary" name="action" value="Rechercher Client">Connect</button>
                </div>
                <br>
                <div class="row">
                 <br> 
                </div>
                <div class="row d-grid">
                    <button id="connectAsAdmin" class="btn btn-warning" type="submit">Connect as Admin</button>
                </div>
                <br>
               <p style="color:white">dont have an account?<a href="inscription.jsp">Create an account here!</a></p>
        </form>
        </div>
        </div>   
    </body>
</html>