
<%@page import="Beans.beans_producto"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAO_producto"%>
<%@page import="javax.swing.JOptionPane"%>
<%
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    DAO_producto o1 = new DAO_producto();
    //tarea 1 = consolas
    List<beans_producto> lista = o1.Buscar_Producto_Codigo(codigo);

    String rutaImg = "../../img/productosImg/" + lista.get(0).getImg_producto();
    String nombre = lista.get(0).getNombre_producto();
    String descriccion = lista.get(0).getDescripcion_producto();
    int stock = lista.get(0).getStock();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  content="charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
        <link href="../../style/utiles/previewProduct.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {
                $('.menuContainer').load('../../menuopciones.jsp');
            });

        </script>
        <div class="menuContainer"></div>
        <main>
            <div class="container">
                <div class="container_img">
                    <!-- Img principal -->
                    <div class="img-big">
                        <img id="img_box" src="<%=rutaImg%>"  alt="img_principal"/>
                    </div>
                    <!-- --------- -->
                    <div class="img-small">
                        <img id="img_box" src="../../img/categorias/categoria1/auto.jpg"  alt="img_principal" onclick="myFunction(this)"/>
                        <img src="<%=rutaImg%>" alt="" onclick="myFunction(this)" />
                        <img src="../../img/categorias/categoria1/bannerdos.png" alt="" onclick="myFunction(this)" />
                        <img src="../../img/categorias/categoria1/chicas.jpg" alt="alt" onclick="myFunction(this)" />
                    </div>
                </div>
                <div class="container_information">
                    <section class="section_description">
                        <h4 class="title_decription"><%=nombre %></h4>
                        <p class="txt_decription" ><%=descriccion %></p>
                        <p class="price"> Precio: <%=stock%></p>
                    </section>
                    <section class="section_car">
                        <form action="" class="car">
                            <label >Cantidad: </label>
                            <input class="catidad_car" type="text" name="cantidad">
                            <input class="btn_add-car" type="submit" name="agregarCarrito" value="Agregar a Carrito">
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
        </main>
        <script  type="text/javascript">
            function myFunction(smallImg) {
                var fullImg = document.getElementById("img_box");
                fullImg.src = smallImg.src;
            }
        </script>

    </body>
</html>
