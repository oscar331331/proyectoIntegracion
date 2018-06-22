<%-- 
    Document   : AgregarAlumno
    Created on : 20-nov-2016, 20:48:01
    Author     : Vitorestor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styleLogin.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Alumno</h1>
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                
                
        <c:if test="${sessionScope.objetoAeditar==null}">
        <jsp:useBean id="usuarioConectado" class="proyectocalendario.dto.administradorDTO" scope="session"/>
        <jsp:useBean id="alumno" class="proyectocalendario.entitys.Alumno" scope="page"/>
        <fieldset><legend>ingreso de datos Alumno nuevo</legend>
            <div class="container" >  
            <form id="contact" name="frmIngresoAlumno" method="post" action="./registraAlumno">
                <input placeholder="Nombre" type="text" required autofocus name="txtNombre">
                              <input placeholder="Apellido" type="text" required autofocus name="txtApellido">
                              <input placeholder="correo" type="email" required autofocus name="txtCorreo">
                              <input placeholder="Usuario" type="text" required autofocus name="txtUsuario">
                              <input placeholder="Password" type="password" required autofocus name="txtPassword">
                <fieldset>
                <button name="btnIngresar" type="submit" id="contact-submit" data-submit="...Sending">Agregar</button>
                </fieldset>
            </form>
        </fieldset>
        </c:if>
        
        <c:if test="${sessionScope.objetoAeditar!=null}">
                    <fieldset><legend>Editar Alumno</legend>
                        <jsp:useBean id="objetoAeditar" class="proyectocalendario.entitys.Alumno"  scope="page"/>
                        <form name="frmEditar" method="post" action="./modificarAlumno">
                            <fieldset>
                                
                                ID: <input type="text" name="txtId" value="${sessionScope.objetoAeditar.idAlumno}" readonly/>
                                
                                <br>Nombre: <input type="text" name="txtNombre" value="${sessionScope.objetoAeditar.nombreAlumno}" required/>
                                <br/>
                                Apellido: <input type="text" name="txtApellido" value="${sessionScope.objetoAeditar.apellidoAlumno}" required/>
                                <br/>
                                Correo <input type="text" name="txtCorreo" value="${sessionScope.objetoAeditar.correoAlumno}" required/>
                                <br/>
                                Usuario <input type="text" name="txtUsuario" value="${sessionScope.objetoAeditar.usuarioAlumno}" required/>
                                <br/>
                                Password <input type="password" name="txtPassword" value="${sessionScope.objetoAeditar.passwordAlumno}" required/>
                                <br/>
                
                               
                
                <fieldset>
                <button name="btnIngresar" type="submit" id="contact-submit" data-submit="...Sending">Guardar Cambios</button>
                </fieldset>
                      </form>          
                                </fieldset>                              
                                
                                <c:remove var="objetoAeditar"/>
                                
                            </fieldset>
                                </c:if>
            </c:otherwise>
        </c:choose>       
    </body>
</html>
