
<%@page import="Beans.beans_producto_precio_stock"%>
<%@page import="Beans.beans_stock"%>
<%@page import="Beans.beans_precio"%>
<%@page import="Beans.beans_categoria"%>
<%@page import="DAO.DAO_producto_precio_stock"%>
<%@page import="DAO.DAO_categoria"%>
<%@page import="DAO.DAO_stock"%>
<%@page import="DAO.DAO_precio"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="Beans.beans_producto"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAO_producto"%>
<%@page import="javax.swing.JOptionPane"%>
<%
    HttpSession misesion = request.getSession(true);
    /*List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));;
    if (carrito != null) {
        JOptionPane.showMessageDialog(null, "carritoPreview: " + carrito.size());
    }
    misesion.setAttribute("carrito", carrito);*/

    int codigo = Integer.parseInt(request.getParameter("codigo"));
    DAO_producto o1 = new DAO_producto();
    //tarea 1 = consolas
    List<beans_producto> lista = o1.Buscar_Producto_Codigo(codigo);

    //se hace la busqueda respectiva de su precio y stock y se guarda n un objeto tipo beans_producto_precio_stock
    DAO_precio d_precio = new DAO_precio();
    DAO_stock d_stock = new DAO_stock();
    DAO_categoria d_categoria = new DAO_categoria();
    List<beans_categoria> lista_categoria = d_categoria.BuscarCategoriaTodos();
    List<beans_stock> lista_stock = d_stock.Buscar_Stock_Todos();
    List<beans_precio> lista_precios = d_precio.Buscar_Precio_Todos();

    DAO_producto_precio_stock d_pview = new DAO_producto_precio_stock(lista, lista_precios, lista_categoria, lista_stock);
    List<beans_producto_precio_stock> l_pview = d_pview.productosView();

    //creo una variable sesion del obteo creado para pasarselo a carrito serv
    misesion.setAttribute("lista_View", l_pview);
    misesion.setAttribute("bandera", 0);
    //int stock = lista.get(0).getId_stock();
    String rutaImg = "../img/productosImg/" + l_pview.get(0).getImg_producto();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  content="charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
        <link href="../style/utiles/previewProduct.css" rel="stylesheet" type="text/css"/>
        <link href="../style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="../img/utiles/favicon.JPG"/>
        <title>preview</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {
                $('.menuContainer').load('../menuopciones_1.jsp');
            });

        </script>
        <div class="menuContainer"></div>
        <div class="main">
            <div class="container ">
                <div class="container_img ">
                    <!-- Img principal -->
                    <div class="img-big">
                        <img id="img_box" src="<%=rutaImg%>"  alt="img_principal"/>
                    </div>
                    <!-- --------- -->
                    <div class="img-small">
                        <img src="<%=rutaImg%>"   alt="img_principal" onclick="myFunction(this)"/>
                        <img src="<%=rutaImg%>" alt="" onclick="myFunction(this)" />
                        <img src="<%=rutaImg%>"  onclick="myFunction(this)" />
                        <img src="<%=rutaImg%>"  alt="alt" onclick="myFunction(this)" />
                    </div>
                </div>
                <div class="container_information ">
                    <section class="section_description">
                        <h4 class="title_decription"><%=l_pview.get(0).getNombre_producto()%></h4>
                        <p class="txt_decription" ><%=l_pview.get(0).getDescripcion_producto()%></p>
                        <p class="price"> Precio: <%=l_pview.get(0).getPrecio()%></p>
                    </section>
                    <section class="section_car">
                        <form action="carrito_serv.jsp" class="car" >
                            <input type="hidden" name="codigo" value="<%=codigo%>" >
                            <label >Cantidad: </label>
                            <input class="catidad_car me-3" type="number" min="1" name="cantidad" value="1">
                            <button class="btn btn-warning" type="submit" name="agregarCarrito" value="">Agregar a Carrito</button>
                            <input type="hidden" name="pagina" value="agregarCar">

                        </form>
                        <div>
                            <div class="decription_shop">
                                <i class="fa-solid fa-truck-moving decription_shop-icon"></i>
                                <p class="decription_shop-text">Despacho a domicilio</p>
                                <span >Stock disponible</span>
                            </div>
                            <div class="decription_shop">
                                <i class="fa-solid fa-shop decription_shop-icon"></i>
                                <p class="decription_shop-text">Recojo en tienda o en puntos autorizados</p>
                                <span >Stock disponible</span>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <script>
            /*
             
             $(document).ready(function () {
             $('.footerContainer').load('../componentes/footer_1.jsp');
             });
             */

        </script>
        <footer class="footerContainer">
        </footer>
        <script  type="text/javascript">
            function myFunction(smallImg) {
                var fullImg = document.getElementById("img_box");
                fullImg.src = smallImg.src;
            }
        </script>

    </body>
</html>
