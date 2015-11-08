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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">


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

			<h3>Seleccionar Horarios</h3>
			
			 <select id="mySelect">
			    <option value="1">option A</option>
			    <option value="2">option B</option>
			</select>
			<br/>
			 
			<span id="iSelected">Hola</span>
			
			
			<div class="row">

				<div class="col-md-12">
					<form id="formulario"
						action="<%=request.getContextPath()%>/RegistrarHorarios" method="post">
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
									<th><center>HORA INICIO</center></th>
									<th><center>HORA FIN</center></th>
									<th>DIA</th>
									<th>HORA INICIO</th>
									<th>HORA FIN</th>
									
								</tr>
							</thead>
							<tbody> 
							
							</tbody>
						</table>
						<div class="row">
							<div class="col-md-12 opcion">							
								<p>
									<input type="submit" id="boton" value="Registrar" class="btn btn-black">
								</p>
							</div>
							<p>
						</div>
					</form>
				</div>
			</div>		

			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
	<script>
		$( document ).ready(function() {
    	console.log( "ready2!" );
		   
			$.ajax({				
				url:"SeleccionaHorarios",
		      	datatype:'json',
		      	method:'Post',		     
				success : function(cursoPreferible1) 
				{					
					var t = $('#table-2').DataTable();					
					console.log(cursoPreferible1.length);
					console.log(cursoPreferible1);
					for(var i=0;i<cursoPreferible1.length;i++){
						t.row.add( [
						             '<center>' +cursoPreferible1[i].mCodigo+'</center>',
						             '<center>' +cursoPreferible1[i].mCurso+'</center>',
						             '<center>' +cursoPreferible1[i].mCiclo+'</center>',
						             '<center>' +cursoPreferible1[i].mCredito+'</center>',
						             '<center>' +llenarSeccion(cursoPreferible1[i].mSeccion)+'</center>',
						             '',
						             '',
						             '',
						             '',
						             '',
						             '',
						        ] ).draw( false );
					}
					//console.log('PASO SERVLET');
				}
			});		   
		});
		function llenarSeccion(jsonSeccion){
			 
		  	var cad=  '<select id="mySelect" name="seccion">';
		    var cad1= '<option></option>';
		 	var cad2 = '</select>';
			var option='';			
			for(var i=0;i<jsonSeccion.length;i++){
				option = option + '<option>'+jsonSeccion[i].mDescripcion+'</option>';
			}
			
			var cad3 = cad+ cad1 + option + cad2;
			//console.log(cad3);
			return cad3;			
		}
		
				
		
		/*
		
		var table = $('#table-2').DataTable();
		
	    $('#table-2 tbody').on( 'click', 'tr', function () {	
	    	/*
			var datos = table.row(this).data();
			console.log( table.row( this ).data() );
			console.log( datos);
			
			var abuelo = $(this).parent().parent()[0];
			var datos = table.row(abuelo).data();
			var credito = datos[1];
			console.log("Credito "+ credito);
			*/
			/*
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	    } );
	    	*/ 	    
	</script>	
	
	<script type="text/javascript">
	
	$('#mySelect').change(function(){
	    var $selectedOption = $(this).find('option:selected');
	    var selectedLabel = $selectedOption.text();
	    var selectedValue = $selectedOption.val();
	    $('#iSelected').text(selectedValue + ' - ' + selectedLabel);
	});
	
	</script>
</body>
</html>