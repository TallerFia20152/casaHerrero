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
	<link href="css/selectize.default.css" rel="stylesheet" type="text/css" />
<link href="css/toastr.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="js/selectize.min.js" type="text/javascript"></script>
<script src="js/toastr.min.js" type="text/javascript"></script>
<script src="js/selectizes/departamentoSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/provinciaSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/distritoSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/universidadSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/especialidadSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/modalidadSelectize.js" type="text/javascript"></script>
<script src="js/selectizes/sexoSelectize.js" type="text/javascript"></script>
<script src="js/registroAlumno.js" type="text/javascript"></script>
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
            <h1 style="text-align: center">REGISTRO DE ALUMNOS</h1>
            <hr>
                
                    <div class="col-md-offset-2 col-md-5">

                        <div>

                            <form id ="login" onsubmit="return false;">

<!--                                <h1 style="display: block;">Informaci&oacute;n Personal</h1> -->
                               <div class="form-group">
                                    <label>C&oacute;digo <span class="required">*</span>
                                    </label>
                                    <input id="id" class="numeros form-control" maxlength="10" required="required" type="text">
                                   
                                </div>
                                <div class="form-group">
                                    <label >Nombres <span class="required">*</span>
                                    </label>
                                    
                                        <input id="nom" style="text-transform:uppercase;" maxlength="100" class="form-control letras"  required="required" type="text">
                                    
                                </div>
                                <div class="form-group">
                                    <label>Apellido Paterno<span class="required">*</span>
                                    </label>
                                    
                                        <input id="apepat" style="text-transform:uppercase;" maxlength="100" class="form-control letras"  required="required" type="text">
                                    
                                </div>
                                <div class="form-group">
                                    <label>Apellido Materno <span class="required">*</span>
                                    </label>
                                    
                                        <input id="apemat"  style="text-transform:uppercase;" maxlength="100" class="letras form-control" name="apellidos" required="required" type="text">
                                    
                                </div>
                                <div class="form-group">
                                    <label>DNI <span class="required">*</span>
                                    </label>
                                    
                                        <input id="dni" style="text-transform:uppercase;" class="form-control numeros" maxlength="8" required="required" type="text" >
                                    
                                </div>
                                <div class="form-group">
                                    <label >Sexo <span class="required">*</span></label>
                                    
                                        <input id="sexo"   type="text"/>
                                        
                                </div>
                                <div class="form-group">
                                    <label>Departamento<span class="required">*</span>
                                    </label>
                                    
                                        <input type="text" id="comboDepartamento" />
                                    
                                </div>
                                <div class="form-group">
                                    <label>Provincia<span class="required">*</span>
                                    </label>
                                    
                                        <input type="text" id="comboProvincia" />
                                    
                                </div>
                                
                                
                                
                                <div class="form-group">
                                    <label>Distrito<span class="required">*</span>
                                    </label>
                                    
                                        <input type="text" id="comboDistrito" />
                                    
                                </div>
                                <div class="form-group">
                                    <label>Direccion <span class="required">*</span>
                                    </label>
                                    
                                        <input style="text-transform:uppercase;" type="text"  maxlength="100" id="dir" required="required" class="form-control">
                                    
                                </div>
                                <div class="form-group">
                                    <label>Fecha Nacimiento<span class="required">*</span>
                                    </label>
                                    
                                        <input type="date" id="fecnac" required="required" class="form-control">
                                    
                                </div>
                                
                                <div class="form-group">
                                    <label >Telefono <span class="required">*</span>
                                    </label>
                                    
                                        <input type="text"  id="numcas" required="required"  maxlength="10" class="form-control numeros">
                                    
                                </div>
                                <div class="form-group">
                                    <label >Celular <span class="required">*</span>
                                    </label>
                                    
                                        <input type="text" class ="form-control numeros" id="numcel" maxlength="9" required="required">
                                    
                                </div>
                                <div class="form-group">
                                    <label >Especialidad<span class="required">*</span>
                                    </label>
                                   
                                        <input type="text" id="comboEspecialidad"  />
                                    
                                </div>
                                 <div class="form-group">
                                    <label >Modalidad Ingreso <span class="required">*</span>
                                    </label>
                                    
                                        <input type="text" id="comboModalidad" />
                                  
                                </div>
                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-3">
                                        <button id="send" type="submit" class="btn btn-success">Submit</button>
                                        <button type="reset" id="reset" class="btn btn-primary">Limpiar</button>
                                    </div>
                                </div>
                            </form>

                        </div>
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