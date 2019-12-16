<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="Spring" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="Tags" %>

<article>
	<header>
		<H2 class="text-primary">Listado Cursos</H2>
	</header>
	<article>
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Creditos</th>
					<th>H. Teoricas</th>
					<th>H. Practicas</th>
					<th>Escolaridad</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="curso" items="${modeloCursos}">
					<tr>
						<td>${curso.nombre}</td>
						<td>${curso.descripcion}</td>
						<td>${curso.creditos}</td>
						<td>${curso.ht}</td>
						<td>${curso.hp}</td>
						<td>${curso.escolaridad}</td>
						<td><a href="#">Editar</a></td>
						<td><a href="#">Eliminar</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>

	</article>
	<footer>
		<div class="container">
		<button type="button" id="btn_agregar" class="btn btn-primary" onclick="show_CursoFormNuevo()">Agregar Curso</button>
		<button type="button" id="btn_cerrar" class="btn btn-secondary" onclick="doCerrarCasoUso3()">Cerrar</button>
		</div>
	</footer>
</article>

<script>
	function show_CursoFormNuevo(){
		$.get("${pageContext.request.contextPath}/curso/nuevo",
	    	function(Resultado){
	    		$('#divCasoForm').html(Resultado);
	    	}
    	)
	}
</script>