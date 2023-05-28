<!DOCTYPE html5>
<html>
    <head>
        <meta charset="utf-8" name="vewport" content="width=device-width ; initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                background-image: url("multimedia/login\ maybe.jfif");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
            }
   #row1{
    border-bottom: 5px solid rgb(5, 30, 3);
    background:linear-gradient(to top,red,black )
        }
        </style>
    
    </head>
    <body>
        <div class="row" id="row1">
         <div><a href="protoacceuil.jsp" style="text-decoration: none;color:white;font-size: 30px;display: inline-block;">HOME</a></div>
        </div>
        <h2 style="text-align: center;font-size: 50px;color: rgb(0, 173, 247);">Create an account with us!</h2>
        <form action="workServlet" method="post">
            <div class="row">
                <div class="col-md-6">
                    <label style="color:white;font-size: 30px;" for="name">Username:${requestScope.usernameVerify}</label>
                   <div class="input-group">
                    <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                      </svg></span>
                   <input type="text" id="name" name="name" class="form-control" placeholder="Saisir votre nom d'utilisateur ici" minlength="4" maxlength="15" required>
                   </div>
                </div> 
               <div class="col-md-6">
                  <label style="color:red;font-size: 30px" for="password">Password:${requestScope.passwordVerify}</label>
                  <div class="input-group">
                    <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                        <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                      </svg></span>
                   <input type="password" id="password" name="password" class="form-control" placeholder="saisir votre mot de passe(de 4 symboles au moin,incluant 1MAJ,1MIN et un chiffre)" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$" minlength="4" maxlength="30" required>
                   <div class="invalid-feedback" style="color: blue;font-size: 20px;">Attention!votre mot de passe doit etre de 4 chars long
                   et incluant au moin un char min,un char maj et un chiffre.
                   </div>
                   </div>
               </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label style="color:white;font-size: 30px;" for="email">Email:${requestScope.adressVerify}</label>
                    <div class="input-group">
                        <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                            <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
                          </svg></span>
                        <input type="email" id="email" name="email" class="form-control" required placeholder="saisir votre email ici">
                        <div class="invalid-feedback" style="color: blue;font-size: 20px;">Respectez le format d'un email!</div>
                    </div>
                </div>
                <div class="col-md-6">
                    <label style="color:red;font-size: 30px" for="phone">PhoneNumber:${requestScope.phoneVerify}</label>
                    <div class="input-group">
                        <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                            <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                          </svg></span>
                        <span class="input-group-text">+216</span>
                        <input type="tel" id="phone" name="phone" class="form-control" required placeholder="XX-XXX-XXX" pattern="[1-9]{2}-[0-9]{3}-[0-9]{3}">
                        <div class="invalid-feedback" style="color: blue;font-size: 20px;">Respectez le format indiqué dans le champ de saisie!</div>   
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-6 offset-3 d-grid"><button type="submit" id="bt1" name="action" value="create acc"  class="btn btn-primary">Create account</button></div>
            </div>
        </form>
    </body>
</html>