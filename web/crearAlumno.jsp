<%-- 
    Document   : crearAlumno
    Created on : 29/04/2018, 08:16:12 PM
    Author     : Vito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="loginCss/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCss/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCss/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCss/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="loginCss/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCss/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCss/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="loginCss/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCss/css/util.css">
	<link rel="stylesheet" type="text/css" href="loginCss/css/main.css">
<!--===============================================================================================-->
        <title>Calendario DUOC</title>
    </head>
    </head>
    <body>
        
          
       
       
       <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form name="frmIngresar" method="post" action="./registraAlumno" class="login100-form validate-form p-l-55 p-r-55 p-t-178">
					<span class="login100-form-title">
						Agregar Alumno
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Ingresa nombre">
						<input class="input100" type="text" name="txtNombre" placeholder="Nombre">
						<span class="focus-input100"></span>
					</div>
                                    <div class="wrap-input100 validate-input m-b-16" data-validate="Ingresa nombre">
						<input class="input100" type="text" name="txtApellido" placeholder="Apellido">
						<span class="focus-input100"></span>
					</div>
                                    <div class="wrap-input100 validate-input m-b-16" data-validate="Ingresa nombre">
						<input class="input100" type="email" name="txtCorreo" placeholder="Correo">
						<span class="focus-input100"></span>
					</div>
                                    <div class="wrap-input100 validate-input m-b-16" data-validate="Ingresa nombre">
						<input class="input100" type="text" name="txtUsuario" placeholder="Usuario">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input class="input100" type="password" name="txtPassword" placeholder="Contraseña">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">
						<c:if test="${sessionScope.msgError!=null}">
                                                    <c:out value="${msgError}"/>
                                                    <c:remove var="msgError"/>
                                                </c:if>
					</div>

					<div class="container-login100-form-btn">
						<button name="btnIngresar" type="submit" id="contact-submit" data-submit="...Sending">
							Ingresar
						</button>
					</div>

					<div class="flex-col-c p-t-170 p-b-40">
						
					</div>
                                </form><br><br>
                                                    <form method="get" action="index.jsp">
                    <button type="submit">Volver</button>
                </form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="loginCss/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCss/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCss/vendor/bootstrap/js/popper.js"></script>
	<script src="loginCss/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCss/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCss/vendor/daterangepicker/moment.min.js"></script>
	<script src="loginCss/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="loginCss/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="loginCss/js/main.js"></script>
        
        
        
        
        
        
        
        
    </body>
</html>
