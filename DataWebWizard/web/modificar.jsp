<%-- 
    Document   : modificar
    Created on : 15/05/2019, 11:24:45 AM
    Author     : andreamarin
--%>

<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
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
               out.println("<input type='hidden' value='"+mySession.getAttribute("user")+"' id='username'/>");
            }else{
                response.sendRedirect("error.jsp");
            }
            
            out.println("<h1 id = 'tabla'>" + request.getParameter("tabla") + "</h1>");
            //out.println("<input type='hidden' value='"+request.getParameter("campos")+"' id='campos'/>");
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(request.getParameter("campos"));
            JSONArray array =  (JSONArray) json.get("response");
            
            for(int i = 0; i < array.size(); i++){
                JSONObject campo = (JSONObject) array.get(i);
                out.println(campo.get("NAME")+ " " + "<input type = 'text' value = ''/> <br>");
            }
        
            
            
            
            
            
        %>
        
        <h3>Selecciona la operación a realizar</h3>
        <input type="button" value="Agregar registro" />
        <input type="button" value="Modificar registro" />
        <input type="button" value="Eliminar registro" />
        <div id = "datos">
            
        </div>
    </body>
</html>
