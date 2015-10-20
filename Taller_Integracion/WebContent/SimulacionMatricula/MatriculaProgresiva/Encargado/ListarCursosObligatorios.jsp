<!DOCTYPE html>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
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
				<li class="active"><strong>Cursos Obligatorios</strong></li>
			</ol>

			<h2>Cursos Obligatorios</h2>

			<br />

			<%
				ArrayList<Curso> listado = (ArrayList) request.getAttribute("cursos");
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
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>


		<jsp:include page="/resources/include/chat.jsp"></jsp:include>

	</div>


	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>