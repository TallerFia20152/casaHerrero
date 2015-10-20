<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
<%@page import="java.util.List"%>
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
				<li><a href="#"><i class="fa-home"></i>Inicio</a></li>
				<li><a href="#">UI Elements</a></li>
				<li class="active"><strong>Detalle Curso</strong></li>
			</ol>

			<h2>Detalles del Curso</h2>

			<br />

			<%
				Curso curso = (Curso) request.getAttribute("listaCursos");
			%>
			<div class="row">

				<div class="col-md-12">

					<div class="panel-group joined" id="accordion-test-2">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion-test-2"
										href="#collapseOne-2"> <strong>DETALLE CURSO</strong>
									</a>
								</h4>
							</div>
							<div id="collapseOne-2" class="panel-collapse collapse in">
								<div class="panel-body">

									<div class="col-md-6">

										<table class="table responsive">
											<thead>
												<tr>
													<th></th>
													<th></th>
												</tr>
											</thead>

											<tbody>
												<tr>
													<td>CODIGO</td>
													<td><%=curso.getCodigo()%></td>
												</tr>

												<tr>
													<td>CREDITOS</td>
													<td><%=curso.getCredito()%></td>
												</tr>

												<tr>
													<td>CICLO</td>
													<td><%=curso.getCiclo()%></td>
												</tr>

												<tr>
													<td>TIPO</td>
													<td><%=curso.getTipoCurso().toUpperCase()%></td>
												</tr>

												<tr>
													<td>CONDICION</td>
													<td><%=curso.getCondicion().toUpperCase()%></td>
												</tr>

												<tr>
													<td>HORAS DE TEORIA</td>
													<td><%=curso.getHorasTeoria()%></td>
												</tr>

												<tr>
													<td>HORAS DE PRACTICA</td>
													<td><%=curso.getHorasPractica()%></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion-test-2"
										href="#collapseTwo-2" class="collapsed"> <strong>DOCENTES
											A CARGO</strong>
									</a>
								</h4>
							</div>
							<div id="collapseTwo-2" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="col-md-6">

										<table class="table responsive">

											<tbody>
												<%
													for (int i = 0; i < curso.getProfesor().size(); i++) {
												%>
												<tr>
													<td><%=curso.getProfesor().get(i).getNombre().toUpperCase() + " "
						+ curso.getProfesor().get(i).getApPaterno().toUpperCase() + " "
						+ curso.getProfesor().get(i).getApMaterno().toUpperCase() + " "%></td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</div>

				</div>



			</div>




			<br />




			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>


		<jsp:include page="/resources/include/chat.jsp"></jsp:include>


	</div>
<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>

</body>
</html>