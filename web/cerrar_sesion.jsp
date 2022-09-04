<%

    //HttpSession misesion = request.getSession(true);
    //misesion.getAttribute("carrito");
    
    //eliminamos todas la sessiones activas
    
    //liberamos el carrito de compras en caso quede guardado un producto y el cliente no valido acceso
    
    session.invalidate();

    RequestDispatcher destino = request.getRequestDispatcher("index.jsp");
    destino.forward(request, response);


%>


