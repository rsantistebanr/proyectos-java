<%@page import="Beans.beans_cliente"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.beans_producto"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAO_producto"%>
<%
    int bandera = 0; //servira para mostrar o no el boton del pou up - login
    HttpSession misesion = request.getSession(true);
    beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");
    if (b_cliente == null) {//es decir que no hay usuario logueado
        bandera = 1;
    }

    //List<beans_producto> lista_recibe = (List<beans_producto>) (misesion.getAttribute("list"));
    int codigo = 0;
    int cantidad = 0;
    int subtotal = 0;
    float totalpago = 0f;
    int t = -1;
    DAO_producto o1 = new DAO_producto();
    List<beans_producto> lista = null;
    //List<beans_producto> listaproductos = (List<beans_producto>) (misesion.getAttribute("list"));;
    List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));

    if (carrito != null) {
        t = carrito.size();
        totalpago = Float.parseFloat(String.valueOf(misesion.getAttribute("totalPago")));

    }

    String rutaBase = "../img/productosImg/";


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="../img/utiles/favicon.JPG"/>
        <!-- POUP UP -LOGIN - VENTANA EMERGENTE -->
        <link href="../style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- --------------------------- -->
        <link href="../style/utiles/popup_login.css" rel="stylesheet" type="text/css"/>

        <title>shoppingcart</title>
    </head>
    <script >
        $(document).ready(function () {
            $('.menuContainer').load('../menuopciones_1.jsp');
        });
    </script>
    <body>
        <div class="menuContainer"></div>

        <div class="main">
            <div class="container">

                <div class="row mt-3">
                    <div class ="col-sm-12 col-md-6 col-lg-6 ms-2 pt-3">
                        <form action="carrito_serv.jsp">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">N°</th>
                                        <th scope="col" colspan="2">Producto</th>
                                        <th scope="col">Precio</th>
                                        <th scope="col">Cantidad</th>
                                        <th scope="col">Subtotal</th>
                                        <th scope="col">X</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                        int i = 0;
                                        while (i < t) {
                                            //JOptionPane.showMessageDialog(null, carrito.get(i).getPrecio_venta() + " -- " + carrito.get(i).getPrecio_venta());

                                    %>

                                    <tr>
                                        <td><%=i + 1%> </td>

                                        <td style="width: 200px; height: 60px"><img src="<%=rutaBase + carrito.get(i).getImg_producto()%>" alt="" class="card-img-top w-100"> </td>
                                        <td> <%=carrito.get(i).getNombre()%></td>
                                        <td> <%=carrito.get(i).getPrecio_venta()%></td>
                                        <td> <input type="number" name="<%="cantidad" + i%>" value="<%=carrito.get(i).getCantidad()%>" min="1"> </td>
                                        <td> <%=carrito.get(i).getPrecio_venta() * carrito.get(i).getCantidad()%></td>
                                        <td><a class="btn btn-danger" role="button" href="carrito_serv.jsp?item=<%=carrito.get(i).getItem()%>&pagina=delete&posicion=<%=i%> " >x</a></td>
                                    </tr>
                                    <%
                                            i++;
                                        }
                                    %>

                                </tbody>
                            </table>

                            <a class="btn btn-danger" role="button" href="../index.jsp"><b><--- </b>Seguir Comprando</a>
                            <button class="btn btn-warning" role="button">Calcular</button>
                            <input type="hidden" name="pagina" value="calcular">

                        </form>

                    </div>

                    <div class ="col-sm-12 col-md-5 col-lg-5 ms-3 pt-4">
                        <form action="pedido_serv.jsp"  >
                            <div class="mb-3 border-bottom">
                                TOTAL CARRITO
                            </div>
                            <div class="mb-3">
                                Total: <%=totalpago%>
                            </div>
                            <!-- 
                            
                            -->
                            <%
                                if (t > 0) {
                                    if (bandera == 0) {
                            %>
                            <button type="submit" class="btn btn-danger">Finalizar Compra</button>
                            <%
                            } else {
                            %>

                            <a type="submit" class="btn btn-warning btn-agregar" id="btn-abrir-popup">Finalizar Compra</a>
                            <%
                                    }
                                }
                            %>
                            <a class="btn btn-secondary" role="button" href="../index.jsp">Cancelar</a>
                            <input type="hidden" name="pagina" value="Mostrar">
                        </form>

                    </div>

                </div>

            </div>
        </div>
        <div class="overlay " id="overlay">
            <div class="popup " id="popup">
                <a href="#" class="btn-cerrar-popup" id="btn-cerrar-popup"><i class="fas fa-times"></i></a>
                <h3>Iniciar Sesion </h3>
                <form action="loginDos_serv.jsp" id="formulario">
                    <div class="md-form">
                        <i class="fas fa-user prefix indigo-text"></i>
                        <label for="usuario">Name User</label>
                        <input type="text"  id="usuario" class="form-control" name="usuario">

                    </div>
                    <div  class="md-form">
                        <i class="fa-solid fa-lock prefix indigo-text"></i>
                        <label for="pass" >Password</label>
                        <input type="password"  id="pass" class="form-control" name="pass">

                    </div>

                    <input id="agregar" class="btn-submit" type="submit" name="accion" value="Ingresar" > 
                    <a href="../registrar.jsp" class=" btn-submit btn-registrar-link" >Crear Cuenta</a>
                    <input type="hidden" name="pagina" value="login2"> <!-- este login se da cuando el usuario accede desde la pagina shopping car-->
                    <!-- comment <input type="submit" name="accion" value="Cancelar" class="boton"> -->
                </form>
            </div>
        </div>
        <!-- POUP UP -LOGIN - VENTANA EMERGENTE -->
        <script src="../js/popup.js" type="text/javascript"></script>
        <script>
        /*
         $(document).ready(function () {
         $('.footerContainer').load('../componentes/footer_1.jsp');
         });
         */

        </script>
        <footer class="footerContainer"></footer>

        <!-- --------------------------- -->
    </body>
</html>
