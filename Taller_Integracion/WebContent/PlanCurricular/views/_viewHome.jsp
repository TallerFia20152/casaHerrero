<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Taller Proyectos</title>
	<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>

	<jsp:include page="/PlanCurricular/views/commons/resources.jsp"/>
	<script type="text/javascript" src='<c:url value="/PlanCurricular/resources/js/functions.js" />'></script>
	<script type="text/javascript">
	var myLayout;
var myDialog;

$(function() {
	
	$('iframe[name=iframe_main]').css('height','680px');
	
	myLayout = $('body').layout({
		closable:			true,
		resizable: 			true, 
		applyDefaultStyles: true,
		center__minSize:	.5,
		east__minSize:		.5,
		south__minSize:		50
	});
	
	//myLayout.sizePane("north", 300);
	myLayout.sizePane("south", 50);
	myLayout.bindButton('.south-toggler', 'toggle', 'south');
	
	myDialog = $('#dialog-form').dialog({
		 autoOpen: false,
		 height: 550,
		 width: 500,
		 modal: false,
		 buttons: {
			 Agregar: function() {
				 myDialog.dialog( "close" );
			 },
			 Cancelar: function() {
				 myDialog.dialog( "close" );
			 }
			 },
		 close: function() {
		 	
		 }
	});
	
	$('.ui-form-buttons').button();
	$('.ui-action-buttons').button();
	$('.ui-action-icons').button({
		 icons: {
		 primary: "ui-icon-trash"
		 },
		 text: false
	});
	
	$('#a-toggle-all').click(function(){
		myLayout.toggle('north');
		myLayout.toggle('south');
	});
	
	/* Temp */
	$('.ui-action-icons').click(function(){
		//myDialog.dialog( "open" );
	});
	
	$( "#tabs" ).tabs();
	
	$('#dialog-tabs').dialog({
		 autoOpen: false,
		 height: 550,
		 width: 930,
		 modal: false,
		 buttons: {
			 Cerrar: function() {
				 this.dialog( "close" );
			 }
			 },
		 close: function() {
		 	
		 }
	});
	
	$('#button12').click(function() {
		$('#dialog-tabs').dialog("open");
	});
});
</script>
<style>
	div#tabs { font-size: 12px; }
	
	</style>
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
			
			<div id="dialog-form" title="">
	
</div>

<div id="dialog-tabs" title="Modificar">
	<div id="tabs">
		<ul>
			<li><a href="#tabs-0">Informacion del Curso</a></li>
			<li><a href="#tabs-1"><span class="ui-icon ui-icon-pencil" style="float:left;"></span><span style="float:right;">Cambiar Nombre</span></a></li>
			<li><a href="#tabs-2"><span class="ui-icon ui-icon-pencil" style="float:left;"></span><span style="float:right;">Cambiar Requisitos</span></a></li>
			<li><a href="#tabs-3"><span class="ui-icon ui-icon-pencil" style="float:left;"></span><span style="float:right;">Cambiar Horas</span></a></li>
			<li><a href="#tabs-4"><span class="ui-icon ui-icon-pencil" style="float:left;"></span><span style="float:right;">Cambiar Tipo</span></a></li>
			<li><a href="#tabs-5"><span class="ui-icon ui-icon-pencil" style="float:left;"></span><span style="float:right;">Dar de Baja</span></a></li>
		</ul>
		<div>
			<div id="tabs-0">Curso...</div>
			<div id="tabs-1">Cambiar Nombre</div>
			<div id="tabs-2">Cambiar Requisitos</div>
			<div id="tabs-3">Cambiar Horas</div>
			<div id="tabs-4">Mover Curso</div>
			<div id="tabs-5">Dar de Baja</div>
		</div>
	</div>
</div>

<div class="ui-layout-center">
	<div id="div-toolbar">
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<!-- <button id="button0" class="ui-form-buttons">Cambiar Nombre</button>
			<button id="button1" class="ui-form-buttons">Cambiar Requisitos</button>
			<button id="button2" class="ui-form-buttons">Cambiar Horas</button>
			<button id="button4" class="ui-form-buttons">Mover Curso</button>
			<button id="button3" class="ui-form-buttons">Agregar Curso</button>
			<button id="button5" class="ui-form-buttons">Dar de baja Curso</button> -->
			<input type=text>
			<button id="button12" class="ui-form-buttons">Modificar Curso</button>
			<button id="button13" class="ui-form-buttons">Agregar Curso</button>
		</div>
	</div>
	<div id="div-change" style="padding-top: 10px">
		<table id="tb-change" class="table-curriculum"></table>
	</div>
</div>
<div class="ui-layout-east">
	<div id="div-toolbar">
		<div id="toolbar" class="ui-widget-header ui-corner-all" align="right">
			<div style="float: left;">
				<a id="a-toggle-all" href="javascript:void(0)" title="Expandir"><c:out value="${semester}"></c:out></a>
			</div>
			<% System.out.println("entra al _viewHome"); %>
			<button id="button8" class="ui-action-buttons">Aplicar</button>
			<button id="button9" class="ui-action-buttons">Reset</button>
			<!-- <button id="button10" class="ui-action-buttons">Guardar</button> -->
			<button id="button11" class="ui-action-buttons">Exportar</button>
		</div>
	</div>
	<div id="div-curriculum" style="padding-top: 0px">
		<jsp:include page="sections/tableCurriculum.jsp"/>
	</div>
</div>
<div class="ui-layout-south">
	<span style="text-decoration: underline; font-weight: bold;">Notificaciones</span>(<span id="ncount">0</span>) &nbsp;[<a href="javascript:void(0)" class="south-toggler">ocultar</a>]
	<ol id="ol-notifications"></ol>
</div>
			
			<!-- Contenido -->

			<!-- Fin contenido -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
</body>
<script type="text/javascript">
	/*botones*/
	$('#button0').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/changeName'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			myDialog.dialog({
				title	: $('#dlg-title', myDialog).text(),
				buttons : {
					Agregar : function() {
						$.ajax({
							method 		: "POST",
							url 		: "<c:url value='/changeName'/>",
							data 		: $('#frm-change', myDialog).serialize(),
							dataType 	: "json",
							cache 		: false
						}).done(function(data) {
							if (data.code === 200) {
								addChange(data.data.type, data.data);
								myDialog.dialog("close");
								addNotification(data.message);		
							} else {
								$('#msg-change', myDialog).empty().text(data.message);
								$('#error-change', myDialog).show();
							}
						}).fail(function() {
							addNotification("[ERROR] No se pudo procesar su solicitud");
							myDialog.dialog("close");
						});
					},
					Cancelar : function() {
						myDialog.dialog("close");
					}
				},
				close : function() {
					myDialog.empty();
				}
			});
			myDialog.dialog("open");
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
	
	$('#button1').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/changeRequirements'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			myDialog.dialog({
				title	: $('#dlg-title', myDialog).text(),
				buttons : {
					Agregar : function() {
						$.ajax({
							method 		: "POST",
							url 		: "<c:url value='/changeRequirements'/>",
							data 		: $('#frm-change', myDialog).serialize(),
							dataType 	: "json",
							cache 		: false
						}).done(function(data) {
							if (data.code === 200) {
								addChange(data.data.type, data.data);
								myDialog.dialog("close");
								addNotification(data.message);		
							} else {
								$('#msg-change', myDialog).empty().text(data.message);
								$('#error-change', myDialog).show();
							}
						}).fail(function() {
							addNotification("[ERROR] No se pudo procesar su solicitud");
							myDialog.dialog("close");
						});
					},
					Cancelar : function() {
						myDialog.dialog("close");
					}
				},
				close : function() {
					myDialog.empty();
				}
			});
			myDialog.dialog("open");
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
	
	
	$('#button2').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/changeHours'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			myDialog.dialog({
				title	: $('#dlg-title', myDialog).text(),
				buttons : {
					Agregar : function() {
						$.ajax({
							method 		: "POST",
							url 		: "<c:url value='/changeHours'/>",
							data 		: $('#frm-change', myDialog).serialize(),
							dataType 	: "json",
							cache 		: false
						}).done(function(data) {
							if (data.code === 200) {
								addChange(data.data.type, data.data);
								myDialog.dialog("close");
								addNotification(data.message);		
							} else {
								$('#msg-change', myDialog).empty().text(data.message);
								$('#error-change', myDialog).show();
							}
						}).fail(function() {
							addNotification("[ERROR] No se pudo procesar su solicitud");
							myDialog.dialog("close");
						});
					},
					Cancelar : function() {
						myDialog.dialog("close");
					}
				},
				close : function() {
					myDialog.empty();
				}
			});
			myDialog.dialog("open");
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
	
	$('#button3').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/addCourse'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			myDialog.dialog({
				title	: $('#dlg-title', myDialog).text(),
				buttons : {
					Agregar : function() {
						$.ajax({
							method 		: "POST",
							url 		: "<c:url value='/addCourse'/>",
							data 		: $('#frm-change', myDialog).serialize(),
							dataType 	: "json",
							cache 		: false
						}).done(function(data) {
							if (data.code === 200) {
								addChange(data.data.type, data.data);
								myDialog.dialog("close");
								addNotification(data.message);		
							} else {
								$('#msg-change', myDialog).empty().text(data.message);
								$('#error-change', myDialog).show();
							}
						}).fail(function() {
							addNotification("[ERROR] No se pudo procesar su solicitud");
							myDialog.dialog("close");
						});
					},
					Cancelar : function() {
						myDialog.dialog("close");
					}
				},
				close : function() {
					myDialog.empty();
				}
			});
			myDialog.dialog("open");
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
	
	$('#button4').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/moveCourse'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			myDialog.dialog({
				title	: $('#dlg-title', myDialog).text(),
				buttons : {
					Agregar : function() {
						$.ajax({
							method 		: "POST",
							url 		: "<c:url value='/moveCourse'/>",
							data 		: $('#frm-change', myDialog).serialize(),
							dataType 	: "json",
							cache 		: false
						}).done(function(data) {
							if (data.code === 200) {
								addChange(data.data.type, data.data);
								myDialog.dialog("close");
								addNotification(data.message);		
							} else {
								$('#msg-change', myDialog).empty().text(data.message);
								$('#error-change', myDialog).show();
							}
						}).fail(function() {
							addNotification("[ERROR] No se pudo procesar su solicitud");
							myDialog.dialog("close");
						});
					},
					Cancelar : function() {
						myDialog.dialog("close");
					}
				},
				close : function() {
					myDialog.empty();
				}
			});
			myDialog.dialog("open");
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
	
	$('#button5').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/cancelCourse'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			myDialog.dialog({
				title	: $('#dlg-title', myDialog).text(),
				buttons : {
					Agregar : function() {
						$.ajax({
							method 		: "POST",
							url 		: "<c:url value='/cancelCourse'/>",
							data 		: $('#frm-change', myDialog).serialize(),
							dataType 	: "json",
							cache 		: false
						}).done(function(data) {
							if (data.code === 200) {
								addChange(data.data.type, data.data);
								myDialog.dialog("close");
								addNotification(data.message);		
							} else {
								$('#msg-change', myDialog).empty().text(data.message);
								$('#error-change', myDialog).show();
							}
						}).fail(function() {
							addNotification("[ERROR] No se pudo procesar su solicitud");
							myDialog.dialog("close");
						});
					},
					Cancelar : function() {
						myDialog.dialog("close");
					}
				},
				close : function() {
					myDialog.empty();
				}
			});
			myDialog.dialog("open");
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
	
	$('#button8').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/applyChanges'/>",
			dataType 	: "html",
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
			method 		: "GET",
			url 		: "<c:url value='/resetChanges'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			$('#div-curriculum').empty();
			$('#div-curriculum').append(data);
		}).fail(function() {
			console.log("FALLO!!!");
		});
	});
</script>
</html>