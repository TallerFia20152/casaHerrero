<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Dar curso de baja</span>
<div>
	<p>Este cambio le permite desabilitar un curso. Para esto solo seleccione el curso que desea desabillitar.</p>
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
		</select> --%>
		<% System.out.println("formCancelCourse"); %>
		<c:forEach items="${sessionCourses}" var="course">
		<div class="grp-courses ${course.code}">
		
			Requisitos:<br/>
			<c:forEach items="${course.requirements}" var="requirement" varStatus="i" >
				&nbsp;<label>Requisito ${i.index + 1}: <b>${requirement}</b><br/>
			</c:forEach>
			<br/>
			<c:choose>
				<c:when test="${course.type eq 1}">
					Ciclo:&nbsp;<b>${course.cycle}</b><br/>
					Tipo:&nbsp;<b>Obligatorio</b>
				</c:when>
				<c:when test="${course.type eq 2}">
					Mencion:&nbsp;<b>
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
					Tipo:&nbsp;<b>Electivo Libre</b>
				</c:otherwise>
			</c:choose>
			<br/>
			<br/>
			Horas Teoria:&nbsp;<b>${course.theoHours}</b>&nbsp;&nbsp;&nbsp;<br/>
			Horas Practica:&nbsp;<b>${course.pracHours}</b>&nbsp;&nbsp;&nbsp;<br/>
			Horas Laboratorio:&nbsp;<b>${course.laboHours }</b>
			
		</div>
		</c:forEach>
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
</script>