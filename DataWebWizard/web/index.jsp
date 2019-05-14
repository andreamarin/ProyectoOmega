<%-- 
    Document   : index
    Created on : 12/05/2019, 11:57:42 AM
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
        <h1>¡Bienvenido a DataWeb Wizard!</h1>
        <br>
        <h3>En caso de ser un nuevo usuario, presiona el botón de registrar y llena los datos</h3>
        <h3>Si ya tienes una cuenta, ingresa tu usuario y contraseña</h3>
        
        
        <form action='menu.jsp' onsubmit='return validate()'>
            <h5 id="hName">Nombre del usuario</h5>
            <input id="name" type="text" name="name" value="" />
            <h5 id ="hDbName">Nombre de la base</h5>
            <input id="dbName" type="text" name="dbName" value="" />
            <h5>Username</h5>
            <input type="text" name="username" value="" />
            <h5>Contraseña</h5>
            <input type="password" name="password" value="" />
            <input id="accion" type="submit" value="Regístrate" />
            <br>
            <input id="boton" value="Cambiar a Log in" type="button" name="signOrLog" onclick="changeSignUpLogIn()"/>
        </form>
        

        
        
        <script>
            function validate(){
                /*
                var ajaxRequest;
                var target = "";
                if(document.getElementById('accion').value == 'Regístrate'){
                    target = 'http://localhost:8080/DataWebWizard/webresources/signup'
                }else{
                    target = "http://localhost:8080/DataWebWizard/webresources/login?username=llanda&password=123"
                }
                alert(target);
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest();
                } else { 
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP");
                }
                ajaxRequest.onreadystatechange = function(){
                    alert(ajaxRequest.readyState);
                    alert(ajaxRequest.status);
                    if (ajaxRequest.readyState==4 && (ajaxRequest.status==200)){
                        alert(ajaxRequest.responseXML);
                    }
                }
                ajaxRequest.open('POST', target, true);
                ajaxRequest.setRequestHeader("Content-Type", "t<ext/html");
                ajaxRequest.send(''); 
                */
               
               return true;
            }
            
            function changeSignUpLogIn(){
                var ac = document.getElementById("accion");
                var h1 = document.getElementById("hName");
                var h2 = document.getElementById("hDbName");
                var text1 = document.getElementById("name");
                var text2 = document.getElementById("dbName");
                var btn = document.getElementById("boton");
                
                
                if(ac.value == "Regístrate"){

                    h1.hidden=true;
                    h2.hidden=true;
                    text1.hidden=true;
                    text2.hidden=true;
                    
                    ac.value = "Log in";
                    btn.value = "Cambiar a registro";
                }else{
                    h1.hidden=false;
                    h2.hidden=false;
                    text1.hidden=false;
                    text2.hidden=false;
                    
                    ac.value = "Regístrate";
                    btn.value = "Cambiar a Log in";
                }
            }
        </script>
        
    </body>
</html>
