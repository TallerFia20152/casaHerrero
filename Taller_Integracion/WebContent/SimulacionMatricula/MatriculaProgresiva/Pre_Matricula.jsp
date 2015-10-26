<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="java.util.List"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
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
						
		<h3>Cursos Preferibles</h3>

		<%
			List<Curso> listado = (List) request.getAttribute("listaCursoAptoPreferibles");
			String codigoAlumno= (String) request.getAttribute("codigoAlumno");
			if (listado.size()==0)
			{
		%>
			<div class="alert alert-danger"><strong>Lo sentimos</strong> No tiene cursos aptos</div>
		<%
			}
			else
			{
		%>
		<form action="<%=request.getContextPath()%>/GenerarPreMatricula" method="post">
		
		<p><input type="hidden" name="codigoAlumno" value="<%=codigoAlumno%>"></p>
		
			<table class="table table-bordered table-striped datatable" id="table-2">
				<thead>
					<tr>
						<th>SELECCIONAR CURSO</th>
						<th>CURSO</th>
						<th>CREDITO</th>
						<th>CICLO</th>
						<th>TIPO DE CURSO</th>
					</tr>
				</thead>
				
				<tbody>
					<%
						for(Curso curso:listado)
						{
					%>
					<tr>
						<td>
							<div class="checkbox checkbox-replace">
								<input type="checkbox" id="chk-1" name="codigos" value="<%=curso.getCodigo()%>">
								<%=curso.getCodigo()%>							
							</div>
						</td>
						<td><%=curso.getCurso()%></td>
						<td><%=curso.getCredito()%></td>
						<td><%=curso.getCiclo()%></td>
						<td><%=curso.getTipoCurso()%></td>
					</tr>
					<%	}
					%>
				</tbody>
			</table>
			<div class="row">
				<div class="col-md-12 opcion">					
					<p><input type="submit" value="Registrar" class="btn btn-lg btn-black btn-icon icon-left hidden-print"></p>
				</div>
				<p>
			</div>
			<%	}
			%>
			</form>
			
			<script type="text/javascript">
			jQuery(window).load(function()
			{
				var $ = jQuery;
				
				$("#table-2").dataTable({
					"sPaginationType": "bootstrap",
					"sDom": "t<'row'<'col-xs-6 col-left'i><'col-xs-6 col-right'p>>",
					"bStateSave": true,
					"language" : {
						"url" : "//cdn.datatables.net/plug-ins/1.10.9/i18n/Spanish.json"
					},
					"iDisplayLength": 12,
					"aoColumns": [
						{ "bSortable": true },
						null,
						null,
						null,
						null
					]
				});
				
				$(".dataTables_wrapper select").select2({
					minimumResultsForSearch: -1
				});
				
				// Highlighted rows
				$("#table-2 tbody input[type=checkbox]").each(function(i, el)
				{
					var $this = $(el),
						$p = $this.closest('tr');
					
					$(el).on('change', function()
					{
						var is_checked = $this.is(':checked');
						
						$p[is_checked ? 'addClass' : 'removeClass']('highlight');
					});
				});
				
				// Replace Checboxes
				$(".pagination a").click(function(ev)
				{
					replaceCheckboxes();
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