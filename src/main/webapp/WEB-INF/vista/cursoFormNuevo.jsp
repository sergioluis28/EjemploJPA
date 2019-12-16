<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="Spring" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="Tags" %>

<article>
	<header>
		<H2 class="text-primary">Registrar Curso</H2>
	</header>
	<article>
	<Spring:form modelAttribute = "curso" id="frmCursoNuevo" method="post">
		<div class="form-group">
			<Spring:hidden path="id" class="form-control" id="InputID" placeholder="(reservado)"/>
			<Spring:errors path="id" cssClass="alert-info"></Spring:errors>
		</div>
		<div class="form-group">
			<Spring:label path="nombre" for="InputNombres">Nombre</Spring:label>
			<Spring:input path="nombre" id="InputNombres" class="form-control" 
				cssErrorClass="form-control alert-danger"	placeholder="Ingrese Nombres" 
				data-toggle="tooltip" data-placement="bottom" title="Ingrese nombres completos"/>
			<Spring:errors path="nombre" class="text-danger"></Spring:errors>
		</div>
		<div class="form-group">
			<Spring:label path="descripcion" for="InputDescripcion">Descripcion</Spring:label>
			<Spring:input path="descripcion" id="InputDescripcion" class="form-control" 
				cssErrorClass="form-control alert-danger" placeholder="Ingrese Descripcion"
				data-toggle="tooltip" data-placement="bottom" title="Ingrese descripcion"/>
			<Spring:errors path="descripcion" cssClass="text-danger"></Spring:errors>
		</div>
		<div class="form-group">
			<Spring:label path="creditos" for="InputCreditos">Creditos</Spring:label>
			<Spring:input path="creditos" id="InputCreditos" class="form-control" 
				cssErrorClass="form-control alert-danger" placeholder="Ingrese Creditos"
				data-toggle="tooltip" data-placement="bottom" title="Ingrese Creditos"/>
			<Spring:errors path="creditos" cssClass="text-danger"></Spring:errors>
		</div>
		<div class="form-group">
			<Spring:label path="ht" for="InputHt">Horas Teoricas</Spring:label>
			<Spring:input path="ht" id="InputHt" class="form-control" 
				cssErrorClass="form-control alert-danger" placeholder="Ingrese Horas Teoricas"
				data-toggle="tooltip" data-placement="bottom" title="Ingrese Horas Teoricas"/>
			<Spring:errors path="ht" cssClass="text-danger"></Spring:errors>
		</div>
		
		<div class="form-group">
			<Spring:label path="hp" for="InputHp">Horas Practica</Spring:label>
			<Spring:input path="hp" id="InputHp" class="form-control" 
				cssErrorClass="form-control alert-danger" placeholder="Ingrese Horas Practicas"
				data-toggle="tooltip" data-placement="bottom" title="Ingrese Horas Practicas"/>
			<Spring:errors path="hp" cssClass="text-danger"></Spring:errors>
		</div>
		
		<div class="form-group">
			<Spring:label path="escolaridad" for="InputEscolaridad">Escolaridad</Spring:label>
			<Spring:input path="escolaridad" id="InputEscolaridad" class="form-control" 
				cssErrorClass="form-control alert-danger" placeholder="Ingrese Escolaridad"
				data-toggle="tooltip" data-placement="bottom" title="Ingrese Escolaridad"/>
			<Spring:errors path="escolaridad" cssClass="text-danger"></Spring:errors>
		</div>

		<div class="form-group">
			<Spring:button type="submit" id="btn_enviar" class="btn btn-primary">Guardar</Spring:button>
			<Spring:button type="button" id="btn_regresar" class="btn btn-secondary"
				 onclick="show_CursoIndex()">Regresar</Spring:button>
		</div>
	</Spring:form>
	</article>
</article>
<script>
	$("#frmCursoNuevo").submit(function() {
		$.post(
			"${pageContext.request.contextPath}/curso/nuevo",
			$("#frmCursoNuevo").serialize(),
			function(Data){
				$('#divCasoForm').html(Data);
			}
		);
		return false;
	});
	$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>>