<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span id="dlg-title" hidden="true">Cambiar Requisitos de Curso</span>
<div>
<% System.out.println("formChangeRequirements"); %>
	<p>Este cambio le permite cambiar los requisitos de un curso.</p>
	<form id="frm-change" action="">
		<label class="label">Curso:</label>
		<span id="course-name"></span>
		<input id="course" name="course" type="hidden">
		<hr/>
		<%-- <label class="label">Curso:</label>
		<select id="courses" name="course" class="field">
			<option value="0">Seleccione un curso</option>
			<c:forEach items="${sessionCourses}" var="course">
				<option value="${course.code}">${course.name}</option>
			</c:forEach>
		</select>
		<br/><br/> --%>
		<div id="div-req">
			<label>Requesitos Actuales:</label>
			<br/><br/>
			<c:forEach items="${sessionCourses}" var="course">
				<div id="div-${course.code}" class="grp-req">
				<c:forEach items="${course.requirements}" var="requirement" varStatus="i" >
					<label>Requisito ${i.index + 1}: <b>${requirement}</b><br/>
				</c:forEach>
				</div>	
			</c:forEach>
			<br/><br/>
			<label>Nuevos Requesitos:</label>
			<br/><br/>
			<div id="div-nreq">
				<label class="label">Requisitos 1:&nbsp;</label>
				<select id="slc-nreq1" name="newreq1" class="field">
					<option value="0">Ninguno</option>
					<c:forEach items="${sessionCourses}" var="course">
						<option id="opt1-${course.code}" value="${course.code}" class="grp-nreq">${course.name}</option>
					</c:forEach>
					<option value="z">Creditos</option>
				</select><br/>
				<div id="z1" style="display:none">
					<label class="label">Creditos 1:&nbsp;</label>
					<input id="credits1" class="field" name="newcred1"><br/>
				</div>
				<label class="label">Requisitos 2:&nbsp;</label>
				<select id="slc-nreq2" name="newreq2" class="field">
					<option value="0">Ninguno</option>
					<c:forEach items="${sessionCourses}" var="course">
						<option id="opt2-${course.code}" value="${course.code}" class="grp-nreq">${course.name}</option>
					</c:forEach>
					<option value="z">Creditos</option>
				</select><br/>
				<div id="z2" style="display:none">
					<label class="label">Creditos 2:&nbsp;</label>
					<input id="credits2" class="field" name="newcred2"><br/>
				</div>
			</div>
		</div>
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
	//$('#div-req').hide();
	/*var code = $('#course').val();
	 $('#div-req').show();
	$('.grp-req').hide();
	$('#div-'+ $('#course').val()).show();
	$('.grp-nreq').show();
	$('#opt1-'+ $('#course').val()).hide();
	$('#opt2-'+ $('#course').val()).hide(); */
	
	/* $('#courses').change(function() {
		if (this.value != 0) {
			$('#div-req').show();
			
			$('.grp-req').hide();
			$('#div-'+this.value).show();
			
			$('.grp-nreq').show();
			$('#opt1-'+this.value).hide();
			$('#opt2-'+this.value).hide();
		} else {
			$('#div-req').hide();
		}
	}); */
	$('#slc-nreq1').change(function(){
		if (this.value === 'z') {
			$('#credits1').val('');
			$('#z1').show();
		} else {
			$('#z1').hide();
		}
	});
	$('#slc-nreq2').change(function(){
		if (this.value === 'z') {
			$('#credits2').val('');
			$('#z2').show();
		} else {
			$('#z2').hide();
		}
	});
</script>