<%@page import="Beans.beans_producto"%>
<%@page import="DAO.DAO_producto"%>
<%@page import="DAO.DAO_stock"%>
<%@page import="Beans.beans_stock"%>
<%@page import="Beans.beans_entrega_pedidos"%>
<%@page import="DAO.DAO_entrega_pedidos"%>
<%@page import="Beans.beans_cliente"%>
<%@page import="DAO.DAO_carrito"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="DAO.DAO_venta"%>
<%@page import="DAO.DAO_detalle_venta"%>
<%@page import="Beans.beans_venta"%>
<%@page import="Beans.beans_detalle_venta"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="java.util.List"%>
<%

    //tenemos que obtener el la lista de carrito
    String pagina = request.getParameter("pagina");

    if (pagina.equals("Mostrar")) {
        HttpSession misesion = request.getSession(true);

        RequestDispatcher destino = request.getRequestDispatcher("formularioPedido.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("realizarPedido")) {

        //EN ESTA PARTE YA SE REALIZO EL PAGO Y EL PEDIDO ES VALIDO
        //recuperamos lo que esta en la varible de sesion y lo guardamos en un objeto detalle venta, asi
        //mismo se crea una nueva venta
        HttpSession misesion = request.getSession(true);
        beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");
        List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));
        float totalpago = Float.parseFloat(String.valueOf(misesion.getAttribute("totalPago")));
        int t = carrito.size();

        DAO_venta d_venta = new DAO_venta();
        int N_venta = d_venta.Contar_Venta() + 1;

        beans_detalle_venta b_detalleVenta;

        //hacemo conversion de Util.Date a Date.SQL -> esto es porque MYSQL no soporta el UtilDATE.
        Date utilDate = new java.util.Date();
        Date sqlDate = new java.sql.Date(utilDate.getTime());

        beans_venta b_venta = new beans_venta(N_venta, b_cliente.getId_cliente(), 1, "Factura", "0000" + N_venta, N_venta + "" + N_venta + "000", sqlDate, totalpago);
        DAO_venta d_venta2 = new DAO_venta();

        d_venta2.InsertarVenta(b_venta);

        for (beans_carrito producto : carrito) {
            DAO_detalle_venta d_detalleVenta = new DAO_detalle_venta();
            DAO_detalle_venta d_detalleVenta2 = new DAO_detalle_venta();

            b_detalleVenta = new beans_detalle_venta();

            b_detalleVenta.setId_detalle_venta(d_detalleVenta2.Contar_detalle_venta_Todos() + 1);
            b_detalleVenta.setId_producto(producto.getId_producto());
            //JOptionPane.showMessageDialog(null, "N° VENTA: " + N_venta);
            b_detalleVenta.setId_venta(N_venta);
            b_detalleVenta.setPrecio_venta(producto.getPrecio_venta());
            b_detalleVenta.setCantidad_producto(producto.getCantidad());
            b_detalleVenta.setSubtotal(producto.getSubtotal());
            d_detalleVenta.Insertar_Detalle_Venta(b_detalleVenta);

            /* ------------- Actualizo el Stock ---------------- */
            //primero obtengo objeto stock
            //JOptionPane.showMessageDialog(null, "Id_producto: " + producto.getId_producto());
            DAO_stock d_stock = new DAO_stock();
            List<beans_stock> stock = d_stock.Buscar_Stock_Codigo_Producto(producto.getId_producto());
            //JOptionPane.showMessageDialog(null, "Stock: size " + stock.size());
            //JOptionPane.showMessageDialog(null, "id_stock - amodificar el estado elim:"+stock.get(0).getId_stock());
            DAO_stock d_stock_contar = new DAO_stock();
            int id_stock = d_stock_contar.Contar_Stock()+1;
            //creo un nuevo stock y reducimos el stock de la tabla
            beans_stock b_stock = new beans_stock();
            b_stock.setId_stock(id_stock);
            b_stock.setId_producto(stock.get(0).getId_producto());
            b_stock.setCantidad(stock.get(0).getCantidad() - producto.getCantidad());
            b_stock.setFecha(sqlDate);
            b_stock.setMovimiento(1);//1 = venta(movimiento)
            b_stock.setEstado(0);
            //cambiamos el estado del stock anterior 
            DAO_stock d_stock3 = new DAO_stock();
            d_stock3.Elimnar_Stock_Logico(stock.get(0).getId_stock());//pasamo su estado de 0 - 1
            
            //inserto stock nuevo
            DAO_stock d_stock2 = new DAO_stock();
            d_stock2.InsertarStock(b_stock);
            

            /* ------------------------------------------------- */
            //hacemos que el producto apunte al nuevo stock
            //buscamo el producto:
            DAO_producto d_producto1 = new DAO_producto();
            List<beans_producto> l_producto = d_producto1.Buscar_Producto_Codigo(producto.getId_producto());
            l_producto.get(0).setId_stock(id_stock);//aqui hacemos la referencia al nuevo stock creado
            //modificamos la opcion id_stock
            DAO_producto d_producto2 = new DAO_producto();
            d_producto2.Modificar_Producto_Codigo(l_producto.get(0));

        }
        DAO_carrito d_carrito_delete = new DAO_carrito();
        d_carrito_delete.Delete_Carrito(b_cliente.getId_cliente());
        misesion.setAttribute("carrito", null);

        /*DESPUES DE REGISTRAR LA VENTA. REGISTRAMOS LOS DETALLES DEL FORMULARIO PEDIDO EN LA TABLA ENTREGA PEDIDOS*/
        //RECUPERAMOS LOS DATOS DE LA TABLA
        DAO_entrega_pedidos contar_entrega_pedidos = new DAO_entrega_pedidos();
        int num_entrega = contar_entrega_pedidos.Contar_Entrega_Pedidos() + 1;
        String razonSocial = request.getParameter("razonSocial");
        String departamento = request.getParameter("departamento");
        String direccion = request.getParameter("direccion");
        String referencia = request.getParameter("referencia");
        String nombre_op = request.getParameter("nombre_op");
        String apellidos_op = request.getParameter("apellidos_op");
        String DNI_op = request.getParameter("dni_op");
        String telefono_op = request.getParameter("telefono_op");
        String referencia_op = request.getParameter("referencia_op");
        int estado_entrega = 0;//representa"pendiente"
        DAO_entrega_pedidos dao_entrega_pedidos = new DAO_entrega_pedidos();
        dao_entrega_pedidos.Insertar_Entrega_pedido(new beans_entrega_pedidos(num_entrega, N_venta, b_cliente.getId_cliente(),
                razonSocial, departamento, direccion, referencia, nombre_op, apellidos_op, DNI_op, telefono_op, referencia_op, estado_entrega));

        RequestDispatcher destino = request.getRequestDispatcher("pedido_serv.jsp?pagina=consulta");
        destino.forward(request, response);

    } else if (pagina.equals("consulta")) {//ver Mis pedidos(compras) en la tabla

        HttpSession misesion = request.getSession(true);
        beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");

        DAO_venta d_venta = new DAO_venta();
        List<beans_venta> l_ventas = d_venta.BuscarVentaCodigo_cliente(b_cliente.getId_cliente());

        misesion.setAttribute("l_ventas", l_ventas);

        RequestDispatcher destino = request.getRequestDispatcher("RegistroPedidos.jsp");
        destino.forward(request, response);
    } else {
        RequestDispatcher destino = request.getRequestDispatcher("formularioPedido.jsp");
        destino.forward(request, response);
    }


%>