<%@page import="Beans.beans_cliente"%>
<%@page import="Beans.beans_carrito"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession misesion = request.getSession(true);
    beans_cliente b_cliente = (beans_cliente) misesion.getAttribute("usuario");
    List<beans_carrito> carrito = (List<beans_carrito>) (misesion.getAttribute("carrito"));
    float totalpago = Float.parseFloat(String.valueOf(misesion.getAttribute("totalPago")));
    int t = carrito.size();

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="../style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="../img/utiles/favicon.JPG"/>
        <title>shoppingcart</title>
    </head>

    <body>
        <script >
            $(document).ready(function () {
                $('.menuContainer').load('../menuopciones_1.jsp');
            });
        </script>
        <div class="menuContainer"></div>
        <div class="main pb-5 mb-5">
            <div class="container ">
                <form action="pedido_serv.jsp">
                    <div class="row my-3">
                        <div class ="col-sm-12 col-md-6 col-lg-6 ms-2 pt-3">

                            <table class="table">
                                <tr>
                                    <th>
                                        <label id="name"> Nombres*</label> 
                                        <input class="w-100" type="text" name="name" for="name" value="<%=b_cliente.getNombre_cliente()%> ">
                                    </th>
                                    <th>
                                        <label id="apellidos"> Apellidos*</label><br>
                                        <input class="w-100" type="text" name="name" for="apellidos" value="<%=b_cliente.getAp_cliente() + " " + b_cliente.getAm_cliente()%>">
                                    </th>

                                </tr>

                                <tr>
                                    <th  colspan="2">
                                        <label > Razon Social(Opcional)</label> <br>
                                        <input class="w-100"  type="text" name="razonSocial" value="">
                                    </th>
                                </tr>
                                <tr>
                                    <th >
                                        <label> Tipo de documentos*</label><br>
                                        <select  class="w-100" name="tipoD" >
                                            <option  value="1">DNI</option>
                                            <option value="2">Pasaporte</option>
                                        </select>
                                    </th>
                                    <th scope="col" >
                                        <label id="numeroD"> N° documento*</label><br>
                                        <input class="w-100" type="text" name="numeroD" value="<%=b_cliente.getNumero_documento()%>">
                                    </th>
                                </tr>
                                <tr>
                                    <th scope="col">
                                        <label> Departamento*</label><br>
                                        <select class="w-100"  name="departamento" required="true" >
                                            <option value="Amazonas">Amazonas</option>
                                            <option value="Áncash">Áncash</option>
                                            <option value="Apurímac">Apurímac</option>
                                            <option value="Arequipa">Arequipa</option>
                                            <option value="Ayacucho">Ayacucho</option>
                                            <option value="Cajamarca">Cajamarca</option>
                                            <option value="Callao">Callao</option>
                                            <option value="Cusco">Cusco</option>
                                            <option value="Huancavelica">Huancavelica</option>
                                            <option value="Huánuco">Huánuco</option>
                                            <option value="Junín">Junín</option>
                                            <option value="La Libertad">La Libertad</option><!-- comment -->
                                            <option value="Lambayeque">Lambayeque</option><!-- comment -->
                                            <option value="Lima">Lima</option
                                            <option value="Loreto">Loreto</option
                                            <option value="Madre de Dios">Madre de Dios</option>
                                            <option value="Moquegua">Moquegua</option>
                                            <option value="Pasco">Pasco</option>
                                            <option value="Piura">Piura</option>
                                            <option value="Puno">Puno</option>
                                            <option value="San Martín">San Martín</option>
                                            <option value="Tacna">Tacna</option>
                                            <option value="Tumbes">Tumbes</option>
                                            <option value="Ucayali">Ucayali</option>                                            
                                        </select>
                                    </th>
                                    <th scope="col" >
                                        <label> Direccion*</label><br>
                                        <!-- DISTRITOS -->
                                        <!-- 
                                        <select class="w-100"  name="tipoD" >
                                            <option value="1">DNI</option>
                                            <option value="2">Pasaporte</option>
                                        </select>
                                        -->
                                        <input type="text"class="w-100" name="direccion" required="true">
                                    </th>
                                </tr>
                                <tr>
                                    <th scope="col" colspan="2">
                                        <label > Referencia*</label><br>
                                        <input class="w-100" type="text" name="referencia" required="true">
                                    </th>
                                </tr>
                                <tr>
                                    <th scope="col" colspan="">
                                        <label > Telefono*</label>
                                        <input class="w-100"  type="text" name="telefono" value="<%=b_cliente.getTelefono_cliente()%>">
                                    </th>
                                    <th scope="col" colspan="">
                                        <label > Correo Electronico*</label>
                                        <input class="w-100"  type="mail" name="email" value="<%=b_cliente.getEmail_cliente()%>">
                                    </th>
                                </tr>
                                <tr>
                                    <th colspan="2">
                                        <br>
                                        <h4>PERSONA QUE RECIBIRA EL PEDIDO</h4>
                                    </th>
                                </tr>
                                <tr>
                                    <th scope="col" colspan="">
                                        <label > Nombre</label>
                                        <input class="w-100"  type="text" name="nombre_op" >
                                    </th>
                                    <th scope="col" colspan="">
                                        <label > Apellidos</label>
                                        <input class="w-100"  type="text" name="apellidos_op" >
                                    </th>
                                </tr>

                                <tr>
                                    <th scope="col" colspan="">
                                        <label > N° DNI *</label>
                                        <input class="w-100"  type="text" name="dni_op" >
                                    </th>
                                    <th scope="col" colspan="">
                                        <label > Telefono</label>
                                        <input class="w-100"  type="text" name="telefono_op" >
                                    </th>
                                </tr>

                                <tr>
                                    <th scope="col" colspan="2">
                                        <label > Referencia de la persona*</label><br>
                                        <textarea class="w-100" name="referencia_op"> </textarea>
                                    </th>
                                </tr>


                            </table>


                        </div>

                        <div class ="col-sm-12 col-md-5 col-lg-5 ms-3 pt-4">

                            <h5 class="border-bottom">Tu pedido</h5>
                            <table class="table">
                                <tr>

                                    <th>
                                        <label>Producto</label> 
                                    </th>
                                    <th>
                                        <label>Producto</label> 
                                    </th>
                                </tr>

                                <tbody> 
                                    <%
                                        int i = 0;

                                        while (i < t) {
                                    %> 

                                    <tr>
                                        <td><%=carrito.get(i).getNombre()%></td>
                                        <td><%=carrito.get(i).getSubtotal()%></td>
                                    </tr>

                                    <%
                                            i++;
                                        }
                                    %> 
                                    <tr>
                                        <td>Total</td>
                                        <td>$<%=totalpago%> </td>
                                    </tr>
                                </tbody>

                            </table>
                            <button type="submit" class="btn btn-danger">Realizar pedido</button>
                            <a class="btn btn-secondary" role="button" href="../index.jsp">Seguir Comprando</a>
                            <input type="hidden" name="pagina" value="realizarPedido">


                        </div>

                    </div>
                </form>
            </div>
        </div>

        <footer class="footerContainer "></footer>

        <script>
            $(document).ready(function () {
                $('.footerContainer').load('../componentes/footer_1.jsp');
            });
        </script>
    </body>
</html>
