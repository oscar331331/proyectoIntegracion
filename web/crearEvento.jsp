<%-- 
    Document   : crearEvento
    Created on : 29/04/2018, 08:54:20 PM
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
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                
                 <h1>Crear evento</h1>
                
                <legend>Evento</legend>
                    <form name="frmCrearEvento" method="post" action="./crearEvento">
                        <table>
                            <td>
                              <input placeholder="Nombre" type="text" required autofocus name="txtNombre">
                              <input placeholder="Apellido" type="text" required autofocus name="txtApellido">
                              <input placeholder="correo" type="email" required autofocus name="txtCorreo">
                              <input placeholder="Usuario" type="text" required autofocus name="txtUsuario">
                              <input placeholder="Password" type="password" required autofocus name="txtPassword">
                            </td>
                        </table>
                    </form>
                
                
            </c:otherwise>
        </c:choose>
    </body>
</html>
