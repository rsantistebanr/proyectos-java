<%-- 
    Document   : login
    Created on : 29 ene. 2022, 19:01:55
    Author     : ROBERT
--%>

<%@page import="Beans.beans_cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="style/login.css"/>
        <meta charset="UTF-8">
        <link href="style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="img/utiles/favicon.JPG"/>
        <title>registrar</title>
    </head>
    <body>

        <!-- <script src="subprocesoT1/js/menu.js"></script> -->
        <!-- ------------------------------------------ -->

        <!-- IMG PARA ESCRITORIO -->

        <div class="container w-75 rounded justify-content-center ">
            <div class="row align-items-stretch  ">

                <div class="col d-none py-5 my-4 d-lg-block col-md-5 col-lg-5 col-xl-6 " >
                    <img src="img/utiles/BANNER-LOGIN.JPG" width="100%" height="90%" class="figure-img img-fluid rounded" alt=""/>
                </div>


                <div class=" col bg-white p-5 mt-5 rounded-end">
                    <h2 class="fw-bold text-center py-2">Registrate </h2>
                    <form action="login_serv.jsp" method="POST" class="">


                        <div class="mb-2" >
                            <label class="form-label">Nombre </label>
                            <input type="text" placeholder="Nombre" class="form-control" name="name" required="true" >
                        </div>

                        <div class="mb-2" >
                            <label class="form-label">Usuario</label>
                            <input type="text" placeholder="Name User" class="form-control" name="nameUser" required="true" >
                        </div>
                        <div class="mb-2" >
                            <label class="form-label">Contraseña</label>
                            <input type="password" id="pass" placeholder="Password" name="password" class="form-control" required="YES" 
                                   pattern="[A-Za-z0-9@#$%]{8,20}" title="Una contraseña válida es una cadena con una longitud entre 8 y 20
                                   caracteres, donde cada uno consiste en una letra mayúscula o minúscula, un dígito, o los símboloss '@', '#',
                                   '$' y '%'">
                        </div>
                        <div class="mb-2" >
                            <label class="form-label">E-mail</label>
                            <input type="text" placeholder="e-mail" name="email" class="form-control" >
                        </div>
                        <div class="mb-2" >
                            <label class="login-label">Telefono</label>
                            <input type="text" placeholder="telefono" name="telefono" class="form-control" id="telefono" >
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" name="terminos" class="form-check-input">
                            <label class="lform-check-label" for="terminos">Acepto terminos y condiciones.</label>
                        </div>
                        <!-- 
                        <div class="mb-2" >
                             <label class="form-label">A. Paterno</label>
                             <input type="text" placeholder="A. Paterno" name="a_paterno" class="form-control" >
                         </div>
                         <div class="mb-2" >
                             <label class="form-label">A. Materno</label>
                             <input type="text" placeholder="A. Materno" name="a_materno" class="form-control" >
                         </div>
                        -->







                        <div class="d-grid">
                            <button type="submit"   class="btn btn-primary" name="btn-login"  >Iniciar Sesión</button>
                        </div>
                        <input type="hidden" name="pagina" value="nuevo">
                    </form>

                    <!-- Login con rede sociales -->
                    <div class="container w-100 my-3">
                        <div class="row text-center">
                            <div class="col">
                                <button class="btn btn-outline-primary w-100 my-1">
                                    <div class="row align-items-center">
                                        <div class="col-2">
                                            <img src="img/utiles/facebook.jpg" width="32" height="25"  alt=""/>
                                        </div>

                                        <div class="col-10 text-center">
                                            Facebook
                                        </div>
                                    </div>
                                </button>
                            </div>
                            <div class="col">
                                <button class="btn btn-outline-danger w-100 my-1">
                                    <div class="row align-items-center">
                                        <div class="col-2">
                                            <img src="img/utiles/google.jpg"  width="32" height="25" alt=""/>
                                        </div>
                                        <div class="col-10 text-center">
                                            Google
                                        </div>
                                    </div>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
                crossorigin="anonymous">

        </script>
        <script>
            function verificarPassword() {
                var inputPassword = document.querySelector("#pass").value;
                var inputTelefono = document.querySelector("#telefono").value;
                if (inputPassword.length < 8) {
                     alert("Debes escribir mas de 8 caracteres");// Puedes colocar un alert() o nada.
                }
                if(inputTelefono.length <=9 and inputTelefono.length >= 8){
                    alert("Debes escribir un telefono válido.");
                }
            }
        </script>
    </body>
</html>
