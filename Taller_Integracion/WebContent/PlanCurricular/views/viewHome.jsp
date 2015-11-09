<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USMP - Cambio de Curricula</title>
<jsp:include page="commons/resources.jsp"/>
<script type="text/javascript" src='<c:url value="/grupo1/resources/js/functions.js" />'></script>
<script type="text/javascript">

var myLayout;
var myDialog;

$(function() {
	
	$('iframe[name=iframe_main]').css('height','680px');
	
	myLayout = $('body').layout({
		closable:			true,
		resizable: 			true, 
		applyDefaultStyles: true,
		center__minWidth:	380,
		east__minSize:		.5,
		south__minSize:		30
	});
	
	//myLayout.sizePane("north", 300);
	myLayout.sizePane("south", 30);
	myLayout.bindButton('.south-toggler', 'toggle', 'south');
	
	myDialog = $('#dialog-form').dialog({
		 autoOpen: false,
		 height: 450,
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
	
	$('.ui-form-buttons').button({
	      icons: {
	          primary: "ui-icon-pencil"
	        }
	});
	$('.ui-action-buttons').button();
	$('.ui-action-icons').button({
		 icons: {
		 primary: "ui-icon-trash"
		 },
		 text: false
	});
	
	/* $('#a-toggle-all').click(function(){
		myLayout.toggle('north');
		myLayout.toggle('south');
	}); */

	$('#tb-change').tableDnD();
});
</script>
</head>
<body>
<div id="dialog-form" title="">
	...
</div>

<div class="ui-layout-center">
	<!-- <div id="div-toolbar" style="position: fixed; top: 0px; width: 100%; padding: 0px; right: 0px; left: 0px; z-index: 999;"> -->
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<div>
				<select id="slc-course" style="width:355px; height: 29px; vertical-align: middle;">
					<option value="0">Seleccione uno</option>
					<c:forEach items="${sessionCourses}" var="course">
						<option value="${course.code}">${course.name}</option>
					</c:forEach>
				</select>
				<button id="buttonC" class="ui-form-buttons" style="width: 166px">Modificar Curso</button>
				<button id="button3" class="ui-form-buttons" style="width: 166px">Agregar Curso</button>
			</div>			
			<div id="div-chgbtn" style="display: none">
				<hr/>
				<button id="button0" class="ui-form-buttons" style="width: 166px">Cambiar Nombre</button>
				<button id="button1" class="ui-form-buttons" style="width: 166px">Cambiar Requisitos</button>
				<button id="button2" class="ui-form-buttons" style="width: 166px">Cambiar Horas</button>
				<button id="button4" class="ui-form-buttons" style="width: 166px">Mover Curso</button>
				<button id="button5" class="ui-form-buttons" style="width: 166px">Dar de baja</button>
			</div>
		</div>
	<!-- </div> -->
	<div id="div-change" style="padding-top: 5px">
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
						<td style="width: 5%; text-align: center;"><button class="ui-action-icons" onclick="javascript:changeRemove(this.value)" value="${change.uuid}">Remove</button></td>
						<td style="width: 5%; text-align: center;"><input onclick="javascript:changeState(this.value)" id="${change.uuid}" checked="checked" value="${change.uuid}" type="checkbox"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="ui-layout-east">
	<div id="div-toolbar" >
		<div id="toolbar" class="ui-widget-header ui-corner-all" align="right">
			<div style="float: left;">
				<a id="a-toggle-all" href="javascript:void(0)" title="Expandir"><c:out value="${semester}"></c:out></a>
			</div>
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
	
	$('#button0').click(function() {
		$.ajax({
			method 		: "GET",
			url 		: "<c:url value='/changeName'/>",
			dataType 	: "html",
			cache : false
		}).done(function(data) {
			myDialog.empty();
			myDialog.html(data);
			
			/* Form values */
						
			$('#course-name').text($('option:selected', '#slc-course').text());
			$('#course').val($('#slc-course').val());
			$('#newname').val($('option:selected', '#slc-course').text());
			
			/* Form values */
			
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
								addChange(0, data.data);
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
			
			/* Form values */
			var code = $('#slc-course').val();
			
			$('#course-name').text($('option:selected', '#slc-course').text());
			$('#course').val(code);
			
			$('#div-req').show();
			$('.grp-req').hide();
			$('#div-'+ code).show();
			$('.grp-nreq').show();
			$('#opt1-'+ code).hide();
			$('#opt2-'+ code).hide();
			/* Form values */
			
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
								addChange(0, data.data);
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
			
			/* Form values */
			var code = $('#slc-course').val();
			
			$('#course-name').text($('option:selected', '#slc-course').text());
			$('#course').val(code);
			
			$('#div-hours').show();
			$('.grp-courses').hide();
			$('#span-'+code).show();
			/* Form values */
			
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
								addChange(0, data.data);
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
								addChange(0, data.data);
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
		$('#div-chgbtn').hide();
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
			
			/* Form values */
			var code = $('#slc-course').val();
			
			$('#course-name').text($('option:selected', '#slc-course').text());
			$('#course').val(code);
			
			$('#error-change').hide();
			$('#div-cycle').show();
			$('.grp-courses').hide();
			$('.'+code).show();
			/* Form values */
			
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
								addChange(0, data.data);
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
			
			/* Form values */
			var code = $('#slc-course').val();
			
			$('#course-name').text($('option:selected', '#slc-course').text());
			$('#course').val(code);
			
			$('.grp-courses').hide();
			$('.'+code).show();
			/* Form values */
			
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
								addChange(0, data.data);
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