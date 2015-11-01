<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Seccion"%>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="java.util.List"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
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

			<h3>Seleccionar Horarios</h3>

			<%
				
				List<Curso> listado = (List) request.getAttribute("listadoCursos");
				if (listado.size() == 0) 
				{
			%>
			<div class="row">

				<div class="col-md-12">
					<div class="alert alert-danger">
						<strong>Lo sentimos</strong> No a seleccionado sus cursos preferibles
					</div>
				</div>
			</div>
			
			<%
				} else {
			%>
			
			<div class="row">

				<div class="col-md-12">
					<form id="formulario"
						action="<%=request.getContextPath()%>/RegistrarHorarios" method="post">
						<table class="table table-bordered table-striped datatable"
							id="table-2">
							<thead>
								<tr>
									<th>CODIGO</th>
									<th>CURSO</th>
									<th>CICLO</th>
									<th>CREDITO</th>
									<th>SECCION - DIA - HORA INICIO - HORA FIN</th>
								</tr>
							</thead>

							<tbody>
								<%
									for(Curso curso:listado)
									{
								%>
									<input type="hidden" name="codigos" value="<%=curso.getCodigo()%>"> 
								<tr>									
									<td><%=curso.getCodigo()%></td>
									<td><%=curso.getCurso()%></td>									
									<td><%=curso.getCiclo()%></td>
									<td><%=curso.getCredito()%></td>
									<td>										
										<select class="form-control" name="seccion">
										<%
											for(Seccion seccion:curso.getSeccion())
											{
										%>
											<option><strong><%=seccion.getDescripcion()+ "   " + seccion.getDia()  + "  " + seccion.getHoraInicio()+ "-" + seccion.getHoraFin()%></strong></option>											
										<%
											}
										%>
										</select>
									</td>								
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<div class="row">
							<div class="col-md-12 opcion">
								<p>
									<input type="submit" id="boton" value="Registrar"
										class="btn btn-lg btn-black btn-icon icon-left hidden-print">
								</p>
							</div>
							<p>
						</div>
						<%
							}
						%>
					</form>
				</div>
			</div>				

			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>