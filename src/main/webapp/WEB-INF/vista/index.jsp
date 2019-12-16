<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		
		<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
		body {
			padding-top: 3.5rem;
		}
		#divCasoForm{
			position: relative;
			top: 20px;
		}
		</style>
		<title>Ejemplo Spring DATA JPA</title>
	</head>

<body>
	<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="${pageContext.request.contextPath}">Ejemplo JPA</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="dropdownArchivo"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Archivo</a>
					<div class="dropdown-menu" aria-labelledby="dropdownArchivo">
						<a class="dropdown-item" href="javascript:show_AlumnoIndex()">Alumno</a>
						<a class="dropdown-item" href="javascript:show_DocenteIndex()">Docente</a>
						<a class="dropdown-item" href="javascript:show_CursoIndex()">Curso</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Pabellon</a>
						<a class="dropdown-item" href="#">Ambiente</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Salir</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="dropdownProceso"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Procesos</a>
					<div class="dropdown-menu" aria-labelledby="dropdownArchivo">
						<a class="dropdown-item" href="#">Aperturar semestre</a>
						<a class="dropdown-item" href="#">Establecer horario</a>
						<a class="dropdown-item" href="#">Inscribir alumno</a>
					</div>
				</li>
			</ul>
		</div>
		<div class="container">
			<sec:authorize access="isAuthenticated()">
				<form action="${pageContext.request.contextPath}/logout" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				<script>
					function formLogoutSubmit(){
						document.getElementById("logoutForm").submit();
					}
				</script>
				<core:if test="${pageContext.request.userPrincipal.name != null }">
					<h4>
						Bienvenido: ${pageContext.request.userPrincipal.name} |
						<small><a href="javascript:formLogoutSubmit()">Cerrar Sesi�n</a></small>
					</h4>
				</core:if>
			</sec:authorize>
		</div>
	</nav>
	</header>
	
	<main role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron" id="divPrincipal">
			<div class="container">
				<h1 class="display-3">Spring DATA JPA!</h1>
				<p>Este programa de ejemplo muestra el acceso a datos usando el Framework Spring. 
				It includes a large callout called a jumbotron and three supporting pieces of content. 
				Use it as a starting point to create something more unique.</p>
				<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
			</div>
		</div>
	
		<div class="container" id="divCasoForm" style="display: none;">
		</div>
	
		<div class="container" id="divCasoRes" style="display: none;">
		</div>

	</main>

	<footer class="container" id="pie">
		<p>&copy; Sistemas 2019</p>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<script>
		function show_AlumnoIndex(){
	        doIniciarCasoUso();
	        // $.get(URL, parametros, funcion(datos, estado, xhr), tipoDato)
	        $.get("${pageContext.request.contextPath}/alumno/index",
	        		function(Resultado){
	        			$('#divCasoForm').html(Resultado);
	        		}
	        );
		};
		function show_DocenteIndex(){
	        doIniciarCasoUso2();
	        // $.get(URL, parametros, funcion(datos, estado, xhr), tipoDato)
	        $.get("${pageContext.request.contextPath}/docente/index",
	        		function(Resultado){
	        			$('#divCasoForm').html(Resultado);
	        		}
	        );
		};

		function show_CursoIndex(){
	        doIniciarCasoUso3();
	        // $.get(URL, parametros, funcion(datos, estado, xhr), tipoDato)
	        $.get("${pageContext.request.contextPath}/curso/index",
	        		function(Resultado){
	        			$('#divCasoForm').html(Resultado);
	        		}
	        );
		};
		
		function doIniciarCasoUso(){
			$('#divPrincipal').hide();
			$('#divCasoForm').show();
			$('#divCasoRes').show();
		}
		function doCerrarCasoUso(){
			$('#divPrincipal').show();
			$('#divCasoForm').hide();
			$('#divCasoRes').hide();
		};

		function doIniciarCasoUso2(){
			$('#divPrincipal').hide();
			$('#divCasoForm').show();
			$('#divCasoRes').show();
		}
		function doCerrarCasoUso2(){
			$('#divPrincipal').show();
			$('#divCasoForm').hide();
			$('#divCasoRes').hide();
		};

		function doIniciarCasoUso3(){
			$('#divPrincipal').hide();
			$('#divCasoForm').show();
			$('#divCasoRes').show();
		}
		function doCerrarCasoUso3(){
			$('#divPrincipal').show();
			$('#divCasoForm').hide();
			$('#divCasoRes').hide();
		};
		
	</script>
	
</body>
</html>