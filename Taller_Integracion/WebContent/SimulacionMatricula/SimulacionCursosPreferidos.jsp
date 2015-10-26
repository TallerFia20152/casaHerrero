<!DOCTYPE html>
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

<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>

<body class="page-body skin-red">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		
		<div class="main-content">
		
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>
			
			<ol class="breadcrumb bc-3">
				<li><a href="#"><i class="fa-home"></i>Simulacion Matricula</a>
				</li>
				<li><a href="#">Simulacion Inicial</a></li>
			</ol>

			<h1>Simulacion Matricula</h1>

			<br />

			<%
				List<Area> listaArea = (List<Area>) request.getAttribute("listaAreaCurso");
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

			<div class="row">

				<div class="col-md-12">

					<div class="panel panel-dark" data-collapsed="1">

						<!-- panel head -->
						<div class="panel-heading active">
							<div class="panel-title">
								<strong>SIMULACION CURSOS PREFERIDOS</strong>
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
											<th>
												<center>
													<STRONG>CANTIDAD</STRONG>
											</th>
											</center>
										</tr>
									</thead>
									<%
										for (Area area:listaArea) {
									%>
									<tbody>
										<tr>
											<td><font size="3" , color="#B04444"> <strong><%=area.getNombre().toUpperCase().toString()%></strong>
											</font></td>
										</tr>
										<%
											for (Curso curso: area.getCursoList()) {
										%>
										<tr>
											<td><%=curso.getCodigo().toString()%></td>
											<td><%=curso.getCurso().toString()%>
											</td>
											<td align="center"><%=curso.getCantidadAlumnos()%>
											</td>
										</tr>
										<%
											}
										%>
									</tbody>
									<%
										}
									%>
								</table>
							</div>
							</p>
						</div>

					</div>

				</div>

			</div>

			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>