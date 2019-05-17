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
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(request.getParameter("campos"));
            JSONArray array =  (JSONArray) json.get("response");
            String input, type, id,title, inst = "", pk;
            for(int i = 0; i < array.size(); i++){
                JSONObject campo = (JSONObject) array.get(i);
                
                type = (campo.get("TYPE").toString().equals("INT")) ? "number" : "text";
                
                id = (campo.get("PRIMARYKEY").toString().equals("1")) ? "pk" : "field" + i;
                title = (campo.get("TYPE").toString().equals("VARCHAR")) ? campo.get("NAME").toString() + ",1" : campo.get("NAME").toString() + ",0";
                
                pk = (campo.get("PRIMARYKEY").toString().equals("1")) ? "<b/>PK </b>" : "";
                
                if(campo.get("TYPE").toString().equals("VARCHAR")){
                    inst = "texto de a lo más " + campo.get("LENGTH").toString() + " caracteres";
                }

                if(campo.get("TYPE").toString().equals("INT")){
                    inst = "número entero";
                }

                if(campo.get("TYPE").toString().equals("BOOLEAN")){
                    inst = "boolean (true/false)";
                }
                
                input = "<input title='" + title + "' id='" + id + "' type='"+type+"' value = '' name = 'atributo'/>";
                
                out.println(pk + campo.get("NAME")+":  "+input +campo.get("TYPE").toString()+"  "+ inst + "<br>");
            }
        %>
        
        <h3>Selecciona la operación a realizar</h3>
        <input type="button" value="Agregar registro" onclick="agrega()"/>
        <input type="button" value="Modificar registro" onclick="modifica()"/>
        <input type="button" value="Eliminar registro" onclick="elimina()"/>
        <a id ="index" href ="menu.jsp">Regresar el menu principal</a>
        
        <script>
        function agrega(){
            var atributos = document.getElementsByName("atributo");

            var valid = true;
            var i = 0;
            var n = atributos.length;

            while(valid && i < n){
                if(atributos[i].value == ""){
                    valid = false;
                }

                i += 1;
            }

            if(valid){
                var fields = "";
                for(var i = 0; i < n; i++){
                    var el = atributos[i];
                    var value = el.value;

                    fields += value + "," + el.title.split(",")[1] + ";"  
                }
                alert(fields);

                var tableName = document.getElementById("tabla").innerHTML;
                var username = document.getElementById("username").value;

                var ajaxRequest;

                if(window.XMLHttpRequest){
                    ajaxRequest = new XMLHttpRequest();
                }else{
                    ajaxRequest = new ActiveXObject();
                }

                ajaxRequest.onreadystatechange = function(){
                    if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
                        var json = JSON.parse(ajaxRequest.responseText);

                        if(json.response){
                            alert("Registro agregado exitosamente.");
                        }else{
                           alert("Hubo un problema en la inserción, revisa tus datos.");
                        }
                    }
                }

                alert(tableName)

                var target = 'http://localhost:8080/DataWebWizard/webresources/tableManager';
                var params = '?username='+username+"&tableName=" + tableName + "&fields="+fields;

                ajaxRequest.open("PUT", target + params, true);
                ajaxRequest.setRequestHeader("Content-Type","application/json");

                ajaxRequest.send();

            }else{
                alert("La regaste");
            }
        }
        
        function modifica(){
            var atributos = document.getElementsByName("atributo");

            var i = 0;
            var n = atributos.length;
            var fields = "";

            for(i = 0; i<n;i++){
                if(atributos[i].value != "" && atributos[i].id != "pk"){
                    fields += atributos[i].title.split(",")[0] + "," + atributos[i].value +"," + atributos[i].title.split(",")[1] + ";";
                }
            }

            var primarykey = document.getElementById("pk");
            var pk = primarykey.title.split(",")[0] + "," + primarykey.value + "," + primarykey.title.split(",")[1];

            var tableName = document.getElementById("tabla").innerHTML;
            var username = document.getElementById("username").value;

            if(primarykey.value != "" && fields != ""){
                var ajaxRequest;

                if(window.XMLHttpRequest){
                    ajaxRequest = new XMLHttpRequest();
                }else{
                    ajaxRequest = new ActiveXObject();
                }

                ajaxRequest.onreadystatechange = function(){
                    if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
                        var xml = ajaxRequest.responseXML;
                        
                        var response = xml.getElementsByTagName("result")[0];
                        alert(response.childNodes[0].nodeValue )
                        if(response.childNodes[0].nodeValue == "true"){
                            alert("Tupla modificada");
                        }else{
                            alert("No se pudo modificar la tupla, checa que los datos sean correctos");
                        }
                        
                    }
                }

                alert(tableName);

                var target = 'http://localhost:8080/DataWebWizard/webresources/tableManager';
                var params = '?username='+username+"&tableName=" + tableName + "&fields="+fields+"&primarykey="+pk ;

                ajaxRequest.open("GET", target + params, true);
                ajaxRequest.setRequestHeader("Content-Type","application/xml");

                ajaxRequest.send();

            }else{
                if(primarykey.value == ""){
                    alert("No has llenado la primary key");
                }else{
                    alert("No llenaste ningún campo a modificar");
                }
            }
                
        }
        
        function elimina(){
            var primarykey = document.getElementById("pk");
            var pk = primarykey.title.split(",")[0] + "," + primarykey.value + "," + primarykey.title.split(",")[1];

            var tableName = document.getElementById("tabla").innerHTML;
            var username = document.getElementById("username").value;
            
            if(primarykey.value != ""){
                var ajaxRequest;

                if(window.XMLHttpRequest){
                    ajaxRequest = new XMLHttpRequest();
                }else{
                    ajaxRequest = new ActiveXObject();
                }

                ajaxRequest.onreadystatechange = function(){
                    if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
                        var xml = ajaxRequest.responseXML;
                        
                        var response = xml.getElementsByTagName("result")[0];
                        
                        if(response.childNodes[0].nodeValue == "true"){
                            alert("Tupla eliminada");
                        }else{
                            alert("No se pudo eliminar la tupla, checa que los datos sean correctos");
                        }

                       
                    }
                }

                alert(tableName);

                var target = 'http://localhost:8080/DataWebWizard/webresources/tableManager';
                var params = '?username='+username+"&tableName=" + tableName + "&primarykey="+pk ;

                ajaxRequest.open("DELETE", target + params, true);
                ajaxRequest.setRequestHeader("Content-Type","application/xml");

                ajaxRequest.send();

            }else{
                alert("No especificaste la primary key a eliminar");
            }
        }
      
        </script>
    </body>
</html>
