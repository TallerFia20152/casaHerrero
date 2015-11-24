<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
	<link href="css/selectize.default.css" rel="stylesheet" type="text/css" />
	<link href="css/toastr.min.css" rel="stylesheet" type="text/css" />
	<link href="css/reporte.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery.blockUI.js" type="text/javascript"></script>
	<script src="js/toastr.min.js" type="text/javascript"></script>
	<script src="js/selectize.min.js" type="text/javascript"></script>
	<script src="js/selectizes/alumnoSelectize.js" type="text/javascript"></script>
	<script src="js/selectizes/cursoOrigenSelectize.js" type="text/javascript"></script>
	<script src="js/reporteConvalidacion.js" type="text/javascript"></script>
	
	<title>Taller Proyectos</title>
	
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
			
			 <h1 style="text-align: center">REPORTE DE CONVALIDACIONES</h1>
       		<div class="row">
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
							<table style="width: 100%">
								<tr id="datosalumno" style="height: 40px;width: 70%">
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
					<div class="col-md-8">
					 <h2 style='text-align:center;'>Convalidaciones</h2>
                	<table style="width: 100%;" class="table table-hover table-bordered ">
                    <thead>
                    <tr style="text-align:center;">
                    	<td colspan="2">UNIV. ORIGEN</td>
                    	<td colspan="2" >USMP</td>
                    </tr>
                        <tr style='text-align:center;font-size:14px;'>
                        	<th style="text-align: center">C&oacute;digo Univ. Origen</th>
                            <th style="text-align: center">Curso Univ. ORigen</th>
                            <th style="text-align: center">C&oacute;digo</th>
                            <th style="text-align: center">Curso</th>
<!--                             <th style="text-align: center">Nota</th> -->
                        </tr>
                    </thead>
                    <tbody id="convalidados" style="font-size:12px;">
                    </tbody>
                </table>
					
					</div>
       			<div class="col-md-4" >
<!-- 					<div style="position:fixed;"> -->
				<div id="navcur">
				
                <h2 style='text-align:center;'>No Convalidados</h2>
                <table style="width: 100%;" class="table table-hover table-bordered ">
                    <thead >
                    
                        <tr style='text-align:center;font-size:14px;'>
                            <th style="text-align: center">C&oacute;digo</th>
                            <th style="text-align: center">Curso</th>
                            
                            <th style="text-align: center">Nota</th>
                        </tr>
                    </thead>
                    <tbody id="cursosorigen" style="font-size:12px;">
                    </tbody>
                </table>
				<hr style="visibility:hidden;">
           
				
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