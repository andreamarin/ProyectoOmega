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
            
            <table>
                <tbody id ="campos_tabla" title = "1">
                <tr id = "campo1" >
                    <td>Nombre del campo: <input class = "atributo" type="text" name="nom" value=""/></td>
                    <td><select name = "type" class = "atributo" onchange = "validate(this)">
                        <option>VARCHAR</option>
                        <option>INT</option>
                        <option>BOOLEAN</option>
                    </select></td>
                    <td>Longitud: <input type="number" name="long" value="" class = "atributo"/></td>
                    <td><input type="radio" name="pk" value="pk1" class = "atributo"/>Primary key</td>
                </tr>
                </tbody>
            </table>
            <input type="button" value="Agrega campo" onclick="agregaCampo()"/>
            <input id ="btn" type="button" value="Crear tabla" id="create" onclick="createTable()"/>
            <%
                out.println("<input type='hidden' value='"+mySession.getAttribute("user")+"' id='username'/>");
            %>
        </form>
        <br>
        <a id ="index" href ="menu.jsp">Regresar el menu principal</a>
        
        <script>
            function validate(dd){
                if(dd.value == "VARCHAR"){
                    dd.parentNode.parentNode.getElementsByClassName("atributo")[2].disabled = false;
                }else{
                    dd.parentNode.parentNode.getElementsByClassName("atributo")[2].disabled = true;
                }
            }
            
            function createTable(){
                var numElems = Number(document.getElementById("campos_tabla").title)
                var fields = "";
                
                for(var i = 1 ; i <= numElems; i++){
                    var fila = document.getElementById("campo"+i);
                    var campos = fila.getElementsByClassName("atributo");
                    fields += campos[0].value + "," + campos[1].value + ",";
                    fields += (campos[1].value == "VARCHAR") ? campos[2].value + "," : "null,";
                    fields += (campos[3].checked) ? "1;" : "0;";
                }
                
                var tableName = document.getElementById("tableName").value;
                var username = document.getElementById("username").value;
                
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
                            alert("Tabla creada exitosamente.");
                            document.getElementById("form").hidden = true;
                        }else{
                            alert("Hubo un error al crear la tabla.");
                        }

                
                    }
                }
                var target = 'http://localhost:8080/DataWebWizard/webresources/tableManager';
                var params = 'username='+username+"&tableName=" + tableName + "&fieldsStr="+fields;
                
                ajaxRequest.open("POST", target, true);
                ajaxRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                
                ajaxRequest.send(params);
            }
            
            function agregaCampo(){
                var tabla = document.getElementById("campos_tabla");
                var n = Number(tabla.title) + 1;
                
                var fila = document.getElementById("campo1").cloneNode(true);
                fila.setAttribute('id', 'campo'+n);
                
                
                childs = fila.getElementsByClassName("atributo");
                
                childs[0].value = "";
                childs[2].value = "";
                
                tabla.appendChild(fila);
                tabla.setAttribute("title",n)
                
                /*
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
                */
            }
        </script>
    </body>
</html>
