<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.GradoAcademico"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Documento"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Telefono"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Email"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Docente"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Personaa"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Ubigeo"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
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
	Personaa persona=(Personaa)request.getAttribute("persona");
	Docente docente=(Docente)request.getAttribute("docente");
	Vector<Email> emails=(Vector)request.getAttribute("emails");
	Vector<Telefono> telefonos=(Vector)request.getAttribute("telefonos");
	Vector<Documento> documentos=(Vector)request.getAttribute("documentos");
	Vector<GradoAcademico> gradoAcademicos=(Vector)request.getAttribute("gradoAcademicos");
	
	List<Ubigeo> departamentos=(List)request.getAttribute("departamentos");
	List<Ubigeo> provincias1=(List)request.getAttribute("provincias1");
	List<Ubigeo> provincias2=(List)request.getAttribute("provincias2");
	List<Ubigeo> distritos1=(List)request.getAttribute("distritos1");
	List<Ubigeo> distritos2=(List)request.getAttribute("distritos2");
%>


<body class="page-body skin-red" style="padding-top: -0;">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>

			<!-- Contenido -->

			<div>
			<input type="hidden" value="true" id="vistaModificar">
				<form class="form-horizontal" data-toggle="validator" role="form" id="formDocente">
			<input type="hidden" value="update" name="tipoRegistro">
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
											class="form-control input-sm" placeholder="<%=docente.getUrl_foto() %>" value="<%=docente.getUrl_foto() %>" />
									</div>
								</div>
								<div class="form-group">
									<label for="codigo" class="col-sm-3 control-label">Codigo:
									</label>
									<div class="col-sm-9">
							<input type="hidden" name="codigo" value="<%=persona.getIdPersona() %>" />
										<input type="text"
											class="form-control input-sm" value="<%=persona.getIdPersona() %>" disabled="disabled"/>
									</div>
								</div>
								<div class="form-group">
									<label for="Nombres" class="col-sm-3 control-label">Nombres:
									</label>
									<div class="col-sm-9">
										<input type="text" name="nombres"
											class="form-control input-sm" required placeholder="<%=persona.getNombre1() %>" value="<%=persona.getNombre1() %>" />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_paterno" class="col-sm-3 control-label">Apellido
										Paterno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidopaterno"
											class="form-control input-sm" required placeholder="<%=persona.getApePaterno() %>" value="<%=persona.getApePaterno() %>" />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_materno" class="col-sm-3 control-label">Apellido
										Materno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidomaterno"
											class="form-control input-sm" required placeholder="<%=persona.getApeMaterno() %>" value="<%=persona.getApeMaterno() %>" />
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="sexo" class="col-sm-3 control-label">Sexo:</label>
									<div class="col-sm-9">
										<select size="1" name="sexo" id="sexo" class="form-control input-sm">
											<option value="Masculino">Masculino</option>
											<option value="Femenino">Femenino</option>
										</select>
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="estado_civil" class="col-sm-3 control-label">Estado
										Civil:</label>
									<div class="col-sm-9">
										<select size="1" name="estadocivil" id="estadocivil"
											class="form-control input-sm">
											<option value="S">Soltero</option>
											<option value="C">Casado</option>
											<option value="D">Divorciado</option>
										</select>
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="paisnacimiento" class="col-sm-3 control-label">Pais
										de Nacimiento:</label>
									<div class="col-sm-9">
										<select size="1" name="pais" id="pais" class="form-control input-sm">
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
											class="form-control input-sm" placeholder="<%=docente.getFecha_nacimiento() %>" value="<%=docente.getFecha_nacimiento() %>" >
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="combo_departamentos_1"
										class="col-sm-3 contro1-label">Departamento:</label>
									<div class="col-sm-9">
										<select id="combo_departamentos_1"
											class="form-control input-sm" name="departamento1" required>
											<option disabled="disabled">Seleccionar</option>
											<% for(int i=0; i<departamentos.size(); i++){
												String selected="";
												if(Integer.parseInt(departamentos.get(i).getCoddpto())==docente.getId_Departamento_nacionalidad())
													selected="selected";
											%>
											<option value="<%=departamentos.get(i).getCoddpto()%>" <%=selected%>><%=departamentos.get(i).getNombre()%></option>
											<% }%>
										</select>
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="combo_provincias_1" class="col-sm-3 contro1-label">Provincia</label>
									<div class="col-sm-9">
										<select id="combo_provincias_1" class="form-control input-sm" name="provincia1" required>
											<option disabled="disabled">Seleccionar</option>
										<% for(int i=0; i<provincias1.size(); i++){
											String selected="";
											if(Integer.parseInt(provincias1.get(i).getCodprov())==docente.getId_Provincia_nacionalidad())
												selected="selected";
										%>
											<option value="<%=provincias1.get(i).getCodprov() %>" <%=selected%>><%=provincias1.get(i).getNombre()%></option>
											<% }%>
										</select>
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="combo_distritos_1" class="col-sm-3 contro1-label">Distrito</label>
									<div class="col-sm-9">
										<select id="combo_distritos_1" class="form-control input-sm" name="distrito1">
											<option disabled="disabled">Seleccionar</option>
										<% for(int i=0; i<distritos1.size(); i++){
											String selected="";
											System.out.print(distritos1.get(i).getCoddist()+"-"+docente.getId_Distrito_nacionalidad());
											if(Integer.parseInt(distritos1.get(i).getCoddist())==docente.getId_Distrito_nacionalidad())
												selected="selected";
										%>
											<option value="<%=distritos1.get(i).getCoddist() %>" <%=selected%>><%=distritos1.get(i).getNombre()%></option>
								
											<% }%>
										</select>
									</div>
								</div>

							</fieldset>


							<fieldset>
								<legend align="left">Direccion</legend>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="combo_departamentos_2"
										class="col-sm-3 contro1-label">Departamento:</label>
									<div class="col-sm-9">
										<select id="combo_departamentos_2"
											class="form-control input-sm" name="departamento2">
											<option disabled="disabled">Seleccionar</option>
											<% for(int i=0; i<departamentos.size(); i++){
												String selected="";
												if(Integer.parseInt(departamentos.get(i).getCoddpto())==docente.getId_Departamento_direccion())
													selected="selected";
											%>
											<option value="<%=departamentos.get(i).getCoddpto()%>" <%=selected%>><%=departamentos.get(i).getNombre()%></option>
											<% }%>
										</select>
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="combo_provincias_2" class="col-sm-3 contro1-label">Provincia</label>
									<div class="col-sm-9">
										<select id="combo_provincias_2" class="form-control input-sm"
											name="provincia2">
											<option disabled="disabled">Seleccionar</option>
										<% for(int i=0; i<provincias2.size(); i++){
											String selected="";
											if(Integer.parseInt(provincias2.get(i).getCodprov())==docente.getId_Provincia_direccion())
												selected="selected";
										%>
											<option value="<%=provincias2.get(i).getCodprov() %>" <%=selected%>><%=provincias2.get(i).getNombre()%></option>
											<% }%>
										</select>
									</div>
								</div>
<!-- no se que hacer con este como box -->
								<div class="form-group">
									<label for="combo_distritos_2" class="col-sm-3 contro1-label">Distrito</label>
									<div class="col-sm-9">
										<select id="combo_distritos_2" class="form-control input-sm" name="distrito2">
											<option disabled="disabled">Seleccionar</option>
										<% for(int i=0; i<distritos2.size(); i++){
											String selected="";
											if(Integer.parseInt(distritos2.get(i).getCoddist())==docente.getId_Distrito_direccion())
												selected="selected";
										%>
											<option value="<%=distritos2.get(i).getCoddist() %>" <%=selected%>><%=distritos2.get(i).getNombre()%></option>
								
											<% }%>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="referencia" class="col-sm-3 contro1-label">Referencia:</label>
									<div class="col-sm-9">
										<input type="text" name="referencia"
											class="form-control input-sm" placeholder="<%=docente.getReferencia_direccion() %>" value="<%=docente.getReferencia_direccion() %>" />
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
									<% for(int i=0;i<telefonos.size();i++){ %>
									<tr>
									<td></td>
									<td><%=telefonos.get(i).getIdTelefono() %></td>
									<td><%=telefonos.get(i).getIdTelefono() %></td>
									<td><%=telefonos.get(i).getTelefono() %></td>
									</tr>
									<%} %>
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
									<% for(int i=0;i<emails.size();i++){ %>
									<tr>
									<td></td>
									<td><%=emails.get(i).getIdEmail()%></td>
									<td><%=emails.get(i).getIdEmail()%></td>
									<td><%=emails.get(i).getEmail()%></td>
									</tr>
									<%} %>
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
									<% for(int i=0;i<documentos.size();i++){ %>
									<tr>
									<td></td>
									<td><%=documentos.get(i).getIdDocumento()%></td>
									<td><%=documentos.get(i).getIdDocumento()%></td>
									<td><%
									String tipoDoc="Licencia de conducir";
									if(documentos.get(i).getTipo()=='1'){
										tipoDoc="DNI";}%><%=tipoDoc%></td>
									<td><%=documentos.get(i).getNumero()%></td>
									</tr>
									<%} %>
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
									<% for(int i=0;i<gradoAcademicos.size();i++){ %>
									<tr>
									<td></td>
									<td><%=gradoAcademicos.get(i).getIdGradoAcademico()%></td>
									<td><%=gradoAcademicos.get(i).getIdGradoAcademico()%></td>
									<%
									String especialidad="S.I";
									if(gradoAcademicos.get(i).getEspecialidad()=='1'){
										especialidad="T.I";}%>
									<td><%=gradoAcademicos.get(i).getGrado() %></td>
									<td><%=gradoAcademicos.get(i).getProfesion() %></td>
									<td><%=especialidad%></td>
									<td><%=gradoAcademicos.get(i).getNombreInstitucion() %></td>
									<td><%=gradoAcademicos.get(i).getFechaIngreso() %></td>
									</tr>
									<%} %>
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
	var estadoCivil="<%=docente.getEstado_civil() %>";
	var paisNacionalidad="<%=docente.getId_Pais_nacionalidad() %>";
	var sexodocente="<%=persona.getSexo() %>";
	$("#estadocivil").val(estadoCivil);
	$("#sexo").val(sexodocente);
	$("#pais").val(paisNacionalidad);
</script>
</body>
</html>