<%@page import="Beans.beans_producto_precio_stock"%>
<%@page import="DAO.DAO_producto_precio_stock"%>
<%@page import="Beans.beans_stock"%>
<%@page import="Beans.beans_categoria"%>
<%@page import="DAO.DAO_stock"%>
<%@page import="DAO.DAO_categoria"%>
<%@page import="Beans.beans_precio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAO_precio"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Beans.beans_producto"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAO_producto"%>
<%
    String patron = "";
    String titulo = "Sillas AKRacing";
    if (request.getParameter("txtbuscar") != null) {
        patron = request.getParameter("txtbuscar");
        if (patron != "") {
            titulo = "Resultados para " + "'" + patron + "'";
        }
    }
    //se supone que esta pantalla solo mostrara a categoria 1: entonces categoria = 1
    int categoria = 11;
    DAO_producto o1 = new DAO_producto();
    DAO_precio o2 = new DAO_precio();
    DAO_categoria o3 = new DAO_categoria();
    DAO_stock o4 = new DAO_stock();

    //tarea 1 = consolas y videojuegos
    List<beans_producto> lista_producto = o1.Filtrar_Producto_Categoria_Nombre(categoria, patron); //me filtra todo los productos que pertenecen a esa categoria
    List<beans_categoria> lista_categoria = o3.BuscarCategoriaTodos();
    List<beans_stock> lista_stock = o4.Buscar_Stock_Todos();
    List<beans_precio> lista_precios = o2.Buscar_Precio_Todos();

    DAO_producto_precio_stock o5 = new DAO_producto_precio_stock(lista_producto, lista_precios, lista_categoria, lista_stock);

    List<beans_producto_precio_stock> lista = o5.productosView(); //es la lista final que recorrera toda por todads las vistas

    int t = lista.size();

    String rutaBase = "../../img/productosImg/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta  content="charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="../../style/inicio.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="../../img/utiles/favicon.JPG"/>
        <title>Sillas AKRacing</title>
    </head>
    <body>

        <div class="menuContainer"></div>
        <main class="main">
            <section class="section-group">
                <h2 class=""> <span class="span-titulo"></span>Sillas AKRacing</h2>

                <!-- aqui se mostraran los productos que pertenescan a la categoria Components -->
                <div class="container--flex container column--50-25">

                    <%
                        int i = 0;
                        while (i < lista.size()) {
                    %>
                    <div class="products">
                        <a href="../../vistas/previewProduct.jsp?codigo=<%=lista.get(i).getId_producto()%>" class="products_link" >
                            <div class="container_img_product">
                                <img src="<%=rutaBase + lista.get(i).getImg_producto()%>" alt="" class="img_product">

                            </div>
                            <div class="grid-price">
                                <h4 class="products__title"><%=lista.get(i).getNombre_producto()%></h4>
                                <span class="money"><%=lista.get(i).getPrecio()%></span>
                            </div>
                            <!-- 
                              <a href="../vistas/ShoppingCart.jsp"  ><i class="fas fa-shopping-cart"></i></a>
                            -->
                        </a>
                    </div>
                    <%
                            i++;
                        }
                    %>

                </div>
            </section>
        </main>
        <div class="footerContainer"></div>
        <script>
            $(document).ready(function () {
                $('.footerContainer').load('../../componentes/footer_2.jsp');
            });
        </script>
        <script>
            $(document).ready(function () {
                $('.menuContainer').load('../../menuopciones.jsp');
            });

        </script>

    </body>


</html>
