<%-- 
    Document   : menu
    Created on : 12/05/2019, 02:19:17 PM
    Author     : Luis Landa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="loadTables()">
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("user") != null){
                out.println("<h1>Bienvenido "+mySession.getAttribute("user")+"!</h1>");
                out.println("<input type='hidden' value='"+mySession.getAttribute("user")+"' id='username'/>");
            }else{
                response.sendRedirect("error.jsp");
            }
        %>
        <h2>Aquí puedes manejar y consultar tu base de datos</h2>
        <h3>Tus tablas</h3>
        <p id ="error"></p>
        
        <select id="tables" onchange="update(this.value)" >
        </select>
        
        
        
        <h3>Acciones posibles con la base de datos</h3>
        
        <form action="tablas.jsp">
        <input type="submit" value="Agregar tabla" name="agrtabla" />
        </form>
        
        <h3>Acciones posibles con una tabla (selecciona la tabla con la que quieres ejecutar la acción)</h3>
        
        <form action="Consultar">
        <input type='hidden' value='' id='tabla' name = 'tabla'/>
        <input type="submit" value="Consulta tabla" name="cons" />
        </form>
        
        <form action="tablas.jsp">
        <input type="submit" value="Agrega entradas" name="agr" />
        <input type="submit" value="Elimina entradas" name="elim" />
        <input type="submit" value="Modifica entradas" name="mod" />
        </form>
         
        <script> 
            function update(value){
                
                
                document.getElementById("tabla").value = value;
            }
            
            function loadTables(){
                var ajaxRequest;

                if(window.XMLHttpRequest){
                    ajaxRequest = new XMLHttpRequest();
                }else{
                    ajaxRequest = new ActiveXObject();
                }

                var user = document.getElementById("username").value;

                ajaxRequest.onreadystatechange = function(){
                    if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
                        var json = JSON.parse(ajaxRequest.responseText);

                var txt = "";
                        var n = json.response.length;

                        if(json.response != "error"){
                            for(var i = 0; i < json.response.length; i++){
                                var nom = json.response[i]
                                txt += "<option value = '"+nom+"'>"+json.response[i]+"</option>";
                            }
                            document.getElementById("tables").innerHTML = txt;
                            document.getElementById("error").hidden = true;
                            document.getElementById("tables").hidden = false;
                        }else{
                            document.getElementById("tables").hidden = true;
                            document.getElementById("error").hidden = false;
                            document.getElementById("error").innerHTML = "Por el momento no tienes tablas";
                        }
                    }
                }
                target = 'http://localhost:8080/DataWebWizard/webresources/query?username='+user
                ajaxRequest.open("PUT", target, true);
                ajaxRequest.setRequestHeader("Content-Type","application/json");
                ajaxRequest.send();
            }
            
        </script>
        
    </body>
    
</html>
