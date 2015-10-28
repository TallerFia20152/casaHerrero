<!DOCTYPE html>

<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Curso"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.CursoAptoProfesor"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Personaa"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Hora"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.Dia"%>

<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>

<%@page import="java.util.Vector"%>

<html lang="en">
<head>
<link
	href="<%=request.getServletContext().getContextPath() %>/RegistroDocente/css/boostrap/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getServletContext().getContextPath() %>/RegistroDocente/css/boostrap/bootstrap-table.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getServletContext().getContextPath() %>/RegistroDocente/css/dashboard.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/bootstrap-table.min.js"></script>
<script
	src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/validator.min.js"></script>
<script
	src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/combos.js"></script>
<script
	src="<%=request.getServletContext().getContextPath() %>/RegistroDocente/js/accionesRegistroDocentes.js"></script>

<title>Registro Docente</title>
<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
</head>
<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	//Persona oPersona = oUsuario.getPersona();
	Persona oPersona=oUsuario.getPersona();
%>
<%
Vector<Dia> listaDias=(Vector)request.getAttribute("dias"); 
Vector<Hora> listaHoras=(Vector)request.getAttribute("horas");
Vector<Personaa> listaDocentes=(Vector)request.getAttribute("docentes");
Vector<Curso> listaCursos=(Vector)request.getAttribute("cursos");
%>






<body class="page-body skin-red" style="padding-top: -0;">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>

			<!-- Contenido -->

			<div>
						<div id="botones">
				<div class="col-xs-4">
					<button type="button" class="btn btn-success btn-addItem"
						href="Gestionar_Docente?f=registrarDocente">Registrar
						Docente</button>
				</div>
				<div class="col-xs-5">
					<button data-toggle="modal" href="#buscarDocenteModal"
						type="button" class="btn btn-success btn-addItem">Buscar
						Profesor</button>
				</div>
			</div>
				<form class="form-horizontal" data-toggle="validator" role="form"
					id="formDocente">
					<div class="row">

						<div class="col-md-6">
							<input type="hidden" name="f" value="guardarDisponibilidadDocente" />

									<%if(request.getAttribute("docente")!=null){ 
									
									Personaa docente=new Personaa();
									docente=(Personaa)request.getAttribute("docente");
									System.out.println("llego el  docente id : "+docente.getIdPersona()+" "+docente.getNombre1());	
									%>


							<fieldset>
								<legend align="left">Docente</legend>
								
								<div class="form-group">
									<label for="codigo" class="col-sm-3 control-label">Codigo:
									</label>
									<div class="col-sm-9">
										<input type="hidden" name="profesor_id" value="<%=docente.getIdPersona() %>" />
										<input type="text"
											class="form-control input-sm" value="<%=docente.getIdPersona() %>" disabled />
									</div>
								</div>
								
								<div class="form-group">
									<label for="nombres" class="col-sm-3 control-label">Nombres:
									</label>
									<div class="col-sm-9">
										<input type="text" name="nombres"
											class="form-control input-sm" value="<%=docente.getNombre1() %>" disabled />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_paterno" class="col-sm-3 control-label">Apellido
										Paterno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidopaterno"
											class="form-control input-sm" value="<%=docente.getApePaterno() %>" disabled />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_materno" class="col-sm-3 control-label">Apellido
										Materno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidomaterno"
											class="form-control input-sm" value="<%=docente.getApeMaterno() %>" disabled />
									</div>
								</div>
							</fieldset>
					<%}else{%>
					<fieldset>
								<legend align="left">Docente</legend>
								
								<div class="form-group">
									<label for="codigo" class="col-sm-3 control-label">Codigo:
									</label>
									<div class="col-sm-9">
								
									
									
										<input type="text" name="codigo"
											class="form-control input-sm"  disabled />
									
									
								
									</div>
								</div>
								
								<div class="form-group">
									<label for="nombres" class="col-sm-3 control-label">Nombres:
									</label>
									<div class="col-sm-9">
										<input type="text" name="nombres"
											class="form-control input-sm"  disabled />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_paterno" class="col-sm-3 control-label">Apellido
										Paterno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidopaterno"
											class="form-control input-sm"  disabled />
									</div>
								</div>

								<div class="form-group">
									<label for="apellido_materno" class="col-sm-3 control-label">Apellido
										Materno:</label>
									<div class="col-sm-9">
										<input type="text" name="apellidomaterno"
											class="form-control input-sm"  disabled />
									</div>
								</div>

						

							</fieldset>
					<%} %>
							<%if(request.getAttribute("cursosAptos")!=null){ 
									

									Vector<CursoAptoProfesor> listaCursosAptos=(Vector)request.getAttribute("cursosAptos");
									
									System.out.println("llego el  cursos del servlet seleccionarcurso : ");	
									%>
							<fieldset>
								<legend align="left">Cursos Aptos a Dictar</legend>

								<div id="botones">
									<dir class="col-xs-3">
										<button data-toggle="modal" href="#agregarCurso" type="button"
											class="btn btn-success btn-addItem">Agregar Curso</button>
									</dir>
									<dir class="col-xs-8">
									<a class="btn btn-success btn-addItem" href="javascript:removeCursoApto('curso')" >Eliminar
											Curso</a>
									</dir>
								</div>



								<table id="table_curso" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id" data-visible="false"></th>
											<th data-field="codigo">Codigo</th>
											<th data-field="curso">Curso</th>
											<th data-field="funcion" data-visible="false"></th>
										</tr>
									</thead>
									<% for(int i=0; i<listaCursosAptos.size(); i++){ %>
										<tr>
											<td class="bs-checkbox">
											<input data-index="<%=i %>" name="btSelectItem" type="checkbox" checked="checked"></td>
											<td<%=listaCursosAptos.get(i).getCursoId() %>></td>
											<td><%=listaCursosAptos.get(i).getCursoId() %></td>	
											<td><%=listaCursosAptos.get(i).getCursoId() %></td>
											<td><%=listaCursosAptos.get(i).getNombre() %></td>	
										</tr>
									<% } %> 
								</table>

							</fieldset>

						<%}else{ %>
						<fieldset>
								<legend align="left">Cursos Aptos a Dictar</legend>

								<div id="botones">
									<dir class="col-xs-3">
										<button data-toggle="modal" href="#agregarCurso" type="button"
											class="btn btn-success btn-addItem">Agregar Curso</button>
									</dir>
									<dir class="col-xs-8">
										<a class="btn btn-success btn-addItem" href="javascript:removeCursoApto('curso')" >Eliminar
											Curso</a>
									</dir>
								</div>



								<table id="table_curso" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id" data-visible="false"></th>
											<th data-field="codigo">Codigo</th>
											<th data-field="curso">Curso</th>
											<th data-field="funcion" data-visible="false"></th>
										</tr>
									</thead>
								</table>

							</fieldset>
						<%} %>
						</div>
						<div class="col-md-6">

							<fieldset>
								<legend align="left">Horas Disponibles</legend>


								<div class="form-group">
									<label for="dias" class="col-sm-3 contro1-label">Dia de
										la Semana:</label>
									<div class="col-sm-9">
										<select size="1" class="form-control input-sm" id="cdias">
										<%System.out.print("llega aca?"); %>
											<%for(int i=0; i<listaDias.size(); i++){ %>
											<option value="<%=listaDias.get(i).getId() %>"><%=listaDias.get(i).getNombre() %></option>
											<%} %>
										</select>
									</div>
								</div>



								<div id="Rangos">
									<dir class="col-xs-5">
										<label for="rangoinicio" class="col-sm-12 contro1-label">Rango
											Inicio:</label>
										<div>
											<select size="1" class="form-control input-sm" id="rangoinicio">
												<%for(int j=0; j<listaHoras.size(); j++){ %>
												<option value="<%=listaHoras.get(j).getId() %>"><%=listaHoras.get(j).getHorainicio() %></option>
												<%} %>
											</select>
										</div>

									</dir>
									<dir class="col-xs-5">
										<label for="rangofin" class="col-sm-12 contro1-label">Rango
											Fin:</label>
										<div>
											<select size="1" class="form-control input-sm" id="rangofin">
												<%for(int j=0; j<listaHoras.size(); j++){ %>
												<option value="<%=listaHoras.get(j).getId() %>"><%=listaHoras.get(j).getHorafin() %></option>
												<%} %>
											</select>
										</div>
									</dir>
								</div>

								<div id="label" class="col-sm-12 contro1-label">Puede
									agregar los rangos de disponibilidad que crea necesarios</div>

								<div id="botones">
									<dir class="col-xs-3">
										<button type="button" class="btn btn-success btn-addItem"
											data-method="append" data-table="rangoHoras">Agregar
											Rango</button>
									</dir>
									<dir class="col-xs-8">
										<button type="button" class="btn btn-success btn-addItem"
											data-method="remove" data-table="rangoHoras">Eliminar
											Rango</button>
									</dir>
								</div>



								<table id="table_rangoHoras" data-height="154"
									data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="id" data-visible="false">Id</th>
											<th data-field="id_local" data-visible="false">Id_local</th>
											<th data-field="dia">Dia</th>
											<th data-field="diaL" data-visible="false"></th>
											<th data-field="horaInicio">Hora inicio</th>
											<th data-field="horaInicioL" data-visible="false"></th>
											<th data-field="horaFin">Hora termino</th>
											<th data-field="horaFinL" data-visible="false"></th>
										</tr>
									</thead>
								</table>

						</fieldset>
						<div class="form-group" id="msj1" style="display: none">
						<br />
						<div class="alert alert-success" role="alert" id="msj2"></div>
						</div>
						<div class="form-group">
							<input type="submit" value="Registrar Disponibilidad" class="btn btn-primary">
						</div>
					</div>
						
					</div>
				</form>
			</div>
			<!-- Fin contenido -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
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
			dataForm=campoCursosDinamicosPost(dataForm,"curso");
			dataForm=campoHorasDinamicosPost(dataForm,"rangoHoras");
			
			  $.ajax({
				  url: "<%=getServletContext().getContextPath() %>/Disponibilidad_Docente",
				  method: "POST",
				  data: dataForm,
				  dataType: "json",
				  
				}).done(function( respuesta ) {
					console.log(respuesta);
					if(respuesta.exito){
						//resetearFormulario(form);
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
			$("#table_curso").bootstrapTable('load', []);
			$("#table_rangoHoras").bootstrapTable('load', []);
		}
		
		function campoCursosDinamicosPost(dataForm,campo){
			var dataTable=$('#table_'+campo).bootstrapTable('getData');
			var nuevoCampo=[];
			  $.each( dataTable, function( key, value ) {
				  nuevoCampo.push({
					  "id": value.id,
					  "curso_id":value.codigo
				    });
				});
			  dataForm.push({name:"json_"+campo,value:JSON.stringify(nuevoCampo)});
			  return dataForm;
		}

		function campoHorasDinamicosPost(dataForm,campo){
			var dataTable=$('#table_'+campo).bootstrapTable('getData');
			var nuevoCampo=[];
			  $.each( dataTable, function( key, value ) {
				  nuevoCampo.push({
					  "id": value.id,
					  "dia":value.diaL,
					  "horaInicio":value.horaInicioL,
					  "horaFin":value.horaFinL
				    });
				});
			  dataForm.push({name:"json_"+campo,value:JSON.stringify(nuevoCampo)});
			  return dataForm;
		}
</script>
	<!-- Inicio Modal Agregar Curso-->
	<div id="agregarCurso" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content" style="margin-top: 10%;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title "  >AGREGAR CURSO</h4>
				</div>
				<div class="modal-body">



					<table data-search="true" id="table_curso_modal" data-height="250"
						data-click-to-select="true">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="id" data-visible="false"></th>
								<th data-field="codigo">Codigo</th>
								<th data-field="curso">Curso</th>
								<th data-field="funcion"></th>
							</tr>
						</thead>
						
						<% for(int i=0; i<listaCursos.size(); i++){ %>
							<tr>
								<td></td>
								<td>-1</td>
								<td><%=listaCursos.get(i).getId() %></td>
								<td><%=listaCursos.get(i).getNombre() %></td>
								<td><a href="javascript:addCursoApto('curso')" >Agregar</a></td>								
							</tr>
						<% } %> 
					</table>




				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- Fin Modal Agregar Curso-->




	<!-- Inicio Modal buscarDocente-->
	<div id="buscarDocenteModal" class="modal fade" role="dialog"  >
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content" style="margin-top: 10%;" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">BUSCAR DOCENTE</h4>
				</div>
				<div class="modal-body">



					<table data-search="true" id="table_telefono" data-height="250"
						data-click-to-select="true">
						<thead>
							<tr>
								
								<th>Codigo</th>
								<th>Nombre</th>
								<th>Apellido Paterno</th>
								<th>Apellido Materno</th>
								<th></th>
							</tr>
						</thead>
						<% for(int i=0; i<listaDocentes.size(); i++){ %>
							<tr>
							
								<td><%=listaDocentes.get(i).getIdPersona() %></td>
								<td><%=listaDocentes.get(i).getNombre1() %></td>
								<td><%=listaDocentes.get(i).getApePaterno() %></td>
								<td><%=listaDocentes.get(i).getApeMaterno() %></td>
								<td><a href="Gestionar_Docente?f=SeleccionarDocente&dato=<%=listaDocentes.get(i).getIdPersona() %>")>Seleccionar</a></td>
							</tr>
						<% } %> 
					</table>




				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- Fin Modal buscarDocente-->


</body>
</html>