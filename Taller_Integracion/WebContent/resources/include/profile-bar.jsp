<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>


<div class="row">

	<!-- Profile Info and Notifications -->
	<div class="col-md-6 col-sm-8 clearfix">

		<ul class="user-info pull-left pull-none-xsm">

			<!-- Profile Info -->
			<li class="profile-info dropdown">
				<!-- add class "pull-right" if you want to place this from right -->

				<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img
					src="<%=request.getServletContext().getContextPath()%>/resources/assets/images/thumb-1@2x.png" alt=""
					class="img-circle" width="44" /> <%=oPersona.getNombre() + " " + oPersona.getApePaterno()%></strong>
			</a>

				<ul class="dropdown-menu">

					<!-- Reverse Caret -->
					<li class="caret"></li>

					<!-- Profile sub-links -->
					<li><a href="extra-timeline.html"> <i
							class="entypo-user"></i> Editar Perfil
					</a></li>
				</ul>
			</li>

		</ul>		

	</div>


	<!-- Raw Links -->
	<div class="col-md-6 col-sm-4 clearfix hidden-xs">

		<ul class="list-inline links-list pull-right">

			<!-- Language Selector -->
			<li class="dropdown language-selector">Idioma: &nbsp; <a
				href="#" class="dropdown-toggle" data-toggle="dropdown"
				data-close-others="true"> <img
					src="<%=request.getServletContext().getContextPath() %>/resources/assets/images/flag-es.png" />
			</a>

				<ul class="dropdown-menu pull-right">
					<li><a href="#"> <img
							src="<%=request.getServletContext().getContextPath() %>/resources/assets/images/flag-es.png" /> <span>Español</span>
					</a></li>
				</ul>

			</li>

			<li class="sep"></li>

			<li><a href="<%=request.getServletContext().getContextPath()%>/index.jsp"> Salir <i
					class="entypo-logout right"></i>
			</a></li>
		</ul>

	</div>

</div>