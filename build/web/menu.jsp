

<%@page import="DAO.DAO_carrito"%>
<%@page import="Beans.beans_cliente"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="java.util.List"%>
<%

    int t = 0;
    int bandera = 0;
    HttpSession misesion = request.getSession(true);
    beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");
    ////JOptionPane.showMessageDialog(null, "iD_CLIENTE " + b_cliente.getId_cliente());
    ////JOptionPane.showMessageDialog(null, "pagina menu1");
    if (b_cliente != null) {// significa que se ingreso con cuenta

        //Al cargar el menu principal cargo consigo los posible productos que quedarone en el carrito y que no se termino de realizar la compra
        DAO_carrito dAO_carrito = new DAO_carrito();
        List<beans_carrito> Recupero_carrito = dAO_carrito.Buscar_Producto_Codigo_Venta(b_cliente.getId_cliente());
        ////JOptionPane.showMessageDialog(null, "Recupero: " + Recupero_carrito.size());

        if (Recupero_carrito.size() > 0) {
            misesion.setAttribute("carrito", Recupero_carrito);
            float totalPago = 0;
            for (int i = 0; i < Recupero_carrito.size(); i++) {
                totalPago = +Recupero_carrito.get(i).getSubtotal();
            }
            misesion.setAttribute("totalPago", totalPago);
        }
        List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));

        if (carrito != null) {
            ////JOptionPane.showMessageDialog(null, "carritoMenu: "+carrito.size());
            t = carrito.size();
        }
    } else {
        //JOptionPane.showMessageDialog(null, "pagina menu2");

        List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));

        if (carrito != null) {
            ////JOptionPane.showMessageDialog(null, "carritoMenu: "+carrito.size());
            t = carrito.size();
        }
        bandera = 1;
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/menu.css" rel="stylesheet" type="text/css"/>
        <!--linea de codigo para importar iconos  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
        <link href="style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>menu</title>
    </head>
    <body>
        <header>
            <span class="header-menu" id="btn-menu">  <i class="fas fa-bars"></i></span> 

            <h1 class="header-title"><a href="index.jsp" style="list-style: none"><span class="span-red">MI</span><span class="span-white">JOSIMAR</span> </a></h1>

            <form class="d-flex col-sm-2 col-md-4 col-lg-4" action="vistas/carrito_serv.jsp">
                <input class="form-control me-2 cl-8 " type="search" placeholder="Search" name="txtbuscar" >
                <button class="btn btn-outline-dark" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                <input type="hidden" name="pagina" value="buscar" >
            </form>

            <span class="header-menu" id="btn-car"><a href="./vistas/ShoppingCart.jsp"><i class="fas fa-shopping-cart"></i><label>(<%=t%>)</label></a></span> 

            <!-- ---- Parte del Menu si se inicio con cuenta --- -->
            <%
                if (bandera == 0) {
            %>
            <div class="dropdown ">
                <button class="btn border-dark dropdown-toggle " type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-user "><span class="ms-2"><%=b_cliente.getUsuario_cliente()%></span> </i>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li><a class="dropdown-item" href="vistas/MisDatos.jsp" type="button">Mis Datos</a></li>
                    <!-- <li><a class="dropdown-item" href="vistas/RegistroPedidos.jsp" type="button">Mis Pedidos</a></li> -->
                    <li><a class="dropdown-item" href="vistas/pedido_serv.jsp?pagina=consulta" type="button" onclick="confirmar();">Mis Pedidos</a></li>
                    <li><a class="dropdown-item" href="cerrar_sesion.jsp" type="button" onclick="confirmar();" >Cerrar sesión</a></li>
                </ul>
            </div>
            <%
            } else {
            %>
            <div class="dropdown ">
                <button class="btn border-dark dropdown-toggle " type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-user "> </i>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <!-- <li><a class="dropdown-item" href="vistas/RegistroPedidos.jsp" type="button">Mis Pedidos</a></li> -->
                    <li><a class="dropdown-item" href="./login.jsp" type="button">Iniciar Sesión</a></li>
                    <li><a class="dropdown-item" href="./registrar.jsp" type="button">Registrarse</a></li>
                </ul>
            </div>

            <%
                }
            %>

            <!-- -------- -->

        </header>
        <nav class="main-nav">
            <ul id="menu" class="menu">
                <li class="menu-item"><a href="./index.jsp" class="menu-link">Inicio</a></li>
                <li class="menu-item container-submenu" >
                    <a href="#" class="menu-link submenu-btn"> Consolas y Videojuegos<i class="fas fa-caret-down trianggulo"></i></a>
                    <ul class="submenu">
                        <li class="menu-item"><a href="categorias/consolasYvideojuegos/consolas.jsp" class="menu-link">Consolas</a></li>
                        <li class="menu-item"><a href="categorias/consolasYvideojuegos/videojuegos.jsp" class="menu-link"> Videojuegos</a></li>
                        <li class="menu-item"><a href="categorias/consolasYvideojuegos/accesorios.jsp" class="menu-link">Accesorios</a></li>
                    </ul>
                </li>
                <li class="menu-item container-submenu" >
                    <a href="#" class="menu-link submenu-btn">Gaming<i class="fas fa-caret-down trianggulo"></i></a>
                    <ul class="submenu">
                        <li class="menu-item"><a href="categorias/gaming/pc gamer.jsp" class="menu-link">PC Gamer</a></li>
                        <li class="menu-item"><a href="categorias/gaming/perifericos gamer.jsp" class="menu-link">Perifericos Gamer</a></li>
                        <li class="menu-item"><a href="categorias/gaming/zona streamer.jsp" class="menu-link">Zona Streamer</a></li>
                    </ul>
                </li>
                <li class="menu-item container-submenu" >
                    <a href="#" class="menu-link submenu-btn"> Cómputo<i class="fas fa-caret-down trianggulo"></i></a>
                    <ul class="submenu">
                        <li class="menu-item"><a href="categorias/computo/computadorasymonitores.jsp" class="menu-link">Computadoras y Monitores</a></li>
                        <li class="menu-item"><a href="categorias/computo/laptos.jsp" class="menu-link">Laptos</a></li>
                        <li class="menu-item"><a href="categorias/computo/tecladoymouse.jsp" class="menu-link">Teclado y Mouse</a></li>
                        <li class="menu-item"><a href="categorias/computo/microfonosyaccesorios.jsp" class="menu-link">Microfonos y Accesorios</a></li>
                    </ul>
                </li>
                <li class="menu-item container-submenu" >
                    <a href="#" class="menu-link submenu-btn">Sillas Gamer<i class="fas fa-caret-down trianggulo"></i></a>
                    <ul class="submenu">
                        <li class="menu-item"><a href="categorias/colecciones/sillas AKRacing.jsp" class="menu-link">Sillas AKRacing</a></li>
                        <li class="menu-item"><a href="categorias/colecciones/sillas DTK.jsp" class="menu-link">Sillas DTX</a></li>
                        <li class="menu-item"><a href="categorias/colecciones/sillas racer.jsp" class="menu-link">Sillas Racer</a></li>
                    </ul>
                </li>

                <li class="menu-item"><a href="vistas/Contacto.jsp" class="menu-link">Contactanos</a></li>
            </ul>

        </nav>



        <script src="./js/menu.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
                crossorigin="anonymous">
        </script>

        <!-- SCRIPT ALECRTA DE CONFIRMACION  -->
        <script type="text/javascript">
         function confirmar() {
                            if (confirm("¿Estas Seguro?")) {
                            } else {
                            }

                        }
        </script>
    </body>
</html>
