<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=us-ascii">
	
	<meta name="viewport" content="width=device-width,initial-scale=1">

	<title>Cargar Excel </title>

	<!--Estilos necesarios-->

	
	<!--  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ElaboracionHorarios/css/bootstrap.min.css">-->
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ElaboracionHorarios/css/dataTables.bootstrap.css">

	<!--Java Script necesarios-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/ElaboracionHorarios/js/site.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/ElaboracionHorarios/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/ElaboracionHorarios/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/ElaboracionHorarios/js/dataTables.bootstrap.js"></script>


	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#example').dataTable();
		} );
	</script>

 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="css/dashboard.css" rel="stylesheet" />
</head>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.login.servlet.LoginServlet"%>
<%@page import="edu.usmp.fia.taller.common.bean.*"%>
<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>
<body >
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Taller</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><%= oPersona.getNombre() + " " + oPersona.getApePaterno()%></a></li>
					<li><a href="login?f=logout">Salir</a></li>
				</ul>
	
			</div>
		</div>
		</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Malla curricular</a></li>
					<li><a href="Registrar_Docente?p='RegistrarDocente'">Registro de docentes</a></li>
					<li><a data-toggle="modal" href="#myModal">Elaboracion de Horarios</a></li>
				</ul>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2>Contenido</h2>
				<div class="fw-container">
		<form action="cargarExcels" method="post" enctype="multipart/form-data">
	
			
			Select File : <input type="file" name="filetoupload">
			<br/>
			<input type="submit" class="btn btn-info" value="Subir Archivo">
		</form>
	</div>
			</div>
		</div>

	</div>

<!-- Inicio Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">

		    <!-- Modal content-->
		    <div class="modal-content" style="margin-top:50%;">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Sistema Elaboracion de Horarios</h4>
		      </div>
		      <div class="modal-body">
		        <p>¿Desea agregar el archivo excel consolidado?.</p>
		        </br>
		        <center>
				<form action="cargarExcels" method="get" >
						<input type="hidden" name="f" value="leerExcel" /> <input type="hidden"
							name="p" id="p" value="" />
			        <button type="submit"  class="btn btn-success">Agregar archivo</button>
			     </form>
			     <form action="ElaboracionHorariosServlet" method="get" > 
			     <input type="hidden" name="f" value="leerHorario" /> <input type="hidden"
						name="p" id="p" value="" /> 
			        <button type="submit"  class="btn btn-info">No agregar archivo</button>
				</form>
			     </center>
			     <p>.</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>

		  </div>
		</div>
		<!-- Fin Modal -->

	<script src="../Scripts/jquery-1.9.1.js"></script>
	<script src="../Scripts/bootstrap.min.js"></script>

	

</body>
</html>