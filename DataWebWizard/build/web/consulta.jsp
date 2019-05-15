<%-- 
    Document   : consulta
    Created on : 14/05/2019, 05:36:34 PM
    Author     : andreamarin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body >
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("user") != null){
               out.println("<input type='hidden' value='"+mySession.getAttribute("user")+"' id='username'/>");
            }else{
                response.sendRedirect("error.jsp");
            }
            
            out.println("<h1 id = 'tabla'>" + request.getParameter("tabla") + "</h1>");
            out.println("<input type='hidden' value='"+request.getParameter("datos")+"' id='json'/>");
        %>
        <p>Número de datos a visualizar simultáneamente: </p><input type="number" id ="n" value="10" />
        <input type="button" value="Visualizar" onclick="visualizar()"/>
        <div id ="data">
            <input type ="button" value ="<<" id ="first" onclick="update(document.getElementById('n').value,1)" disabled = "disabled" />
            <input type ="button" value ="<" id ="before" disabled = "disabled" onclick="update(document.getElementById('n').value, Number(document.getElementById('pag').value)-1)" />
            <span id = 'pag' value = "1">1</span>
            <input type ="button" value =">" id ="next" disabled = "disabled" onclick="update(document.getElementById('n').value, Number(document.getElementById('pag').value)+1)"/>
            <input type ="button" value =">>" id ="last" disabled = "disabled" onclick="update(document.getElementById('n').value,0)"/>
        </div>
        
        
        <script>
            function visualizar(){
                var json = JSON.parse(document.getElementById('json').value);
                
                if(json.response  == "error"){
                    document.getElementById('data').innerHTML = "<p>  Ha ocurrido un error intentando encontrar datos <p>"
                    + "<br> <a href = menu.jsp>Regresar al menú</a>";
                }else{
                    document.getElementById('first').disabled = false;
                    document.getElementById('before').disabled = false;
                    document.getElementById('next').disabled = false;
                    document.getElementById('last').disabled = false;
                    update(document.getElementById('n').value,1)
                }
                
            }
            
            function update(n,i){
                var json = JSON.parse(document.getElementById('json').value);
                var data = json.response;
                var n = Number(n);
                
                if(data  ==  'No tienes datos todavia.'){
                    var txt = "<p>" + data + "</p>";
                    document.getElementById('data').innerHTML = txt;
                }else{
                    var num = Math.ceil(data.length/n);
                    
                    if(document.getElementById('resultado') != null){
                        tabla = document.getElementById('resultado');
                        tabla.parentNode.removeChild(tabla);
                    }
                    
                    if(i == 0){
                        i = num;
                    }
                    
                    if(i > num){
                        i = 1;
                    }
                    
                    document.getElementById('pag').value = i;
                    document.getElementById('pag').innerHTML = i;

                    var table = document.createElement("table");
                    table.setAttribute('id','resultado');

                    var start = n*(i-1);
                    var end = Math.min(start + n,  data.length);

                    var row = document.createElement("tr");
                    for(key in data[0]){
                        var col = document.createElement("td");
                        var txt = document.createTextNode(key);
                        col.appendChild(txt);
                        row.appendChild(col);
                    }
                    table.appendChild(row);

                    for(var j = start; j < end; j++){
                        var row = document.createElement("tr");
                        var data_row = data[j];

                        for(key in data_row){
                            var col = document.createElement("td");
                            var txt = document.createTextNode(data_row[key]);

                            col.appendChild(txt);
                            row.appendChild(col);
                        }
                        table.appendChild(row);
                    }


                    document.getElementById('data').appendChild(table);
                }

        }
        </script>
    </body>
</html>
