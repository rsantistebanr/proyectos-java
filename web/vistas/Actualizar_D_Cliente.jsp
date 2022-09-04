<%@page import="DAO.DAO_cliente"%>
<%@page import="Beans.beans_cliente"%>
<%
    HttpSession misesion = request.getSession(true);
    beans_cliente usuario = (beans_cliente) misesion.getAttribute("usuario");
    String pagina = request.getParameter("pagina");

    beans_cliente b_cliente = new beans_cliente();
    DAO_cliente dAO_cliente = new DAO_cliente();

    if (pagina.equals("u_perfil")) { //u_perfil -> update perfil
        //preparo los datos
        String nombre = request.getParameter("nombre");
        String ap = request.getParameter("ap");
        String am = request.getParameter("am");
        String telf = request.getParameter("telf");
        String mail = request.getParameter("mail");
        String tipoDoc = request.getParameter("tipoDoc");
        String numDoc = request.getParameter("numDoc");
        String direccion = request.getParameter("direccion");

        //prearo un beans_cliente:
        b_cliente.setNombre_cliente(nombre);
        b_cliente.setAp_cliente(ap);
        b_cliente.setAm_cliente(am);
        b_cliente.setTelefono_cliente(telf);
        b_cliente.setEmail_cliente(mail);
        b_cliente.setTipo_documento(tipoDoc);
        b_cliente.setNumero_documento(numDoc);
        b_cliente.setDireccion_cliente(direccion);
        //datos que quedan como estan
        b_cliente.setId_cliente(usuario.getId_cliente());
        b_cliente.setSexo_cliente(usuario.getSexo_cliente());
        b_cliente.setUsuario_cliente(usuario.getUsuario_cliente());
        b_cliente.setPassword_cliente(usuario.getPassword_cliente());
        b_cliente.setEliminado_cliente(usuario.getEliminado_cliente());

        //modifico el cliente haciendo uso del DAO_cliente
        dAO_cliente.ModificarCliente(b_cliente);
        //redirecciono y modifico el atributo de sesion "usuario"
    } else {

        //preparo los datos
        String user = request.getParameter("user");
        String newPass = request.getParameter("newPass");

        b_cliente.setId_cliente(usuario.getId_cliente());
        b_cliente.setNombre_cliente(usuario.getNombre_cliente());
        b_cliente.setAp_cliente(usuario.getAp_cliente());
        b_cliente.setAm_cliente(usuario.getAm_cliente());
        b_cliente.setTelefono_cliente(usuario.getTelefono_cliente());
        b_cliente.setEmail_cliente(usuario.getEmail_cliente());
        b_cliente.setTipo_documento(usuario.getTipo_documento());
        b_cliente.setNumero_documento(usuario.getNumero_documento());
        b_cliente.setDireccion_cliente(usuario.getDireccion_cliente());
        b_cliente.setSexo_cliente(usuario.getSexo_cliente());
        b_cliente.setUsuario_cliente(user);
        b_cliente.setPassword_cliente(newPass);
        b_cliente.setEliminado_cliente(usuario.getEliminado_cliente());

        dAO_cliente.ModificarCliente(b_cliente);

    }
    misesion.setAttribute("usuario", b_cliente);
    RequestDispatcher destino = request.getRequestDispatcher("MisDatos.jsp");
    destino.forward(request, response);
%>
