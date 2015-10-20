<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Taller Proyectos</title>
<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
<link href="css/selectize.default.css" rel="stylesheet" type="text/css" />
<link href="css/inicio.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="js/selectize.min.js" type="text/javascript"></script>
<script src="js/selectizes/alumnoSelectize.js" type="text/javascript"></script>
<script src="js/inicio.js" type="text/javascript"></script>
</head>




<body class="page-body skin-red">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>

<div></div>

			<h1>Proceso de Convalidacion > Convalidar Cursos</h1>
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
					<table style="height: 30px">
						<tr id="datosalumno">
							<td class="subsubtit" style="width: 50px;">Código:</td>
							<td style="width: 100px;">
								<div id="codigo"></div>
							</td>
							<td class="subsubtit" style="width: 50px;">Apellidos:</td>
							<td style="width: 150px;">
								<div id="apellidos"></div>
							</td>
							<td class="subsubtit" style="width: 50px;">Nombres:</td>
							<td style="width: 150px;">
								<div id="nombres"></div>
							</td>
							<td class="subsubtit" style="width: 50px;">Facultad:</td>
							<td style="width: 220px;">
								<div id="facultad"></div>
							</td>
							<td class="subsubtit" style="width: 50px;">Escuela:</td>
							<td style="width: 250px;">
								<div id="escuela"></div>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div class="summary-content">
				<fieldset style="float: left; width: 45%; max-width: 45%">
					<legend>Datos de Ingreso</legend>
					<table>
						<tr>
							<td class="subsubtit ajuste">Modalidad Ingreso</td>
							<td>
								<div id="desmoding"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Semestre de Ingreso</td>
							<td>
								<div id="seming"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Grado Academico</td>
							<td>
								<div id="desgraaca"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Ultimo Semestre Matriculado</td>
							<td>
								<div id="ultsemmat"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Requisitos para egresar:</td>
							<td>
								<div id="credreq"></div>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div>
				<fieldset style="float: right; width: 45%; max-width: 45%">
					<legend>Datos Adicionales</legend>
					<table>
						<tr>
							<td class="subsubtit ajuste">DNI:</td>
							<td>
								<div id="documentos"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Domicilio:</td>
							<td>
								<div id="domicilio"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Telefonos:</td>
							<td>
								<div id="telefonos"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Correos:</td>
							<td>
								<div id="correos"></div>
							</td>
						<tr>
							<td class="subsubtit ajuste">Fecha Nacimiento:</td>
							<td>
								<div id="fecnac"></div>
							</td>
						</tr>
						<tr>
							<td class="subsubtit ajuste">Sexo:</td>
							<td>
								<div id="sexcli"></div>
							</td>
						</tr>

					</table>
				</fieldset>
			</div>
			<div>
				<fieldset style="float: left; width: 45%; max-width: 45%">
					<legend>Datos de Familiares</legend>
					<div></div>
				</fieldset>
			</div>



		</div>

		<jsp:include page="/resources/include/footer.jsp"></jsp:include></di
						v>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	</div>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>

</body>
</html>