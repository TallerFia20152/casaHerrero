<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Alumno"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Taller Proyectos</title>
<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>

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

			<hr />

			<ol class="breadcrumb bc-3">
				<li><a href="SimulacionMatricula/index.jsp"><i
						class="fa-home"></i>Inicio</a></li>
				<li><a href="#">Matricula Progresiva</a></li>
				<li>Alumnos</li>
				<li class="active"><strong>Cursos Aptos</strong></li>
			</ol>

			<h2>Cursos Aptos</h2>

			<br />

			<%
				ArrayList<Curso> listado = (ArrayList) request.getAttribute("listaCursoApto");
			%>

			<table class="table table-bordered datatable" id="table-1">
				<thead>
					<tr>
						<th data-hide="phone">Codigo</th>
						<th>Estado</th>
						<th data-hide="phone">Curso</th>
						<th data-hide="phone,tablet">Credito</th>
						<th>Ciclo</th>
						<th>Tipo de Curso</th>
						<th>Detalles</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < listado.size(); i++) {
					%>
					<tr class="odd gradeX">
						<td><%=listado.get(i).getCodigo()%></td>
						<td><%=listado.get(i).getEstado()%></td>
						<td><%=listado.get(i).getCurso()%></td>
						<td><%=listado.get(i).getCredito()%></td>
						<td><%=listado.get(i).getCiclo()%></td>
						<td><%=listado.get(i).getTipoCurso()%></td>
						<td><a
							href="<%=request.getContextPath()%>/DetalleCurso?codCurso=<%=listado.get(i).getCodigo()%>"
							class="btn btn-default btn-sm btn-icon icon-left"> <i
								class="entypo-pencil"></i> <strong>Ver Detalle</strong>
						</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
				<tfoot>
					<tr>
						<th>Codigo</th>
						<th>Estado</th>
						<th>Curso</th>
						<th>Credito</th>
						<th>Ciclo</th>
						<th>Tipo de Curso</th>
						<th>Detalles</th>
					</tr>
				</tfoot>
			</table>

			<script type="text/javascript">
				var responsiveHelper;
				var breakpointDefinition = {
					tablet : 1024,
					phone : 480
				};
				var tableContainer;

				jQuery(document)
						.ready(
								function($) {
									tableContainer = $("#table-1");

									tableContainer
											.dataTable({
												"sPaginationType" : "bootstrap",
												"aLengthMenu" : [
														[ 10, 25, 50, -1 ],
														[ 10, 25, 50, "All" ] ],
												"bStateSave" : true,
												"language" : {
													"url" : "//cdn.datatables.net/plug-ins/1.10.9/i18n/Spanish.json"
												},

												// Responsive Settings
												bAutoWidth : false,
												fnPreDrawCallback : function() {
													// Initialize the responsive datatables helper once.
													if (!responsiveHelper) {
														responsiveHelper = new ResponsiveDatatablesHelper(
																tableContainer,
																breakpointDefinition);
													}
												},
												fnRowCallback : function(nRow,
														aData, iDisplayIndex,
														iDisplayIndexFull) {
													responsiveHelper
															.createExpandIcon(nRow);
												},
												fnDrawCallback : function(
														oSettings) {
													responsiveHelper.respond();
												}
											});

									$(".dataTables_wrapper select").select2({
										minimumResultsForSearch : -1
									});
								});
			</script>

			<!-- Footer -->
			<footer class="main">

				&copy; 2015 <strong>SOID</strong> Solutions <a href="#"
					target="_blank">SOID Solutions</a>

			</footer>
		</div>


		<div id="chat" class="fixed" data-current-user="Art Ramadani"
			data-order-by-status="1" data-max-chat-history="25">

			<div class="chat-inner">


				<h2 class="chat-header">
					<a href="#" class="chat-close"><i class="entypo-cancel"></i></a> <i
						class="entypo-users"></i> Chat <span
						class="badge badge-success is-hidden">0</span>
				</h2>

			</div>

			<!-- conversation template -->
			<div class="chat-conversation">

				<div class="conversation-header">
					<a href="#" class="conversation-close"><i class="entypo-cancel"></i></a>

					<span class="user-status"></span> <span class="display-name"></span>
					<small></small>
				</div>

				<ul class="conversation-body">
				</ul>

				<div class="chat-textarea">
					<textarea class="form-control autogrow"
						placeholder="Type your message"></textarea>
				</div>

			</div>

		</div>

	</div>


	<link rel="stylesheet" type="text/css"
		href="//cdn.datables.net/1.10.7/css/jquery.datatables.min.css">

	<link rel="stylesheet" type="text/css"
		href="//cdn.datables.net/tabletools/2.2.4/css/datatables.tableTools.css">


	<!-- Imported styles on this page -->
	<link rel="stylesheet"
		href="<%=request.getServletContext().getContextPath() %>/resources/assets/js/datatables/responsive/css/datatables.responsive.css">
	<link rel="stylesheet"
		href="<%=request.getServletContext().getContextPath() %>/resources/assets/js/select2/select2-bootstrap.css">
	<link rel="stylesheet"
		href="<%=request.getServletContext().getContextPath() %>/resources/assets/js/select2/select2.css">

	<!-- Bottom scripts (common) -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/gsap/main-gsap.js"></script>
	<script
		src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/bootstrap.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/joinable.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/resizeable.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-api.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/datatables/TableTools.min.js"></script>


	<!-- Imported scripts on this page -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/dataTables.bootstrap.js"></script>
	<script
		src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/datatables/jquery.dataTables.columnFilter.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/datatables/lodash.min.js"></script>
	<script
		src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/datatables/responsive/js/datatables.responsive.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/select2/select2.min.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-chat.js"></script>

	<!-- JavaScripts initializations and stuff -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-custom.js"></script>

	<!-- Demo Settings -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-demo.js"></script>

</body>
</html>