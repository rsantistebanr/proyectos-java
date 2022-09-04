<%-- 
    Document   : reporte_dv
    Created on : 17/04/2022, 11:08:44 PM
    Author     : ROBERT
--%>
<%@page import="Config.connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%

    Connection con = null;
    connection obj_conn = new connection();
    con = obj_conn.getConnection();
    
    String codigo = request.getParameter("id_venta");
    int id_venta = Integer.parseInt(codigo);


 
    File reportFile = new File(application.getRealPath("//reportes/reporte_detalleventa/detalleventa.jasper"));
    Map parametros = new HashMap();

    parametros.put("id_venta", id_venta);

    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametros, con);
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);

    ServletOutputStream output = response.getOutputStream();
    response.getOutputStream();
    output.write(bytes, 0, bytes.length);
    output.flush();
    output.close();
%>