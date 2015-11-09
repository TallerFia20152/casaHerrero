<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Seccion"%>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="java.util.List"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page
	import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Taller Proyectos</title>
<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="SimulacionMatricula/css/Simulacion.css">
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

			<%
				
				List<Curso> listado = (List) request.getAttribute("listadoCursos");
				if (listado.size() == 0) 
				{
			%>
			<div class="row">

				<div class="col-md-12">
					<div class="alert alert-danger">
						<strong>Lo sentimos</strong> No a seleccionado sus cursos preferibles
					</div>
				</div>
			</div>
			
			<%
				} else {
			%>
			
		
			<form id="formulario"
						action="<%=request.getContextPath()%>/RegistrarHorarios" method="post">
			<div class="row">
			
			<%
				for(Curso curso:listado)
				{
				%>
				CODIGOS: <input style='border-color:white;' type="text" name="codigos" value="<%=curso.getCodigo()%>">
				 <br/>
				
			<% 
				}
			 %> 
			
				
				<div class="col-md-12">
					<h4>Cruces</h4>
						<table class="table table-bordered table-striped datatable"
							id="tablaCruce">
							<thead>
								<tr>
									<th>CODIGO</th>
									<th>CURSO</th>
									<th>SECCION</th>
									<th>CODIGO</th>
									<th>CURSO</th>
									<th>SECCION</th>							
								</tr>
							</thead>
							<tbody>
																
							</tbody>
						</table>
				</div>
			</div>	
			
			
			<div class="row">
				<h3>Seleccionar Horarios</h3>
				<div class="col-md-12">					
						<table class="table table-bordered table-striped datatable"
							id="table-2">
							<thead>
								<tr>
									<th>CODIGO</th>
									<th>CURSO</th>
									<th>CICLO</th>
									<th>CREDITO</th>
									<th>SECCION</th>
									<th>DIA</th>
									<th>HORA INICIO</th>
									<th>HORA FIN</th>
									<th>DIA</th>
									<th>HORA INICIO</th>
									<th>HORA FIN</th>
									
								</tr>
							</thead>
							<tbody>
								<%
									for(Curso curso:listado)
									{
									%>									 
								<tr>									
									<td><%=curso.getCodigo()%></td>
									<td><%=curso.getCurso()%></td>									
									<td><%=curso.getCiclo()%></td>
									<td><%=curso.getCredito()%></td>
									<td>										
										<select class="form-control" name="seccion" id="<%=curso.getCodigo()%>" required>
										<option></option>
										<%
											for(Seccion seccion1:curso.getSeccion())
											{
										%>
											<option><%=seccion1.getDescripcion()%></option>											
										<%
											}
										%>
										</select>
									</td>
									<td></td>
									<td></td>
									<td></td>	
									<td></td>
									<td></td>
									<td></td>													
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<div class="row">
							<div class="col-md-12 opcion">							
								<p>
									<!-- 
									<a href="javascript:;" onclick="jQuery('#modal-6').modal('show', {backdrop: 'static'});" class="btn btn-primary">Informar Cruces</a>
									 -->
									<input type="submit" id="boton" value="Registrar"
										class="btn btn-black">
								</p>
							</div>
							<p>
						</div>
						<%
							}
						%>
					
				</div>
			</div>
			</form>
			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
	<script>
		var table;
		var fila;
		var json;
		var cruce="";
		var tablaCruce;
		
		
		$(document).ready(function() {
			table = $('#table-2').DataTable({
				"paging" : true,
				"ordering" : false,
			});
			
			tablaCruce= $('#tablaCruce').DataTable();
		});
	</script>
	
	<script type="text/javascript">		
		$("select").click(function() {
			var codCurso= $(this).attr("id");

        	$( '#'+ codCurso ).change(function() {        		  
        		  var seccion = $(this).val();        		  
              		
					//OBTENER FILA Y COLUMNA              	  
	              	
	              		$.ajax({					
	        				url:"BuscarHorasSecciones",
	        		      	datatype:'json',
	        		      	method:'Post',
	        		      	data:{
	  			      		  'codCurso':codCurso,
	  			      		  'seccion':seccion,
	  			      		  },
	  	               		async:false,
	        				success : function(horasSeccion) 
	        				{		
	        					$('td').click(function(){
	        		          		fila = $(this).parent().parent().children().index($(this).parent());
	        		          		//var col = $(this).parent().children().index($(this));
	        					});	
	        						        					  
	        					  if(horasSeccion.length==0)
	        						{
	        						  table.cell(fila,5).data('');
	        						  table.cell(fila,6).data('');
	        						  table.cell(fila,7).data('');			  
	        						  table.cell(fila,8).data('');
	        						  table.cell(fila,9).data('');
	        						  table.cell(fila,10).data('');
	        						  return;
	        						}
	        						
	        						if(horasSeccion.length==1)
	        						{
	        						  table.cell(fila,5).data(horasSeccion[0].mDia);
		        					  table.cell(fila,6).data(horasSeccion[0].mHoraInicio);
									  table.cell(fila,7).data(horasSeccion[0].mHoraFin);			  
	        						}
	        						else
	        						{
	        						  table.cell(fila,5).data(horasSeccion[0].mDia );
	        						  table.cell(fila,6).data(horasSeccion[0].mHoraInicio );
	        						  table.cell(fila,7).data(horasSeccion[0].mHoraFin);			  
	        						  table.cell(fila,8).data(horasSeccion[1].mDia );
	        						  table.cell(fila,9).data(horasSeccion[1].mHoraInicio );
	        						  table.cell(fila,10).data(horasSeccion[1].mHoraFin);				
	        						}
	        						json=null;
	        						json=CrearJsonDataTable();	        						
	        						tablaCruce.clear();
	        						Verificar();      						
	        				}
	        			});	
	        		});
        	
	        	toastr.options = {
	                    "timeOut": 4000,
	                    newestOnTop: true,
	                    hideDuration: 2000,
	                    "extendedTimeOut": 5000,
	                    "closeButton": true,
	                    "positionClass": "toast-bottom-right",
	                    "debug": false,
	                    "tapToDismiss": false
	        	 };
	        });
			
		function ObtenerFilaColumna()		
		{
			$('td').click(function(){
          		fila = $(this).parent().parent().children().index($(this).parent());
          		//var col = $(this).parent().children().index($(this));
			});		
		}
		
		
		function evaluarCursoCruce(diUno, diDos,indice) {
		    for (var j = 0; j < json.length; j++) {
		        if (indice != j) {
		        	
		            var djUno = generarDia(json[j].Dia1, DevolverMinutos(json[j].HoraInicio1), DevolverMinutos(json[j].HoraFinal1), json[j].NombreCurso,json[j].CodCurso,json[j].Seccion);
		            var djDos = generarDia(json[j].Dia2, DevolverMinutos(json[j].HoraInicio2), DevolverMinutos(json[j].HoraFinal2), json[j].NombreCurso,json[j].CodCurso,json[j].Seccion);
					
		            comparar(diUno, djUno);        	
		            comparar(diUno, djDos);		            
		            comparar(diDos, djUno);
		            comparar(diDos, djDos);
		            
		            //LimpiarDatosTablaVacia();
		            
		        }
		    }
		}	

		function LimpiarDatosTablaVacia(){
			
			var codCurso;
			var cantidad=0;
			
			$('#tablaCruce tr').each(function () {				
				codCurso = $(this).find("td").eq(0).html();
				
				if (codCurso=="")
				{
					var row = $(this).closest("tr").get(cantidad);
					tablaCruce.fnDeleteRow(tablaCruce.fnGetPosition(row));
				}
				cantidad++;				
			});
		}
		
		function DevolverMinutos(tiempo) {
			if(tiempo!="")
			{
			    var hora = parseInt(tiempo.substr(0, tiempo.indexOf(':')));
			    var minuto = parseInt(tiempo.substr(tiempo.indexOf(':') + 1, tiempo.length));
			    return hora*60 + minuto;
			}
			else
			{
				return 0;
			}
		    
		}

		function comparar(dia1, dia2) {
		    
			console.log('dia1 ' + dia1.nombre);
			console.log('dia2 ' + dia2.nombre);
		    if (dia1.nombre == dia2.nombre) {
		        if (dia1.horai < dia2.horai) {
		            if (!(dia2.horai >= dia1.horaf)) {
		                console.log("hay cruce entre " + dia1.curso + " y " + dia2.curso);		             
		                
		                //toastr["error"]('<center>El horario selecionado tiene cruces con los siguientes Cursos</center><br/><center>'+ cruce+'</center>' );
    					
    					console.log(dia1);
		                VerficarTablaCruce(dia1.curso,dia2.curso);
				        
				        //toastr["error"]('<center>El horario selecionado tiene cruces con los siguientes Cursos</center><br/><center>' + dia1.curso + " y " + dia2.curso +'</center>' );
				        
		                return true;
		            } else {
		            	//toastr["info"]("<center>Horario escogido sin cruce</center>");
		                return false;
		            }
		        } else {
		            if (!(dia1.horai >= dia2.horaf)) {
		                console.log("hay cruce entre " + dia1.curso + " y " + dia2.curso);
		                //cruce=cruce+ dia1.curso + " y " + dia2.curso+"<br/>"
		                
		                VerficarTablaCruce(dia1,dia2);               
		                return true;

		            } else {
		            	//toastr["info"]("<center>Horario escogido sin cruce</center>");  
		                return false;
		            }
		        }
		    }
		}
		
		function VerficarTablaCruce(dia1,dia2)
		{
			var codCurso1;
			var codCurso2;
			var nomCurso1;
			var trDelResultado;
			var existe1;
			var existe2;
			existe1=0;
			existe2=0;
						
			console.log($('#tablaCruce >tbody >tr').length);
			/* DIA 1*/
			$("#tablaCruce tr").find('td:eq(0)').each(function () {
				 codCurso1 = $(this).html();
 
                  //comparamos para ver si el código es igual a la busqueda
                  if(codCurso1==dia1.codigo){
						trDelResultado=$(this).parent();                        
                         
                         //CURSO 2
                         $("#tablaCruce tr").find('td:eq(2)').each(function () {
            				 codCurso2 = $(this).html();
                              if(codCurso2==dia2.codigo){             
                                    existe1= 1;             
                              }                        
	                  	})
                  }
 
          })
          /* DIA 2*/
          $("#tablaCruce tr").find('td:eq(2)').each(function () {
				 codCurso1 = $(this).html();
				 console.log('codCurso1 ' +codCurso1);
 
                  //comparamos para ver si el código es igual a la busqueda
                  if(codCurso1==dia1.codigo){
						trDelResultado=$(this).parent();                        
                         
                         //CURSO 2
                         $("#tablaCruce tr").find('td:eq(0)').each(function () {
            				 codCurso2 = $(this).html();
            				 console.log('codCurso2 ' +codCurso2);
            				 codCurso2=trDelResultado.find("td:eq(2)").html();
            				 
            				 console.log('codCurso2 2 ' +codCurso2);
             
                              //comparamos para ver si el código es igual a la busqueda
                              if(codCurso2==dia2.codigo){             
                            	  existe2= 1;             
                              }                        
	                  	})
                  }
 
          })
          
			
			if (existe1!=1 && existe2!=1)
			{
				if ($('#tablaCruce >tbody >tr').length > 0){
					if(dia1.codigo!="" && dia1.codigo!==undefined)
					{
						tablaCruce.row.add( [
							 		           '<input type="text" class="form-control" name="codCursoCruce1" value="'+dia1.codigo+'">',
							 		           '<input type="text" class="form-control"name="seccionCruce1" value="'+dia1.curso+'">',
							 		           '<input type="text" class="form-control"name="seccionCruce1" value="'+dia1.seccion+'">',							 		           
							 		           '<input type="text" class="form-control" name="codCursoCruce2" value="'+dia2.codigo+'">',
							 		          '<input type="text" class="form-control"name="seccionCruce2" value="'+dia2.curso+'">',
							 		           '<input type="text" class="form-control"name="seccionCruce1" value="'+dia2.seccion+'">',
							 		        ] ).draw( false );
						
						toastr["error"]('<center>El horario selecionado tiene cruces con los siguientes Cursos</center><br/><center>' + dia1.curso + " y " + dia2.curso+'</center>' );
					}
				}				
			}
			
		}
		
		function generarDia(nombre,horai,horaf,curso,codigo,seccion){
		    var dia ={
		        "nombre":nombre,
		        "horai": horai,
		        "horaf": horaf,
		        "curso":curso,
		        "codigo":codigo,
		        "seccion":seccion,
		    }
		    return dia;
		}		
		
		function CrearJsonDataTable()
		{
			var arrayList=[];			
			var cant=0;
			var cursoObjeto;
			
			$('#table-2 tr').each(function () {				
				
				if(cant>0)
				{
					codigoCurso= $(this).find("td").eq(0).html();
					nomCurso= $(this).find("td").eq(1).html();
					
					dia1 = $(this).find("td").eq(5).html();	
					
					seccion=$("#"+codigoCurso).val();									
					
					if(seccion!="" &&  seccion!== undefined)
					{
						horaInicio1= $(this).find("td").eq(6).html();
						horaFin1 = $(this).find("td").eq(7).html();

						dia2 = $(this).find("td").eq(8).html();
						
						if(dia2!="" &&  dia2!== undefined)
						{
							horaInicio2= $(this).find("td").eq(9).html();
							horaFin2 = $(this).find("td").eq(10).html();
						}
						else
						{
							horaInicio2= "";
							horaFin2 = "";
						}										
						cursoObjeto = new Curso(codigoCurso,nomCurso, dia1, horaInicio1,horaFin1,dia2,horaInicio2,horaFin2,seccion);
						arrayList.push(cursoObjeto);
					}
				}				
				cant=cant+1;
			});

			var jsonData = JSON.stringify(arrayList);
			var javascriptObject = JSON.parse(jsonData);			
			return javascriptObject;			
		}
				
		function Curso(codCurso,nombreCurso,dia1,horaInicio1,horaFinal1,dia2,horaInicio2,horaFinal2,seccion){			
			this.CodCurso=codCurso;
			this.Seccion = seccion;
			this.NombreCurso=nombreCurso;
			this.Dia1 = dia1;
		    this.HoraInicio1 = horaInicio1;
		    this.HoraFinal1 = horaFinal1;
		    this.Dia2 = dia2;
		    this.HoraInicio2 = horaInicio2;
		    this.HoraFinal2 = horaFinal2;
		    
		}	
		
		function Verificar()
		{
			 console.log(json);
			 for (var i = 0; i < json.length; i++) {		       
		       var diUno = generarDia(json[i].Dia1, DevolverMinutos(json[i].HoraInicio1), DevolverMinutos(json[i].HoraFinal1), json[i].NombreCurso,json[i].CodCurso,json[i].Seccion);
	           var diDos = generarDia(json[i].Dia2, DevolverMinutos(json[i].HoraInicio2), DevolverMinutos(json[i].HoraFinal2), json[i].NombreCurso,json[i].CodCurso,json[i].Seccion);
		       
		       evaluarCursoCruce(diUno, diDos, i);
			 }
		}
		
					
	</script>
	
</body>
</html>
