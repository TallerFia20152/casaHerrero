<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
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
			
			
			
			<div class="row">
				<div class="col-sm-3 col-xs-6">
					<div class="tile-stats tile-red">
						<div class="icon">
							<i class="entypo-users"></i>
						</div>
						<div class="num" data-start="0" data-end="83" data-postfix=""
							data-duration="1500" data-delay="0">0</div>

						<h3>Registered users</h3>
						<p>so far in our blog, and our website.</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-6">
					<div class="tile-stats tile-green">
						<div class="icon">
							<i class="entypo-chart-bar"></i>
						</div>
						<div class="num" data-start="0" data-end="135" data-postfix=""
							data-duration="1500" data-delay="600">0</div>

						<h3>Daily Visitors</h3>
						<p>this is the average value.</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-6">
					<a href="correo.html">
						<div class="tile-stats tile-aqua">
							<div class="icon">
								<i class="entypo-mail"></i>
							</div>
							<div class="num" data-start="0" data-end="23" data-postfix=""
								data-duration="1500" data-delay="1200">0</div>

							<h3>New Messages</h3>
							<p>messages per day.</p>
						</div>
					</a>
				</div>
				<div class="col-sm-3 col-xs-6">
					<div class="tile-stats tile-blue">
						<div class="icon">
							<i class="entypo-rss"></i>
						</div>
						<div class="num" data-start="0" data-end="52" data-postfix=""
							data-duration="1500" data-delay="1800">0</div>

						<h3>Subscribers</h3>
						<p>on our site right now.</p>
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-8"></div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-8"></div>
			</div>
			<br />
			
			

			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
</body>
</html>