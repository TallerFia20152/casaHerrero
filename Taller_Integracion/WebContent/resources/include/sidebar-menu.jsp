<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>

<div class="sidebar-menu">

	<div class="sidebar-menu-inner">

		<header class="logo-env">
			<!-- logo -->
			<div class="logo">
				<a href="<%=request.getServletContext().getContextPath()%>/welcome.jsp">
					<h1 style="color: #FCFDFF;">
						<strong>USMP</strong>
					</h1>
				</a>
			</div>
			<!-- logo collapse icon -->
			<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon"> <!-- add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition -->
					<i class="entypo-menu"></i>
				</a>
			</div>
			<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
			<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation"> <!-- add class "with-animation" to support animation -->
					<i class="entypo-menu"></i>
				</a>
			</div>
		</header>

		<div class="sidebar-user-info">
			<div class="sui-hover inline-links animate-in">
				<a href="correo.html"> <i class="entypo-mail"></i> Correo
				</a> <a href="login?f=logout""> <i class="entypo-lock"></i> Salir
				</a> <span class="close-sui-popup">&times;</span>
				<!-- this is mandatory -->
			</div>
		</div>
		
		<ul id="main-menu" class="main-menu">
			<li><a href="<%=request.getContextPath()%>/welcome.jsp"><i class="entypo-gauge"></i><span class="title">INICIO</span></a></li>
			<jsp:include page="/resources/include/menu/simumatricula.jsp"></jsp:include>
			<jsp:include page="/resources/include/menu/reg-docente.jsp"></jsp:include>
			<jsp:include page="/resources/include/menu/conv-cursos.jsp"></jsp:include>
			<jsp:include page="/resources/include/menu/elaboracion-horario.jsp"></jsp:include>
			<jsp:include page="/resources/include/menu/malla-curricular.jsp"></jsp:include>
			<jsp:include page="/resources/include/menu/plan-curricular.jsp"></jsp:include>
		</ul>
	</div>
	
</div>
<!-- Inicio Modal -->
		<div id="myModalElaboracionHorario" class="modal fade" role="dialog">
		  <div class="modal-dialog">

		    <!-- Modal content-->
		    <div class="modal-content" style="margin-top:150px;">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Sistema Elaboracion de Horarios</h4>
		      </div>
		      <div class="modal-body">
		        <p>¿Desea agregar el archivo excel consolidado?.</p>
		        </br>
		        <center>
				<form action="cargarExcels" method="get" >
						<input type="hidden" name="f" value="leerExcel" /> <input type="hidden"
			name="p" id="p" value="" />
			        <button type="submit"  class="btn btn-success" style:"float:left;">Agregar archivo</button>
			     </form>
			     <form action="ElaboracionHorariosServlet" method="get" > 
			     <input type="hidden" name="f" value="leerHorario" /> <input type="hidden"
						name="p" id="p" value="" /> 
			        <button type="submit"  class="btn btn-info" style:"float:rigth;">No agregar archivo</button>
				</form>
			     </center>
			     <p>.</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>

		  </div>
		</div>
		<!-- Fin Modal -->