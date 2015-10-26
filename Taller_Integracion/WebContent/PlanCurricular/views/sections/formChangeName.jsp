<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Cambiar Nombre de Curso</span>
<div>
<% System.out.println("formChangeName"); %>
	<p>Este cambio le permite cambiar el nombre de un curso. Para esto solo seleccione el curso que desea cambiar de nombre y modifique el nombre del curso.</p>
	<form id="frm-change" action="">
		<label class="label">Curso:</label>
		<span id="course-name"></span>
		<input id="course" name="course" type="hidden">
		<hr/>
		<label class="label">Nuevo Nombre:</label>
		<br/><br/><input id="newname" name="newname" type="text" class="field">
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