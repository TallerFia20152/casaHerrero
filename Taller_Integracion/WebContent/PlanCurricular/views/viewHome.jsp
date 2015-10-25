<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:p="http://primefaces.org/ui"
	xmlns:f="http://java.sun.com/jsf/core">

<f:view encoding="UTF-8" contentType="text/html">

	<ui:insert name="metadata" />
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Taller Proyectos</title>
		<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>

		<jsp:include page="/PlanCurricular/views/commons/resources.jsp" />
		<script type="text/javascript"
			src='<c:url value="/PlanCurricular/resources/js/functions.js" />'></script>
		<script type="text/javascript">
			var myLayout;
			var myDialog;
			$(function() {
				$('iframe[name=iframe_main]').css('height', '680px');
				myLayout = $('body').layout({
					closable : true,
					resizable : true,
					applyDefaultStyles : true,
					center__minWidth : 380,
					east__minSize : .5,
					south__minSize : 50
				});
				//myLayout.sizePane("north", 300);
				myLayout.sizePane("south", 30);
				myLayout.bindButton('.south-toggler', 'toggle', 'south');
				myDialog = $('#dialog-form').dialog({
					autoOpen : false,
					height : 450,
					width : 500,
					modal : false,
					buttons : {
						Agregar : function() {
							myDialog.dialog("close");
						},
						Cancelar : function() {
							myDialog.dialog("close");
						}
					},
					close : function() {
					}
				});
				$('.ui-form-buttons').button({
					icons : {
						primary : "ui-icon-pencil"
					}
				});
				$('.ui-action-buttons').button();
				$('.ui-action-icons').button({
					icons : {
						primary : "ui-icon-trash"
					},
					text : false
				});
				/* $('#a-toggle-all').click(function(){
					myLayout.toggle('north');
					myLayout.toggle('south');
				}); */
				$('#tb-change').tableDnD();
			});
		</script>
	</head>

	<%
		Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
			Persona oPersona = oUsuario.getPersona();
	%>


	<body class="page-body skin-red">
		<div class="page-container">
			<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
			<div class="main-content">
				<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>
				<div id="dialog-form" title="">...</div>
				
				<p:layoutUnit position="center" resizerTip="Resize Me" togglerTipClosed="Open Me" togglerTipOpen="Close Me" fullpage="false" style="100%;">
				<div class="ui-layout-center">
					<div id="toolbar" class="ui-widget-header ui-corner-all">
						<div>
							<select id="slc-course"
								style="width: 355px; height: 29px; vertical-align: middle; color: #999">
								<option value="0" style="color: #999">Seleccione uno</option>
								<c:forEach items="${sessionCourses}" var="course">
									<option value="${course.code}" style="color: #999">${course.name}</option>
								</c:forEach>
							</select>
							<%
								System.out.println("entra al viewHome");
							%>
							<button id="buttonC" class="ui-form-buttons" style="width: 166px">Modificar
								Curso</button>
							<button id="button3" class="ui-form-buttons" style="width: 166px">Agregar
								Curso</button>
						</div>
						<div id="div-chgbtn" style="display: none">
							<hr />
							<button id="button0" class="ui-form-buttons" style="width: 166px">Cambiar
								Nombre</button>
							<button id="button1" class="ui-form-buttons" style="width: 166px">Cambiar
								Requisitos</button>
							<button id="button2" class="ui-form-buttons" style="width: 166px">Cambiar
								Horas</button>
							<button id="button4" class="ui-form-buttons" style="width: 166px">Mover
								Curso</button>
							<button id="button5" class="ui-form-buttons" style="width: 166px">Dar
								de baja</button>
						</div>
					</div>
					<!-- </div> -->
					<div id="div-change" style="padding-top: 5px">
						<div class="row">
							<table id="tb-change" class="table-curriculum">
								<thead id="0">
									<tr style="cursor: move;">
										<th colspan="6">Cambios Diseñados</th>
									</tr>
									<tr style="cursor: move;">
										<th style="width: 5%;">Ciclo</th>
										<th style="width: 25%;">Curso</th>
										<th style="width: 60%;">Cambio</th>
										<th style="width: 5%; text-align: center;">Eliminar</th>
										<th style="width: 5%; text-align: center;">Habilitar</th>
									</tr>
								</thead>
								<tbody id="0">
									<c:forEach items="${sessionChanges}" var="change">
										<tr id="tr${change.uuid}">
											<td style="width: 5%; text-align: center;">${change.course.cycle}</td>
											<td>${change.course.code}&nbsp;${change.course.name}</td>
											<td>${change.description}</td>
											<td style="width: 5%; text-align: center;"><button
													class="ui-action-icons"
													onclick="javascript:changeRemove(this.value)"
													value="${change.uuid}">Remove</button></td>
											<td style="width: 5%; text-align: center;"><input
												onclick="javascript:changeState(this.value)"
												id="${change.uuid}" checked="checked" value="${change.uuid}"
												type="checkbox" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					</div>
				</p:layoutUnit>
				
					<div class="ui-layout-east">
						<div id="div-toolbar">
							<div id="toolbar" class="ui-widget-header ui-corner-all"
								align="right">
								<div style="float: left;">
									<a id="a-toggle-all" href="javascript:void(0)" title="Expandir"><c:out
											value="${semester}"></c:out></a>
								</div>
								<button id="button8" class="ui-action-buttons">Aplicar</button>
								<button id="button9" class="ui-action-buttons">Reset</button>
								<button id="button11" class="ui-action-buttons">Exportar</button>
							</div>
						</div>
						<div id="div-curriculum" style="padding-top: 0px">
							<jsp:include
								page="/PlanCurricular/views/sections/tableCurriculum.jsp" />
						</div>
					</div>
					<div class="ui-layout-south">
						<span style="text-decoration: underline; font-weight: bold;">Notificaciones</span>(<span
							id="ncount">0</span>) &nbsp;[<a href="javascript:void(0)"
							class="south-toggler">ocultar</a>]
						<ol id="ol-notifications"></ol>
					</div>
					<!-- Fin contenido -->
					<jsp:include page="/resources/include/footer.jsp"></jsp:include>
				</div>
				<jsp:include page="/resources/include/chat.jsp"></jsp:include>
			</div>

			<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
		/*botones*/
		$('#slc-course').change(function() {
			$('#div-chgbtn').hide();
			myDialog.dialog("close");
			myDialog.empty();
		});

		$('#buttonC').click(function() {
			if ($('#slc-course').val() != 0) {
				$('#div-chgbtn').show();
			}
		});

		$('#button0')
				.click(
						function() {
							$
									.ajax({
										method : "GET",
										url : "<c:url value='/changeName'/>",
										dataType : "html",
										cache : false
									})
									.done(
											function(data) {
												myDialog.empty();
												myDialog.html(data);

												/* Form values */

												$('#course-name').text(
														$('option:selected',
																'#slc-course')
																.text());
												$('#course').val(
														$('#slc-course').val());
												$('#newname').val(
														$('option:selected',
																'#slc-course')
																.text());

												/* Form values */

												myDialog
														.dialog({
															title : $(
																	'#dlg-title',
																	myDialog)
																	.text(),
															buttons : {
																Agregar : function() {
																	$
																			.ajax(
																					{
																						method : "POST",
																						url : "<c:url value='/changeName'/>",
																						data : $(
																								'#frm-change',
																								myDialog)
																								.serialize(),
																						dataType : "json",
																						cache : false
																					})
																			.done(
																					function(
																							data) {
																						if (data.code === 200) {
																							addChange(
																									0,
																									data.data);
																							myDialog
																									.dialog("close");
																							addNotification(data.message);
																						} else {
																							$(
																									'#msg-change',
																									myDialog)
																									.empty()
																									.text(
																											data.message);
																							$(
																									'#error-change',
																									myDialog)
																									.show();
																						}
																					})
																			.fail(
																					function() {
																						addNotification("[ERROR] No se pudo procesar su solicitud");
																						myDialog
																								.dialog("close");
																					});
																},
																Cancelar : function() {
																	myDialog
																			.dialog("close");
																}
															},
															close : function() {
																myDialog
																		.empty();
															}
														});
												myDialog.dialog("open");
											}).fail(function() {
										console.log("FALLO!!!");
									});
						});

		$('#button1')
				.click(
						function() {
							$
									.ajax(
											{
												method : "GET",
												url : "<c:url value='/changeRequirements'/>",
												dataType : "html",
												cache : false
											})
									.done(
											function(data) {
												myDialog.empty();
												myDialog.html(data);

												/* Form values */
												var code = $('#slc-course')
														.val();

												$('#course-name').text(
														$('option:selected',
																'#slc-course')
																.text());
												$('#course').val(code);

												$('#div-req').show();
												$('.grp-req').hide();
												$('#div-' + code).show();
												$('.grp-nreq').show();
												$('#opt1-' + code).hide();
												$('#opt2-' + code).hide();
												/* Form values */

												myDialog
														.dialog({
															title : $(
																	'#dlg-title',
																	myDialog)
																	.text(),
															buttons : {
																Agregar : function() {
																	$
																			.ajax(
																					{
																						method : "POST",
																						url : "<c:url value='/changeRequirements'/>",
																						data : $(
																								'#frm-change',
																								myDialog)
																								.serialize(),
																						dataType : "json",
																						cache : false
																					})
																			.done(
																					function(
																							data) {
																						if (data.code === 200) {
																							addChange(
																									0,
																									data.data);
																							myDialog
																									.dialog("close");
																							addNotification(data.message);
																						} else {
																							$(
																									'#msg-change',
																									myDialog)
																									.empty()
																									.text(
																											data.message);
																							$(
																									'#error-change',
																									myDialog)
																									.show();
																						}
																					})
																			.fail(
																					function() {
																						addNotification("[ERROR] No se pudo procesar su solicitud");
																						myDialog
																								.dialog("close");
																					});
																},
																Cancelar : function() {
																	myDialog
																			.dialog("close");
																}
															},
															close : function() {
																myDialog
																		.empty();
															}
														});
												myDialog.dialog("open");
											}).fail(function() {
										console.log("FALLO!!!");
									});
						});

		$('#button2')
				.click(
						function() {
							$
									.ajax({
										method : "GET",
										url : "<c:url value='/changeHours'/>",
										dataType : "html",
										cache : false
									})
									.done(
											function(data) {
												myDialog.empty();
												myDialog.html(data);

												/* Form values */
												var code = $('#slc-course')
														.val();

												$('#course-name').text(
														$('option:selected',
																'#slc-course')
																.text());
												$('#course').val(code);

												$('#div-hours').show();
												$('.grp-courses').hide();
												$('#span-' + code).show();
												/* Form values */

												myDialog
														.dialog({
															title : $(
																	'#dlg-title',
																	myDialog)
																	.text(),
															buttons : {
																Agregar : function() {
																	$
																			.ajax(
																					{
																						method : "POST",
																						url : "<c:url value='/changeHours'/>",
																						data : $(
																								'#frm-change',
																								myDialog)
																								.serialize(),
																						dataType : "json",
																						cache : false
																					})
																			.done(
																					function(
																							data) {
																						if (data.code === 200) {
																							addChange(
																									0,
																									data.data);
																							myDialog
																									.dialog("close");
																							addNotification(data.message);
																						} else {
																							$(
																									'#msg-change',
																									myDialog)
																									.empty()
																									.text(
																											data.message);
																							$(
																									'#error-change',
																									myDialog)
																									.show();
																						}
																					})
																			.fail(
																					function() {
																						addNotification("[ERROR] No se pudo procesar su solicitud");
																						myDialog
																								.dialog("close");
																					});
																},
																Cancelar : function() {
																	myDialog
																			.dialog("close");
																}
															},
															close : function() {
																myDialog
																		.empty();
															}
														});
												myDialog.dialog("open");
											}).fail(function() {
										console.log("FALLO!!!");
									});
						});

		$('#button3')
				.click(
						function() {
							$
									.ajax({
										method : "GET",
										url : "<c:url value='/addCourse'/>",
										dataType : "html",
										cache : false
									})
									.done(
											function(data) {
												myDialog.empty();
												myDialog.html(data);
												myDialog
														.dialog({
															title : $(
																	'#dlg-title',
																	myDialog)
																	.text(),
															buttons : {
																Agregar : function() {
																	$
																			.ajax(
																					{
																						method : "POST",
																						url : "<c:url value='/addCourse'/>",
																						data : $(
																								'#frm-change',
																								myDialog)
																								.serialize(),
																						dataType : "json",
																						cache : false
																					})
																			.done(
																					function(
																							data) {
																						if (data.code === 200) {
																							addChange(
																									0,
																									data.data);
																							myDialog
																									.dialog("close");
																							addNotification(data.message);
																						} else {
																							$(
																									'#msg-change',
																									myDialog)
																									.empty()
																									.text(
																											data.message);
																							$(
																									'#error-change',
																									myDialog)
																									.show();
																						}
																					})
																			.fail(
																					function() {
																						addNotification("[ERROR] No se pudo procesar su solicitud");
																						myDialog
																								.dialog("close");
																					});
																},
																Cancelar : function() {
																	myDialog
																			.dialog("close");
																}
															},
															close : function() {
																myDialog
																		.empty();
															}
														});
												myDialog.dialog("open");
											}).fail(function() {
										console.log("FALLO!!!");
									});
							$('#div-chgbtn').hide();
						});

		$('#button4')
				.click(
						function() {
							$
									.ajax({
										method : "GET",
										url : "<c:url value='/moveCourse'/>",
										dataType : "html",
										cache : false
									})
									.done(
											function(data) {
												myDialog.empty();
												myDialog.html(data);

												/* Form values */
												var code = $('#slc-course')
														.val();

												$('#course-name').text(
														$('option:selected',
																'#slc-course')
																.text());
												$('#course').val(code);

												$('#error-change').hide();
												$('#div-cycle').show();
												$('.grp-courses').hide();
												$('.' + code).show();
												/* Form values */

												myDialog
														.dialog({
															title : $(
																	'#dlg-title',
																	myDialog)
																	.text(),
															buttons : {
																Agregar : function() {
																	$
																			.ajax(
																					{
																						method : "POST",
																						url : "<c:url value='/moveCourse'/>",
																						data : $(
																								'#frm-change',
																								myDialog)
																								.serialize(),
																						dataType : "json",
																						cache : false
																					})
																			.done(
																					function(
																							data) {
																						if (data.code === 200) {
																							addChange(
																									0,
																									data.data);
																							myDialog
																									.dialog("close");
																							addNotification(data.message);
																						} else {
																							$(
																									'#msg-change',
																									myDialog)
																									.empty()
																									.text(
																											data.message);
																							$(
																									'#error-change',
																									myDialog)
																									.show();
																						}
																					})
																			.fail(
																					function() {
																						addNotification("[ERROR] No se pudo procesar su solicitud");
																						myDialog
																								.dialog("close");
																					});
																},
																Cancelar : function() {
																	myDialog
																			.dialog("close");
																}
															},
															close : function() {
																myDialog
																		.empty();
															}
														});
												myDialog.dialog("open");
											}).fail(function() {
										console.log("FALLO!!!");
									});
						});

		$('#button5')
				.click(
						function() {
							$
									.ajax({
										method : "GET",
										url : "<c:url value='/cancelCourse'/>",
										dataType : "html",
										cache : false
									})
									.done(
											function(data) {
												myDialog.empty();
												myDialog.html(data);

												/* Form values */
												var code = $('#slc-course')
														.val();

												$('#course-name').text(
														$('option:selected',
																'#slc-course')
																.text());
												$('#course').val(code);

												$('.grp-courses').hide();
												$('.' + code).show();
												/* Form values */

												myDialog
														.dialog({
															title : $(
																	'#dlg-title',
																	myDialog)
																	.text(),
															buttons : {
																Agregar : function() {
																	$
																			.ajax(
																					{
																						method : "POST",
																						url : "<c:url value='/cancelCourse'/>",
																						data : $(
																								'#frm-change',
																								myDialog)
																								.serialize(),
																						dataType : "json",
																						cache : false
																					})
																			.done(
																					function(
																							data) {
																						if (data.code === 200) {
																							addChange(
																									0,
																									data.data);
																							myDialog
																									.dialog("close");
																							addNotification(data.message);
																						} else {
																							$(
																									'#msg-change',
																									myDialog)
																									.empty()
																									.text(
																											data.message);
																							$(
																									'#error-change',
																									myDialog)
																									.show();
																						}
																					})
																			.fail(
																					function() {
																						addNotification("[ERROR] No se pudo procesar su solicitud");
																						myDialog
																								.dialog("close");
																					});
																},
																Cancelar : function() {
																	myDialog
																			.dialog("close");
																}
															},
															close : function() {
																myDialog
																		.empty();
															}
														});
												myDialog.dialog("open");
											}).fail(function() {
										console.log("FALLO!!!");
									});
						});

		$('#button8').click(function() {
			$.ajax({
				method : "GET",
				url : "<c:url value='/applyChanges'/>",
				dataType : "html",
				cache : false
			}).done(function(data) {
				$('#div-curriculum').empty();
				$('#div-curriculum').append(data);
			}).fail(function() {
				console.log("FALLO!!!");
			});
		});

		$('#button9').click(function() {
			$.ajax({
				method : "GET",
				url : "<c:url value='/resetChanges'/>",
				dataType : "html",
				cache : false
			}).done(function(data) {
				$('#div-curriculum').empty();
				$('#div-curriculum').append(data);
			}).fail(function() {
				console.log("FALLO!!!");
			});
		});
	</script>

</f:view>

</html>