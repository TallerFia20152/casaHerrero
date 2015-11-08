<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Seccion"%>
<%@page import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Area"%>
<%@page import="java.util.List"%>
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

<body class="page-body skin-red">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>

			<ol class="breadcrumb bc-3">
				<li><a href="#"><i class="fa-home"></i>Simulacion Matricula</a>
				</li>
				<li><a href="#">Simulacion Probable</a></li>
			</ol>

			<h1>Simulacion Matricula</h1>

			<br />
			<br />
			
			<%
				List<Curso> listado = (List<Curso>) request.getAttribute("listaCursos");
			
				if (listado==null)
				{
			%>
				<div class="row">
					<div class="alert alert-danger"><strong>LO SENTIMOS</strong> No hay los datos necesarios para mostrar los resultados de la Matricula Progresiva</div>
				</div>
			<%
				}
				else
				{
			%>
			<div class="row">

				<div class="col-md-12">

					<div class="panel panel-dark" data-collapsed="10000">

						<!-- panel head -->
						<div class="panel-heading">
							<div class="panel-title">
								<strong>REPORTE DE MATRICULA PROGRESIVA</strong>
							</div>

							<div class="panel-options">
								<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
							</div>
						</div>

						<div class="panel-body">
							<p>
							<div id="export">
								<table id="table-1" class="table responsive">

									<thead>
										<tr>
											<th><STRONG>CODIGO</STRONG></th>
											<th><STRONG>CURSO</STRONG></th>
											<th><STRONG><center>SECCION</center></STRONG></th>
											<th>
												<center>
													<STRONG>CANTIDAD</STRONG>
											</th>
											</center>
										</tr>
									</thead>
									<tbody>
									<%
										for(Curso curso:listado)
										{
									%>
										<tr>
											<td><%=curso.getCodigo()%></td>
											<td><%=curso.getCurso()%></td>
											<td><center><%=curso.getSeccio()%></center></td>
											<td><center><%=curso.getCantidadAlumnos()%></center></td>
										</tr>
									<%
										}
									%>
									</tbody>
								</table>
							</div>
							</p>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>

			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>