<%-- 
    Document   : reporte_dv
    Created on : 17/04/2022, 11:08:44 PM
    Author     : ROBERT
--%>
<%


    String codigos = request.getParameter("dato");
    int codigo1 = Integer.parseInt(codigos);


 
    File reportFile = new File(application.getRealPath("//reportes/tipo2/ejemplo03.jasper"));
    Map parametros = new HashMap();

    parametros.put("codigo", codigo1);

    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametros, con);
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);

    ServletOutputStream output = response.getOutputStream();
    response.getOutputStream();
    output.write(bytes, 0, bytes.length);
    output.flush();
    output.close();
%>