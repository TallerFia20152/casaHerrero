<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="java.util.Vector"%>
<%@page import="edu.usmp.fia.taller.common.bean.RegistroDocente.*"%>
<html lang="en">
<head>
<link href="css/boostrap/bootstrap.min.css" rel="stylesheet" />
<link href="css/boostrap/bootstrap-table.min.css" rel="stylesheet" />
 <link href="css/dashboard.css" rel="stylesheet" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <script src="js/bootstrap-table.min.js"></script>
 <script src="js/validator.min.js"></script>
 <script src="js/combos.js"></script>
 <script src="js/accionesRegistroDocentes.js"></script>
<title>Registro Docente</title>
	<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
</head>
<%
Vector<Dia> listaDias=(Vector)request.getAttribute("dias"); 
Vector<Hora> listaHoras=(Vector)request.getAttribute("horas");
%>
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
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form class="form-horizontal" data-toggle="validator" role="form" id="formDocente">
		<div class="row">
		
		<div class="col-md-6">
		<input type="hidden" name="f" value="guardarDocente" /> 
				
				<fieldset>
				<legend align="left">Docente</legend>
								
				<div class="form-group">
				<label for="nombres" class="col-sm-3 control-label"  >Nombres: </label>
				<div class="col-sm-9">
				<input type="text" name="nombres" class="form-control input-sm" required/>
				</div>
				</div>
				
				<div class="form-group">
				<label for="apellido_paterno" class="col-sm-3 control-label" >Apellido Paterno:</label>
				<div class="col-sm-9">
				 <input type="text" name="apellidopaterno" class="form-control input-sm" required/>
				 </div>
				 </div>
				 
				 <div class="form-group">
				<label for="apellido_materno" class="col-sm-3 control-label">Apellido Materno:</label>
				<div class="col-sm-9">
				 <input type="text" name="apellidomaterno" class="form-control input-sm" required/>
				 </div>
				 </div>
				 
				 
	              
				</fieldset>
				
				<fieldset>
				<legend align="left">Cursos Aptos a Dictar</legend>
				
				<div id="botones" >
					<dir class="col-xs-3">
						<button data-toggle="modal" href="#agregarCurso" type="button" class="btn btn-success btn-addItem" >Agregar Curso</button>
					</dir>
					<dir class="col-xs-8">
						<button type="button" class="btn btn-success btn-addItem" data-method="remove" data-table="cursosaptos">Eliminar Curso</button>
					 </dir>
				</div>
							
				
				
				<table  id="table_telefono" data-height="154" data-click-to-select="true">
				    <thead>
				    <tr>
				        <th data-field="state" data-checkbox="true"></th>
				        <th data-field="id" data-visible="false">Id</th>
				        <th data-field="id_local" data-visible="false">Id_local</th>
				        <th data-field="codigo">Codigo</th>
				        <th data-field="curso">Curso</th>
				    </tr>
				    </thead>
				</table>
			  
			  </fieldset>
			  
			  
			  
		</div>
		<div class="col-md-6">
				 		
				 		<fieldset>
				 		<legend align= "left">Horas Disponibles</legend>
				 		
				 		
				 <div class="form-group">
				 <label for="dias" class="col-sm-3 contro1-label">Dia de la Semana:</label>
				 <div class="col-sm-9">
				 <select size="1" class="form-control input-sm" name="dias">
	                	<%for(int i=0; i<listaDias.size(); i++){ %>
	                	<option value="<%=listaDias.get(i).getId() %>"><%=listaDias.get(i).getNombre() %></option>
	                    <%} %>
	                    </select>
	                    </div>
	                    </div>
	                            
	                            
	                            
	            <div id="Rangos" >
					<dir class="col-xs-5">
						 <label for="rangoinicio" class="col-sm-12 contro1-label">Rango Inicio:</label>
					<div>
					<select size="1" class="form-control input-sm" name="">
	                			<%for(int j=0; j<listaHoras.size(); j++){ %>
	                			<option value="<%=listaHoras.get(j).getId() %>"><%=listaHoras.get(j).getHorainicio() %></option> 
	                    		<%} %>
	                    	</select>
					</div>
					
					</dir>
					<dir class="col-xs-5">
					<label for="rangofin" class="col-sm-12 contro1-label">Rango Fin:</label>	
					 <div>
					 <select size="1" class="form-control input-sm" name="">
	                			<%for(int j=0; j<listaHoras.size(); j++){ %>
	                    		<option value="<%=listaHoras.get(j).getId() %>"><%=listaHoras.get(j).getHorafin() %></option>
	                    		<%} %>
	                    	</select>
					 </div>
					 </dir>
				</div>
				
	           <div id="label" class="col-sm-12 contro1-label">               
	            Puede agregar los rangos de disponibilidad que crea necesarios                
	           </div>                     
	                            
	           <div id="botones" >
					<dir class="col-xs-3">
						<button type="button" class="btn btn-success btn-addItem" data-method="append" data-table="rangoHoras">Agregar Rango</button>
					</dir>
					<dir class="col-xs-8">
						<button type="button" class="btn btn-success btn-addItem" data-method="remove" data-table="rangoHoras">Eliminar Rango</button>
					 </dir>
				</div>
							
				
				
				<table  id="table_telefono" data-height="154" data-click-to-select="true">
				    <thead>
				    <tr>
				        <th data-field="state" data-checkbox="true"></th>
				        <th data-field="id" data-visible="false">Id</th>
				        <th data-field="id_local" data-visible="false">Id_local</th>
				        <th data-field="dia">Dia</th>
				        <th data-field="rangoDisponibiblidad">Rango de Disponibilidad</th>
				    </tr>
				    </thead>
				</table>
	                    
	             
	              
	            
				 
				 
				 
		</fieldset>
			</div>
			<div class="form-group">
				 <input type="submit"value="Agregar" class="btn btn-primary">
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
	<!-- Inicio Modal Agregar Curso-->
		<div id="agregarCurso" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content" style="margin-top:50%;">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">AGREGAR CURSO</h4>
		      </div>
		      <div class="modal-body">
		        		
		        		
		        		
		        	<table data-search="true" id="table_telefono" data-height="154" data-click-to-select="true">
				    <thead>
				    <tr>
				        <th data-field="state" data-checkbox="true"></th>
				        <th data-field="id" data-visible="false">Id</th>
				        <th data-field="id_local" data-visible="false">Id_local</th>
				        <th data-field="codigo">Codigo</th>
				        <th data-field="curso">Curso</th>
				    </tr>
				    </thead>
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
		<div id="buscarDocenteModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content" style="margin-top:50%;">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">BUSCAR DOCENTE</h4>
		      </div>
		      <div class="modal-body">
		        		
		        		
		        		
		        	<table id="table_telefono" data-height="154" data-click-to-select="true">
				    <thead>
				    <tr>
				        <th data-field="state" data-checkbox="true"></th>
				        <th data-field="id" data-visible="false">Id</th>
				        <th data-field="id_local" data-visible="false">Id_local</th>
				        <th data-field="codigo">Codigo</th>
				        <th data-field="nombre">Nombre</th>
				        <th data-field="apellidopaterno">Apellido Paterno</th>
				        <th data-field="apellidomaterno">Apellido Materno</th>
				    </tr>
				    </thead>
				</table>	
		        		
		        		
		        		
		        		    
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>

		  </div>
		</div>
		<!-- Fin Modal buscarDocente-->
	
				<!-- Inicio Modal importar excel jose-->
		<div id="RegistrarDocenteModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content" style="margin-top:50%;">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">REGISTRAR DOCENTE</h4>
		      </div>
		      <div class="modal-body">
		        		    
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>

		  </div>
		</div>
		<!-- Fin Modal -->
				<script>
		var form =$('#formDocente');
		form.validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
			  
		  } else {
			  e.preventDefault();
			  var dataForm=form.serializeArray();
			  	/*console.log(dataTelefonos);
				dataForm.push(dataTelefonos);*/
			  console.log(dataForm);
			  $.ajax({
				  url: "<%=getServletContext().getContextPath() %>/Gestionar_Docente",
				  method: "POST",
				  data: dataForm,
				  dataType: "json",
				  
				}).done(function( departamentos ) {
					console.log(departamentos);
					
				});
		    // everything looks good!
		  }
		});
		
		function telefonoataPost(nombreTabla){
		var dataTelefonos=$('#table_'+nombreTabla).bootstrapTable('getData');
		dataTelefonos.each(function( index, filaTabla ) {
			
		});
			
		}
</script>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
</body>
</html>