<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Agregar Nuevo de Curso</span>
<div>
<% System.out.println("formAddCourse"); %>
	<p>Este cambio le permite crear un nuevo curso. Para esto solo ingrese los datos requeridos del curso.</p>
	<form id="frm-change" action="">
		<label class="label">Nombre:</label>
		<input id="name" name="name" type="text" class="field"><br/>
		<label class="label">Tipo:</label>
		<select id="slc-type" name="type" class="field">
			<option value="1">Obligatorio</option>
			<option value="2">Electivo de Mencion</option>
			<option value="3">Electivo Libre</option>
		</select>
		<br/>
		<div id="div-t1">
			<label class="label">Ciclo:</label>
			<select id="slc-cycle" name="cycle" class="field">
				<option value="1">1</option>
				<option value="1">2</option>
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
		<div id="div-t2" style="display: none">
			<label class="label">Mencion:</label>
			<input type="checkbox" name="mention" value="3">Ingenieria de Software<br/>
			<label class="label">&nbsp;</label>
			<input type="checkbox" name="mention" value="1">Sistemas de Informacion<br/>
			<label class="label">&nbsp;</label>
			<input type="checkbox" name="mention" value="2">Tecnologias de Informacion
		</div>
		<label>Horas:</label>
		<br/><br/>
		<label class="label">H. Teoria:</label>
		<select id="course" name="teo" class="field">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>	
		</select>
		<br/>
		<label class="label">H. Practica:</label>
		<select id="course" name="prac" class="field">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select>
		<label class="label">H. Laboratorio:</label>
		<select id="course" name="lab" class="field">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select>
	</form>
	<br/>
	<div id="error-change" class="ui-state-error ui-corner-all" style="width: 100%">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
			<span id="msg-change"></span>
		</p>
	</div>
</div>
<script type="text/javascript">
	$('#error-change').hide();
	$('#slc-type').change(function() {
		console.log('V: ' + this.value);
		if (this.value == 1) {
			$('#div-t1').show();
			$('#div-t2').hide();
		} else if (this.value == 2) {
			$('#div-t2').show();
			$('#div-t1').hide();
		} else {
			$('#div-t1').hide();
			$('#div-t2').hide();
		}
	});
</script>