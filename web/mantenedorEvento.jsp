<%-- 
    Document   : MantenedorEvento
    Created on : 22-11-2016, 21:06:47
    Author     : cetecom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel="stylesheet" href="tableCss/css/style.css">
        <title>Mantenedor Proyecto</title>
    </head>
    <body >        
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="evento" class="proyectocalendario.entitys.Evento" scope="page"/>
                <jsp:useBean id="usuarioConectado" class="proyectocalendario.dto.administradorDTO" scope="session"/>
                <p style="text-align: right">Bienvenido(a) <b><c:out value="${usuarioConectado.nombre_administrador}"></c:out></b> | <a href="./cerrarSesion">Cerrar Sesión</a></p>
                <HR width=100%>   
                <jsp:include page="./getAllEvento" flush="true"/>
                <div class="table-users">
                <div class="header">Eventos</div>
                    <form name="frmAgregaEvento" method="post" action="./agregarEvento">
                        <table cellspacing="0">
                            <tr>
                            <th>Nombre Evento</th>
                            <th>A calendario</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                            </tr>
                                <c:forEach items="${listaEvento}" var="evento">
                                    <tr>
                                        <td><c:out value="${evento.nombreEvento}"/></td>
                                        <c:url value="${evento.urlEvento}" var="linkEvento">
                                            <c:param name="codigoEvento" value="${evento.idEvento}"/>
                                        </c:url>
                                        <td><i class="material-icons button edit" onclick="window.location.href = '${linkEvento}'">Link</i></td>
                                        
                                        
                                        
                                        <c:url value="./modificarEvento" var="modificaEvento">
                                            <c:param name="codigoEvento" value="${evento.idEvento}"/>
                                        </c:url>
                                        <td><i class="material-icons button edit" onclick="window.location.href = '${modificaEvento}'">edit</i></td>
                                            <c:url value="./eliminaEvento" var="eliminaEvento">
                                                <c:param name="codigoEvento" value="${evento.idEvento}"/>
                                            </c:url>
                                        <td><i class="material-icons button delete" onclick="window.location.href = '${eliminaEvento}'">delete</i></td>
                                    </tr>
                                </c:forEach>
                            
                        </table>
                        </div>
                    </form>  
                    <center> 
                    <i class="material-icons button md-48" onclick="window.location.href = 'crearEvento.jsp'">add_circle_outline</i>
                    
                    <font color="black">Agregar Evento</font>
                </center>
                    <c:if test="${sessionScope.msgError!=null}">
                        <c:out value="${msgError}"/>
                        <c:remove var="msgError"/>
                    </c:if>                                       
                
                <c:if test="${sessionScope.objetoAeditar!=null}">
                    <fieldset><legend>Edición</legend>
                        <jsp:useBean id="objetoAeditar" class="proyectocalendario.entitys.Evento"  scope="page"/>
                        <form name="frmEditar" method="post" action="./modificarEvento">
                            descripcionOriginal: <c:out value="${sessionScope.objetoAeditar.nombreEvento}"></c:out>
                                <br/>                                
                                id asociada <input type="text" name="txtID" value="${sessionScope.objetoAeditar.codigoEvento}" readonly/>
                            <br/>
                            descripcion nueva: <input type="text" name="txtDescripcionEditada"/>
                            <br/>
                            <input type="submit" name="btnEditar" value="guardar Edición"/>  
                        </form>                                                                
                    </fieldset>
                    <c:remove var="objetoAeditar"/>
                </c:if>
            </c:otherwise>
        </c:choose>                    
    </body>
</html>
