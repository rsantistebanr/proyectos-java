<%@page import="Beans.beans_cliente"%>
<%
    HttpSession misesion = request.getSession(true);

    beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");

    int bander = 0;
    if(request.getParameter("bander") != null){
        bander = Integer.parseInt(request.getParameter("bander"));
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="../img/utiles/favicon.JPG"/>
        <title>contact</title>
    </head>
    <script>
        $(document).ready(function () {
            $('.menuContainer').load('../menuopciones_1.jsp');
        });

    </script>
    <body>

        <div class="menuContainer"></div>

        <div class="main mt-5 mb-5">
            <div class="container w-100">
                <div class="row">
                    <!-- contendra el submenu -->
                    <div class="col-lg-4  col-sm-12  col-md-4  me-4 h-100 border-end" >
                        <div class="h-100" style="width: 18rem;">
                            <div class="ps-4" style="font-size: 1.8rem;">
                                <i class="fas fa-user"> <span> | <%=b_cliente.getUsuario_cliente()+ " #"+b_cliente.getId_cliente() %></span> </i>

                            </div>
                            <div class="card-body">
                                <ul class="list-group list-group-flush">
                                    <a href="MisDatos.jsp?bander=<%=0%>" class="list-group-item"> <i class="fas fa-user"></i>  Mis Datos</a>
                                    <a href="MisDatos.jsp?bander=<%=1%>" class="list-group-item"> <i class="fa-solid fa-lock"></i>  Seguridad</a>
                                    <a href="pedido_serv.jsp?pagina=consulta" class="list-group-item"> <i class="fa-solid fa-box-open"></i> Mis pedidos</a>
                                    <a href="../cerrar_sesion.jsp" class="list-group-item"> <i class="fa-solid fa-power-off"></i> Cerrar sesión</a>
                                </ul>
                            </div>
                        </div>


                    </div>

                    <div class="col-lg-7  col-sm-12  col-md-8  pb-5 pe-2">

                        <%
                            if (bander == 0) {
                        %>
                        <!-- Formulario para mostrar informacion del usuairo: (menu 1)-->
                        <form action="Actualizar_D_Cliente.jsp" method="POST">

                            <!-- Nombres -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example1">Nombres</label>
                                        <input type="text" id="form6Example1" class="form-control" value="<%=b_cliente.getNombre_cliente()%>" name="nombre"/>
                                    </div>
                                </div>
                            </div>
                            <!-- apellidos -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example2">Apellido Paterno</label>
                                        <input type="text" id="form6Example2" class="form-control"  value="<%=b_cliente.getAp_cliente()%>" name="ap"/>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example3">Apellido Materno</label>
                                        <input type="text" id="form6Example3" class="form-control" value="<%=b_cliente.getAm_cliente()%>" name="am" />
                                    </div>
                                </div>

                            </div>

                            <!-- Tipo de documento y número -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example4">Tipo de documento</label>
                                        <select  class="w-100" name="tipoDoc" id="form6Example4" class="form-control">
                                            <option  value="1">DNI</option>
                                            <option value="2">Pasaporte</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example5">Número de documento</label>
                                        <input type="text" id="form6Example5" class="form-control" value="<%=b_cliente.getNumero_documento()%>" name="numDoc"/>
                                    </div>
                                </div>

                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form6Example6">Email</label>
                                <input type="email" id="form6Example6" class="form-control" value="<%=b_cliente.getEmail_cliente()%>" name="mail" />
                            </div>

                            <!-- Number input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form6Example7">Telefóno</label>
                                <input type="text" id="form6Example7" class="form-control" value="<%=b_cliente.getTelefono_cliente()%>" name="telf"/>
                            </div>
                            <!-- direccion input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form6Example8">Dirección</label>
                                <input type="text" id="form6Example8" class="form-control" value="<%=b_cliente.getDireccion_cliente()%>" name="direccion"/>
                            </div>

                            <!-- Message input 
                            <div class="form-outline mb-4">
                                <textarea class="form-control" id="form6Example7" rows="4"></textarea>
                                <label class="form-label" for="form6Example7">Additional information</label>
                            </div>
    
                            Checkbox 
                            <div class="form-check d-flex justify-content-center mb-4">
                                <input class="form-check-input me-2" type="checkbox" value="" id="form6Example8" checked />
                                <label class="form-check-label" for="form6Example8"> Create an account? </label>
                            </div>
                            -->



                            <!-- Submit button -->
                            <input type="hidden" name="pagina" value="u_perfil">
                            <button type="submit" class="btn btn-primary btn-block mb-4">Actualizar Datos</button>
                        </form>
                        <%
                        } else {
                        %>
                        <!-- Formulario para mostrar la informacion de seguridad del usuario: (menu 2)-->

                        <form action="Actualizar_D_Cliente.jsp" method="POST">
                            <!-- Usuario -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example1">Usuario</label>
                                        <input type="text" id="form6Example1" class="form-control" value="<%=b_cliente.getUsuario_cliente()%>" name="user" />
                                    </div>
                                </div>
                            </div>

                            <!-- Password -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="form6Example2" >Contraseña</label>
                                        <input type="text" id="form6Example2" class="form-control" readonly value="<%=b_cliente.getPassword_cliente()%>" name="pass"/>
                                    </div>
                                </div>
                            </div>

                            <!-- Nuevo Password -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <label class="form-label" for="nc">Nueva Contraseña</label>
                                        <input type="password" id="nc" class="form-control" name="newPass" required="true" />
                                    </div>
                                </div>
                            </div>

                            <!-- Submit button -->
                            <input type="hidden" name="pagina" value="u_login">
                            <button type="submit" class="btn btn-primary btn-block mb-4">Actualizar Datos</button>
                        </form>



                        <%}%>

                    </div>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('.footerContainer').load('../componentes/footer_1.jsp');
            });
        </script>
        <div class="footerContainer"></div>

    </body>
</html>

