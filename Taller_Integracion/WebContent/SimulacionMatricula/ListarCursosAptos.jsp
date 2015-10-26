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
				<li><a href="#">Simulacion de Matricula</a></li>
				<li>Alumnos</li>
				<li class="active"><strong>Cursos Aptos</strong></li>
			</ol>

			<h2>Cursos Aptos</h2>
			<br />
			<%
				List<Curso> listado = (List) request.getAttribute("listaCursoApto");
				if (listado==null)
				{
			%>
				<div class="alert alert-danger"><strong>Lo sentimos</strong> No tiene cursos aptos</div>
			<%
				}
				else
				{
			%>
				<table class="table table-bordered datatable" id="table-1">
					<tr  class="odd gradeA">
						<td data-hide="phone"><strong>CODIGO</strong></td>
						<td><strong>ESTADO</strong></td>
						<td data-hide="phone"><strong>CURSO</strong></td>
						<td data-hide="phone,tablet"><strong>CREDITO</strong></td>
						<td><strong>CICLO</strong></td>
						<td><strong>TIPO DE CURSO</strong></td>
						<td><strong>DETALLES</strong></td>
					</tr>
					<%
						for (Curso curso:listado) 
						{
					%>
					<tr class="odd gradeX">
						<td><%=curso.getCodigo()%></td>
						<td>
							<%
								if(curso.getEstado().toUpperCase().equals("APTO"))
								{
							%>	
								<%=curso.getEstado()%>
							<%
								}
								else
								{
							%>
								<font color="red"><%=curso.getEstado()%></font>
							<%
								}
							%>														
						</td>						
						<td><%=curso.getCurso()%></td>
						<td><%=curso.getCredito()%></td>
						<td><%=curso.getCiclo()%></td>
						<td><%=curso.getTipoCurso()%></td>
						<td><a
							href="<%=request.getContextPath()%>/DetalleCurso?codCurso=<%=curso.getCodigo()%>"
							class="btn btn-default btn-sm btn-icon icon-left"> <i
								class="entypo-pencil"></i> <strong>Ver Detalle</strong>
						</a></td>
					</tr>
					<%	}%>
				</table>
			<%} %>
			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>

<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>