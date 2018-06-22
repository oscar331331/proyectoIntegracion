<%-- 
    Document   : index.jsp
    Created on : 29/04/2018, 07:25:01 PM
    Author     : Vito
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='buttonCss/text/css'>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
            <link rel="stylesheet" href="buttonCss/css/style.css">
        <title>Calendario Google Duoc</title>
    </head>
    <body>
        
    <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="proyectocalendario.dto.administradorDTO" scope="session"/>
                <p style="text-align: right">Bienvenido(a) <b><c:out value="${usuarioConectado.nombre_administrador}"></c:out></b> | <a href="./cerrarSesion">Cerrar Sesión</a></p>
                <HR width=100%>
                <!--*<h1>Calendario Duoc :: Menú</h1>
                <h3><a  href="crearProfesor.jsp">Agregar profesor</a></h3>
                <h3><a  href="CrearEvento.jsp">Agregar alumno</a></h3>
                <h3><a  href="CrearEvento.jsp">Agregar evento</a></h3>
                
                <h3><a  href="mantenedorProfesor.jsp">Ver profesores</a></h3>
                <h3><a  href="eventos.jsp">Ver alumnos</a></h3>
                <h3><a  href="eventos.jsp">Ver eventos</a></h3>-->
             
                
                <div align="center">
                <section>
                <a href="mantenedorProfesor.jsp" class="btn">
                        <span class="btn-content">Profesores</span>
                        <span class="icon"><i class="fa fa-group" aria-hidden="true"></i></span>
                </a>
                <a href="mantenedorAlumno.jsp" class="btn">
                        <span class="btn-content">Alumnos</span>
                        <span class="icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></span>
                </a>
                    
                <a href="mantenedorEvento.jsp" class="btn">
                        <span class="btn-content">Eventos</span>
                        <span class="icon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                </a>
                </section>
                <script src='https://use.fontawesome.com/ff9a5d262d.js'></script>
                </div>
  

                <!--<script  src="buttonCss/js/index.js"></script>-->
                
            </c:otherwise>
    </c:choose>
    </body>
</html>

