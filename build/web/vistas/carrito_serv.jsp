<%@page import="Beans.beans_cliente"%>
<%@page import="DAO.DAO_venta"%>
<%@page import="DAO.DAO_carrito"%>
<%@page import="Beans.beans_producto_precio_stock"%>
<%@page import="DAO.DAO_precio"%>
<%@page import="Beans.beans_precio"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="DAO.DAO_producto"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Beans.beans_producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%

    // servlet para el carrito de compras
    List<beans_carrito> carrito;
    List<beans_producto_precio_stock> l_pview;

    float totalPago = 0.0f;

    String pagina = request.getParameter("pagina");
    if (pagina.equals("pedido")) {

        RequestDispatcher destino = request.getRequestDispatcher("formularioPedido.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("delete")) {//este delete representa el eliminado dentro de carrito no el final que se da el ya alfinalizar elpedido
        HttpSession misesion = request.getSession(true);
        //if (Integer.parseInt(String.valueOf(misesion.getAttribute("bandera_eliminar"))) != 1) {

        if (request.getParameter("item") != null & request.getParameter("posicion") != null) {

            int it = Integer.parseInt(request.getParameter("item"));
            int pos = Integer.parseInt(request.getParameter("posicion"));

            carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));;

            if (carrito.size() > pos) { //validamos el recargar pagina 

                carrito.remove(pos);//lo elimina de la lista y atributo carrito
                DAO_carrito d_carrito = new DAO_carrito();

                d_carrito.Delete_Producto(it);//lo eleimina de carrito en la tabla mysql
                for (int i = 0; i < carrito.size(); i++) {
                    totalPago = totalPago + (carrito.get(i).getPrecio_venta() * carrito.get(i).getCantidad());
                    //JOptionPane.showMessageDialog(null, "suma I: " + totalPago);
                }
            }
            //actualizo carrito y pago
            misesion.setAttribute("carrito", carrito);
            misesion.setAttribute("totalPago", totalPago);
            misesion.setAttribute("bandera_eliminar", 1);

            //  }
        }
        RequestDispatcher destino = request.getRequestDispatcher("ShoppingCart.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("agregarCar")) { //representa la opcion del boton agregar carrito en previewProduct
        HttpSession misesion = request.getSession(true);
        carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));//obtengo el carrito y los porductos agregadoss
        beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");

        l_pview = (List<beans_producto_precio_stock>) misesion.getAttribute("lista_View");//esta lista contine un elemento que viene de PreviewProducts

        if (carrito == null) {
            carrito = new ArrayList();
        }
        if (Integer.parseInt(String.valueOf(misesion.getAttribute("bandera"))) != 1) {
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            //DAO_venta d_venta = new DAO_venta();

            DAO_carrito d_carrito_todos = new DAO_carrito();
            List<beans_carrito> lista_carrito_s_todos = d_carrito_todos.Buscar_Carrito_Todos();
            //int tamanño = d_carrito_tamaño.Buscar_Carrito_Todos().size();
            //entonces si tamaño devuelve 2 tomo ese ultimo elemento de la lista y obtengo su item y le sumo uno: ese nuevo 
            //item sera el item que le correponde al que ningresa recien a tabla carrito
            //DAO_carrito d_carrito_todos = new DAO_carrito();

            int tamaño = lista_carrito_s_todos.size();

            /*Esto sirve para la primera passada*/
            int item = 1;
            if (tamaño > 0) {
                item = lista_carrito_s_todos.get(tamaño - 1).getItem() + 1;
            }
            /* -------------------------------- */

            //lueego de obtener los datos necesario se carga en el carrito
            DAO_carrito d_carrito = new DAO_carrito();
            beans_carrito objcarrito = new beans_carrito();

            objcarrito.setItem(item);
            objcarrito.setId_producto(codigo);

            //esta linea de codigo validad si el cliente entro con su cuenta o si esta en modo no validar acceso
            if (b_cliente != null) {
                //modo si valido acceso
                objcarrito.setId_venta(b_cliente.getId_cliente());
            } else {
                //modo no valido acceso
                objcarrito.setId_venta(0);
            }
            // ------------------------------------ 
            objcarrito.setImg_producto(l_pview.get(0).getImg_producto());
            objcarrito.setNombre(l_pview.get(0).getNombre_producto());
            objcarrito.setDescripcion(l_pview.get(0).getDescripcion_producto());
            objcarrito.setCantidad(cantidad);
            objcarrito.setPrecio_venta(l_pview.get(0).getPrecio());
            objcarrito.setSubtotal(cantidad * l_pview.get(0).getPrecio());
            carrito.add(objcarrito);
            d_carrito.Insertar_Carrito(objcarrito);

            misesion.setAttribute("carrito", carrito);
            for (int i = 0; i < carrito.size(); i++) {
                totalPago = totalPago + (carrito.get(i).getPrecio_venta() * carrito.get(i).getCantidad());
            }
            misesion.setAttribute("totalPago", totalPago);
            misesion.setAttribute("bandera", 1);
        }
        RequestDispatcher destino = request.getRequestDispatcher("ShoppingCart.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("iconAgregarCarrito")) {

    } else if (pagina.equals("home")) {
        RequestDispatcher destino = request.getRequestDispatcher("../index.jsp");
        destino.forward(request, response);
    } else if (pagina.equals("buscar")) {

        String patron = "";
        if (request.getParameter("txtbuscar") != null) {
            patron = request.getParameter("txtbuscar");
        }

        HttpSession misesion = request.getSession(true);
        DAO_producto o1 = new DAO_producto();
        List<beans_producto> lista_producto = o1.Filtrar_Producto_Nombre(patron);

        misesion.setAttribute("lista_productos", lista_producto);
        misesion.setAttribute("patron", patron);
        RequestDispatcher destino = request.getRequestDispatcher("tienda.jsp");
        destino.forward(request, response);
    } else if (pagina.equals("calcular")) {

        HttpSession misesion = request.getSession(true);
        carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));

        float total = 0;
        if (carrito != null) {
            for (int i = 0; i < carrito.size(); i++) {
                //tener en cuenta que en carrito lo que cambia es el i pero no el item (ver pagina = agregarCart )

                int cant_txt = Integer.parseInt(request.getParameter("cantidad" + i));//obtengo la cantidad de cada imput cantidad
                total += (cant_txt * carrito.get(i).getPrecio_venta());
                //modifico la cantidad
                carrito.get(i).setCantidad(cant_txt);//lo modifique logicamente
                carrito.get(i).setSubtotal(cant_txt * carrito.get(i).getPrecio_venta());
                //modificamos en la tabla
                DAO_carrito m_carrito = new DAO_carrito();
                m_carrito.Modificar_Carrito_item(carrito.get(i));
            }
        }
        //JOptionPane.showMessageDialog(null, "Pagina carrito_serv ->calcular: cantidad"+total);
        misesion.setAttribute("carrito", carrito);
        misesion.setAttribute("totalPago", total);
        RequestDispatcher destino = request.getRequestDispatcher("ShoppingCart.jsp");
        destino.forward(request, response);
    }
%>