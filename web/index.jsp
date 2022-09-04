<%@page import="DAO.DAO_producto_precio_stock"%>
<%@page import="Beans.beans_producto_precio_stock"%>
<%@page import="Beans.beans_precio"%>
<%@page import="Beans.beans_stock"%>
<%@page import="Beans.beans_categoria"%>
<%@page import="DAO.DAO_stock"%>
<%@page import="DAO.DAO_categoria"%>
<%@page import="DAO.DAO_precio"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Beans.beans_producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAO_producto"%>
<%
    HttpSession misesion = request.getSession(true);

    List<beans_producto> lista_producto = (List<beans_producto>) misesion.getAttribute("lista_productos");

    if (lista_producto == null) {
        //JOptionPane.showMessageDialog(null, "pagina index");
        String patron = "";
        DAO_producto o1 = new DAO_producto();
        lista_producto = o1.Filtrar_Producto_Nombre(patron); //me filtra todo los productos que pertenecen a esa categoria

    }

    DAO_precio o2 = new DAO_precio();
    DAO_categoria o3 = new DAO_categoria();
    DAO_stock o4 = new DAO_stock();

    //tarea 1 = consolas y videojuegos
    List<beans_categoria> lista_categoria = o3.BuscarCategoriaTodos();
    List<beans_stock> lista_stock = o4.Buscar_Stock_Todos();
    List<beans_precio> lista_precios = o2.Buscar_Precio_Todos();

    DAO_producto_precio_stock o5 = new DAO_producto_precio_stock(lista_producto, lista_precios, lista_categoria, lista_stock);

    List<beans_producto_precio_stock> lista = o5.productosView(); //es la lista final que recorrera toda por todads las vistas

    int t = lista.size();

    String rutaBase = "img/productosImg/";
    //String rutaBase = "C:/Users/ROBERT/Desktop/imgProductos/";

    //HACEMOS LA PRUEBA DEL AGINADO ---- 
    int i = 0;
    int p = 0;
    int n = 12;
    if (request.getParameter("p") != null) {
        p = Integer.parseInt(request.getParameter("p"));
        n = p;
        p -= 12;
        i = p;
    }
    if (request.getParameter("n") != null) {
        n = Integer.parseInt(request.getParameter("n"));
        i = n;
        p = i;
        n += 12;
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/inicio.css"/>

        <link rel="shortcut icon" href="img/utiles/favicon.JPG"/>
        <title>inicio</title>
    </head>

    <body>
        <div class="menuContainer"></div>


        <div class="banner-slider">
            <div class="banner-welcome">
                <a class="fa-solid fa-truck-moving btn-icon " href="#"></a><a class="fa-solid btn-icon fa-shop" href=""></a>
                <h1>BIENVENIDO A MI JOSIMAR</h1>
                <a class="fa-solid fa-phone btn-icon" href="vistas/Contacto.jsp" ></a><a class="btn-icon fa-solid fa-book" href="#" ></a>
            </div>
            <div class="container-slider" id="container-slider">
                <div class="slider-section">
                    <img  class="slider-img" src="img/utiles/slider_1.jpg" alt="alt"/>
                </div>
                <div class="slider-section">
                    <img class="slider-img" src="img/utiles/slider_2.jpg" alt="alt"/>
                </div>
                <div class="slider-section">
                    <img class="slider-img" src="img/utiles/slider_1.jpg" alt="alt"/>
                </div>
                <div class="slider-section">
                    <img class="slider-img" src="img/utiles/slider_4.jpg" alt="alt"/>
                </div>

            </div>
            <div class="slider-btn btn-left" ><i class="fas fa-chevron-circle-left"></i></div>
            <div id="btn-right" class="slider-btn btn-right" ><i class="fas fa-chevron-circle-right"></i></div>

        </div>



        <main class="main">

            <section class="section-group">
                <h2 class=""> <span class="span-titulo"></span>!LOS MEJORES PRODUCTOS¡</h2>
                <div class="container--flex container column--50-25">
                    <!---------------------------------------------->

                    <%                            //int i = 0;
                        while (i < n && i < lista.size()) {
                    %>
                    <div class="products ">
                        <a href="vistas/previewProduct.jsp?codigo=<%=lista.get(i).getId_producto()%>" class="products_link" >
                            <div class="container_img_product"> <img src="<%=rutaBase + lista.get(i).getImg_producto()%>" alt="" class="img_product"></div>
                            <div class="grid-price">
                                <h5 class="products__title"><%=lista.get(i).getNombre_producto()%></h5>
                                <span class="money"><%="$" + lista.get(i).getPrecio()%></span>
                            </div>
                        </a>
                    </div>

                    <%
                            i++;
                        }
                    %>


                    <!----------------------------------------------->

                </div>

            </section>
            <nav  class="paginacion">
                <ul class="pagination ">
                    <%
                        if (p != 0) {
                    %>
                    <li class="page-item"><a href="index.jsp?p=<%=p%>" class="page-link" >Preview</a></li>
                        <%
                            }
                            //JOptionPane.showMessageDialog(null, "n: "+n + " - l:"+lista.size());
                            if (n <= lista.size()) {
                        %>
                    <li class="page-item"></li>
                    <li class="page-item"><a  href="index.jsp?n=<%=n%>" class="page-link">Next</a></li>
                        <%
                            }
                        %>
                </ul>
            </nav>

            <section class="group--testimonials">
                <div class="testimonials">
                    <h3 class="products__title">Testimonials</h3>
                    <h3>Gretchen <span for="">customer</span></h3>
                    <label for="">United States</label>
                    <p class="testimonials__txt">Maecenas interdum, metus vitae tincidunt porttitor, magna quam egestas sem, ac scelerisque nisl nibh vel lacus. Proin eget gravida odio. Donec ullamcorper est eu accumsan cursu</p>
                </div>
            </section>
            <div class="galsess container--flex  column--50-25">
                <div class="col"> 
                    <img src="img/utiles/index-main.jpg" alt="" class="colimg"/>
                    <p class="editor__circle">REALIZA TU COMPRA SEGURO</p>
                    <p class="col__txt">EXPERIENCIA <span> UNICA</span></p>
                </div>

                <div class="col"> 
                    <img src="img/utiles/index-main2.jpg" alt="" class="colimg"/>
                    <p class="editor__circle">REALIZA TU COMPRA SEGURO</p>
                    <p class="col__txt">EXPERIENCIA <span> UNICA</span></p>
                </div>
            </div>
            <div class="container--flex mb-5">

                <div class="galsess_container column--50-25">
                    <div class="galsess--log4 container--flex ">
                        <div class="btn-icon"><span class="fas fa-bars"></span></div>
                        <h4 class="sub--title">Satisfación garantizada</h4>
                        <p class="sub__txt">Todo lo que buecas en un solo lugar.</p>
                        <p><a href="" class="btn__log4">Ingresar</a></p>
                    </div>
                    <div class="galsess--log4 container--flex ">
                        <div class="btn-icon"><span class="fas fa-map-marker-alt"></span></div>
                        <h4 class="sub--title">Envio rápido</h4>
                        <p class="sub__txt">Para una mayor seguridad y expriencia puede seguir tu pedido.</p>
                        <p><a href="" class="btn__log4">Ingresar</a></p>
                    </div>
                    <div class="galsess--log4 container--flex ">
                        <div class="btn-icon"><span class="fas fa-phone-alt"></span></div>
                        <h4 class="sub--title">Contactanos</h4>
                        <p class="sub__txt">Contactanos. Nosotros te atenderemos con mucho gusto.</p>
                        <p><a href="" class="btn__log4">Ingresar</a></p>
                    </div>
                </div>
            </div>
            <!-- 
            <section class="group--testimonials__products container--flex column--50-25">
        <div class="testimonials__products ">
            <div class="testimonials__icon"><i class="fa-solid fa-computer"></i></div>
            
            <h3 class="testimonials__title">GENUINE PRODUCTS</h3>
            <p class="testimonials__txt">Maecenas interdum, metus vitae tincidunt porttitor, magna quam egestas sem.</p>
        </div>
        <div class="testimonials__products ">
            <div class="testimonials__icon"><span class="fas fa-phone-alt"></span></div>
            
            <h3 class="testimonials__title">SECURE PRODUCTS</h3>
            <p class="testimonials__txt">Maecenas interdum, metus vitae tincidunt porttitor, magna quam egestas sem.</p>
        </div>
           
        <div class="testimonials__products ">
            <div class="testimonials__icon"><span class="fas fa-phone-alt"></span></div>
             
            <h3 class="testimonials__title">CASH ON DELIVERY</h3>
            <p class="testimonials__txt">Maecenas interdum, metus vitae tincidunt porttitor, magna quam egestas sem.</p>
            </div>
        <div class="testimonials__products ">
            <div class="testimonials__icon"><span class="fas fa-phone-alt"></span></div>
             
            <h3 class="testimonials__title">EASY DELIVERY</h3>
            <p class="testimonials__txt">Maecenas interdum, metus vitae tincidunt porttitor, magna quam egestas sem.</p>
        </div>
    </section>
            
            
            -->

        </main>
        <div class="footerContainer"></div>
        <script>
            $(document).ready(function () {
                $('.footerContainer').load('componentes/footer.jsp');
            });
        </script>
        <script src="js/slider.js"></script>
        <script>
            $(document).ready(function () {
                $('.menuContainer').load('./menu.jsp');
            });
        </script>
    </body>
</html>
