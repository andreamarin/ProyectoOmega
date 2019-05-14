<%-- 
    Document   : Datos
    Created on : 12/05/2019, 03:13:36 PM
    Author     : Luis Landa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("user") != null){
                out.println("<h1>Bienvenido "+mySession.getAttribute("user")+"!</h1>");
            }else{
                response.sendRedirect("error.jsp");
            }
        %>
        <h1>Maneja los datos de tu tabla</h1>
        <h2>Consulta tabla</h2>
    </body>
</html>
