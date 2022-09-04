<%@page import="Beans.beans_producto"%>
<%@page import="DAO.DAO_producto"%>
<%@page import="Beans.beans_detalle_venta"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.List"%>
<%@page import="Beans.beans_cliente"%>
<%@page import="Beans.beans_venta"%>
<%@page import="DAO.DAO_venta"%>
<%

    HttpSession misesion = request.getSession(true);
    //beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");
    //DAO_venta d_venta = new DAO_venta();
    // List<beans_venta> l_ventas = d_venta.BuscarVentaCodigo_cliente(b_cliente.getId_cliente());
    List<beans_venta> l_ventas = (List<beans_venta>) misesion.getAttribute("l_ventas");

    /* PARTE DE CODIGO PARA MOSTRAR LOS DETALLES DE CADA VENTA - COMO SE REMPLAZO CON EL REPORTE YA NO SE UTILIZA
    List<beans_detalle_venta> l_detalles = (List<beans_detalle_venta>) misesion.getAttribute("l_detalles");
    int bandera = 0;
    if (l_detalles != null) {
        bandera = 1;

    }*/

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RegistroPedidos</title>
        <link href="../style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="../img/utiles/favicon.JPG"/>
    </head>

    <body>
        <div class="menuContainer"></div>
        <div class="container vh-100">
            <div class="my-5">
                <form action="">

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">N°</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Tipo comprobante</th>
                                <th scope="col">Total</th>
                                <th scope="col" class="text-center">Estado</th>
                                <th scope="col">Ver detalle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                
                                int t = l_ventas.size();
                                int i = 0;
                                while (i < t) {
                                    String estado = "Entregado";
                            %>
                            <tr>
                                <th scope="row"><%=i + 1%></th>
                                <td><%=l_ventas.get(i).getFecha_venta()%></td>
                                <td><%=l_ventas.get(i).getTipo_comprobante_venta()%></td>
                                <td><%=l_ventas.get(i).getTotal_venta()%></td>
                                <td class="p-3"><p  class="bg-success text-white text-center"><%=estado%></p></td>
                                <td>
                                    <!-- 
                                    <a href="consultas_serv.jsp?id_venta=" 
                                       class="link-dark ">Ver detalle</a>
                                    -->
                                    <a href="../reportes/reporte_detalleventa/reporte_dv.jsp?id_venta=<%=l_ventas.get(i).getId_venta()%>" 
                                       class="link-dark" target="ventana_iframe">Ver detalle
                                    </a>
                                    <a href="RegistroPedidos.jsp" class="ms-1"> X</a>
                                </td>
                            </tr>
                            <%
                                    i++;
                                }
                            %>

                        </tbody>
                    </table>
                </form>

                <iframe src="" marginwidth="0" marginheight="0" name="ventana_iframe" 
                        scrolling="no" frameborder="0" width="80%" height="500" class="col-12 mt-5">

                </iframe> 
            </div>
            <!-- Detalle pedido - mostrar en pdf -->

        </div>

        <div class="footerContainer"></div>
        <script>
            $(document).ready(function () {
                $('.footerContainer').load('../componentes/footer_1.jsp');
            });
        </script>
        <script >
            $(document).ready(function () {
                $('.menuContainer').load('../menuopciones_1.jsp');
            });
        </script>
    </body>
</html>
