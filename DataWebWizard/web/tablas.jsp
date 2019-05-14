<%-- 
    Document   : tablas
    Created on : 12/05/2019, 02:32:17 PM
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
        <h2>Agrega tablas</h2>
        <form id="form" name="form" action="http://localhost:8080/DataWebWizard/webresources/tableManager" method="POST">
            <h3>Nombre de la tabla</h3>
            <input type="text" name="nombre" value="" />
            <h3>Campos</h3>
            <p>Nombre del campo: </p><input type="text" name="campo1" value=""/>
            <p>Tipo</p>
            <select name="Type">
                <option></option>
                <option></option>
            </select>
            <br>
            <input id ="btn" type="submit" value="Crear tabla" name="create" />
            <%
                out.println("<input type='hidden' value='"+mySession.getAttribute("user")+"' name='username'/>");
            %>
        </form>
        <br>
        <input type="button" value="Agrega campo" onclick="agregaCampo()"/>
        
        <script>
            function agregaCampo(){
                var btn = document.getElementById("btn");
                btn.parentNode.removeChild(btn);
                
                var nomtxt = document.createElement("P");
                nomtxt.innerText = "Nombre del campo: ";
                
                var nom = document.createElement("INPUT");
                nom.setAttribute('type','text');
                
                var tipotxt = document.createElement("P");
                tipotxt.innerText = "Tipo";
                
                var tipo = document.createElement("Select");
                
                var boton = document.createElement("INPUT");
                boton.setAttribute('id','btn');
                boton.setAttribute('type','submit');
                boton.setAttribute('value','Crear tabla')
                
                
                document.getElementById("form").appendChild(nomtxt);
                document.getElementById("form").appendChild(nom);
                document.getElementById("form").appendChild(tipotxt);
                document.getElementById("form").appendChild(tipo);
                document.getElementById("form").appendChild(boton);
            }
        </script>
    </body>
</html>
