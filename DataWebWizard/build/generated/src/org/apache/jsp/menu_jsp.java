package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1>Aquí puedes manejar y consultar tu base de datos</h1>\r\n");
      out.write("        <h3>Tus tablas</h3>\r\n");
      out.write("        <select name=\"tables\">\r\n");
      out.write("            <option>blegh</option>\r\n");
      out.write("            <option>bluh</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        \r\n");
      out.write("        ");

            if(request.getParameter("password") != null){
                HttpSession mySession = request.getSession();
                mySession.setAttribute("user", request.getParameter("username"));
                
                mySession.setMaxInactiveInterval(20);
            }else{
                response.sendRedirect("error.jsp");
            }
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h3>Acciones posibles con la base de datos</h3>\r\n");
      out.write("        <input type=\"submit\" value=\"Agregar tabla\" name=\"agrtabla\" />\r\n");
      out.write("        <input type=\"submit\" value=\"Eliminar tabla\" name=\"elimtabla\" />\r\n");
      out.write("        <h3>Acciones posibles con una tabla (selecciona la tabla con la que quieres ejecutar la acción)</h3>\r\n");
      out.write("        <input type=\"submit\" value=\"Consulta tabla\" name=\"cons\" />\r\n");
      out.write("        <input type=\"submit\" value=\"Agrega entradas\" name=\"agr\" />\r\n");
      out.write("        <input type=\"submit\" value=\"Elimina entradas\" name=\"elim\" />\r\n");
      out.write("        <input type=\"submit\" value=\"Modifica entradas\" name=\"mod\" />\r\n");
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
