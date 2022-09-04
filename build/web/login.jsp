
<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
    <head>
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="style/login.css"/>
        <link rel="shortcut icon" href="img/utiles/favicon.JPG"/>
        <meta charset="UTF-8">
        <title>login</title>
    </head>
    <body>
        <!-- ------------------ MENU ------------------ -->
        <script>
            //$(document).ready(function () {
               // $('.menuContainer').load('./menu.jsp');
            //});

        </script>
        <div class="menuContainer"></div>
        <!-- <script src="subprocesoT1/js/menu.js"></script> -->
        <!-- ------------------------------------------ -->

        <!-- IMG PARA ESCRITORIO -->

        <div class="container-login">
            <h3>Iniciar Sesion </h3>
            <form action="login_serv.jsp">

                <label class="login-label">Name User</label></br></br>
                <input type="text" placeholder="Name User" class="login" name="usuario"></br></br>
                <label class="login-label">Password</label></br></br>
                <input type="password" placeholder="Password" class="login" name="pass"></br></br>


                <div class="terminos-condiciones">
                    <input type="checkbox" name="check">
                    <p>Al registrarte, aceptas nuestras acepta las politicas de terminos y condiciones.</p>
                </div>
                <input type="hidden" name="pagina" value="login">
                <input type="submit" value="Iniciar Sesion" id="btn-login">

            </form>
            <p class="text-alternativo"> o <a href="login_serv.jsp?pagina=recuperarPass"> ¿Has olvidado la contraseña?</a></p>
        </div>
        <div> 
            <p class="text-alternativo">¿No tienes cuenta? <a href="login_serv.jsp?pagina=registrar">Registrate</a></p>
        </div>

    </body>
</html>
