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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Elimina/Agrega tablas</h1>\n");
      out.write("        <form id=\"form\" name=\"form\" action=\"http://localhost:8080/DataWebWizard/webresources/tableManager\" method=\"POST\">\n");
      out.write("            <h3>Nombre de la tabla</h3>\n");
      out.write("            <input type=\"text\" name=\"nombre\" value=\"\" />\n");
      out.write("            <h3>Campos</h3>\n");
      out.write("            <p>Nombre del campo: </p><input type=\"text\" name=\"campo1\" value=\"\"/>\n");
      out.write("            <p>Tipo</p>\n");
      out.write("            <select name=\"Type\">\n");
      out.write("                <option></option>\n");
      out.write("                <option></option>\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            <input id =\"btn\" type=\"submit\" value=\"Crear tabla\" name=\"create\" />\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        <input type=\"button\" value=\"Agrega campo\" onclick=\"agregaCampo()\"/>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function agregaCampo(){\n");
      out.write("                var btn = document.getElementById(\"btn\");\n");
      out.write("                btn.parentNode.removeChild(btn);\n");
      out.write("                \n");
      out.write("                var nomtxt = document.createElement(\"P\");\n");
      out.write("                nomtxt.innerText = \"Nombre del campo: \";\n");
      out.write("                \n");
      out.write("                var nom = document.createElement(\"INPUT\");\n");
      out.write("                nom.setAttribute('type','text');\n");
      out.write("                \n");
      out.write("                var tipotxt = document.createElement(\"P\");\n");
      out.write("                tipotxt.innerText = \"Tipo\";\n");
      out.write("                \n");
      out.write("                var tipo = document.createElement(\"Select\");\n");
      out.write("                \n");
      out.write("                var boton = document.createElement(\"INPUT\");\n");
      out.write("                boton.setAttribute('id','btn');\n");
      out.write("                boton.setAttribute('type','submit');\n");
      out.write("                boton.setAttribute('value','Crear tabla')\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                document.getElementById(\"form\").appendChild(nomtxt);\n");
      out.write("                document.getElementById(\"form\").appendChild(nom);\n");
      out.write("                document.getElementById(\"form\").appendChild(tipotxt);\n");
      out.write("                document.getElementById(\"form\").appendChild(tipo);\n");
      out.write("                document.getElementById(\"form\").appendChild(boton);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
