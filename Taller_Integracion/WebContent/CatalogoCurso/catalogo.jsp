<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="edu.usmp.fia.taller.common.bean.silabo.CursoBean"%>
	<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="edu.usmp.fia.taller.common.action.SessionParameters"%>
<%@page import="edu.usmp.fia.taller.common.bean.Usuario"%>
<%@page import="edu.usmp.fia.taller.common.bean.Persona"%>
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <head>
  <%
	Vector<CursoBean> VECTOR_LIST = (Vector)request.getAttribute("LIST_CURSO");
  Vector<CursoBean> VECTOR_CURSO = (Vector)request.getAttribute("CURSO");
	%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/logo.ico">

    <title>Elaboración de Cursos</title>
		<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>
		
		
		
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/theme.css" rel="stylesheet">

   <script type="text/javascript" src="http://lineadecodigo.com/js/jquery/jquery.js"></script>
    <script src="js/ie-emulation-modes-warning.js"></script>
<script type="text/javascript">
function soloNumeros(e)
{
var keynum = window.event ? window.event.keyCode : e.which;
if ((keynum == 8) || (keynum == 46))
return true;
 
return /\d/.test(String.fromCharCode(keynum));
}

</script>
    
  </head>
  <body role="document">
<body class="page-body skin-red">
	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>
			
			<div id="dialog-form" title="">
	
</div>
    


    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
        
	<div class="page-header">
        <h1>Curso</h1>
      </div>
      <div id="principal-app">
      	<div id="section-app">
		</div>
        <!-- Trigger the modal with a button -->
        <div id="section-app">
        <form method="post" action="<%=request.getContextPath() %>/Curso">
        
        <select id="id" name="id_curso" class="form-control" onChange="validarCursos()" onClick="mostrarDatos()">
            <option value="">---Seleccione---</option>
            <%for(int i=0;i<VECTOR_LIST.size();i++){%>
                <option value="<%=VECTOR_LIST.get(i).getIdCurso()%>"><%= VECTOR_LIST.get(i).getNombreCurso()%></option>
        	<%}%>
        </select>
        
        <input type="submit" id="btn_funcion" name="btn_funcion" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalx" style="margin:10px 0px; float:left;" value="Buscar Curso"><br><br><br>
        </form>
        <input type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="margin:10px 0px; float:left;" value="Crear Nuevo Curso"><br><br><br>
        <input type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2" style="margin:10px 0px; float:left;" value="Editar Curso"><br><br>
        </div>
      </div>
      <br><br><br>
      
      
      <div >
      <br><br>
    		<label for="inputCurso">Curso</label>
            <input type="text" id="txt_curso" class="form-control" disabled value="<%= VECTOR_CURSO.get(0).getNombreCurso()%>" ><br>
            <label for="inputCodigo">Código del curso</label>
            <input type="text" class="form-control" disabled value="<%= VECTOR_CURSO.get(0).getIdCurso()%>"><br>
            <label for="inputSumilla">Sumilla</label>
            <textarea class="form-control" rows="4" disabled ><%= VECTOR_CURSO.get(0).getSumillaCurso()%></textarea><br>
            <label for="inputCodigo">Tipo de curso</label>
            <input type="text" class="form-control" disabled value="<%= VECTOR_CURSO.get(0).getTipoCurso()%>"><br>
            <br>
      		</div>
      
      
<!--------------------------------- Modal ---------------------------------------------------->
<form method="post" action="<%=request.getContextPath() %>/Curso">
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Crear Nuevo Curso</h4>
        <br/><br/>
        
          <div class="form-group">
                       
            	Codigo del curso : 09- <input type="text" name="codigo"/><br><br>
				Nombre del curso : <input type="text" name="nombre"/><br><br>
				Tipo del curso : 
				<select name="tipo">
				<option value="Seleccionar">Seleccionar</option>
				<option value="1">Laboratorio</option>
				<option value="2">Teoría</option> 
				</select><br><br>				
				Sumilla del Curso :
				<textarea name="sumilla" placeholder="Agregar Sumilla">
				</textarea>
				<br><br>
				<input type="submit" name="btn_funcion" value="Agregar Curso" class="btn btn-lg btn-primary"/><br>
            </div>
            <br><br>
          </div>
          <br/><br/>
      </div>
    </div>
  </div>
</div>
<br><br>
</form>

<div id="myModal2" class="modal fade" role="dialog">
  <form method="post" action="<%=request.getContextPath() %>/Curso">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modificar Curso</h4>
        <br/><br/>
          <div class="form-group">
            
             <div >
    		<label for="inputCurso">Curso</label>
            <input type="text" name="nombre" id="txt_curso" class="form-control" value="<%= VECTOR_CURSO.get(0).getNombreCurso()%>" ><br>
            <label for="inputCodigo">Código del curso</label>
            <input type="text" name="codigoCurso" class="form-control" value="<%= VECTOR_CURSO.get(0).getIdCurso()%>"><br>
            <label for="inputSumilla">Sumilla</label>
            <textarea name="sumilla" class="form-control" rows="4" ><%= VECTOR_CURSO.get(0).getSumillaCurso()%></textarea><br>
            <label for="inputCodigo">Tipo de curso</label>
            <select name="tipo">
				
				<%if(VECTOR_CURSO.get(0).getTipoCurso()=="Laboratorio"){ %>
				<option value="1">Laboratorio</option>
				<%}else{%>
				<option value="2">Teoría</option>
				<%}%>	
				<option value="1">Laboratorio</option>
				<option value="2">Teoría</option> 
				</select><br><br>
            
            
            <br>
      		</div>
            <br><br>
            <input type="submit" name="btn_funcion" value="Modificar Curso" class="btn btn-lg btn-primary"/><br>
            <br><br>
          </div>
          <br/><br/>
      </div>
    </div>    
  </div>
  </form>
</div>

    </div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <jsp:include page="/resources/include/footer.jsp"></jsp:include>
	<jsp:include page="/resources/include/chat.jsp"></jsp:include>
  </body>
</html>