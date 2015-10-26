<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Cambiar Horas de Curso</span>
<div>
<% System.out.println("formChangeHours"); %>
	<p>Este cambio le permite cambiar las horas de un curso. Para esto solo seleccione el curso al que desea cambiar las horas y seleccione la nueva distribucion de horas.</p>
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
		</select>
		<br/><br/> --%>
		<div id="div-hours" style="display:none">
			<div id="div-chours">
				<c:forEach items="${sessionCourses}" var="course">
					<span id="span-${course.code}" class="grp-courses">
						H. Teoria:&nbsp;<b>${course.theoHours}</b>&nbsp;&nbsp;&nbsp; 
						H. Practica:&nbsp;<b>${course.pracHours}</b>&nbsp;&nbsp;&nbsp;
						H. Laboratorio:&nbsp;<b>${course.laboHours }</b>
					</span>
				</c:forEach>
			</div>
			
			<br/><br/>
			<label>Nueva Distribucion de horas:</label>
			<br/><br/>
			<label class="label">H. Teoria:</label>
			<select id="thours" name="thours" class="field">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>	
			</select>
			<br/>
			<label class="label">H. Practica:</label>
			<select id="phours" name="phours" class="field">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
			<label class="label">H. Laboratorio:</label>
			<select id="lhours" name="lhours" class="field">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
		</div>
	</form>
	<br/>
	<div id="error-change" class="ui-state-error ui-corner-all" style="width: 100%; display:none;">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
			<span id="msg-change"></span>
		</p>
	</div>
</div>
<script type="text/javascript">
	$('#error-change').hide();
	/* $('#course').change(function() {
		$('#error-change').hide();
		if (this.value != 0) {
			$('#div-hours').show();
			
			$('.grp-courses').hide();
			$('#span-'+this.value).show();
		} else {
			$('#div-hours').hide();
		}
	}); */
</script>