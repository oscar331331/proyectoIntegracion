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
                
                 <h1>Crear evento</h1>
                
                <legend>Evento</legend>
                    <form name="frmCrearProfesor" method="post" action="./registraEvento">
                        <table>
                            <td>
                              <input placeholder="Titulo evento" type="text" required autofocus name="txtTitulo">
                              <input placeholder="Descripción" type="text" required autofocus name="txtDescripcion">
                              <input placeholder="Sala" type="text" required autofocus name="txtSala">
                              <input placeholder="fecha" type="date" required autofocus name="fecha">
                              <%-- start web service invocation --%><hr/>
                                <%
                                
                                %>
                                <%-- end web service invocation --%><hr/>
                            </td>
                        </table>
                        <button name="btnIngresar" type="submit" id="contact-submit" data-submit="...Sending">Agregar</button>

                    </form>
                
                
            </c:otherwise>
        </c:choose>
    
    </body>
</html>
