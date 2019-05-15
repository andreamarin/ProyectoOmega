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
        
        
        <form action='Balidar' onsubmit='return validate()'>
            <h5 id="hName">Nombre del usuario</h5>
            <input id="name" type="text" name="name" value="" />
            <h5 id ="hDbName">Nombre de la base</h5>
            <input id="dbName" type="text" name="dbName" value="" />
            <h5>Username</h5>
            <input id="usr" type="text" name="username" value="" />
            <h5>Contraseña</h5>
            <input id="psswrd" type="password" name="password" value="" />
            <input id="accion" name="accion" type="submit" value="Regístrate" />
            <br>
            <input id="boton" value="Cambiar a Log in" type="button" name="signOrLog" onclick="changeSignUpLogIn()"/>
        </form>
        

        
        
        <script>
            function validate(){
                res = false;
                
                if(document.getElementById("usr").value != "" && document.getElementById("psswrd").value != ""){
                    if(document.getElementById("accion").value == "Regístrate"){
                        res = document.getElementById("name").value != "" && document.getElementById("dbName").value != "";
                        if(!res){
                            alert("Llena los campos de nombre de usuario y nombre de base");
                        }
                    }else {
                        res = true;
                    }
                }else{
                    alert("llena los campos de usuario y contraseña");
                }
                
                return res;
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
