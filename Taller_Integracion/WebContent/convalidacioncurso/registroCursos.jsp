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
<link href="css/fileinput.min.css" rel="stylesheet" type="text/css" />
<link href="css/registroCursos.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="js/selectize.min.js" type="text/javascript"></script>
<script src="js/fileinput.min.js" type="text/javascript"></script>
<script src="js/fileinput_locale_es.js" type="text/javascript"></script>
<script src="js/selectizes/alumnoSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/universidadSelectize.js"
	type="text/javascript"></script>
<script src="js/registroCursos.js" type="text/javascript"></script>

</head>

<body class="page-body skin-red">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>

			<div>
				<div class="row">
					<h1>Proceso de Convalidacion > Registrar Cursos</h1>
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
					<hr style="visibility: hidden;">
					<hr>
					<hr style="visibility: hidden;">

					<div class="row">
						<div class="col-md-offset-2 col-md-8">
							<div class="form-group">
								<label>Universidad Origen<span class="required">*</span>
								</label> <input type="text" id="comboUniversidad" />

							</div>

						</div>
					</div>

					

					<div class="col-md-offset-1 col-md-10">
						

						<form id="form">
						<div class="row">
						<div class="col-md-12">
							<table class="table table-hover table-bordered " style="font-size:13px;">
								<thead>
								<tr>
									<td style="text-align:center;" class="subsubtit" colspan="4"><b>USMP</b></td>
									<td style="text-align:center;"  class="subsubtit" colspan="2"><b>UNIV. ORIGEN</b></td>
								</tr>
									<th>N° Conv.</th>
									<th>C&oacute;digo</th>
									<th>Curso</th>
									<th>Ciclo</th>
									<th>C&oacute;digo</th>
									<th>Curso</th>
									<th>Añadir</th>
									<th>Nota</th>
								</thead>
								<tbody id="cursosregistrados">
								</tbody>
							</table>
						</div>
					
						<label class="col-md-12 col-xs-12 col-sm-12">Cursos no encontrados</label>
						<div class="col-md-6 col-xs-6 col-sm-6">
							<input id="agregarcurso" style="width:50px;"
								class="btn btn-success btn-lg mitooltip" data-placement="right"
								title="AGREGAR UN CURSO" value="+"/>
						</div>
						<hr style="visibility: hidden">
						<hr style="visibility: hidden">
						<hr style="visibility: hidden">
						
							<div class="col-md-12" id="cursosaprobados"></div>
							<hr style="visibility: hidden">
							<hr style="visibility: hidden">
							<div style="text-align: center;">
								<input type="submit" class="btn btn-success"
									value="Registrar Cursos" />
							</div>
						</div>	
						</form>
						<hr style="visibility: hidden">
						</div>
					</div>
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