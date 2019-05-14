package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tablas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
  
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("user") != null){
                out.println("<h1>Bienvenido "+mySession.getAttribute("user")+"</h1>");
            }else{
                response.sendRedirect("error.jsp");
            }
        
      out.write("\r\n");
      out.write("        <h2>Agrega tablas</h2>\r\n");
      out.write("        <form id=\"form\" name=\"form\" action=\"http://localhost:8080/DataWebWizard/webresources/tableManager\" method=\"POST\">\r\n");
      out.write("            <h3>Nombre de la tabla</h3>\r\n");
      out.write("            <input type=\"text\" name=\"nombre\" value=\"\" />\r\n");
      out.write("            <h3>Campos</h3>\r\n");
      out.write("            <p>Nombre del campo: </p><input type=\"text\" name=\"campo1\" value=\"\"/>\r\n");
      out.write("            <p>Tipo</p>\r\n");
      out.write("            <select name=\"Type\">\r\n");
      out.write("                <option></option>\r\n");
      out.write("                <option></option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input id =\"btn\" type=\"submit\" value=\"Crear tabla\" name=\"create\" />\r\n");
      out.write("        </form>\r\n");
      out.write("        <br>\r\n");
      out.write("        <input type=\"button\" value=\"Agrega campo\" onclick=\"agregaCampo()\"/>\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            function agregaCampo(){\r\n");
      out.write("                var btn = document.getElementById(\"btn\");\r\n");
      out.write("                btn.parentNode.removeChild(btn);\r\n");
      out.write("                \r\n");
      out.write("                var nomtxt = document.createElement(\"P\");\r\n");
      out.write("                nomtxt.innerText = \"Nombre del campo: \";\r\n");
      out.write("                \r\n");
      out.write("                var nom = document.createElement(\"INPUT\");\r\n");
      out.write("                nom.setAttribute('type','text');\r\n");
      out.write("                \r\n");
      out.write("                var tipotxt = document.createElement(\"P\");\r\n");
      out.write("                tipotxt.innerText = \"Tipo\";\r\n");
      out.write("                \r\n");
      out.write("                var tipo = document.createElement(\"Select\");\r\n");
      out.write("                \r\n");
      out.write("                var boton = document.createElement(\"INPUT\");\r\n");
      out.write("                boton.setAttribute('id','btn');\r\n");
      out.write("                boton.setAttribute('type','submit');\r\n");
      out.write("                boton.setAttribute('value','Crear tabla')\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                document.getElementById(\"form\").appendChild(nomtxt);\r\n");
      out.write("                document.getElementById(\"form\").appendChild(nom);\r\n");
      out.write("                document.getElementById(\"form\").appendChild(tipotxt);\r\n");
      out.write("                document.getElementById(\"form\").appendChild(tipo);\r\n");
      out.write("                document.getElementById(\"form\").appendChild(boton);\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
