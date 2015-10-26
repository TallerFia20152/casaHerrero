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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/logo.ico">

    <title>Elaboración de Sílabos</title>
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
 
$(document).ready(function() {

    var MaxInputs       = 10; //Número Maximo de Campos
    var contenedor       = $("#agregarB"); //ID del contenedor
    var AddButton       = $("#btnNewB"); //ID del Botón Agregar

    //var x = número de campos existentes en el contenedor
    var x = $("#agregarB div").length + 1;
    var FieldCount = x-1; //para el seguimiento de los campos

    $(AddButton).click(function (e) {
        if(x <= MaxInputs) //max input box allowed
        {
            FieldCount++;
            //agregar campo
            $(agregarB).append('<div><input type="text" class="form-control" name="mitexto[]" id="campo_'+ FieldCount +'" placeholder="Reseña bibliográfica"/><a href="#" class="eliminar">&times;</a></div>');
            x++; //text box increment
        }
        return false;
    });

    $("body").on("click",".eliminar", function(e){ //click en eliminar campo
        if( x > 1 ) {
            $(this).parent('div').remove(); //eliminar el campo
            x--;
        }
        return false;
    });
});



</script>

<script type="text/javascript">
 
$(document).ready(function() {

    var MaxInputs       = 10; //Número Maximo de Campos
    var contenedor       = $("#agregarSemana"); //ID del contenedor
    var AddButton       = $("#btnNewSemana"); //ID del Botón Agregar

    //var x = número de campos existentes en el contenedor
    var x = $("#agregarSemana div").length + 1;
    var FieldCount = x-1; //para el seguimiento de los campos

    $(AddButton).click(function (e) {
        if(x <= MaxInputs) //max input box allowed
        {
            FieldCount++;
            //agregar campo
            
			$(agregarSemana).append('<div><label for="inputEditTema_'+ FieldCount +'">Tema</label><input type="text" class="form-control" name="mitexto[]" id="campo_'+ FieldCount +'" placeholder="Nombre del Tema"/><label for="inputEditDescrip_'+ FieldCount +'">Descripción</label><input type="text" class="form-control" name="mitexto[]" id="campo_'+ FieldCount +'" placeholder="Descripción del Tema"/><a href="#" class="eliminar">&times;</a></div>');
			
            x++; //text box increment
        }
        return false;
    });

    $("body").on("click",".eliminar", function(e){ //click en eliminar campo
        if( x > 1 ) {
            $(this).parent('div').remove(); //eliminar el campo
            x--;
        }
        return false;
    });
});



</script>

<script type="text/javascript">
 
$(document).ready(function() {

    var MaxInputs       = 10; //Número Maximo de Campos
    var contenedor       = $("#agregarSemana2"); //ID del contenedor
    var AddButton       = $("#btnNewSemana2"); //ID del Botón Agregar

    //var x = número de campos existentes en el contenedor
    var x = $("#agregarSemana2 div").length + 1;
    var FieldCount = x-1; //para el seguimiento de los campos

    $(AddButton).click(function (e) {
        if(x <= MaxInputs) //max input box allowed
        {
            FieldCount++;
            //agregar campo
            
			$(agregarSemana2).append('<div><label for="inputEditTema2_'+ FieldCount +'">Tema</label><input type="text" class="form-control" name="mitexto[]" id="campo2_'+ FieldCount +'" placeholder="Nombre del Tema"/><label for="inputEditDescrip2_'+ FieldCount +'">Descripción</label><input type="text" class="form-control" name="mitexto[]" id="campo2_'+ FieldCount +'" placeholder="Descripción del Tema"/><a href="#" class="eliminar">&times;</a></div>');
			
            x++; //text box increment
        }
        return false;
    });

    $("body").on("click",".eliminar", function(e){ //click en eliminar campo
        if( x > 1 ) {
            $(this).parent('div').remove(); //eliminar el campo
            x--;
        }
        return false;
    });
});



</script>

<script type="text/javascript">
 
$(document).ready(function() {

    var MaxInputs       = 10; //Número Maximo de Campos
    var contenedor       = $("#agregarSemana3"); //ID del contenedor
    var AddButton       = $("#btnNewSemana3"); //ID del Botón Agregar

    //var x = número de campos existentes en el contenedor
    var x = $("#agregarSemana3 div").length + 1;
    var FieldCount = x-1; //para el seguimiento de los campos

    $(AddButton).click(function (e) {
        if(x <= MaxInputs) //max input box allowed
        {
            FieldCount++;
            //agregar campo
            
			$(agregarSemana3).append('<div><label for="inputEditTema3_'+ FieldCount +'">Tema</label><input type="text" class="form-control" name="mitexto[]" id="campo3_'+ FieldCount +'" placeholder="Nombre del Tema"/><label for="inputEditDescrip3_'+ FieldCount +'">Descripción</label><input type="text" class="form-control" name="mitexto[]" id="campo3_'+ FieldCount +'" placeholder="Descripción del Tema"/><a href="#" class="eliminar">&times;</a></div>');
			
            x++; //text box increment
        }
        return false;
    });

    $("body").on("click",".eliminar", function(e){ //click en eliminar campo
        if( x > 1 ) {
            $(this).parent('div').remove(); //eliminar el campo
            x--;
        }
        return false;
    });
});



</script>


<script type="text/javascript">
function buscarDatos(){
	
}
function mostrarDatos(){
	
	
	
}


function mostrar() {

		
		document.getElementById('invisible').style.display='block';		
	}
	
function validarCursos(){
	if(frm.lista.value == ""){
			document.getElementById('curso1').style.display='none';
			document.getElementById('curso2').style.display='none';
			document.getElementById('curso3').style.display='none';
		}
	if(frm.lista.value == "1"){
			document.getElementById('curso1').style.display='block';
			document.getElementById('curso2').style.display='none';
			document.getElementById('curso3').style.display='none';
		}
	if(frm.lista.value == "2"){
			document.getElementById('curso1').style.display='none';
			document.getElementById('curso2').style.display='block';
			document.getElementById('curso3').style.display='none';
		}
	if(frm.lista.value == "3"){
			document.getElementById('curso1').style.display='none';
			document.getElementById('curso2').style.display='none';
			document.getElementById('curso3').style.display='block';
		}	
}


function soloNumeros(e)
{
var keynum = window.event ? window.event.keyCode : e.which;
if ((keynum == 8) || (keynum == 46))
return true;
 
return /\d/.test(String.fromCharCode(keynum));
}

</script>
    
  </head>

	<%
	Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
	Persona oPersona = oUsuario.getPersona();
%>
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
        <h1>Elaboración de Sílabos</h1>
      </div>
      <div id="principal-app">
      	<div id="section-app">
        
		</div>
        <br><br>
        <!-- Trigger the modal with a button -->
        <div id="section-app">
        <input type="text" id="txt_Idcurso" class="form-control"  placeholder="Código del Curso" onKeyPress="return soloNumeros(event);" maxlength="6"><br>
        <input type="submit" id="busqueda" name="busqueda" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalx" style="margin:10px 0px; float:left;" onClick="mostrar();" onClick="buscarDatos();" value="Buscar Sílabo"><br><br><br>
        <input type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="margin:10px 0px; float:left;" value="Crear Nuevo Sílabo"><br><br><br>
        <input type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2" style="margin:10px 0px; float:left;" value="Editar Sílabo">
        </div>
      </div>
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <div id="invisible" style="display:none;">
    		<label for="inputCurso">Curso</label>
            <input type="text" id="txt_curso" class="form-control"  placeholder="Nombre del curso" disabled ><br>
            <label for="inputAreaC">Área Curricular</label>
            <input type="text" class="form-control"  placeholder="Área curricular a la que pertenece" disabled><br>
            <label for="inputCodigo">Código del curso</label>
            <input type="text" class="form-control"  placeholder="Código del curso" disabled><br>
            <label for="inputCredito">Créditos</label>
            <input type="text" class="form-control"  placeholder="Cantidad de créditos" disabled><br>
            <label for="inputReq">Requisito</label>
            <input type="text" class="form-control"  placeholder="Curso(s) de requisito" disabled><br>
            <label for="inputCondi">Condición del curso</label>
            <input type="text" class="form-control"  placeholder="Condición obligatorio o electivo" disabled><br>
            <label for="inputSumilla">Sumilla</label>
            <textarea class="form-control" rows="4"  placeholder="Escriba la sumilla del curso" disabled></textarea><br>
            <label for="inputBiblio1">Bibliografía</label>
            <input type="text" class="form-control"  placeholder="Reseña bibliográfica" disabled><br>
            <label for="inputHTeo">Horas Teoría</label>
            <input type="text" class="form-control"  placeholder="Cantidad de horas teóricas" disabled><br>
            <label for="inputHLab">Horas Laboratorio</label>
            <input type="text" class="form-control"  placeholder="Cantidad de horas prácticas" disabled>
            <br>
      		</div>
      
<!--------------------------------- Modal ---------------------------------------------------->
<div id="myModal0" class="modal fade" role="dialog">
  <div class="modal-dialog">
	
	<%
	Vector<CursoBean> VECTOR_LIST = (Vector)request.getAttribute("LIST_CURSO");
	%>
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Crear Nuevo Curso</h4>
        <br/><br/>
        <div class="form-group">
            <label for="inputCurso">Código del Curso</label>
            <input type="text" class="form-control"  placeholder="Código del curso">
            <label for="inputNombre">Nombre del Curso</label>
            <input type="text" class="form-control"  placeholder="Nombre del curso">
            <label for="inputPreReq">Nro de Créditos</label>
            <input type="text" class="form-control"  placeholder="Número de créditos">
            <label for="inputHTeo">Sumilla</label>
            <textarea class="form-control" rows="4"  placeholder="Escriba la sumilla del curso"></textarea>
            <br>
            <input type="submit" class="btn btn-danger" data-toggle="modal" data-target="#myM" style="margin:10px 0px; float:right;" value="Crear"><br><br>
          </div>
      </div>
      
    </div>
    
  </div>
</div>
<br><br>

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Crear Nuevo Sílabo</h4>
        <br/><br/>
        <form>
          <div class="form-group">
            <label for="inputCurso">Lista de Cursos</label>
            <select id="lista" name="lista-cursos" class="form-control" onChange="validarCursos()">
            <option value="">---Seleccione---</option>
            <% for(int i=0;i<VECTOR_LIST.size();i++){%>
                <option value="<%=VECTOR_LIST.get(i).getIdCurso()%>"><%= VECTOR_LIST.get(i).getNombreCurso() %></option>
        	<%}%>
            </select>
            <br/>
            <label for="inputCod">Código del curso</label>
            <input type="text" class="form-control"  placeholder="Código del curso" disabled>
            <label for="inputNom">Nombre del curso</label>
            <input type="text" class="form-control"  placeholder="Nombre del curso" disabled>
            <label for="inputNroC">Nro de Créditos</label>
            <input type="text" class="form-control"  placeholder="Cantidad de Créditos" disabled>
            <label for="inputSumilla">Sumilla</label>
            <textarea class="form-control" rows="4"  placeholder="Escriba la sumilla del curso" disabled></textarea>
            <label for="inputHTeo">Horas Teoría</label>
            <input type="text" class="form-control"  placeholder="Cantidad de horas teóricas">
            <label for="inputHLab">Horas Laboratorio</label>
            <input type="text" class="form-control"  placeholder="Cantidad de horas prácticas">
            <br/><br/>
            <label for="inputBiblio1">Bibliografía</label>
            <div id="agregarB">
            <input type="text" class="form-control"  placeholder="Reseña bibliográfica"><br>
            </div>
            <input type="submit" id="btnNewB" name="btnNewB" class="btn btn-xs btn-danger" style="margin:10px 0px; float:right;" value="Nueva Bibliografía">
            <br><br><hr>
            <label for="inputPF">Promedio Final</label>
            <input type="text" class="form-control"  placeholder="Fórmula del Promedio Final">
           <br>
            <input type="" class="btn btn-danger" data-toggle="modal" data-target="#myModal6" style="margin:10px 0px; float:right;" value="Siguiente">
          </div>
          <br/><br/>
        </form>
      </div>
      
    </div>
    
  </div>
</div>
<br><br>

<div id="myModal6" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Crear Nuevo Sílabo</h4>
        <br/><br/>
        <form>
        	
        	<div class="jumbotron">
        		<h4>Unidades de Aprendizaje</h4>
      		</div>
          <div class="form-group">
          <h4><strong>Unidad I</strong></h4><br>
          <div id="agregarSemana">
            <label for="inputEditTema">Tema</label>
            <input type="text" class="form-control"  placeholder="Nombre del Tema">
            <label for="inputEditDescrip">Descripción</label>
            <input type="text" class="form-control"  placeholder="Descripción del tema">
            <br>
            </div>
            <input type="submit" id="btnNewSemana" name="btnNewSemana" class="btn btn-xs btn-danger" style="margin:10px 0px; float:right;" value="Nueva Semana">
          
          <h4><strong>Unidad II</strong></h4><br>
          <div id="agregarSemana2">
            <label for="inputEditTema">Tema</label>
            <input type="text" class="form-control"  placeholder="Nombre del Tema">
            <label for="inputEditDescrip">Descripción</label>
            <input type="text" class="form-control"  placeholder="Descripción del tema">
            <br>
            </div>
            <input type="submit" id="btnNewSemana2" name="btnNewSemana2" class="btn btn-xs btn-danger" style="margin:10px 0px; float:right;" value="Nueva Semana">
          
          
          <h4><strong>Unidad III</strong></h4><br>
          <div id="agregarSemana3">
            <label for="inputEditTema">Tema</label>
            <input type="text" class="form-control"  placeholder="Nombre del Tema">
            <label for="inputEditDescrip">Descripción</label>
            <input type="text" class="form-control"  placeholder="Descripción del tema">
            <br>
            </div>
            <input type="submit" id="btnNewSemana3" name="btnNewSemana3" class="btn btn-xs btn-danger" style="margin:10px 0px; float:right;" value="Nueva Semana">
           
            <br><br>
            <br><br>
            <input type="" class="btn btn-danger" style="margin:20px 0px; float:right;" value="Guardar y Exportar">
          </div>
          <br/><br/>
        </form>
      </div>
      
    </div>
    
  </div>
</div>



<div id="myModal2" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Crear Nuevo Sílabo</h4>
        <br/><br/>
        <form>
          <div class="form-group">
            <label for="inputCurso">Ingrese un Curso</label>
            <input type="text" class="form-control"  placeholder="Código del curso">
            <input type="submit" class="btn btn-xs btn-danger" style="margin:10px 0px; float:right;">Buscar</button>
            <br/><br>
            
            <input type="" class="btn btn-success" data-toggle="modal" data-target="#myModal3" style=" margin: 0 auto; width: 300px;" value="Editar Bibliografía">
            <br><br>
            <input type="" class="btn btn-success" data-toggle="modal" data-target="#myModal4" style=" margin: 0 auto; width: 300px;" value="Editar Evaluaciones">
            <br><br>
            <input type="" class="btn btn-success" data-toggle="modal" data-target="#myModal5" style=" margin: 0 auto; width: 300px;" value="Editar descripción de las semanas">
            <br><br>
            
          </div>
          <br/><br/>
        </form>
      </div>
      
    </div>
    
  </div>
</div>

<div id="myModal3" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Editar Bibliografía</h4>
        <br/><br/>
        <form>
          <div class="form-group">
            <label for="inputEditBiblio1">Bibliografía</label>
            <input type="text" class="form-control"  placeholder="Reseña bibliográfica">
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Editar</button>
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Eliminar</button>
            <br/><br><br>
            <label for="inputEditBiblio2">Bibliografía 2</label>
            <input type="text" class="form-control"  placeholder="Reseña bibliográfica">
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Editar</button>
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Eliminar</button>
            <br><br>
            <button type="button" class="btn btn-danger" style="margin:10px 0px; float:right;">Guardar Cambios</button>
          </div>
          <br/><br/>
        </form>
      </div>
      
    </div>
    
  </div>
</div>

<div id="myModal4" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Editar Evaluaciones</h4>
        <br/><br/>
        <form>
          <div class="form-group">
          	<label for="inputPF">Promedio Final</label>
            <input type="text" class="form-control"  placeholder="Fórmula del Promedio Final">
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Editar</button>
            <br><br><br>
            <label for="inputPE">Promedio de Evaluaciones</label>
            <input type="text" class="form-control"  placeholder="Fórmula del Promedio de Evaluaciones">
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Editar</button>
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Borrar</button>
            <br><br><br>
            <label for="inputPL">Promedio de Laboratorio</label>
            <input type="text" class="form-control"  placeholder="Fórmula del Promedio de Laboratorio">
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Editar</button>
            <button type="button" class="btn btn-xs btn-danger"  style="margin:10px 15px; float:left;">Borrar</button>
           
            <br><br>
            <button type="button" class="btn btn-danger" style="margin:10px 0px; float:right;">Guardar Cambios</button>
          </div>
          <br/><br/>
        </form>
      </div>
      
    </div>
    
  </div>
</div>

<div id="myModal5" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Editar descripción de las semanas</h4>
        <br/><br/>
        <form>
          <div class="form-group">
            <label for="inputEditBiblio1">Semana 1 sesión 1</label><br>
			<label for="inputEditBiblio1">Nombre</label>
            <input type="text" class="form-control"  placeholder="Título">
            <label for="inputEditBiblio1">Descripción</label>
            <input type="t" class="form-control"  placeholder="Descripción del tema">
            <br><br>
            <label for="inputEditBiblio1">Semana 1 sesión 2</label><br>
			<label for="inputEditBiblio1">Nombre</label>
            <input type="text" class="form-control"  placeholder="Título">
            <label for="inputEditBiblio1">Descripción</label>
            <input type="t" class="form-control"  placeholder="Descripción del tema">
            <br><br>
            <label for="inputEditBiblio1">Semana 2 sesión 1</label><br>
			<label for="inputEditBiblio1">Nombre</label>
            <input type="text" class="form-control"  placeholder="Título">
            <label for="inputEditBiblio1">Descripción</label>
            <input type="t" class="form-control"  placeholder="Descripción del tema">
            
            <br><br>
            <button type="button" class="btn btn-danger" style="margin:10px 0px; float:right;">Guardar Cambios</button>
          </div>
          <br/><br/>
        </form>
      </div>
      
    </div>
    
  </div>
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