<%@page import="java.util.List"%>
<%@page import="Beans.beans_detalle_venta"%>
<%@page import="DAO.DAO_detalle_venta"%>
<%@page import="DAO.DAO_venta"%>
<%@page import="Beans.beans_cliente"%>
<%

    HttpSession misesion = request.getSession(true);
    beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");

    int id_venta = Integer.parseInt(request.getParameter("id_venta"));

//haciendo el uso del DAO_venta obtengo todas las ventas cone es codigo:
    DAO_venta d_venta = new DAO_venta();
    DAO_detalle_venta d_detalle_venta = new DAO_detalle_venta();

    List<beans_detalle_venta> l_detalles = d_detalle_venta.Buscar_detalle_venta(id_venta);
    misesion.setAttribute("l_detalles", l_detalles);

    RequestDispatcher destino = request.getRequestDispatcher("RegistroPedidos.jsp");
    destino.forward(request, response);

%>


