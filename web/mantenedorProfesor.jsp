<%-- 
    Document   : MantenedorProfesor
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
                <jsp:useBean id="profesor" class="proyectocalendario.entitys.Profesor" scope="page"/>
                <jsp:useBean id="usuarioConectado" class="proyectocalendario.dto.administradorDTO" scope="session"/>
                <p style="text-align: right">Bienvenido(a) <b><c:out value="${usuarioConectado.nombre_administrador}"></c:out></b> | <a href="./cerrarSesion">Cerrar Sesión</a></p>
                <HR width=100%>   
                <jsp:include page="./getAllProfesor" flush="true"/>
                <div class="table-users">
                <div class="header">Profesores</div>
                    <form name="frmAgregaProfesor" method="post" action="./agregarProfesor">
                        <table cellspacing="0">
                            <tr>
                            <th>Nombre profesor</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                            </tr>
                                <c:forEach items="${listaProfesor}" var="profesor">
                                    <tr>
                                        <td><c:out value="${profesor.nombreProfesor}"/></td>
                                        <c:url value="./modificarProfesor" var="modificaProfesor">
                                            <c:param name="codigoProfesor" value="${profesor.idProfesor}"/>
                                        </c:url>
                                        <td><i class="material-icons button edit" onclick="window.location.href = '${modificaProfesor}'">edit</i></td>
                                            <c:url value="./eliminaProfesor" var="eliminaProfesor">
                                                <c:param name="codigoProfesor" value="${profesor.idProfesor}"/>
                                            </c:url>
                                        <td><i class="material-icons button delete" onclick="window.location.href = '${eliminaProfesor}'">delete</i></td>
                                    </tr>
                                </c:forEach>
                            
                        </table>
                        </div>
                    </form>  
                    <center> 
                    <i class="material-icons button md-48" onclick="window.location.href = 'crearProfesor.jsp'">add_circle_outline</i>
                    
                    <font color="black">Agregar Profesor</font>
                </center>
                    <c:if test="${sessionScope.msgError!=null}">
                        <c:out value="${msgError}"/>
                        <c:remove var="msgError"/>
                    </c:if>                                       
                
                <c:if test="${sessionScope.objetoAeditar!=null}">
                    <fieldset><legend>Edición</legend>
                        <jsp:useBean id="objetoAeditar" class="proyectocalendario.entitys.Profesor"  scope="page"/>
                        <form name="frmEditar" method="post" action="./modificarProfesor">
                            descripcionOriginal: <c:out value="${sessionScope.objetoAeditar.nombreProfesor}"></c:out>
                                <br/>                                
                                id asociada <input type="text" name="txtID" value="${sessionScope.objetoAeditar.codigoProfesor}" readonly/>
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
