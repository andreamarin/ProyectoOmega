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
    <body>
        <h1>Aquí puedes manejar y consultar tu base de datos</h1>
        <h3>Tus tablas</h3>
        <select name="tables">
            <option>blegh</option>
            <option>bluh</option>
        </select>
        <h3>Acciones posibles con la base de datos</h3>
        <input type="submit" value="Agregar tabla" name="agrtabla" />
        <input type="submit" value="Eliminar tabla" name="elimtabla" />
        <h3>Acciones posibles con una tabla (selecciona la tabla con la que quieres ejecutar la acción)</h3>
        <input type="submit" value="Consulta tabla" name="cons" />
        <input type="submit" value="Agrega entradas" name="agr" />
        <input type="submit" value="Elimina entradas" name="elim" />
        <input type="submit" value="Modifica entradas" name="mod" />
    </body>
</html>
