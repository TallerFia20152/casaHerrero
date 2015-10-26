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
<script src="SimulacionMatricula/excellexport/excellentexport.js"></script>

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
				<li><a href="#">Simulacion de Matricula</a></li>
				<li class="active"><strong>Alumnos</strong></li>
			</ol>

			<h2>Listado de Alumnos</h2>

			<br />

			<%
				ArrayList<Alumno> listado = (ArrayList) request.getAttribute("listaAlumno");
			
			%>
<!-- 
			<div class="row">
				<div class="col-md-12 opcion">
					<a download="Demanda_Cursos_Prrobables.xls" href=""
						onclick="return ExcellentExport.excel(this, 'table-1');"
						class="btn btn-lg btn-black">Exportar</a>
					
					<a href="javascript:window.print();" class="btn btn-lg btn-black btn-icon icon-left hidden-print">
							Imprimir
						<i class="entypo-doc-text"></i>
					</a>
				</div>
				<p>
			</div>
 -->

			<div id="export">
				<table class="table table-bordered datatable" id="table-1">
					<thead>
						<tr>
							<th data-hide="phone">N&deg;</th>
							<th>Codigo</th>
							<th data-hide="phone">Nombre</th>
							<th data-hide="phone,tablet">Apellido Paterno</th>
							<th>Apellido Materno</th>
							<!-- <th>Curso Obligatorio</th> -->
							<th>Curso Apto</th>
							<th>Cursos Probables</th>
							<th>Cursos Preferibles</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < listado.size(); i++) {
						%>
						<tr class="odd gradeX">
							<td><%=i + 1%></td>
							<td><%=listado.get(i).getCodUSMP()%></td>
							<td><%=listado.get(i).getNombre()%></td>
							<td class="center"><%=listado.get(i).getApPaterno()%></td>
							<td class="center"><%=listado.get(i).getApMaterno()%></td>
							<!-- 
							<td align="center"><a
								href="<%=request.getContextPath()%>/ListarCursosObligatorios?codAlumno=<%=listado.get(i).getCodUSMP()%>"
								class="btn btn-default btn-sm btn-icon icon-left"> <i
									class="entypo-pencil"></i> <strong>Ver</strong>
							</a></td>
							 -->
							<td align="center"><a
								href="<%=request.getContextPath()%>/ListarCursosAptos?codAlumno=<%=listado.get(i).getCodUSMP()%>"
								class="btn btn-default btn-sm btn-icon icon-left"> <i
									class="entypo-pencil"></i> <strong>Ver</strong>
							</a></td>
							<td align="center"><a
								href="<%=request.getContextPath()%>/ListarCursosPropuesto?codAlumno=<%=listado.get(i).getCodUSMP()%>"
								class="btn btn-default btn-sm btn-icon icon-left"> <i
									class="entypo-pencil"></i> <strong>Ver</strong>
							</a></td>
							<td align="center"><a
								href="<%=request.getContextPath()%>/ListarCursosPreferibles?codAlumno=<%=listado.get(i).getCodUSMP()%>"
								class="btn btn-default btn-sm btn-icon icon-left"> <i
									class="entypo-pencil"></i> <strong>Ver</strong>
							</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
					<tfoot>
						<tr>
							<th>N&deg;</th>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<!-- <th>Curso Obligatorio</th> -->
							<th>Curso Apto</th>
							<th>Cursos Probables</th>
							<th>Cursos Preferibles</th>
						</tr>
					</tfoot>
				</table>
			</div>

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