<%-- 
    Document   : login
    Created on : 29/04/2018, 06:50:52 PM
    Author     : Vito
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendario DUOC</title>
    </head>
   <body>
       <h2>Calendario Duoc</h2>
        <fieldset style="width:10%"><legend>Acceso</legend>   
            <form name="frmIngresar" method="post" action="./ValidarAdministradorServlet">
                
                <input placeholder="Login" type="text" tabindex="1" required autofocus name="txtLogin">
                <br>

                <input placeholder="Password" type="password" tabindex="2" name="txtPass" required>
                <br>

                <button name="btnIngresar" type="submit"  data-submit="...Sending">Entrar</button>
                <br>
                
                
                
                    
            </form>
            <c:if test="${sessionScope.msgError!=null}">
                <c:out value="${msgError}"/>
                <c:remove var="msgError"/>
            </c:if>
        </fieldset>
    </body>
</html>