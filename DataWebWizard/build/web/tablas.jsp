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
        <form id="form" name="form">
            <h3>Nombre de la tabla</h3>
            <input type="text" id="tableName" value="" />
            <h3>Campos</h3>
            <p>Nombre del campo: </p><input type="text" name="campo1" value=""/>
            <p>Tipo</p>
            <select name="type" id = "type">
                <option>VARCHAR</option>
                <option>INT</option>
                <option>BOOLEAN</option>
            </select>
            <p>Longitud: </p><input type="number" name="long" value=""/>
            <input type="radio" name="pk" value="pk1" />
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
                
                var lengthtxt = document.createElement("P");
                tipotxt.innerText = "Longitud: ";
                
                var length = document.createElement("INPUT");
                length.setAttribute('type','number');
                
                var pk = document.createElement("P");
                tipotxt.innerText = "Primary key ";
                
                var radiobtn = document.createElement("INPUT");
                radiobtn.setAttribute('type','radio');
                radiobtn.setAttribute('name','pk');
                radiobtn.setAttribute('value','pk2');
                
                var tipo = document.getElementById("type").cloneNode(true);
                tipo.setAttribute('id','type2');
                
                var boton = document.createElement("INPUT");
                boton.setAttribute('id','btn');
                boton.setAttribute('type','submit');
                boton.setAttribute('value','Crear tabla')
                
                
                document.getElementById("form").appendChild(nomtxt);
                document.getElementById("form").appendChild(nom);
                document.getElementById("form").appendChild(tipotxt);
                document.getElementById("form").appendChild(tipo);
                document.getElementById("form").appendChild(lengthtxt);
                document.getElementById("form").appendChild(length);
                document.getElementById("form").appendChild(radiobtn);
                document.getElementById("form").appendChild(pk);
            }
        </script>
    </body>
</html>
