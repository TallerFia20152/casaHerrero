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
<link rel="stylesheet" type="text/css" href="SimulacionMatricula/css/Simulacion.css">
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
											<option><%=seccion.getDescripcion()+ "   " + seccion.getDia()  + "  " + seccion.getHoraInicio()+ "-" + seccion.getHoraFin()%></option>											
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
									<a href="javascript:;" onclick="jQuery('#modal-6').modal('show', {backdrop: 'static'});" class="btn btn-primary">Informar Cruces</a>
									<input type="submit" id="boton" value="Registrar"
										class="btn btn-black">
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
					
			<div class="modal fade" id="modal-6">
					<div class="modal-dialog">
						<div class="modal-content">
							
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title">Informe de Cruces</h4>
							</div>
							
							<div class="modal-body">
							
								<div class="row">
									<div class="col-md-12">
										
										<table class="table table-bordered table-striped datatable">
											<thead>
												<tr>
													<th>CURSO PREFERIBLE</th>
													<th><center>SECCION</center></th>
													<th><center>SECCION CRUCE</center>	</th>
												</tr>
											</thead>
											<tbody>
											<%
												for(Curso curso:listado)
												{
											%>
											<tr>							
												<td><strong><%=curso.getCurso()%></strong></td>									
												
												<td>										
													<select class="form-control" name="seccion">
													<option></option>
													<%
														for(Seccion seccion:curso.getSeccion())
														{
													%>
													
														<option><%=seccion.getDescripcion()%></option>											
													<%
														}
													%>
													</select>
												</td>
												
												<td>										
													<select class="form-control" name="seccionTodas">
													<option></option>
													<%
														for(Curso todosCursos:listado)
														{													
															for(Seccion seccionTodas:todosCursos.getSeccion())
															{
														%>
															<option><%=seccionTodas.getDescripcion()+ " - " + todosCursos.getCurso()%></option>											
														<%
															}
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
										
									</div>
									

								</div>
														
								
							</div>
							
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
								<button type="button" class="btn btn-primary">Registrar</button>
							</div>
						</div>
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