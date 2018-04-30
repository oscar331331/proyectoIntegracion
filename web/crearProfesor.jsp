<%-- 
    Document   : crearProfesor
    Created on : 29/04/2018, 08:16:12 PM
    Author     : Vito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>        
            
            <c:otherwise>
                
                 <h1>Crear profesor</h1>
                
                <legend>Profesor</legend>
                    <form name="frmCrearProfesor" method="post" action="./registraProfesor">
                        <table>
                            <td>
                              <input placeholder="Nombre" type="text" required autofocus name="txtNombre">
                              <input placeholder="Apellido" type="text" required autofocus name="txtApellido">
                              <input placeholder="correo" type="email" required autofocus name="txtCorreo">
                              <input placeholder="Usuario" type="text" required autofocus name="txtUsuario">
                              <input placeholder="Password" type="password" required autofocus name="txtPassword">
                            </td>
                        </table>
                        <button name="btnIngresar" type="submit" id="contact-submit" data-submit="...Sending">Agregar</button>

                    </form>
                
                
            </c:otherwise>
        </c:choose>
    </body>
</html>
