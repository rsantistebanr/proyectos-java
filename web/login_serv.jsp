<%@page import="Beans.beans_producto"%>
<%@page import="DAO.DAO_producto"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.beans_cliente"%>
<%@page import="DAO.DAO_cliente"%>
<%

    String pagina = request.getParameter("pagina");
    if (pagina.equals("login")) {

        String user = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        //JOptionPane.showMessageDialog(null, "t: " + user);
        //JOptionPane.showMessageDialog(null, "t: " + pass);

        try {
            DAO_cliente o1 = new DAO_cliente();
            List<beans_cliente> lista = new ArrayList<>();
            lista = o1.BuscarCliente_Usuario_Password(user, pass);
            int t = lista.size();
            //JOptionPane.showMessageDialog(null, "t: " + t);

            if (t == 1) {
                //CCREO SESSION
                HttpSession misesion = request.getSession(true);
                //se pasa el usuario como objeto
                misesion.setAttribute("usuario", lista.get(0));

                //redirecciono
                RequestDispatcher destino = request.getRequestDispatcher("login_serv.jsp?pagina=buscar");
                destino.forward(request, response);

            } else {
                //redirecciono
                RequestDispatcher destino = request.getRequestDispatcher("login.jsp");
                destino.forward(request, response);

            }
        } catch (Exception e) {
            System.out.println("Hubo error: " + e);
        }

    } else if (pagina.equals("registrar")) {//redirecciona a registrar
        RequestDispatcher destino = request.getRequestDispatcher("registrar.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("nuevo")) {//se registro , ahora se redireciona a login para que acceda asu cuenta

        String contraseña = request.getParameter("password");
        String Telefono = request.getParameter("telefono");
        if (contraseña.length() > 8 & Telefono.length()<=9 & Telefono.length()>=8) {
            String nombre = request.getParameter("name");
            String usuario = request.getParameter("nameUser");
            String mail = request.getParameter("email");
            
            DAO_cliente d_cliente = new DAO_cliente();
            int id_cliente = d_cliente.Contar_Clientes()+1;
            beans_cliente b_cliente = new beans_cliente();
            b_cliente.setId_cliente(id_cliente);
            b_cliente.setNombre_cliente(nombre);
            b_cliente.setUsuario_cliente(usuario);
            b_cliente.setPassword_cliente(contraseña);
            b_cliente.setEmail_cliente(mail);
            b_cliente.setTelefono_cliente(Telefono);
            
            DAO_cliente d_cliente2 = new DAO_cliente();
            d_cliente2.InsertarCliente(b_cliente);
            
            RequestDispatcher destino = request.getRequestDispatcher("login.jsp");
            destino.forward(request, response);

        }
        RequestDispatcher destino = request.getRequestDispatcher("registrar.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("recuperarPass")) {

        RequestDispatcher destino = request.getRequestDispatcher("login.jsp");
        destino.forward(request, response);

    } else if (pagina.equals("buscar")) {

        String patron = "";
        HttpSession misesion = request.getSession(true);
        DAO_producto o1 = new DAO_producto();
        List<beans_producto> lista_producto = o1.Filtrar_Producto_Nombre(patron);

        misesion.setAttribute("lista_productos", lista_producto);
        RequestDispatcher destino = request.getRequestDispatcher("index.jsp");
        destino.forward(request, response);

    }


%>