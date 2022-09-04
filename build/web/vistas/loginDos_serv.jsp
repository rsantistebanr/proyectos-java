<%@page import="Beans.beans_carrito"%>
<%@page import="DAO.DAO_carrito"%>
<%@page import="Beans.beans_cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAO_cliente"%>
<%@page import="javax.swing.JOptionPane"%>
<%
    //Pasos: //LOGIN2 - MODAL
    /*
   1. Se detecta la pagina, en este caso es login2
   2. Se obtiene los datos user y pass
   3. Se hace la validadcion con los DAO - Beans
   4. Hay dos opciones, a) si el usuario existe :
        4.1.obtengo los producto regitrados en el carrito - porque necesito los items de cada uno y asi extraerlos de 
            la tabla.
   
        4.2. Se procede a modificar el campo de id_venta(id_cliente) de la tabla carrito
            del MYSQL y cambiarlo por el id_cliente del usuario ya logueado, ojo el id_venta(id_cliente) de la tabla 
            carrito esta en valor cero cuando se agregue un porducto al carrito si haber iniciado session.
   
        4.3.luego de haber hecho la modigicacion yu que todo este OK, se procede a redireccionar a la pagina de donde
            se logueo,en este caso sera ShoppingCart.jsp
   
   5.La opcion b): es cuando el user y pass no son correctos, para ello solo se procede a mostrar un alert en la pagina
        y redirecciona a la misma pagina ShoppingCart.jsp
   
     */

    // 1.
    String pagina = request.getParameter("pagina");
    float totalPago = 0f;

    if (pagina.equals("login2")) {//este login2 modifica lo que el cliente guar en el carrito antes de logearse
        // 2.
        String user = request.getParameter("usuario");
        String pass = request.getParameter("pass");

        try {
            // 3.
            DAO_cliente o1 = new DAO_cliente();
            List<beans_cliente> lista = new ArrayList<>();
            lista = o1.BuscarCliente_Usuario_Password(user, pass);
            int t = lista.size();
            //JOptionPane.showMessageDialog(null, "t: " + t);

            if (t == 1) {
                //CREO VARIABLE DE SESSION
                HttpSession misesion = request.getSession(true);

                misesion.setAttribute("usuario", lista.get(0));

                //4.1 obtengo los producto del carrito almacenados el a varibale de sesion carrito
                List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));

                if (carrito != null) {
                    //4.2
                    for (int i = 0; i < carrito.size(); i++) {
                        //se modifica primero al atributo id_venta(id_Cliente) y luego a la tabla
                        //JOptionPane.showMessageDialog(null, "Pagina login Dos: item"+carrito.get(i).getItem());
                        carrito.get(i).setId_venta(lista.get(0).getId_cliente());

                        DAO_carrito m_carrito = new DAO_carrito();
                        m_carrito.Modificar_Carrito_item(carrito.get(i));
                        carrito.set(i, carrito.get(i));
                    }

                }

                //->(obtenemos los posible elementos que se queadaron en el temporal carrito )
                DAO_carrito dAO_carrito = new DAO_carrito();
                List<beans_carrito> recupero_carrito = dAO_carrito.Buscar_Producto_Codigo_Venta(lista.get(0).getId_cliente());

                //4.3 seteo el atributo carrito y redirecciono
                //calculamo el nuevo subtotal
                for (int i = 0; i < recupero_carrito.size(); i++) {
                    totalPago = totalPago + (recupero_carrito.get(i).getPrecio_venta() * recupero_carrito.get(i).getCantidad());
                }
                misesion.setAttribute("totalPago", totalPago);
                misesion.setAttribute("carrito", recupero_carrito);
                RequestDispatcher destino = request.getRequestDispatcher("ShoppingCart.jsp");
                destino.forward(request, response);

            } else {

                //6. muestro un alert que diga login incorrecto
                //JOptionPane.showMessageDialog(null, "!Error: User and password failed!");
                RequestDispatcher destino = request.getRequestDispatcher("ShoppingCart.jsp");
                destino.forward(request, response);

            }
        } catch (Exception e) {
            System.out.println("Hubo error: " + e);
        }
    }
%>