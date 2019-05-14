package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1>¡Bienvenido a DataWeb Wizard!</h1>\r\n");
      out.write("        <br>\r\n");
      out.write("        <h3>En caso de ser un nuevo usuario, presiona el botón de registrar y llena los datos</h3>\r\n");
      out.write("        <h3>Si ya tienes una cuenta, ingresa tu usuario y contraseña</h3>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <form action='menu.jsp' onsubmit='return validate()'>\r\n");
      out.write("            <h5 id=\"hName\">Nombre del usuario</h5>\r\n");
      out.write("            <input id=\"name\" type=\"text\" name=\"name\" value=\"\" />\r\n");
      out.write("            <h5 id =\"hDbName\">Nombre de la base</h5>\r\n");
      out.write("            <input id=\"dbName\" type=\"text\" name=\"dbName\" value=\"\" />\r\n");
      out.write("            <h5>Username</h5>\r\n");
      out.write("            <input type=\"text\" name=\"username\" value=\"\" />\r\n");
      out.write("            <h5>Contraseña</h5>\r\n");
      out.write("            <input type=\"password\" name=\"password\" value=\"\" />\r\n");
      out.write("            <input id=\"accion\" type=\"submit\" value=\"Regístrate\" />\r\n");
      out.write("            <br>\r\n");
      out.write("            <input id=\"boton\" value=\"Cambiar a Log in\" type=\"button\" name=\"signOrLog\" onclick=\"changeSignUpLogIn()\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            function validate(){\r\n");
      out.write("                /*\r\n");
      out.write("                var ajaxRequest;\r\n");
      out.write("                var target = \"\";\r\n");
      out.write("                if(document.getElementById('accion').value == 'Regístrate'){\r\n");
      out.write("                    target = 'http://localhost:8080/DataWebWizard/webresources/signup'\r\n");
      out.write("                }else{\r\n");
      out.write("                    target = \"http://localhost:8080/DataWebWizard/webresources/login?username=llanda&password=123\"\r\n");
      out.write("                }\r\n");
      out.write("                alert(target);\r\n");
      out.write("                if (window.XMLHttpRequest){\r\n");
      out.write("                    ajaxRequest=new XMLHttpRequest();\r\n");
      out.write("                } else { \r\n");
      out.write("                    ajaxRequest=new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("                }\r\n");
      out.write("                ajaxRequest.onreadystatechange = function(){\r\n");
      out.write("                    alert(ajaxRequest.readyState);\r\n");
      out.write("                    alert(ajaxRequest.status);\r\n");
      out.write("                    if (ajaxRequest.readyState==4 && (ajaxRequest.status==200)){\r\n");
      out.write("                        alert(ajaxRequest.responseXML);\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                ajaxRequest.open('POST', target, true);\r\n");
      out.write("                ajaxRequest.setRequestHeader(\"Content-Type\", \"t<ext/html\");\r\n");
      out.write("                ajaxRequest.send(''); \r\n");
      out.write("                */\r\n");
      out.write("               \r\n");
      out.write("               return true;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            function changeSignUpLogIn(){\r\n");
      out.write("                var ac = document.getElementById(\"accion\");\r\n");
      out.write("                var h1 = document.getElementById(\"hName\");\r\n");
      out.write("                var h2 = document.getElementById(\"hDbName\");\r\n");
      out.write("                var text1 = document.getElementById(\"name\");\r\n");
      out.write("                var text2 = document.getElementById(\"dbName\");\r\n");
      out.write("                var btn = document.getElementById(\"boton\");\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                if(ac.value == \"Regístrate\"){\r\n");
      out.write("\r\n");
      out.write("                    h1.hidden=true;\r\n");
      out.write("                    h2.hidden=true;\r\n");
      out.write("                    text1.hidden=true;\r\n");
      out.write("                    text2.hidden=true;\r\n");
      out.write("                    \r\n");
      out.write("                    ac.value = \"Log in\";\r\n");
      out.write("                    btn.value = \"Cambiar a registro\";\r\n");
      out.write("                }else{\r\n");
      out.write("                    h1.hidden=false;\r\n");
      out.write("                    h2.hidden=false;\r\n");
      out.write("                    text1.hidden=false;\r\n");
      out.write("                    text2.hidden=false;\r\n");
      out.write("                    \r\n");
      out.write("                    ac.value = \"Regístrate\";\r\n");
      out.write("                    btn.value = \"Cambiar a Log in\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
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
