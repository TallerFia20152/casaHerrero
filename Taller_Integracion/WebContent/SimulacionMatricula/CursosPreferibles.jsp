<!DOCTYPE html>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
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
				<li>
				<li><a
					href="<%=request.getContextPath()%>/SimulacionMatricula/index.jsp">

						<i class="fa-home"></i>Simulacion de Matricula
				</a></li>

				<li><a href="#">Listar Alumnos</a></li>
				<li class="active"><strong>Cursos Preferibles</strong></li>
			</ol>

			<h1>Simulacion de Matricula</h1>

			<br />
			<%
				List<Curso> listaCursos = (List<Curso>) request.getAttribute("CursosPeferibles");
				if (listaCursos==null)
				{
			%>
				<div class="row">
					<div class="alert alert-danger"><strong>Lo sentimos</strong> No tiene cursos preferibles</div>
				</div>
			<%
				}
				else
				{
			%>

			<div class="row">

				<div class="col-md-12">

					<div class="panel panel-dark" data-collapsed="1">

						<!-- panel head -->
						<div class="panel-heading">
							<div class="panel-title">
								<strong>CURSOS PREFERIBLES</strong>
							</div>

							<div class="panel-options">
								<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
							</div>
						</div>

						<div class="panel-body">
							<p>						
							<table class="table responsive">

								<thead>
									<tr>
										<th><STRONG>CODIGO</STRONG></th>
										<th><STRONG>CURSO</STRONG></th>
									</tr>
								</thead>
								<tbody>
									<%
										Integer cantidadCreditos=0;
										for (Curso curso:listaCursos) 
										{										
									%>
									<tr>
										<td><%=curso.getCodigo().toString()%></td>
										<td><%=curso.getCurso().toString()%></td>									
									</tr>
									<%
										}
									%>
								</tbody>
								<thead>
									<tr>
										<th><STRONG></STRONG></th>
										<th><STRONG></STRONG></th>
									</tr>
								</thead>
							</table>
							</p>
						</div>

					</div>

				</div>
			</div>
			<%} %>
			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>

		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>