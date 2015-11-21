<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<title>Taller Proyectos</title>
	<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
</head>

<body class="page-body skin-red">

<div class="page-container">
	<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>	

	<div class="main-content">
		<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>
		<hr />
			<ol class="breadcrumb bc-3" >
				<li>
					<a href="index.html"><i class="fa-home"></i>Inicio</a>
				</li>
				<li>
					<a href="ui-panels.html">Simulacion</a>
				</li>
				<li class="active">
					<strong>Reporte de Cruces</strong>
				</li>
			</ol>		
		
		<h3>REPORTE DE CRUCES</h3>
		<br />
				
		
		<div class="row">
		
			<div class="col-md-12">
			
				<div class="tabs-vertical-env">
				
					<ul class="nav tabs-vertical"><!-- available classes "right-aligned" -->
						<li class="active"><a href="#v-home" class="principal"  data-toggle="tab" id="1"><strong>CICLO 1</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="2"><strong>CICLO 2</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="3"><strong>CICLO 3</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="4"><strong>CICLO 4</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="5"><strong>CICLO 5</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="6"><strong>CICLO 6</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="7"><strong>CICLO 7</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="8"><strong>CICLO 8</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="9"><strong>CICLO 9</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="10"><strong>CICLO 10</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="11"><strong>ELECTIVOS</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="12"><strong>ELECTIVOS</strong></a></li>
						<li><a href="#v-home" class="principal" data-toggle="tab" id="13"><strong>ELECTIVOS</strong></a></li>
					</ul>
					
					<div class="tab-content">
						<div class="tab-pane active" id="v-home">

							<table class="table responsive" id="tablaReporte">

								<thead>
									<tr>
										<th><center><STRONG>CURSO</STRONG></center></th>
										<th><center><STRONG>SECCION</STRONG></center></th>
										<th><center><STRONG>CURSO CRUCE</STRONG></center></th>
										<th><center><STRONG>SECCION CRUCE</STRONG></center></th>
										<th><center><STRONG>CICLO</STRONG></center></th>
										<th>
											<center>
												<STRONG>CANTIDAD</STRONG>
											</center>
										</th>
									</tr>
								</thead>
								<tbody>									
								
								</tbody>
								
							</table>
						</div>
						<div class="tab-pane" id="v-profile">
							<p>Fulfilled direction use continual set him propriety continued. Saw met applauded favourite deficient engrossed concealed and her. Concluded boy perpetual old supposing. Farther related bed and passage comfort civilly. Dashwoods see frankness objection abilities the. As hastened oh produced prospect formerly up am. Placing forming nay looking old married few has. Margaret disposed add screened rendered six say his striking confined. </p>
						</div>						
					</div>
					
				</div>	
			
			</div>

		</div>		
		<jsp:include page="/resources/include/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/chat.jsp"></jsp:include>
</div>
<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
	<script type="text/javascript">
	
		function getContextPath() {
		   return "${pageContext.request.contextPath}";
		}
	
		function VerificarCruceCiclo(ciclo)
		{
			console.log('RUTA GENERAL '+  getContextPath());
			
			tablaReporte.clear();
			
			 $.ajax({
	                url: "../ReporteCiclo",
	                async:false,
	                data: {'ciclo':ciclo},
	                dataType: 'json',
	                method: 'POST',
	                success: function (datos) {
	                	
	                	console.log(datos);
	                	
	                	if (datos!=null)
	                	{
							for (var i=0;i<datos.length;i++)
							{							
								tablaReporte.row.add( [							 		         
									 		           	'<center><strong><font color="blue">'+ datos[i].mCurso+'</font><strong></center>',
									 		          	'',
									 		         	'',
									 		        	'',
									 		       		'',
									 		      		'',							 		           
									 		        ] ).draw(false);
								
								console.log(datos[i].mCodigo)
								
								//OBTIENE LOS CRUCES DE LOS CURSOS
								ObtenerCrucesCursos(datos[i].mCodigo);							
	
								tablaReporte.row.add( [							 		         
									 		           	'',
									 		          	'',
									 		         	'',
									 		        	'',
									 		       		'',
									 		      		'',							 		           
									 		        ] ).draw(false);
							}
	                	}
	                	else
	                	{
	                		console.log('NO HAY DATOS');
	                	}
	                }
	            });	
		}
		
		function ObtenerCrucesCursos(codigo)
		{
			$.ajax({
				url: "../CruceXCiclo",
	            async:false,
	            data: {'codCurso':codigo},
	            dataType: 'json',
	            method: 'POST',
	            success: function (datos) {
	            	
	            	console.log(datos);
					for (var i=0;i<datos.length;i++)
					{						
						//OBTIENE LOS CRUCES DE LOS CURSOS
						 tablaReporte.row.add( [							 		         
							 		           	'<center></center>',
							 		            '<center>' + datos[i].mSeccion1 +'<center>',
							 		          	'<center>' + datos[i].mCurso2 +'<center>',
							 		         	'<center>' + datos[i].mSeccion2 +'<center>',
							 		         	'<center>' + datos[i].mCiclo2 +'<center>',
							 		         	'<center>' + datos[i].mCantidadCruce +'<center>',							 		           
							 		        ] ).draw(false);									
						}							                    
	            	}
		});	
	}
	</script>
	
	<script type="text/javascript">	
		
		var tablaReporte;
		
		
		$(document).ready(function() 
		{
			tablaReporte = $('#tablaReporte').DataTable({
				"paging" : false,
				"ordering" : false,
				"bFilter": false, 
				"bInfo": false,
			});			
	
			VerificarCruceCiclo(1);
		});
	
		$('.principal').click(function (event){ 
	     event.preventDefault(); 
	     var ciclo = $(this).attr('id')
	     
	     if (ciclo!==undefined)
	    {
	    	 //alert('INGRESO ' + ciclo);	    	 
	    	 VerificarCruceCiclo(ciclo); 	 
	    }
	     
		});
	</script>
	
</body>
</html>