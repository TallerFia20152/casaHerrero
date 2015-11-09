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
		<div id="div-t1">
			<label class="label" style="color:#999;">Posición:</label>
			<select id="slc-order" name="order" class="field">
				<option value="1">1</option>
				<option value="1">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
			</select>
		</div>
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