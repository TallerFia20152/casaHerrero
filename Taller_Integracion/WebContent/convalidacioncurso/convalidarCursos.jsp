<!DOCTYPE html>
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script src="js/convalidarCursos.js" type="text/javascript"></script>
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
			
			 <h1 style="text-align: center">HISTORICO DE CONVALIDACIONES</h1>
        <!--Cursos del Plan-->
        <div class="col-md-6">
            <div>
                <h2 style='text-align:center;'>Plan de Estudios del alumno</h2>
                <table style="width: 100%" class="table table-hover table-bordered ">
                    <thead>
                        <tr style='text-align:center;font-size:14px;'>
                            <th style="text-align: center">C&oacute;digo</th>
                            <th style="text-align: center">Curso</th>
                            <th style="text-align: center">Cr&eacute;dito</th>
                        </tr>
                    </thead>
                    <tbody id="cursosplan">
                    </tbody>
                </table>

            </div>
        </div>
        <!--Cursos de Alumno -->
        <div class="col-md-6">
            <div>
                <h2 style='text-align:center;'>Cursos Aprobados</h2>
                <table style="width: 100%" class="table table-hover table-bordered">
                    <thead>
                        <tr style='text-align:center;font-size:14px;'>
                            <th style="text-align: center">C&oacute;digo</th>
                            <th style="text-align: center">Curso</th>
                            <th style="text-align: center">Cr&eacute;dito</th>
                            <th style="text-align: center">Convalidacion</th>
                        </tr>
                    </thead>
                    <tbody id="cursosorigen">
                    </tbody>

                </table>
            </div>
        </div>
        <!--        <div class="col-md-offset-2 col-md-8">
                    <div>
                        <h2 style='text-align:center;'>Convalidaciones</h2>
                        <table style="width: 100%" class="table table-hover table-striped">
                            <thead>
                                <tr style='text-align:center;font-size:14px;'>
                                    <th style="text-align: center">Asignatura(Universidad Origen)</th>
                                    <th style="text-align: center"></th>
                                    <th style="text-align: center">Asignatura(USMP)</th>
                                    <th style="text-align: center">Credito</th>
                                </tr>
                            </thead>
                            <tbody id="convalidaciones">
        
                            </tbody>
                        </table>
                    </div>
                </div>-->
        <div class="col-md-offset-2 col-md-8">
            <div style="text-align: center;">
                <input  id="terminar" type="button" class="btn btn-primary" value="Terminar Evaluación"/>

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