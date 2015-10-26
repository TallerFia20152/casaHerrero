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
<link href="<%=request.getServletContext().getContextPath() %>/RegistroDocente/css/boostrap/bootstrap.min.css" rel="stylesheet" />
<link href="<%=request.getServletContext().getContextPath() %>/RegistroDocente/css/boostrap/bootstrap-table.min.css" rel="stylesheet" />
 <link href="<%=request.getServletContext().getContextPath() %>/RegistroDocente/css/dashboard.css" rel="stylesheet" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <script src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/bootstrap-table.min.js"></script>
 <script src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/validator.min.js"></script>
 <script src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/combos.js"></script>
 <script src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/accionesRegistroDocentes.js"></script>
<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
</head>

<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>


<body class="page-body skin-red" style="padding-top: -0;">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>

			<!-- Contenido -->

			<div>
				<form class="form-horizontal" data-toggle="validator" role="form" id="formDocente">
					<div class="row">

						<div class="col-md-6">
							<input type="hidden" name="f" value="guardarDocente" />

							<fieldset>
								<legend align="left">Datos Generales</legend>
								<div class="form-group">
									<label for="foto" class="col-sm-3 control-label">Url
										Foto: </label>
									<div class="col-sm-9">
										<input type="text" name="urlfoto"
											class="form-control input-sm" />
									</div>
								</div>

								<div class="form-group">
									<label for="Nombres" class="col-sm-3 control-label">Nombres:
									</label>
									<div class="col-sm-9">
										<input type="text" name="nombres"
											class="form-control input-sm" required />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_paterno" class="col-sm-3 control-label">Apellido
										Paterno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidopaterno"
											class="form-control input-sm" required />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_materno" class="col-sm-3 control-label">Apellido
										Materno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidomaterno"
											class="form-control input-sm" required />
									</div>
								</div>

								<div class="form-group">
									<label for="sexo" class="col-sm-3 control-label">Sexo:</label>
									<div class="col-sm-9">
										<select size="1" name="sexo" class="form-control input-sm">
											<option value="Masculino">Masculino</option>
											<option value="Femenino">Femenino</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="estado_civil" class="col-sm-3 control-label">Estado
										Civil:</label>
									<div class="col-sm-9">
										<select size="1" name="estadocivil"
											class="form-control input-sm">
											<option value="S">Soltero</option>
											<option value="C">Casado</option>
											<option value="D">Divorciado</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="paisnacimiento" class="col-sm-3 control-label">Pais
										de Nacimiento:</label>
									<div class="col-sm-9">
										<select size="1" name="pais" class="form-control input-sm">
											<option value="1">Peru</option>
											<option value="2">Chile</option>
											<option value="3">Colombia</option>
										</select>
									</div>
								</div>

							</fieldset>

							<fieldset>
								<legend align="left">Datos de Nacimiento</legend>

								<div class="form-group">
									<label for="fechanacimiento" class="col-sm-3 contro1-label">Fecha
										de Nacimiento:</label>
									<div class="col-sm-9">
										<input type="date" name="fechanacimiento"
											class="form-control input-sm">
									</div>
								</div>

								<div class="form-group">
									<label for="combo_departamentos_1"
										class="col-sm-3 contro1-label">Departamento:</label>
									<div class="col-sm-9">
										<select id="combo_departamentos_1"
											class="form-control input-sm" name="departamento1" required>
											<option>Seleccionar</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="combo_provincias_1" class="col-sm-3 contro1-label">Provincia</label>
									<div class="col-sm-9">
										<select id="combo_provincias_1" class="form-control input-sm"
											disabled="true" name="provincia1" required>
											<option>Seleccionar</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="combo_distritos_1" class="col-sm-3 contro1-label">Distrito</label>
									<div class="col-sm-9">
										<select id="combo_distritos_1" class="form-control input-sm"
											disabled="true" name="distrito1">
											<option>Seleccionar</option>
										</select>
									</div>
								</div>

							</fieldset>


							<fieldset>
								<legend align="left">Direccion</legend>

								<div class="form-group">
									<label for="combo_departamentos_2"
										class="col-sm-3 contro1-label">Departamento:</label>
									<div class="col-sm-9">
										<select id="combo_departamentos_2"
											class="form-control input-sm" name="departamento2">
											<option>Seleccionar</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="combo_provincias_2" class="col-sm-3 contro1-label">Provincia</label>
									<div class="col-sm-9">
										<select id="combo_provincias_2" class="form-control input-sm"
											disabled="true" name="provincia2">
											<option>Seleccionar</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="combo_distritos_2" class="col-sm-3 contro1-label">Distrito</label>
									<div class="col-sm-9">
										<select id="combo_distritos_2" class="form-control input-sm"
											disabled="true" name="distrito2">
											<option>Seleccionar</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="referencia" class="col-sm-3 contro1-label">Referencia:</label>
									<div class="col-sm-9">
										<input type="text" name="referencia"
											class="form-control input-sm" />
									</div>
								</div>

							</fieldset>

							<fieldset>
								<legend align="left">Datos de Contacto</legend>


								<div class="form-group">
									<label for="telefono" class="col-sm-3 contro1-label">Telefono:</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-xs-9">
												<input type="number" id="telefono"
													class="form-control input-sm" />
											</div>
											<div class="col-xs-3">
												<button type="button" class="btn btn-success btn-addItem"
													data-method="remove" data-table="telefono">-</button>
												<button type="button" class="btn btn-success btn-addItem"
													data-method="append" data-table="telefono">+</button>
											</div>
										</div>
									</div>
								</div>
								<table id="table_telefono" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id" data-visible="false">Id</th>
											<th data-field="id_local" data-visible="false">Id_local</th>
											<th data-field="valor">Telefono</th>
										</tr>
									</thead>
								</table>
								</br>

								<div class="form-group">
									<label for="email" class="col-sm-3 contro1-label">Email:</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-xs-9">
												<input type="email" class="form-control input-sm" id="email" />
											</div>
											<div class="col-xs-3">
												<button type="button" class="btn btn-success btn-addItem"
													data-method="remove" data-table="email">-</button>
												<button type="button" class="btn btn-success btn-addItem"
													data-method="append" data-table="email">+</button>
											</div>
										</div>
									</div>
								</div>

								<table id="table_email" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id" data-visible="false">Id</th>
											<th data-field="id_local" data-visible="false">Id_local</th>
											<th data-field="valor">E-mail</th>
										</tr>
									</thead>
								</table>
								</br>

								<div class="form-group">
									<label class="col-sm-3 contro1-label">Tipo Doc.:</label>
									<div class="col-sm-9">
										<select size="1" id="tipodoc" class="form-control input-sm">
											<option value="1">DNI</option>
											<option value="2">Licencia de Conducir</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 contro1-label">Numero:</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-xs-9">
												<input type="text" id="documento"
													class="form-control input-sm" />
											</div>
											<div class="col-xs-3">
												<button type="button" class="btn btn-success btn-addItem"
													data-method="remove" data-table="documento">-</button>
												<button type="button" class="btn btn-success btn-addItem"
													data-method="append" data-table="documento">+</button>
											</div>
										</div>
									</div>
								</div>

								<table id="table_documento" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id" data-visible="false">Id</th>
											<th data-field="id_local" data-visible="false">Id_local</th>
											<th data-field="tipodocshow"># Tipo</th>
											<th data-field="valor"># Documento</th>
										</tr>
									</thead>
								</table>

							</fieldset>
						</div>
						<div class="col-md-6">

							<fieldset>
								<legend align="left">
									<p>
										Datos Academicos
										<button type="button"
											class="btn btn-success btn-addItem-derecha"
											data-method="remove" data-table="gradoAcademico">-</button>
										<button type="button"
											class="btn btn-success btn-addItem-derecha"
											data-method="append" data-table="gradoAcademico">+</button>
									</p>
								</legend>


								<div class="form-group">
									<label for="email" class="col-sm-3 contro1-label">Grado
										Academico:</label>
									<div class="col-sm-9">
										<select size="1" class="form-control input-sm"
											id="gradoAcademico">
											<option value="Master">Master</option>
											<option value="Doctor">Doctor</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="email" class="col-sm-3 contro1-label">Profesion:</label>
									<div class="col-sm-9">
										<select size="1" class="form-control input-sm" id="profesion">
											<option value="Ing.Sistemas">Ing.Sistemas</option>
											<option value="Ing.Industrial">Ing.Industrial</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 contro1-label">Especialidad:</label>
									<div class="col-sm-9">
										<select size="1" class="form-control input-sm"
											id="especialidad">
											<option value="1">S.I</option>
											<option value="2">T.I</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 contro1-label">Institucion:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control input-sm"
											id="institucion" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 contro1-label">Fecha de Ingreso:</label>
									<div class="col-sm-9">
										<input type="date" class="form-control input-sm"
											id="fechaIngreso" />
									</div>
								</div>
								<table id="table_gradoAcademico" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id_local" data-visible="false">Id_local</th>
											<th data-field="id" data-visible="false">Id</th>
											<th data-field="gradoAcademico">Grado Academico</th>
											<th data-field="profesion">Profesion</th>
											<th data-field="especialidadshow">Especialidad</th>
											<th data-field="institucion">Institucion</th>
											<th data-field="fechaIngreso">Ingreso</th>
										</tr>
									</thead>
								</table>
								<div class="form-group" id="msj1" style="display: none">
									<br />
									<div class="alert alert-success" role="alert" id="msj2"></div>
								</div>
						</div>
						<div class="form-group">
							<input type="submit" value="Agregar" class="btn btn-primary">
						</div>
					</div>

				</form>
			</div>
					<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>



		<!-- Fin contenido -->
	<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	</div>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
<script>

var form =$('#formDocente');
form.validator().on('submit', function (e) {
  if (e.isDefaultPrevented()) {
	  
  } else {
	  e.preventDefault();
	  var dataForm=form.serializeArray();
	  	/*console.log(dataTelefonos);
		dataForm.push(dataTelefonos);*/
		dataForm=camposDinamicosPost(dataForm,"telefono");
		dataForm=camposDinamicosPost(dataForm,"email");
		dataForm=campoDocumentoDinamicosPost(dataForm,"documento");
		dataForm=campoGradoDinamicosPost(dataForm,"gradoAcademico");
	  $.ajax({
		  url: "<%=getServletContext().getContextPath() %>/Gestionar_Docente",
		  method: "POST",
		  data: dataForm,
		  dataType: "json",
		  
		}).done(function( respuesta ) {
			console.log(respuesta);
			if(respuesta.exito){
				resetearFormulario(form);
				$("#msj2").html(respuesta.mensaje);
				$("#msj1").fadeToggle("fast", function() {
					$("#msj1").delay(2000).fadeToggle(1000);
				});;
				
			}
		});
    // everything looks good!
  }
});

function resetearFormulario(form){
	form[0].reset();
	$("select[id*='combo_provincias']").prop('disabled', true);
	$("select[id*='combo_distritos']").prop('disabled', true);
	$("#table_gradoAcademico").bootstrapTable('load', []);
	$("#table_telefono").bootstrapTable('load', []);
	$("#table_documento").bootstrapTable('load', []);
	$("#table_email").bootstrapTable('load', []);
}

function camposDinamicosPost(dataForm,campo){
	var dataTable=$('#table_'+campo).bootstrapTable('getData');
	var nuevoCampo=[];
	  $.each( dataTable, function( key, value ) {
		  nuevoCampo.push({
			  "id": value.id,
			  "campo": value.valor
		    });
		});
	  dataForm.push({name:"json_"+campo,value:JSON.stringify(nuevoCampo)});
	  return dataForm;
}
function campoDocumentoDinamicosPost(dataForm,campo){
	var dataTable=$('#table_'+campo).bootstrapTable('getData');
	var nuevoCampo=[];
	  $.each( dataTable, function( key, value ) {
		  nuevoCampo.push({
			  "id": value.id,
			  "tipodoc":value.tipodoc,
			  "campo": value.valor
		    });
		});
	  dataForm.push({name:"json_"+campo,value:JSON.stringify(nuevoCampo)});
	  return dataForm;
}
function campoGradoDinamicosPost(dataForm,campo){
	var dataTable=$('#table_'+campo).bootstrapTable('getData');
	var nuevoCampo=[];
	  $.each( dataTable, function( key, value ) {
		  nuevoCampo.push({
			   "id": value.id,
			   "gradoAcademico": value.gradoAcademico,
	           "profesion":value.profesion,
	           "especialidad": value.especialidad,
	           "institucion":value.institucion,
	           "fechaIngreso":value.fechaIngreso
		    });
		});
	  dataForm.push({name:"json_"+campo,value:JSON.stringify(nuevoCampo)});
	  return dataForm;
}
</script>
</body>
</html>