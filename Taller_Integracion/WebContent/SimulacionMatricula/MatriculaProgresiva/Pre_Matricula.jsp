<!DOCTYPE html>
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
				List<Curso> listadoProable = (List) request.getAttribute("listaCursoProbables");			
				if (listado.size() == 0) {
			%>
			<div class="alert alert-danger">
				<strong>Lo sentimos</strong> No tiene cursos aptos
			</div>
			<%
				} else {
			%>
				<div class="row">
						<div class="col-md-12">
							<form id="formulario"
								action="<%=request.getContextPath()%>/GenerarPreMatricula"
								method="post">
								<p>
									<input type="hidden" id="creditosMinimos"
										name="creditosMinimos" value="16">
								</p>
								<p>
									<input type="hidden" id="creditosMaximos"
										name="creditosMaximos" value="23">
								</p>
								<p ALIGN=right>
									<strong>Cantidad de Creditos Seleccionado : </strong><label
										id="cantCreditos"><font color="red"><strong>0</strong></font></label>
								</p>

								<table class="table table-bordered table-striped datatable"
									id="table-2">
									<thead>
										<tr>
											<th>SELECCIONAR CURSO</th>
											<th>CURSO</th>
											<th>CREDITO</th>
											<th>CICLO</th>
											<th>TIPO DE CURSO</th>
											<th>CURSO PROBABLE</th>
										</tr>
									</thead>

									<tbody>
										<%
											for (Curso curso : listado) {
										%>
										<tr>
											<td>
											 <input type="checkbox" class="tipo" id="chk-1" name="codigos"
												value="<%=curso.getCodigo()%>"> <%=curso.getCodigo()%>
											</td>
											<td><%=curso.getCurso()%></td>
											<td><%=curso.getCredito()%></td>
											<td><%=curso.getCiclo()%></td>
											<td><%=curso.getTipoCurso()%></td>
											<td>
												<%
													for (Curso cursoProbable : listadoProable) {
																if (curso.getCodigo().equalsIgnoreCase(cursoProbable.getCodigo())) {
												%> <font color="red">PROBABLE</font> <%
 												}
 											}
 											%>
											</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
								<div class="row">
									<div class="col-md-12 opcion">
										<p>
											<input type="submit" id="boton" value="Registrar"
												class="btn btn-lg btn-black btn-icon icon-left hidden-print">
										</p>
									</div>
									<p>
								</div>
								<%
									}
								%>
							</form>
						</div>
					</div>

					<script>
						var table;
						$(document).ready(function() {
							table = $('#table-2').DataTable({
								"paging" : true,
								"ordering" : false,
							});
						});
					</script>

					<script>
						var creditos = 0;

						var creditosMinimos = $('#creditosMinimos').attr('value');
						console.log('creditosMinimos ' + creditosMinimos);

						var creditosMaximos = $('#creditosMaximos').attr('value');
						console.log('creditosMaximos ' + creditosMaximos);

						$(document).ready(function() {
							$('.tipo').change(function() {
								var abuelo = $(this).parent().parent()[0];
								var datos = table.row(abuelo).data();
								var credito = datos[2];
								console.log("Credito "+ credito);

								if ($(this).is(":checked")) {
									creditos = creditos+ parseInt(credito);
									if (creditos >creditosMaximos) {
										$(this).prop("checked",false);
										creditos = creditos- parseInt(credito);
										alert("Usted no puede registrar mas de " + creditosMaximos + " creditos");
									}
								} else {
									creditos = creditos - parseInt(credito);

								}
								console.log(creditos);
								if(creditos<=(parseInt(creditosMinimos)-1))
								{
									$('#cantCreditos').html('<font color="red"><strong>'+ creditos+ '</strong></font>');								
								}
								else
								{
									$('#cantCreditos').html('<font color="blue"><strong>'+ creditos+ '</strong></font>');
								}
							});

							$('#formulario').submit(function(event) {
								if (creditos <= parseInt(creditosMinimos)) {
									alert('Debe de escoger un minimo de '+ creditosMinimos+ ' y un maximo de '+ creditosMaximos + ' Créditos');
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