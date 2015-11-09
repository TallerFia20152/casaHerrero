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
<body class="page-body skin-red">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>
			<!-- Contenido -->
			<%String mensaje=(String)request.getAttribute("Mensaje"); %>
			<p><%=mensaje%><p>
			<!-- Fin contenido -->
			</div></div>
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
</body>
</html>