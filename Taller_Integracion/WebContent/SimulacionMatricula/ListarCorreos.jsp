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

<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>


<body class="page-body skin-red">

	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>

		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>	

			<hr />

			<div class="mail-env">

				<!-- compose new email button -->
				<div class="mail-sidebar-row visible-xs">
					<a href="mailbox-compose.jsp"
						class="btn btn-blue btn-icon btn-block"> Enviar Mensaje <i
						class="entypo-pencil"></i>
					</a>
				</div>


				<!-- Mail Body -->
				<div class="mail-body">

					<div class="mail-header">
						<!-- title -->
						<h3 class="mail-title">
							Correo <span class="count">(6)</span>
						</h3>

						<!-- search -->
						<form method="get" role="form" class="mail-search">
							<div class="input-group">
								<input type="text" class="form-control" name="s"
									placeholder="Buscar Correo..." />

								<div class="input-group-addon">
									<i class="entypo-search"></i>
								</div>
							</div>
						</form>
					</div>


					<!-- mail table -->
					<table class="table mail-table">
						<!-- mail table header -->
						<thead>
							<tr>
								<th width="5%">
									<div class="checkbox checkbox-replace">
										<input type="checkbox" />
									</div>
								</th>
								<th colspan="4">

									<div class="mail-select-options">Mark as Read</div>

									<div class="mail-pagination" colspan="2">
										<strong>1-30</strong> <span>of 789</span>

										<div class="btn-group">
											<a href="#" class="btn btn-sm btn-white"><i
												class="entypo-left-open"></i></a> <a href="#"
												class="btn btn-sm btn-white"><i
												class="entypo-right-open"></i></a>
										</div>
									</div>
								</th>
							</tr>
						</thead>

						<!-- email list -->
						<tbody>
							<tr class="unread">
								<!-- new email class: unread -->
								<td>
									<div class="checkbox checkbox-replace">
										<input type="checkbox" />
									</div>
								</td>
								<td class="col-name"><a href="#" class="star stared"> <i
										class="entypo-star"></i>
								</a> <a href="mailbox-message.jsp" class="col-name">Asunto</a></td>
								<td class="col-subject"><a href="mailbox-message.jsp">
										Detalle Mensaje </a></td>
								<td class="col-options"><a href="mailbox-message.jsp"><i
										class="entypo-attach"></i></a></td>
								<td class="col-time">hora envio</td>
							</tr>

						</tbody>

						<!-- mail table footer -->
						<tfoot>
							<tr>
								<th width="5%">
									<div class="checkbox checkbox-replace">
										<input type="checkbox" />
									</div>
								</th>
								<th colspan="4">

									<div class="mail-pagination" colspan="2">
										<strong>1-30</strong> <span>of 789</span>

										<div class="btn-group">
											<a href="#" class="btn btn-sm btn-white"><i
												class="entypo-left-open"></i></a> <a href="#"
												class="btn btn-sm btn-white"><i
												class="entypo-right-open"></i></a>
										</div>
									</div>
								</th>
							</tr>
						</tfoot>
					</table>
				</div>

				<jsp:include page="/SimulacionMatricula/menuCorreo.jsp"></jsp:include>				
			</div>

			<hr />
			<!-- Footer -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
	</div>
	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
</body>
</html>