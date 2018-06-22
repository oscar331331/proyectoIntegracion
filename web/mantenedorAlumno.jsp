<%-- 
    Document   : MantenedorAlumno
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
                <jsp:useBean id="alumno" class="proyectocalendario.entitys.Alumno" scope="page"/>
                <jsp:useBean id="usuarioConectado" class="proyectocalendario.dto.administradorDTO" scope="session"/>
                <p style="text-align: right">Bienvenido(a) <b><c:out value="${usuarioConectado.nombre_administrador}"></c:out></b> | <a href="./cerrarSesion">Cerrar Sesión</a></p>
                <HR width=100%>   
                <jsp:include page="./getAllAlumno" flush="true"/>
                <div class="table-users">
                <div class="header">Alumnos</div>
                    <form name="frmAgregaAlumno" method="post" action="./agregarAlumno">
                        <table cellspacing="0">
                            <tr>
                            <th>Nombre alumno</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                            </tr>
                                <c:forEach items="${listaAlumno}" var="alumno">
                                    <tr>
                                        <td><c:out value="${alumno.nombreAlumno}"/></td>
                                        <c:url value="./modificarAlumno" var="modificaAlumno">
                                            <c:param name="codigoAlumno" value="${alumno.idAlumno}"/>
                                        </c:url>
                                        <td><i class="material-icons button edit" onclick="window.location.href = '${modificaAlumno}'">edit</i></td>
                                            <c:url value="./eliminaAlumno" var="eliminaAlumno">
                                                <c:param name="codigoAlumno" value="${alumno.idAlumno}"/>
                                            </c:url>
                                        <td><i class="material-icons button delete" onclick="window.location.href = '${eliminaAlumno}'">delete</i></td>
                                    </tr>
                                </c:forEach>
                            
                        </table>
                        </div>
                    </form>  
                    <center> 
                    <i class="material-icons button md-48" onclick="window.location.href = 'crearAlumno.jsp'">add_circle_outline</i>
                    
                    <font color="black">Agregar Alumno</font><br><br>
                    <form method="get" action="index.jsp">
                    <button type="submit">Volver</button>
                </form>
                </center>
                    <c:if test="${sessionScope.msgError!=null}">
                        <c:out value="${msgError}"/>
                        <c:remove var="msgError"/>
                    </c:if>                                       
                
                <c:if test="${sessionScope.objetoAeditar!=null}">
                    <fieldset><legend>Edición</legend>
                        <jsp:useBean id="objetoAeditar" class="proyectocalendario.entitys.Alumno"  scope="page"/>
                        <form name="frmEditar" method="post" action="./modificarAlumno">
                            descripcionOriginal: <c:out value="${sessionScope.objetoAeditar.nombreAlumno}"></c:out>
                                <br/>                                
                                id asociada <input type="text" name="txtID" value="${sessionScope.objetoAeditar.codigoAlumno}" readonly/>
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
