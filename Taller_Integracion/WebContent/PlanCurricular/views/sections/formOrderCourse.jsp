<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Ordenar Curso en Malla</span>
<div>
<% System.out.println("formOrderCourse"); %>
	<p>Este cambio le permite cambiar la posición de un curso en la Malla Curricular. Para esto solo ingrese el nuevo orden del curso.</p>
	<form id="frm-change" action="">
		<label class="label" style="color:#999;">Curso:</label>
		<span id="course-name"></span>
		<input id="course" name="course" type="hidden">
		<hr/>
		<label class="label" style="color:#999;">Nueva Posición:</label>
		<br/><br/><input id="neworder" name="neworder" type="text" class="field">
	</form>
	<br/>
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
</script>