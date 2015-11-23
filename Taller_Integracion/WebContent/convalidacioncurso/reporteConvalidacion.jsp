<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script src="js/reporteConvalidacion.js" type="text/javascript"></script>
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
			
			 <h1 style="text-align: center">REPORTE DE CONVALIDACIONES</h1>
       		<div class="row">
       			    <section id="SeleccionarAlumno">
						<div>
							<div id="label">
								<span>ALUMNO</span>
							</div>
							<div>
								<input type="text" id="comboAlumno"
									placeholder="Ingrese primer apellido o código de alumno para comenzar" />
							</div>
						</div>
					</section>
					<div id="imprcab">
						<fieldset>
							<legend>Datos Generales</legend>
							<table style="width: 100%">
								<tr id="datosalumno" style="height: 40px;width: 70%">
									<td class="subsubtit" style="width: 50px;">Código:</td>
									<td style="width: 100px;">
										<div id="codigo"></div>
									</td>
									<td class="subsubtit" style="width: 50px;">Apellidos:</td>
									<td style="width: 120px;">
										<div id="apellidos"></div>
									</td>
									<td class="subsubtit" style="width: 50px;">Nombres:</td>
									<td style="width: 120px;">
										<div id="nombres"></div>
									</td>
									<td class="subsubtit" style="width: 50px;">Facultad:</td>
									<td style="width: 150px;">
										<div id="facultad"></div>
									</td>
									<td class="subsubtit" style="width: 50px;">Escuela:</td>
									<td style="width: 150px;">
										<div id="escuela"></div>
									</td>
								</tr>
							</table>
						</fieldset>
					</div>
       			
       			
       			
       			
       		</div>
			
			
			
			
			

			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
</body>
</html>