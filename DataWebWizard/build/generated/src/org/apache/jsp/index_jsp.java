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
      out.write("        <h1>¡Bienvenido a DataWeb Wizard!</h1>\n");
      out.write("        <br>\n");
      out.write("        <h3>En caso de ser un nuevo usuario, presiona el botón de registrar y llena los datos</h3>\n");
      out.write("        <h3>Si ya tienes una cuenta, ingresa tu usuario y contraseña</h3>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form action='Balidar' onsubmit='return validate()'>\n");
      out.write("            <h5 id=\"hName\">Nombre del usuario</h5>\n");
      out.write("            <input id=\"name\" type=\"text\" name=\"name\" value=\"\" />\n");
      out.write("            <h5 id =\"hDbName\">Nombre de la base</h5>\n");
      out.write("            <input id=\"dbName\" type=\"text\" name=\"dbName\" value=\"\" />\n");
      out.write("            <h5>Username</h5>\n");
      out.write("            <input id=\"usr\" type=\"text\" name=\"username\" value=\"\" />\n");
      out.write("            <h5>Contraseña</h5>\n");
      out.write("            <input id=\"psswrd\" type=\"password\" name=\"password\" value=\"\" />\n");
      out.write("            <input id=\"accion\" name=\"accion\" type=\"submit\" value=\"Regístrate\" />\n");
      out.write("            <br>\n");
      out.write("            <input id=\"boton\" value=\"Cambiar a Log in\" type=\"button\" name=\"signOrLog\" onclick=\"changeSignUpLogIn()\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function validate(){\n");
      out.write("                res = false;\n");
      out.write("                \n");
      out.write("                if(document.getElementById(\"usr\").value != \"\" && document.getElementById(\"psswrd\").value != \"\"){\n");
      out.write("                    if(document.getElementById(\"accion\").value == \"Regístrate\"){\n");
      out.write("                        res = document.getElementById(\"name\").value != \"\" && document.getElementById(\"dbName\").value != \"\";\n");
      out.write("                        if(!res){\n");
      out.write("                            alert(\"Llena los campos de nombre de usuario y nombre de base\");\n");
      out.write("                        }\n");
      out.write("                    }else {\n");
      out.write("                        res = true;\n");
      out.write("                    }\n");
      out.write("                }else{\n");
      out.write("                    alert(\"llena los campos de usuario y contraseña\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                return res;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function changeSignUpLogIn(){\n");
      out.write("                var ac = document.getElementById(\"accion\");\n");
      out.write("                var h1 = document.getElementById(\"hName\");\n");
      out.write("                var h2 = document.getElementById(\"hDbName\");\n");
      out.write("                var text1 = document.getElementById(\"name\");\n");
      out.write("                var text2 = document.getElementById(\"dbName\");\n");
      out.write("                var btn = document.getElementById(\"boton\");\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                if(ac.value == \"Regístrate\"){\n");
      out.write("\n");
      out.write("                    h1.hidden=true;\n");
      out.write("                    h2.hidden=true;\n");
      out.write("                    text1.hidden=true;\n");
      out.write("                    text2.hidden=true;\n");
      out.write("                    \n");
      out.write("                    ac.value = \"Log in\";\n");
      out.write("                    btn.value = \"Cambiar a registro\";\n");
      out.write("                }else{\n");
      out.write("                    h1.hidden=false;\n");
      out.write("                    h2.hidden=false;\n");
      out.write("                    text1.hidden=false;\n");
      out.write("                    text2.hidden=false;\n");
      out.write("                    \n");
      out.write("                    ac.value = \"Regístrate\";\n");
      out.write("                    btn.value = \"Cambiar a Log in\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
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
