<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Cambiar Tipo de Curso</span>
<div>
<% System.out.println("formMoveCourse"); %>
	<p>Este cambio le permite mover un curso entre ciclos. Para esto solo seleccione el curso que desea cambiar y seleccione a donde lo desea mover.</p>
	<form id="frm-change" action="">
		<label class="label">Curso:</label>
		<span id="course-name"></span>
		<input id="course" name="course" type="hidden">
		<hr/>
		<%-- <select id="course" name="course" class="field">
			<option value="0">Seleccione uno</option>
			<c:forEach items="${sessionCourses}" var="course">
				<option value="${course.code}">${course.name}</option>
			</c:forEach>
		</select><br/> --%>
		
		<div id="div-cycle" style="display:none">
			<div>
				<c:forEach items="${sessionCourses}" var="course">
				<div class="grp-courses ${course.code}">
					<c:choose>
						<c:when test="${course.type eq 1}">
							&nbsp;Tipo:&nbsp;<b>Obligatorio - Ciclo ${course.cycle}</b>
						</c:when>
						<c:when test="${course.type eq 2}">
							&nbsp;Mencion:&nbsp;<b>
							<c:forEach items="${course.mentions}" var="mention">
								<c:choose>
									<c:when test="${mention eq 1}">Sistemas de Informacion&nbsp;</c:when>
									<c:when test="${mention eq 2}">Tecnologia de la Informacion&nbsp;</c:when>
									<c:when test="${mention eq 3}">Ingenieria de Software&nbsp;</c:when>
								</c:choose>
							</c:forEach>
							</b> 
						</c:when>
						<c:otherwise>
							&nbsp;Tipo:&nbsp;<b>Electivo Libre</b>
						</c:otherwise>
					</c:choose>
				</div>
				</c:forEach>
			</div>
			<br/>
			Nuevo Tipo:
			<fieldset>
				<legend><input type="radio" class="grp-rdo" name="type" value="1">Obligatorio</legend>
				<div class="grp-types type1" style="display: none;">
					<label class="label">Ciclo:</label>
					<select id="cycle" name="cycle" class="field">
						<option value="0">Seleccione un ciclo</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
			</fieldset>
			<fieldset>
				<legend><input type="radio" class="grp-rdo" name="type" value="2">Mencion<br/></legend>
				<div class="grp-types type2" style="display: none;">
					<input type="checkbox" name="mention" value="1">Sistemas de Informacion<br/>
					<input type="checkbox" name="mention" value="2">Tecnologias de Informacion<br/>
					<input type="checkbox" name="mention" value="3">Ingenieria de Software<br/>
				</div>
			</fieldset>
			<fieldset>
				<legend><input type="radio" class="grp-rdo" name="type" value="3">Libre<br/></legend>
				<div class="grp-types type3" style="display: none;">Curso Electivo libre</div>
			</fieldset>
		</div>
	</form>
	<br/>
	<div id="error-change" class="ui-state-error ui-corner-all" style="width: 100%; display: none;">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
			<span id="msg-change"></span>
		</p>
	</div>
</div>
<script type="text/javascript">
	$('#error-change').hide();
	/* $('#course').change(function(){
		$('#error-change').hide();
		if (this.value != 0) {
			$('#div-cycle').show();
			
			$('.grp-courses').hide();
			$('.'+this.value).show();
		} else {
			$('#div-cycle').hide();
		}
	}); */
	
	$('.grp-rdo').click(function() {
		$('.grp-types').hide();
		$('.type' +this.value).show();
	});
</script>