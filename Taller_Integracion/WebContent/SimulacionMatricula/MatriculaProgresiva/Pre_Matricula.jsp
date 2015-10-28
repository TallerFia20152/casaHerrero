<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="java.util.List"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<title>Taller Proyectos</title>

	<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.9/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="js/dataTables.colResize.js"></script>

    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.9/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/responsive/1.0.7/js/dataTables.responsive.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/1.0.7/css/responsive.bootstrap.min.css">
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
						
		<h3>Cursos Preferibles</h3>

		<%
			List<Curso> listado = (List) request.getAttribute("listaCursoAptoPreferibles");
			String codigoAlumno= (String) request.getAttribute("codigoAlumno");
			if (listado.size()==0)
			{
		%>
			<div class="alert alert-danger"><strong>Lo sentimos</strong> No tiene cursos aptos</div>
		<%
			}
			else
			{
		%>
		<form id="formulario" action="<%=request.getContextPath()%>/GenerarPreMatricula" method="post">
		
		<p><input type="hidden" name="codigoAlumno" value="<%=codigoAlumno%>"></p>
		<p><input type="text" id="creditosMinimos" name="creditosMinimos" value="13"></p>
		<p><input type="text" id="creditosMaximos" name="creditosMaximos" value="13"></p>
		
			<table class="table table-bordered table-striped datatable" id="table-2">
				<thead>
					<tr>
						<th>SELECCIONAR CURSO</th>
						<th>CURSO</th>
						<th>CREDITO</th>
						<th>CICLO</th>
						<th>TIPO DE CURSO</th>
					</tr>
				</thead>
				
				<tbody>
					<%
						for(Curso curso:listado)
						{
					%>
					<tr>
						<td>
							<!--
							<div class="checkbox checkbox-replace">
								<input type="checkbox" class="tipo" id="chk-1" name="codigos" value="<%=curso.getCodigo()%>">
								<%=curso.getCodigo()%>							
							</div>
							-->
							<input type="checkbox" class="tipo" id="chk-1" name="codigos" value="<%=curso.getCodigo()%>">
								<%=curso.getCodigo()%>							
						</td>
						<td><%=curso.getCurso()%></td>						
						<td><%=curso.getCredito()%></td>						 
						<td><%=curso.getCiclo()%></td>
						<td><%=curso.getTipoCurso()%></td>
					</tr>
					<%	}
					%>
				</tbody>
			</table>
			<div class="row">
				<div class="col-md-12 opcion">					
					<p><input type="submit" id="boton" value="Registrar" class="btn btn-lg btn-black btn-icon icon-left hidden-print"></p>
				</div>
				<p>
			</div>
			<%	}
			%>
		</form>
	
		<script>
			var table;
	        $(document).ready(function () {
	            table = $('#table-2').DataTable({
	                "scrollY": "200px",
	                "scrollCollapse": true,
	                "paging": false,
	                "dom": 'Zlfrtip',
	                "ordering":false,
	            });
	        });
	    </script>
	    
		<script>
			var creditos=0;			
			var creditosMinimos=$('#creditosMinimos').value;
			var creditosMaximos=$('#creditosMaximos').value;
			console.log('creditosMinimos ' + creditosMinimos);
			
			$( document ).ready(function() {
				$('.tipo').change(function() {
						var abuelo = $( this ).parent().parent()[0];
						 var datos = table.row( abuelo ).data();					 
						 var credito = datos[2];
						 console.log("Credito "+ credito);
					if($(this).is(":checked")) {
						creditos = creditos + parseInt(credito);
						if(creditos>creditosMaximos){
							$(this).prop( "checked", false );
							creditos = creditos - parseInt(credito);
							alert("no puedes");
						}
					}
					else
					{
						creditos = creditos - parseInt(credito);						
					}
					
					console.log(creditos);
				});
				
				$('#formulario').submit(function(event) 
				{
					var creditosMinimos=$('#creditosMinimos').value;
					console.log('creditosMinimos ' + creditosMinimos);
					
					if(creditos<creditosMinimos)
					{
						alert('Debe de escoger un minimo de ' +creditosMinimos + 'y un maximo de ' + creditosMaximos);
						return false;
					}
				});
			});
		</script>
			
		<!-- Footer -->
		<jsp:include page="/resources/include/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/chat.jsp"></jsp:include>
</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>