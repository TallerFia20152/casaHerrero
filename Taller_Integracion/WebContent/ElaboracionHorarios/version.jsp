<%@page import="java.util.List"%>
<%
	List<String> versiones = (List<String>)request.getAttribute("versiones");
%>
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
	<title>Elaboración de Horarios</title>

    <link href="ElaboracionHorarios/css/bootstrap.css" rel="stylesheet">
    <link href="ElaboracionHorarios/css/signin.css" rel="stylesheet">

    <script src="ElaboracionHorarios/js/jquery.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="ElaboracionHorarios/js/bootstrap.min.js"></script>
    <link href="css/dashboard.css" rel="stylesheet" />
<style>
.hora{
  background-color:#inherit;
  color: white;
  font-size;12px;
}
.hora-activa{
  background-color: #5C9FB8;
  color: white;
  cursor:pointer;
}
.con-curso{
  background-color: #5C9FB8;
  color: white;
}
</style>

</head>

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
      <div> 
<div >
  <div class="list-group profesores">
    <a href="#" class="list-group-item disabled">Elige una versión</a>
    
    <%
      for(int i = 0; i < versiones.size(); ++i){
    %>
    <input type="hidden" name="version" value="<%=versiones.get(i) %>"/>
    <a href="?f=leerHorario&version=<%=versiones.get(i) %>" class="list-group-item"><%=versiones.get(i) %></a>  
    <% } %>

    <a href="#" class="list-group-item">
      <div class="input-group">
            <input type="text" class="form-control" name="version" placeholder="Nombre de la Versión">
            <span class="input-group-btn">
              <button class="btn btn-default crear-version" type="button">Crear Versión</button>
            </span>
        </div><!-- /input-group -->
    </a>
  </div>
</div>
      </div>
      <script type="text/javascript">
$(".crear-version").click(function(){
  version = $("[name=\"version\"]").val();
  if(version.length > 0)
  {
    window.location.href="?version="+version;
  }
});
</script>
			<!--FIN CONTENIDO -->
			<jsp:include page="/resources/include/footer.jsp"></jsp:include>
		</div>
		<jsp:include page="/resources/include/chat.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="/resources/include/footer-resources.jsp"></jsp:include>
	
</body>
</html>