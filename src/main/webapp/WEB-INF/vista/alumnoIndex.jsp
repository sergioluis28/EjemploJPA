<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="Spring" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="Tags" %>

<article>
	<header>
		<H2 class="text-primary">Listado Alumnos</H2>
	</header>
	<article>
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Celular</th>
					<th>Direccion</th>
					<th>F. Nacimiento</th>
					<th>eMail</th>
					<th>Promedio</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="alumno" items="${modeloAlumnos}">
					<tr>
						<td>${alumno.nombre}</td>
						<td>${alumno.apellido}</td>
						<td>${alumno.celular}</td>
						<td>${alumno.direccion}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${alumno.fNacimiento}" /></td>
						<td>${alumno.eMail}</td>
						<td>${alumno.promedio}</td>
						<td><a href="#">Editar</a></td>
						<td><a href="#">Eliminar</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>

	</article>
	<footer>
		<div class="container">
		<button type="button" id="btn_agregar" class="btn btn-primary" onclick="show_AlumnoFormNuevo()">Agregar Alumno</button>
		<button type="button" id="btn_cerrar" class="btn btn-secondary" onclick="doCerrarCasoUso()">Cerrar</button>
		</div>
	</footer>
</article>

<script>
	function show_AlumnoFormNuevo(){
		$.get("${pageContext.request.contextPath}/alumno/nuevo",
	    	function(Resultado){
	    		$('#divCasoForm').html(Resultado);
	    	}
    	)
	}

</script>
